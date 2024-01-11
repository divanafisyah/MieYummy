package com.example.mieyummy.halaman

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
    onCustMenuClick:()->Unit={},
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
        Spacer(modifier = Modifier.height(250.dp)
        )
        ElevatedCard (
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            modifier = Modifier
                .width(300.dp)
                .height(200.dp)
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
        Spacer(modifier = Modifier
            .height(250.dp))
        Button(
            onClick = onCustMenuClick,
            modifier = Modifier
                .width(350.dp)
                .height(50.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Kembali",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewHalamanRecap() {
    MieYummyTheme {RecapScreen(onCustMenuClick = {})    }
}