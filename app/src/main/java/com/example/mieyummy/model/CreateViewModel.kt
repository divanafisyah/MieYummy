package com.example.mieyummy.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mieyummy.data.MieYummy
import com.example.mieyummy.repository.RepositoryMie

class CreateViewModel (private val repositoryMie: RepositoryMie): ViewModel(){
    var uiStateMieYummy by mutableStateOf(UIStateMieYummy())
    private set

    private fun validasiInput(uiState : DetailMieYummy = uiStateMieYummy.detailMieYummy): Boolean{
        return with(uiState){
            jenis.isNotBlank()&& nama.isNotBlank()&&deskripsi.isNotBlank()
        }
    }

    fun updateUiState(detailMieYummy: DetailMieYummy){
        uiStateMieYummy =
            UIStateMieYummy(detailMieYummy=detailMieYummy,isEnteryValid = validasiInput(detailMieYummy))
    }

    suspend fun saveMieYummy(){
        if (validasiInput()){
            repositoryMie.insertMenu(uiStateMieYummy.detailMieYummy.toMieYummy())
        }
    }
}

data class UIStateMieYummy(
    val detailMieYummy: DetailMieYummy = DetailMieYummy(),
    val isEnteryValid: Boolean = false
)

data class DetailMieYummy(
    val id: Int = 0,
    val jenis: String ="",
    val nama: String ="",
    val deskripsi: String ="",
    val harga: String ="",
)

fun DetailMieYummy.toMieYummy(): MieYummy = MieYummy(
    id = id,
    jenis = jenis,
    nama = nama,
    deskripsi = deskripsi,
    harga = harga
)
fun MieYummy.toDetailMieYummy(): DetailMieYummy = DetailMieYummy(
    id = id,
    jenis = jenis,
    nama = nama,
    deskripsi = deskripsi,
    harga = harga
)

fun MieYummy.toUiStateMieYummy(isEnteryValid: Boolean = false): UIStateMieYummy = UIStateMieYummy(
    detailMieYummy = this.toDetailMieYummy(),
    isEnteryValid = isEnteryValid
)

