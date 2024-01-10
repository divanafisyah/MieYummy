package com.example.mieyummy.halaman

import android.graphics.Color
import android.provider.CalendarContract
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mieyummy.R
import com.example.mieyummy.halaman.DestinasiLanding.LandingScreen
import com.example.mieyummy.model.MenuViewModel
import com.example.mieyummy.model.PenyediaViewModel
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
        Text(text = "WELCOME TO MIE YUMMY!", fontSize = 25.sp, fontWeight = FontWeight.Bold)

        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
                OutlinedCard(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                    ),
                    modifier = Modifier
                        .fillMaxSize() // Fill the entire available space
                        .padding(vertical = 30.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize() // Fill the entire card space
                    ) {
                        ElevatedCard(
                            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(dimensionResource(R.dimen.padding_medium))
                                    .weight(1f), // Allow buttons to expand evenly
                                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
                                verticalAlignment = Alignment.Bottom
                            ) {
                                Button(
                                    onClick = onLoginClick,
                                    modifier = Modifier.weight(1f) // Allow button to expand horizontally
                                ) {
                                    Text(stringResource(R.string.btn_login))
                                }
                                Button(
                                    onClick = onMenuCustClick,
                                    modifier = Modifier.weight(1f) // Allow button to expand horizontally
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxSize(),
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.menu),
                                            contentDescription = "Menu",
                                            modifier = Modifier.size(24.dp)
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(stringResource(R.string.btn_menu))
                                    }
                                }
                            }
                        }
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