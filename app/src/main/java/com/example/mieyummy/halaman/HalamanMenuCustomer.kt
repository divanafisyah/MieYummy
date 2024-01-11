package com.example.mieyummy.halaman

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mieyummy.R
import com.example.mieyummy.data.MieYummy
import com.example.mieyummy.model.MenuViewModel
import com.example.mieyummy.model.PenyediaViewModel
import com.example.mieyummy.navigasi.DestinasiNavigasi
import com.example.mieyummy.navigasi.MieTopAppBar
import com.example.mieyummy.ui.theme.MieYummyTheme

object DestinasiMenuCust: DestinasiNavigasi {
    override val route= "MENU"
    override val titleRes= R.string.psn
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuCustomerScreen(
    modifier: Modifier = Modifier,
    viewModel: MenuViewModel = viewModel(factory = PenyediaViewModel.factory)

){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MieTopAppBar(
                title = stringResource(DestinasiMenuCust.titleRes),
                canNavigateBack = false,
                scrollBehavior= scrollBehavior)
        },){
        innerPadding->
        val uiStateMieYummy by viewModel.menuuistate.collectAsState()

        BodyCustMenu(itemCustMenu = uiStateMieYummy.listMie, modifier = Modifier.padding(innerPadding).fillMaxWidth(),)
    }

}
@Composable
fun BodyCustMenu(
    itemCustMenu: List<MieYummy>,
    modifier: Modifier = Modifier,
    onCustMenuClick:(Int)->Unit={},
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier)
    {
        ListCustMenu(itemCustMenu = itemCustMenu,
            modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_small)),
            onListCustClick = {onCustMenuClick(it.id)})
    }
}
@Composable
fun ListCustMenu(
    itemCustMenu: List<MieYummy>,
    modifier: Modifier = Modifier,
    onListCustClick: (MieYummy)-> Unit
){
    LazyColumn(modifier = Modifier){
        items(items = itemCustMenu, key ={it.id}){
            cust->

            CustMenu(mieYummy = cust, modifier = modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
                .clickable { onListCustClick(cust) })
        }
    }
}
@Composable
fun CustMenu(
    mieYummy: MieYummy,
    modifier: Modifier
){
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            Text(
                text = mieYummy.jenis,
                style = MaterialTheme.typography.titleMedium,
            )
            Spacer(Modifier.weight(1f))
            Text(
                text = mieYummy.nama,
                style = MaterialTheme.typography.titleMedium,
            )
            Spacer(Modifier.weight(1f))
            Text(
                text = mieYummy.deskripsi,
                style = MaterialTheme.typography.titleMedium,
            )
            Spacer(Modifier.weight(1f))
            Text(
                text = mieYummy.harga,
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewMenuCustomerScreen(){
    MieYummyTheme{
        MenuCustomerScreen()
    }
}