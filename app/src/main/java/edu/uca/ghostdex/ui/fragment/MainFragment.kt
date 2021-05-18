package edu.uca.ghostdex.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import edu.uca.ghostdex.ui.MainViewModel
import javax.inject.Inject
import edu.uca.ghostdex.R
import edu.uca.ghostdex.intent.Intent
import edu.uca.ghostdex.model.Pkmn
import edu.uca.ghostdex.utils.AdapterPkmn
import edu.uca.ghostdex.utils.DataState
import edu.uca.ghostdex.utils.RecyclerViewClickListener

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainFragment
constructor() : Fragment(R.layout.fragment_first){
    private val TAG: String = "AppDebug"

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var adapterPkmn: AdapterPkmn

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
        val layoutManager =
            LinearLayoutManager(
                requireActivity().applicationContext,
                LinearLayoutManager.VERTICAL,
                false
            )
        layoutManager.reverseLayout = true
        layoutManager.stackFromEnd = true
        recyclerViewPkmn.layoutManager = layoutManager
        recyclerViewPkmn.adapter = adapterPkmn

        subscribeObservers()
        lifecycleScope.launch {
            viewModel.userIntent.send(Intent.GetPkmnEvent)
        }

        adapterPkmn.setOnClickListener(object: RecyclerViewClickListener{
            override fun onClickPkmn(position: Int, pkmn: Pkmn) {
                Log.d("Probando, nombre:",pkmn.pkmnname)
                val dp = DetailsPokemon()
                dp.setPkmnDetail(pkmn)
                activity?.let { dp.show(it.supportFragmentManager, "DialogFragmentPkmnDetails") }
            }

        })
    }

    private fun subscribeObservers(){
        lifecycleScope.launch {
            viewModel.dataState.collect {
                when(it){
                    is DataState.Success -> {
                        displayProgressBar(false)
                        adapterPkmn.setPkmns(it.pkmn)
                    }
                    is DataState.Error -> {
                        displayProgressBar(false)
                        displayError(it.exception.message)
                    }
                    is DataState.Loading -> {
                        displayProgressBar(true)
                    }
                }
            }
        }
    }

    private fun displayError(message: String?) {
        //  if (message != null) text.text = message else text.text = "Unknown error."
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        progress_bar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }
}