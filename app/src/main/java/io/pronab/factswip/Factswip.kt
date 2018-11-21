package io.pronab.factswip

import android.app.Application

class Factswip : Application() {
    companion object {


        const val FETCH_ERROR ="facts access error"
          const val SHOW_FACTS="Facts"
          const val SHOW_ERROR="Error"

        var  what_to_show_onScreen_now: String? = SHOW_FACTS

    }


}