package io.pronab.factswip.ui.factsdisplay

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.pronab.factswip.Factswip
import io.pronab.factswip.R

class FactsDisplayController : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.facts_display_controller_activity)
        setSupportActionBar(findViewById(R.id.facts_toolbar))

        attachFragment()

    }

    fun attachFragment() {

        when (Factswip.what_to_show_onScreen_now) {
            Factswip.SHOW_FACTS -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, FactsDisplayFragment.newInstance())
                    .commitNow()
            }
            Factswip.SHOW_ERROR -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, FactsErrorFragment.newInstance())
                    .commitNow()
            }
            else -> {
                Log.d("No fragment To attach :", Factswip.what_to_show_onScreen_now)
            }
        }


    }

    fun setTitle(aTitle: String) {

        supportActionBar?.title = aTitle

    }



}
