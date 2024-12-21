package pt.iade.ei.zoopolis.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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

    private val personId = 1 // ID fixo, pode ser dinâmico dependendo do caso de uso

    private val _favoriteAnimals = MutableStateFlow<List<AnimalDTO>>(emptyList())
    val favoriteAnimals = _favoriteAnimals.asStateFlow()

    private val _favoriteStatus = MutableStateFlow<Map<Int, Boolean>>(emptyMap()) // MutableStateFlow
    val favoriteStatus: StateFlow<Map<Int, Boolean>> = _favoriteStatus

    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()

    init {
        loadFavoriteAnimalsByPerson(personId)
    }

    // Carregar animais favoritos
    private fun loadFavoriteAnimalsByPerson(personId: Int) {
        viewModelScope.launch {
            favoriteRepository.getFavoriteAnimalsByPerson(personId).collectLatest { result ->
                when (result) {
                    is Result.Error -> {
                        _showErrorToastChannel.send(true)
                    }
                    is Result.Sucess -> {
                        result.data?.let { animals ->
                            _favoriteAnimals.update { animals }
                            // Atualiza o mapa de status de favoritos
                            val updatedStatus = animals.associate { it.id to true }
                            _favoriteStatus.update { updatedStatus }
                            // Adiciona o log aqui para verificar o estado
                            Log.d("FavoriteViewModel", "favoriteStatus after load: ${_favoriteStatus.value}")
                        }
                    }
                }
            }
        }
    }

    fun addFavorite(animalId: Int) {
        viewModelScope.launch {
            try {
                val response = favoriteRepository.addFavorite(personId, animalId)
                if (response == "Animal added to favorites successfully.") {
                    _favoriteStatus.update { currentStatus -> currentStatus + (animalId to true) }
                    Log.d("FavoriteViewModel", "favoriteStatus after add: ${_favoriteStatus.value}")
                }
            } catch (e: Exception) {
                _showErrorToastChannel.send(true)
            }
        }
    }

    fun removeFavorite(animalId: Int) {
        viewModelScope.launch {
            try {
                val response = favoriteRepository.removeFavorite(personId, animalId)
                if (response == "Animal removed from favorites successfully.") {
                    _favoriteStatus.update { currentStatus -> currentStatus - animalId }
                    Log.d("FavoriteViewModel", "favoriteStatus after remove: ${_favoriteStatus.value}")
                }
            } catch (e: Exception) {
                _showErrorToastChannel.send(true)
            }
        }
    }



    // Verificar se um animal é favorito
    fun checkIfFavorite(animalId: Int) {
        viewModelScope.launch {
            try {
                val isFavorite = favoriteRepository.isFavorite(personId, animalId)
                _favoriteStatus.update { it + (animalId to isFavorite) }
                // Adiciona o log aqui
                Log.d("FavoriteViewModel", "favoriteStatus after check: ${_favoriteStatus.value}")
            } catch (e: Exception) {
                _showErrorToastChannel.send(true)
            }
        }
    }
}





