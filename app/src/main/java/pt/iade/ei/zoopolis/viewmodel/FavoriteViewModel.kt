package pt.iade.ei.zoopolis.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pt.iade.ei.zoopolis.models.AnimalDTO
import pt.iade.ei.zoopolis.retrofit.FavoriteRepository
import pt.iade.ei.zoopolis.retrofit.Result

class FavoriteViewModel(
    private val favoriteRepository: FavoriteRepository
) : ViewModel() {

    private val personId = 1
    private val _favoriteAnimals = MutableStateFlow<List<AnimalDTO>>(emptyList())
    val favoriteAnimals = _favoriteAnimals.asStateFlow()

    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()
    init {
        loadFavoriteAnimalsByPerson(personId)
    }

    private fun loadFavoriteAnimalsByPerson(personId: Int) {
        viewModelScope.launch {
            favoriteRepository.getFavoriteAnimalsByPerson(personId).collectLatest { result ->
                when (result) {
                    is Result.Error -> {
                        _showErrorToastChannel.send(true)
                    }
                    is Result.Sucess -> {
                        result.data?.let { animals ->
                            _favoriteAnimals.update {
                                animals
                            }
                        }
                    }
                }
            }
        }
    }
}

