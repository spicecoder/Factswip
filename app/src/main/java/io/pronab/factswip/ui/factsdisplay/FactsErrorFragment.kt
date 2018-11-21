package io.pronab.factswip.ui.factsdisplay

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.pronab.factswip.R
import io.pronab.factswip.model.FactsErrorViewModel

class FactsErrorFragment : Fragment() {

    companion object {
        fun newInstance() = FactsErrorFragment()
    }

    private lateinit var viewModel: FactsErrorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.facts_error_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FactsErrorViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
