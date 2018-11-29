package io.pronab.factswip.presenter

import android.util.Log
import io.pronab.factswip.Factswip
import io.pronab.factswip.R
import io.pronab.factswip.ui.factsdisplay.FactsDisplayController
import io.pronab.factswip.ui.factsdisplay.FactsDisplayFragment
import io.pronab.factswip.ui.factsdisplay.FactsErrorFragment

open class FragmentsPresesnterImpl(var fdc: FactsDisplayController = FactsDisplayController()) : ShowFragments {

    override fun showFacts() {
        fdc.supportFragmentManager.beginTransaction()
            .replace(R.id.container, FactsDisplayFragment.newInstance())
            .commitNow()
    }

    override fun showError() {

        fdc.supportFragmentManager.beginTransaction()
            .replace(R.id.container, FactsErrorFragment.newInstance())
            .commitNow()

    }
    fun setDisplay(fdc: FactsDisplayController){this.fdc =  fdc  }
   fun attachFragment() {
       when (Factswip.what_to_show_onScreen_now) {
           Factswip.SHOW_FACTS -> {
               showFacts()
           }
           Factswip.SHOW_ERROR -> {
               showError()
           }
           else -> {
               Log.d("No fragment To attach :", Factswip.what_to_show_onScreen_now)
           }
       }

   }
}