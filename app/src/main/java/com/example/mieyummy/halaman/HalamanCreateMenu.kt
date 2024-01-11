package com.example.mieyummy.halaman


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mieyummy.R
import com.example.mieyummy.model.CreateViewModel
import com.example.mieyummy.model.DetailMieYummy
import com.example.mieyummy.model.PenyediaViewModel
import com.example.mieyummy.model.UIStateMieYummy
import com.example.mieyummy.navigasi.DestinasiNavigasi
import com.example.mieyummy.navigasi.MieTopAppBar
import com.example.mieyummy.ui.theme.MieYummyTheme
import kotlinx.coroutines.launch

object DestinasiCreate: DestinasiNavigasi {
    override val route = "item_entry"
    override val titleRes = R.string.entry_menu}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateMenuScreen(
    navigateBack: ()-> Unit,
    onNavigateUp:()-> Unit,
    modifier: Modifier = Modifier,
    viewModel: CreateViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = PenyediaViewModel.factory)
){
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MieTopAppBar(
                title = stringResource(DestinasiMenu.titleRes),
                canNavigateBack = true,
                navigateUp = onNavigateUp,
                scrollBehavior = scrollBehavior
            )
        }
    ){  innerPadding ->
        CreateMenuBody(
            uiStateMieYummy = viewModel.uiStateMieYummy,
            onMieValueChange = viewModel::updateUiState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.saveMieYummy()
                    navigateBack()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )

    }
}

@Composable
fun CreateMenuBody(
    uiStateMieYummy: UIStateMieYummy,
    onMieValueChange:(DetailMieYummy)->Unit,
    onSaveClick:()-> Unit,
    modifier: Modifier = Modifier
){
    Column (
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_large)),
        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
    ){
        FormInputMenu(
            detailMieYummy = uiStateMieYummy.detailMieYummy,
            onValueChange = onMieValueChange,
            modifier = modifier.fillMaxWidth()
        )
        Button(
            onClick = onSaveClick,
            enabled = uiStateMieYummy.isEnteryValid,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.btn_submit))
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInputMenu(
    detailMieYummy: DetailMieYummy,
    modifier: Modifier = Modifier,
    onValueChange: (DetailMieYummy)->Unit={},
    enabled: Boolean = true
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ) {
        OutlinedTextField(
            value = detailMieYummy.jenis,
            onValueChange = { onValueChange(detailMieYummy.copy(jenis = it)) },
            label = { Text(stringResource(R.string.jenis)) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled
        )
        OutlinedTextField(
            value = detailMieYummy.nama,
            onValueChange = { onValueChange(detailMieYummy.copy(nama = it)) },
            label = { Text(stringResource(R.string.nama)) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled
        )
        OutlinedTextField(
            value = detailMieYummy.deskripsi,
            onValueChange = { onValueChange(detailMieYummy.copy(deskripsi = it)) },
            label = { Text(stringResource(R.string.desk)) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled
        )
        OutlinedTextField(
            value = detailMieYummy.harga,
            onValueChange = { onValueChange(detailMieYummy.copy(harga = it)) },
            label = { Text(stringResource(R.string.price)) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled
        )
        if (enabled) {
            Text(
                text = stringResource(id = R.string.required_field),
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
            )
        }
        Divider(
            thickness = dimensionResource(id = R.dimen.padding_small),
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_medium))

        )

    }
}

