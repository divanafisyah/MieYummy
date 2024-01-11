package com.example.mieyummy.model

import androidx.lifecycle.ViewModel
import com.example.mieyummy.data.MieYummy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderViewModel : ViewModel(){
    private val _stateUI = MutableStateFlow(MieYummy())
    val stateUi: StateFlow<MieYummy> = _stateUI.asStateFlow()

    fun setJenis(menu:String){
        _stateUI.update { stateSaatIni -> stateSaatIni.copy(jenis = menu)}
    }
    fun setNama(menu:String){
        _stateUI.update { stateSaatIni -> stateSaatIni.copy(nama = menu)}
    }
    fun setDesk(menu:String){
        _stateUI.update { stateSaatIni -> stateSaatIni.copy(deskripsi = menu)}
    }
    fun setHarga(menu:String){
        _stateUI.update { stateSaatIni -> stateSaatIni.copy(harga = menu)}
    }

}
