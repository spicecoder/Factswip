package io.pronab.factswip.model

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.pronab.factswip.repo.Factsrepo

class FactsDisplayViewModel(var facts: MutableLiveData<Facts>? = Factsrepo().getCacheFacts()) : ViewModel() {


    fun resetCache(): MutableLiveData<Facts>? {
        return Factsrepo().resetFacts()
    }



}
