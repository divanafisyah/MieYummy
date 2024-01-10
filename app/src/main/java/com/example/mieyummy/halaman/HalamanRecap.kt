package com.example.mieyummy.halaman

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mieyummy.R
import com.example.mieyummy.model.CreateViewModel
import com.example.mieyummy.model.PenyediaViewModel
import com.example.mieyummy.navigasi.DestinasiNavigasi
import com.example.mieyummy.ui.theme.MieYummyTheme

object DestinasiRecap: DestinasiNavigasi {
    override val route= "RECAP"
    override val titleRes= R.string.app_name
}
@Composable
fun RecapScreen(
    navigateBack: ()-> Unit,
    viewModel: CreateViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = PenyediaViewModel.factory)
){
    val id: Int = 0
    val jenis: String =""
    val nama: String =""
    val deskripsi: String =""
    val harga: String =""

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    )
    {
        Text(
            text = "Pesanan Anda",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        ElevatedCard (
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = "ID :" + id,
                fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
            )
            Text(
                text = "Jenis :" + jenis,
                fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
            )
            Text(
                text = "Nama :" + nama,
                fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
            )
            Text(
                text = "Deskripsi Pesanan :" + deskripsi,
                fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
            )
            Text(
                text = "Harga :" + harga,
                fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewHalamanRecap() {
    MieYummyTheme {RecapScreen(navigateBack = {})    }
}