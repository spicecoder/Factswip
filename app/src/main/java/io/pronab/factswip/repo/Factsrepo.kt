package io.pronab.factswip.repo

import android.arch.lifecycle.MutableLiveData
import io.pronab.factswip.model.Facts
import io.pronab.factswip.network.FactsFetcher

class Factsrepo {
    private var factsRepo: MutableLiveData<Facts>? = null

    fun getFactsFromNetwork(): MutableLiveData<Facts>? {

        factsRepo = FactsFetcher().loadFacts() //this is repo refresh ..
        return factsRepo

    }

    fun getCacheFacts(): MutableLiveData<Facts>? {

        if (factsRepo == null) {
            getFactsFromNetwork()
        }

        return factsRepo; }

    fun resetFacts(): MutableLiveData<Facts>? {
        factsRepo = null
        getFactsFromNetwork()
        return factsRepo
    }

}



