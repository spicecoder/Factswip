package io.pronab.factswip.ui.factsdisplay

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.DividerItemDecoration.VERTICAL
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.pronab.factswip.Factswip
import io.pronab.factswip.R
import io.pronab.factswip.model.Facts
import io.pronab.factswip.model.FactsDisplayViewModel


class FactsDisplayFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {

    companion object {
        fun newInstance() = FactsDisplayFragment()
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FactsAdapter
    private lateinit var swipeLayout: SwipeRefreshLayout
    var facts: Facts? = Facts("Empty", ArrayList())

    private lateinit var viewModel: FactsDisplayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.facts_display_fragment, container, false)

        this.swipeLayout = view.findViewById(R.id.factsSwipeRefresh) as SwipeRefreshLayout
        swipeLayout.setOnRefreshListener(this)


        return view
    }

    override fun onRefresh() {
        viewModel.facts = viewModel.resetCache()
        swipeLayout.isRefreshing = false
        adapter.notifyDataSetChanged()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //setContentView(R.layout.activity_facts)
        recyclerView = view?.findViewById(R.id.recyclerFactsview) as RecyclerView
        // recyclerView = findViewById(R.id.recyclerFactsview) as RecyclerView
        recyclerView.setHasFixedSize(false)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val decoration = DividerItemDecoration(activity?.applicationContext, VERTICAL)
        recyclerView.addItemDecoration(decoration)
        viewModel = ViewModelProviders.of(this).get(FactsDisplayViewModel::class.java)
        adapter = FactsAdapter(this@FactsDisplayFragment, facts = facts)

        recyclerView.adapter = adapter
        adapter.setAdapterForChange(this.activity)

        makeObserve()


    }


    private fun makeObserve() {

        // viewModel = ViewModelProviders.of(this).get(FactsDisplayViewModel::class.java)
        viewModel.facts?.observe(this, Observer { facts ->
            run {
                facts?.let { cascade(it) }

            }
        })

    }

    private fun cascade(facts: Facts) = when {
        facts.title == "" -> {
            Factswip.what_to_show_onScreen_now = Factswip.SHOW_ERROR
            (activity as FactsDisplayController).factpresenter.attachFragment()
        }
        facts.title == Factswip.FETCH_ERROR -> {
            Factswip.what_to_show_onScreen_now = Factswip.SHOW_ERROR
            (activity as FactsDisplayController).factpresenter.attachFragment()
        }
        else -> {
            adapter = FactsAdapter(this@FactsDisplayFragment, facts = facts)
            (activity as FactsDisplayController).setTitle(facts.title)
            recyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }

}