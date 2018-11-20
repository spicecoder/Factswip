package io.pronab.factswip.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import io.pronab.factswip.repo.Factsrepo

class FactsDisplayViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    val facts: LiveData<Facts>? = Factsrepo().getCacheFacts()

    fun resetCache() { Factsrepo().resetFacts() }


}
