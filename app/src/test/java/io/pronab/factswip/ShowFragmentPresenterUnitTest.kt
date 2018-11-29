package io.pronab.factswip

import io.pronab.factswip.ui.factsdisplay.FactsDisplayController
import org.junit.Test
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


class ShowFragmentPresenterUnitTest() {

    @Test
    fun `test swich fragment follows correct logic in error situation`() {
        Factswip.what_to_show_onScreen_now = Factswip.SHOW_ERROR
        val spiedController = com.nhaarman.mockitokotlin2.spy(FactsDisplayController())
        val spiedPresenter = com.nhaarman.mockitokotlin2.spy(FragmentPresenterMock(spiedController))

        MockitoAnnotations.initMocks(this)
        spiedPresenter.attachFragment();
        verify(spiedPresenter).showError();

    }

    @Test
    fun `test swich fragment follows correct logic in success situation`() {
        Factswip.what_to_show_onScreen_now = Factswip.SHOW_FACTS
        val spiedController = com.nhaarman.mockitokotlin2.spy(FactsDisplayController())
        val spiedPresenter = com.nhaarman.mockitokotlin2.spy(FragmentPresenterMock(spiedController))

        MockitoAnnotations.initMocks(this)
        spiedPresenter.attachFragment();
        verify(spiedPresenter).showFacts();
    }

}
