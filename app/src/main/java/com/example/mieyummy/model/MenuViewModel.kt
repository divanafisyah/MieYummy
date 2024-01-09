package com.example.mieyummy.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mieyummy.repository.RepositoryMie
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class MenuViewModel (private val repositoryMie: RepositoryMie): ViewModel(){
    companion object{
        private const val TIMEOUT_MILIES = 5_000L
    }
    val menuuistate : StateFlow<MenuUiState> = repositoryMie.getAllMieStream().filterNotNull().map { MenuUiState(
        listMie = it.toList())}.stateIn(scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(TIMEOUT_MILIES),
        initialValue = MenuUiState())

    data class MenuUiState(
        val listMie: List<com.example.mieyummy.data.MieYummy> = listOf()
    )
}