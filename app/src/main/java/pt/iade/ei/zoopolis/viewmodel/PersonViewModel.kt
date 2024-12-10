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
import pt.iade.ei.zoopolis.models.Person
import pt.iade.ei.zoopolis.retrofit.PersonRepository
import pt.iade.ei.zoopolis.retrofit.Result

class PersonViewModel(
    private val personrepository: PersonRepository
):ViewModel() {

    private val _persons = MutableStateFlow<List<Person>>(emptyList())
    val persons = _persons.asStateFlow()

    private val _personById = MutableStateFlow<Person?>(null)
    val personById = _personById.asStateFlow()

    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()

    init {
        loadPersons()
    }

    private fun loadPersons() {
        viewModelScope.launch {
            personrepository.getPersons().collectLatest { result ->
                when (result) {
                    is Result.Error -> {
                        _showErrorToastChannel.send(true)
                    }
                    is Result.Sucess -> {
                        result.data?.let { persons ->
                            _persons.update {
                               persons
                            }
                        }
                    }
                }
            }
        }
    }

    fun loadPersonById(id: Int) {
        viewModelScope.launch {
            personrepository.getPersonsById(id).collectLatest { result ->
                when (result) {
                    is Result.Error -> {
                        _showErrorToastChannel.send(true)
                    }
                    is Result.Sucess -> {
                        result.data?.let { person ->
                            _personById.update {
                                person
                            }
                        }
                    }
                }
            }
        }
    }
}