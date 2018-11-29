package io.pronab.factswip.ui.factsdisplay

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.pronab.factswip.R
import io.pronab.factswip.presenter.FragmentsPresesnterImpl

open class FactsDisplayController : AppCompatActivity() {
    val factpresenter: FragmentsPresesnterImpl = FragmentsPresesnterImpl(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.facts_display_controller_activity)
        setSupportActionBar(findViewById(R.id.facts_toolbar))

        factpresenter.attachFragment()

    }

    fun setTitle(aTitle: String) {

        supportActionBar?.title = aTitle

    }


}
