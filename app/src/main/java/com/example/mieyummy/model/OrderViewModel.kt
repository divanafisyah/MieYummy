//package com.example.mieyummy.model
//
//import androidx.lifecycle.ViewModel
//import com.example.mieyummy.data.MieYummy
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.flow.update
//import java.text.NumberFormat
//
//private const val HARGA_PER_CUP = 3000
//class OrderViewModel : ViewModel() {
//    private val _stateUI = MutableStateFlow(MieYummy())
//    val stateUI: StateFlow<MieYummy> = _stateUI.asStateFlow()
//
//    fun setJumlah(jmlMie: Int) {
//        _stateUI.update { stateSaatIni ->
//            stateSaatIni.copy(
//                jumlah = jmlMie,
//                harga = hitungHarga(jumlah = jmlMie)
//            )
//        }
//    }
//    fun setJenis(pilihan: String) {
//        _stateUI.update { stateSaatIni -> stateSaatIni.copy(jenis = "") }
//    }
//    fun resetOrder() {
//        _stateUI.value = MieYummy()
//    }
//    private fun hitungHarga(
//        jumlah: Int = _stateUI.value.jumlah,
//    ): String {
//        val kalkulasiHarga = jumlah * HARGA_PER_CUP
//
//        return NumberFormat.getNumberInstance().format(kalkulasiHarga)
//    }
//
//    fun setContact(list: MutableList<String>){
//        _stateUI.update { stateSaatini ->
//            stateSaatini.copy(
//                jenis = list[0],
//                deskripsi = list[1],
//                harga = list[2],
//            )
//        }
//    }
//}