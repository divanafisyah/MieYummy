package com.example.admin.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.admin.halaman.EditDestination
import com.example.admin.repository.RepositoryMie
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class EditViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoryMie: RepositoryMie
): ViewModel() {
    var mieUiState by mutableStateOf(UIStateMieYummy())
        private set
    private val itemId: Int = checkNotNull(savedStateHandle[EditDestination.itemIdArg])
    val uiState: StateFlow<ItemDeleteUiState> =
        repositoryMie.getMieStream(itemId).filterNotNull().map { ItemDeleteUiState(detailMieYummy = it.toDetailMieYummy())
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = ItemDeleteUiState()
        )
    init {
        viewModelScope.launch {
            mieUiState =
                repositoryMie.getMieStream(itemId).filterNotNull().first().toUiStateMieYummy(true)
        }
    }

    suspend fun updateMenu() {
        if (validasiInput(mieUiState.detailMieYummy)){
            repositoryMie.updateMenu(mieUiState.detailMieYummy.toMieYummy())
        }
        else{
            println("Data tidak valid")
        }
    }


    fun updateUiState(detailMieYummy: DetailMieYummy){
        mieUiState =
            UIStateMieYummy(detailMieYummy = detailMieYummy, isEnteryValid  = validasiInput(detailMieYummy))
    }

    private fun validasiInput(uiState: DetailMieYummy = mieUiState.detailMieYummy): Boolean{
        return with(uiState){
            jenis.isNotBlank() && nama.isNotBlank() && deskripsi.isNotBlank()&& harga.isNotBlank()
        }
    }

    suspend fun deleteItem(){
        repositoryMie.deleteMenu(uiState.value.detailMieYummy.toMieYummy())
    }

    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class ItemDeleteUiState(
    val outOfStock: Boolean = true,
    val detailMieYummy: DetailMieYummy= DetailMieYummy()
)