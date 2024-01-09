package com.example.admin.navigasi

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.admin.R
import com.example.admin.halaman.CreateMenuScreen
import com.example.admin.halaman.DestinasiCreate
import com.example.admin.halaman.DestinasiLogin

import com.example.admin.halaman.DestinasiMenu
import com.example.admin.halaman.EditDestination
import com.example.admin.halaman.EditMenuScreen
import com.example.admin.halaman.LoginScreen
import com.example.admin.halaman.MenuScreen


@Composable
fun MieYummyApp(navController: NavHostController = rememberNavController()){
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MieTopAppBar(title: String,
                 canNavigateBack: Boolean,
                 modifier: Modifier = Modifier,
                 scrollBehavior: TopAppBarScrollBehavior? = null,
                 navigateUp: () -> Unit = {}
) {
    CenterAlignedTopAppBar(title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back)
                    )
                }
            }
        }
    )
}

@Composable
fun HostNavigasi(
        navController: NavHostController,
        modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = DestinasiLogin.route,
        modifier = Modifier
    ) {
        composable(DestinasiLogin.route){
            LoginScreen (onLogin = {navController.navigate(DestinasiMenu.route)})

        }
        composable(DestinasiMenu.route) {
            MenuScreen(navigateToItemEntry = { navController.navigate(DestinasiCreate.route) },
                onDetailClick = {
                    navController.navigate("${EditDestination.route}/$it")
                }
                )
        }

        composable(DestinasiCreate.route) {
            CreateMenuScreen(navigateBack = { navController.popBackStack() })
        }
        composable(
            EditDestination.routeWithArgs,
            arguments = (listOf(navArgument(EditDestination.itemIdArg) {
                type = NavType.IntType
            }))
        )
        {
            EditMenuScreen(
                navigationBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}

