package com.example.mieyummy.halaman


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon

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
import androidx.compose.ui.text.style.TextAlign
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


object DestinasiMenu: DestinasiNavigasi {
    override val route= "Menu"
    override val titleRes= R.string.mieymm
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(
    navigateToItemEntry :()->Unit,
    modifier: Modifier=Modifier,
    onLandingClick: ()->Unit,
    onDetailClick:(Int)->Unit={},
    viewModel: MenuViewModel =viewModel(factory = PenyediaViewModel.factory)
    ){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MieTopAppBar(
                title = stringResource(DestinasiMenu.titleRes),
                canNavigateBack = false,
                scrollBehavior= scrollBehavior)
        },
        floatingActionButton = {
            Column {
                FloatingActionButton(onClick = navigateToItemEntry,
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
                ) {
                    Icon(imageVector = Icons.Default.Add,
                        contentDescription = stringResource(id = R.string.entry_menu) )
                }
                FloatingActionButton(onClick = onLandingClick,
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
                ) {
                    Icon(imageVector = Icons.Default.ExitToApp,
                        contentDescription = "")
                }
            }


        }

    ) {innerPadding ->
        val uiStateMieYummy by viewModel.menuuistate.collectAsState()
            BodyMenu(itemMieYummy = uiStateMieYummy.listMie,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth(),
                onMenuClick = onDetailClick)
    }
}

@Composable
fun BodyMenu(
    itemMieYummy: List<MieYummy>,
    modifier: Modifier= Modifier,
    onMenuClick:(Int)->Unit={}
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier)
    {
            if (itemMieYummy.isEmpty()) {
                Text(
                    text = stringResource(id = R.string.deskripsi_no_item),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge,
                )
            } else {
                ListMenu(
                    itemMieYummy = itemMieYummy,
                    modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_small)),
                    onItemClick = { onMenuClick(it.id) }
                )
            }
    }
}

@Composable
fun ListMenu(
    itemMieYummy: List<MieYummy>,
    modifier: Modifier = Modifier,
    onItemClick: (MieYummy)->Unit
){
    LazyColumn(
        modifier = Modifier){
        items(items = itemMieYummy, key ={it.id}){
            person->

            DataMenuAdmin(
                mieYummy = person,
                modifier = Modifier
                    .padding(dimensionResource(id =R.dimen.padding_small))
                    .clickable { onItemClick(person) }
                )
        }
    }
}

@Composable
fun DataMenuAdmin(
    mieYummy: MieYummy,
    modifier: Modifier = Modifier
) {
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

