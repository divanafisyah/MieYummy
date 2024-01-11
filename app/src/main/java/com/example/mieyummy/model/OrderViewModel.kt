//package com.example.mieyummy.model
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.mieyummy.data.MieYummy
//import com.example.mieyummy.repository.RepositoryMie
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.SharingStarted
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.filterNotNull
//import kotlinx.coroutines.flow.map
//import kotlinx.coroutines.flow.stateIn
//
//class OrderViewModel(private val repositoryMie: RepositoryMie) : ViewModel() {
//
//    companion object {
//        private const val TIMEOUT_MILIES = 5_000L
//    }
//
//    // State untuk daftar menu
//    val orderistate: StateFlow<OrderViewModel.OrderUiState> =
//        repositoryMie.getAllMieStream()
//            .filterNotNull()
//            .map { OrderViewModel.OrderUiState(listOrder = it.toList())}.stateIn(scope = viewModelScope, started = SharingStarted.WhileSubscribed(
//                TIMEOUT_MILIES), initialValue = OrderUiState())
//
//    // State untuk pesanan
//    val listOrder = MutableStateFlow(emptyList<>())
//    val orderList: StateFlow<List<listMie> get() = listMie.asStateFlow()
//
//    // Fungsi untuk menambah pesanan
//    fun addToOrder(mie: Mie) {
//        listMie.value = listMie.value + mie
//    }
//
//    // Fungsi untuk menghapus pesanan
//    fun removeFromOrder(mie: Mie) {
//        listMie.value = listMie.value - mie
//    }
//
//    // Fungsi untuk menghitung total pesanan
//    fun calculateTotalOrder(): Double {
//        return listMie.value.sumByDouble { it.price }
//    }
//
//    data class OrderUiState(
//        val listOrder: List<com.example.mieyummy.data.MieYummy> = listOf()
//    )
//}
//
//
//
////class OrderViewModel : ViewModel() {
////    private val _stateUI = MutableStateFlow(MieYummy())
////    val stateUI: StateFlow<MieYummy> = _stateUI.asStateFlow()
////
////    fun setJumlah(jmlMie: Int) {
////        _stateUI.update { stateSaatIni ->
////            stateSaatIni.copy(
////                jumlah = jmlMie,
////                harga = hitungHarga(jumlah = jmlMie)
////            )
////        }
////    }
////    fun setJenis(pilihan: String) {
////        _stateUI.update { stateSaatIni -> stateSaatIni.copy(jenis = "") }
////    }
////    fun resetOrder() {
////        _stateUI.value = MieYummy()
////    }
////    private fun hitungHarga(
////        jumlah: Int = _stateUI.value.jumlah,
////    ): String {
////        val kalkulasiHarga = jumlah * HARGA_PER_CUP
////
////        return NumberFormat.getNumberInstance().format(kalkulasiHarga)
////    }
////
////    fun setContact(list: MutableList<String>){
////        _stateUI.update { stateSaatini ->
////            stateSaatini.copy(
////                jenis = list[0],
////                deskripsi = list[1],
////                harga = list[2],
////            )
////        }
////    }
////}