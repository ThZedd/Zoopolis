package pt.iade.ei.zoopolis.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pt.iade.ei.zoopolis.models.LoginRequestDTO
import pt.iade.ei.zoopolis.models.LoginResponseDTO
import pt.iade.ei.zoopolis.models.Person
import pt.iade.ei.zoopolis.retrofit.PersonRepository
import pt.iade.ei.zoopolis.retrofit.Result

class PersonViewModel(private val personRepository: PersonRepository) : ViewModel() {

    // LiveData para resultados de login
    private val _loginResult = MutableLiveData<Result<LoginResponseDTO>?>()
    val loginResult: MutableLiveData<Result<LoginResponseDTO>?> get() = _loginResult

    // LiveData para resultados de registro
    private val _registerResult = MutableLiveData<Result<Person>>()
    val registerResult: LiveData<Result<Person>> get() = _registerResult

    // LiveData para lista de pessoas
    private val _personsList = MutableLiveData<Result<List<Person>>>()
    val personsList: LiveData<Result<List<Person>>> get() = _personsList

    // Função para fazer login
    fun login(loginRequestDTO: LoginRequestDTO) {
        // Lançar a chamada para login no repositório
        viewModelScope.launch {
            val result = personRepository.login(loginRequestDTO)
            _loginResult.postValue(result)  // Atualiza o LiveData com o resultado
        }
    }

    // Função para registrar pessoa
    fun register(person: Person) {
        // Lançar a chamada para registro no repositório
        viewModelScope.launch {
            val result = personRepository.register(person)
            _registerResult.postValue(result)  // Atualiza o LiveData com o resultado
        }
    }

    // Função para pegar a lista de pessoas
    fun getPersons() {
        // Lançar a chamada para pegar a lista de pessoas no repositório
        viewModelScope.launch {
            val result = personRepository.getPersons()
            _personsList.postValue(result)  // Atualiza o LiveData com o resultado
        }
    }
}
