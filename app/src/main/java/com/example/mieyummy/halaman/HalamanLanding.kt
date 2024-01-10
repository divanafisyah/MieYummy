package com.example.mieyummy.halaman

import android.graphics.Color
import android.provider.CalendarContract
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mieyummy.R
import com.example.mieyummy.model.MenuViewModel
import com.example.mieyummy.model.PenyediaViewModel
import com.example.mieyummy.ui.theme.MieYummyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LandingScreen(
    navigateToLogin: () -> Unit,
    navigateToMenu: () -> Unit,
    onLandingClick: () -> Unit,
    modifier: Modifier =Modifier,

) {
    Column(modifier = Modifier, verticalArrangement = Arrangement.SpaceBetween) {
        OutlinedCard(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),

            modifier = Modifier
                .fillMaxWidth(0.95f)
                .padding(vertical = 30.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {}
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewHalamanLanding(){
    MieYummyTheme{
        LandingScreen(navigateToLogin = {}, navigateToMenu = {}, onLandingClick = {})
    }
}