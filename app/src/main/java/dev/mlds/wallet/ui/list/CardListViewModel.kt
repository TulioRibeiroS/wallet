package dev.mlds.wallet.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.mlds.wallet.domain.models.CardsModel
import dev.mlds.wallet.domain.models.Resource
import dev.mlds.wallet.domain.usecases.GetCardsUseCase
import kotlinx.coroutines.launch

class CardListViewModel(private val useCase: GetCardsUseCase) : ViewModel() {

    private var _cards: MutableLiveData<Resource<CardsModel>> = MutableLiveData()
    val cards: LiveData<Resource<CardsModel>> = _cards

    fun getAllCards() {
        viewModelScope.launch {
            _cards.postValue(Resource.Loading)
            useCase.execute().collect { state ->
                _cards.postValue(state)
            }
        }
    }

}