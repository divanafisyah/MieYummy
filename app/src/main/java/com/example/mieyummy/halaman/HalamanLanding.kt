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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mieyummy.R
import com.example.mieyummy.halaman.DestinasiLanding.LandingScreen
import com.example.mieyummy.navigasi.DestinasiNavigasi
import com.example.mieyummy.ui.theme.MieYummyTheme

object DestinasiLanding: DestinasiNavigasi {
    override val route = "LANDING"
    override val titleRes = R.string.app_name

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LandingScreen(
        onMenuCustClick:()-> Unit,
        onLoginClick:() -> Unit,
        modifier: Modifier = Modifier,

        ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        )
        {
            Spacer(modifier = Modifier.height(100.dp)
            )
            Text(
                text = "WELCOME TO MIE YUMMY!",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium))
                    .weight(1f), // Allow buttons to expand evenly
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
                verticalAlignment = Alignment.Bottom
            ) {
                Column(
                    modifier = Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Button(
                        onClick = onLoginClick,
                        modifier = Modifier
                            .width(350.dp)
                            .height(75.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(R.drawable.user),
                                contentDescription = "Admin",
                                modifier = Modifier.size(30.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "ADMIN",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(100.dp)
                    )
                    Button(
                        onClick = onLoginClick,
                        modifier = Modifier
                            .width(350.dp)
                            .height(75.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(R.drawable.menu_white),
                                contentDescription = "Menu",
                                modifier = Modifier.size(30.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "PESAN DISINI",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(250.dp)
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewHalamanLanding(){
    MieYummyTheme{
        LandingScreen(onMenuCustClick = {}, onLoginClick = {})
    }
}