package com.example.mieyummy.halaman

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mieyummy.R
import com.example.mieyummy.navigasi.DestinasiNavigasi

object DestinasiMenuCust: DestinasiNavigasi {
    override val route= "MENU"
    override val titleRes= R.string.app_name
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanMenuCustomer(
    onMenuCust:()-> Unit,
    onDetailClick:(Int)->Unit={},
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
)
{
    var quantity by remember { mutableIntStateOf(0) }

    Column (modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween){
        Column (modifier =
        Modifier.padding(dimensionResource(R.dimen.padding_medium))){
            IconButton(
                onClick = { if (quantity > 1) quantity-- },
                modifier = Modifier.size(40.dp),
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.minus),
                    contentDescription = "Decrement"
                )
            }

            Text(
                text = quantity.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            IconButton(
                onClick = { quantity++ },
                modifier = Modifier.size(40.dp),
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.add),
                    contentDescription = "Increment"
                )
            }
            Divider(
                thickness = dimensionResource(R.dimen.padding_medium),
                modifier = Modifier.padding(bottom =
                dimensionResource(R.dimen.padding_medium)
                )
            )
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
                .weight(1f, false),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            ){

            }
            Divider(
                thickness = dimensionResource(R.dimen.padding_medium),
                modifier = Modifier.padding(bottom =
                dimensionResource(R.dimen.padding_medium)
                )
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium))
                    .weight(1f, false),
                horizontalArrangement =
                Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
                verticalAlignment = Alignment.Bottom
            ){
                OutlinedButton(
                    modifier = Modifier.weight(1f),
                    onClick = onCancelButtonClicked) {
                    Text(stringResource(R.string.cancel))
                }
                Button(
                    modifier = Modifier.weight(1f),
                    //the button is enabled when the user makes a selection
                    onClick = onNextButtonClicked
                ){
                    Text(stringResource(R.string.next))
                }
            }
        }
    }
}