package pl.fzymek.cryptobrowser.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pl.fzymek.cryptobrowser.Greeting

class MainViewModel: ViewModel() {

    private val _greetingsList = MutableStateFlow<List<String>>(listOf())
    val greetingList: StateFlow<List<String>> get() = _greetingsList

    init {
        viewModelScope.launch {
            Greeting().greet().collect { phrase ->
                _greetingsList.update { list -> list + phrase }
            }
        }
    }
}