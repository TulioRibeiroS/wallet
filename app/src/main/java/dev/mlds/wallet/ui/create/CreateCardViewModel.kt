package dev.mlds.wallet.ui.create

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.mlds.wallet.domain.models.CardModel
import dev.mlds.wallet.domain.models.Resource
import dev.mlds.wallet.domain.usecases.PostCardUseCase
import kotlinx.coroutines.launch
import java.util.UUID

class CreateCardViewModel(private val useCase: PostCardUseCase) : ViewModel() {

    private var _card: MutableLiveData<Resource<CardModel>> = MutableLiveData()
    val card: LiveData<Resource<CardModel>> = _card

    fun postCard(card: CardModel) {
        card.id = generateUUID()
        viewModelScope.launch {
            _card.postValue(Resource.Loading)
            useCase.execute(card).collect { state ->
                _card.postValue(state)
            }
        }
    }

    private fun generateUUID(): String {
        val uuid = UUID.randomUUID()
        return uuid.toString()
    }

}