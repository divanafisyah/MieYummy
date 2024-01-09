package com.example.mieyummy.halaman

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mieyummy.R
import com.example.mieyummy.model.EditViewModel
import com.example.mieyummy.model.ItemDeleteUiState
import com.example.mieyummy.model.PenyediaViewModel
import com.example.mieyummy.model.toMieYummy
import com.example.mieyummy.navigasi.DestinasiNavigasi
import com.example.mieyummy.navigasi.MieTopAppBar
import kotlinx.coroutines.launch

object EditDestination : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_menu
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditMenuScreen(
    navigationBack:()-> Unit,
    onNavigateUp:()-> Unit,
    modifier: Modifier= Modifier,
    viewModel: EditViewModel = viewModel(factory = PenyediaViewModel.factory )
){
    val uiState = viewModel.uiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold (
        topBar = {
            MieTopAppBar(
                title = stringResource(EditDestination.titleRes) ,
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ) { innerPadding ->
       Column (
           modifier = modifier.padding(dimensionResource(id = R.dimen.padding_small)),
           verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
       ){
           CreateMenuBody(
               uiStateMieYummy = viewModel.mieUiState,
               onMieValueChange = viewModel::updateUiState,
               onSaveClick = {
                   coroutineScope.launch {
                       viewModel.updateMenu()
                       navigationBack()
                   }
               },
               modifier = Modifier.padding(innerPadding)
           )
           ItemDeleteBody(
               itemDeleteUiState = uiState.value,
               onDelete = {
                   coroutineScope.launch {
                       viewModel.deleteItem()
                       navigationBack()
                   }
               },
               modifier = Modifier.padding(innerPadding))
       }

    }
}

@Composable
private fun ItemDeleteBody(
    itemDeleteUiState: ItemDeleteUiState,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ){
        var deleteConfirmationRequired by rememberSaveable { mutableStateOf(false) }
        OutlinedButton(
            onClick = {deleteConfirmationRequired = true},
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.delete))
        }
        if (deleteConfirmationRequired){
            DeleteConfirmationDialog(
                onDeleteConfirm = {
                    deleteConfirmationRequired = false
                    onDelete() },
                onDeleteCancel = {deleteConfirmationRequired = false},
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
            )
        }
    }
}

@Composable
private fun DeleteConfirmationDialog(
    onDeleteConfirm: () -> Unit, onDeleteCancel: () -> Unit, modifier: Modifier = Modifier
){
    AlertDialog(onDismissRequest = { /*Do nothing*/ },
        title = { Text(stringResource(R.string.attention)) },
        text = { Text(stringResource(R.string.delete)) },
        modifier = modifier,
        dismissButton = {
            TextButton(onClick = onDeleteCancel) {
                Text(text = stringResource(R.string.no))
            }
        },
        confirmButton = {
            TextButton(onClick = onDeleteConfirm) {
                Text(text = stringResource(R.string.yes))
            }
        }
    )
}

