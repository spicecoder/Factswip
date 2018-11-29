package io.pronab.factswip

import io.pronab.factswip.presenter.FragmentsPresesnterImpl
import io.pronab.factswip.presenter.ShowFragments
import io.pronab.factswip.ui.factsdisplay.FactsDisplayController

class FragmentPresenterMock(fdc: FactsDisplayController) : ShowFragments, FragmentsPresesnterImpl(fdc) {
    override fun showError() {
    }

    override fun showFacts() {
    }
}