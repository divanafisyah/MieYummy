package com.example.mieyummy.halaman

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.mieyummy.R
import com.example.mieyummy.data.MieYummy
import com.example.mieyummy.navigasi.DestinasiNavigasi
import com.example.mieyummy.ui.theme.FormatHarga
import com.example.mieyummy.ui.theme.MieYummyTheme

object DestinasiRecap: DestinasiNavigasi {
    override val route= "RECAP"
    override val titleRes= R.string.app_name
}
@Composable
fun HalamanRecap(
    mieYummy: MieYummy,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    val items = listOf(
        Pair(stringResource(R.string.quantity), mieYummy.jumlah),
        Pair(stringResource(R.string.jenis), mieYummy.jenis)
    )

    val contact= listOf(
        Pair(stringResource(id = R.string.nama), mieYummy.nama),
        Pair(stringResource(id = R.string.desk), mieYummy.deskripsi),
        Pair(stringResource(id = R.string.price), mieYummy.harga)
    )
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Column (
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ){
            contact.forEach { item ->
                Column {
                    Text(item.first, fontWeight = FontWeight.Bold)
                    Text(text = item.second)
                }
                Divider(
                    thickness = dimensionResource(R.dimen.padding_medium)
                )
            }

            items.forEach { item ->
                Column {
                    Text(item.first.uppercase())
                    Text(text = item.second.toString(), fontWeight = FontWeight.Bold)
                }
                Divider(
                    thickness = dimensionResource(R.dimen.padding_medium)
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
            FormatHarga(
                subtotal = mieYummy.harga,
                modifier = Modifier.align(Alignment.End)
            )
        }
        Row (
            modifier = Modifier
                .weight(1f, false)
                .padding(dimensionResource(R.dimen.padding_medium))
        ){
            Column (
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ){
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { }
                ) {
                    Text(stringResource(R.string.back))
                }
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onCancelButtonClicked
                ) {
                    Text(stringResource(R.string.cancel))
                }
            }
        }
    }
}