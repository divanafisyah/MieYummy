package com.example.mieyummy.navigasi

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
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mieyummy.R
import com.example.mieyummy.SplashScreen
import com.example.mieyummy.halaman.CreateMenuScreen
import com.example.mieyummy.halaman.DestinasiCreate
import com.example.mieyummy.halaman.DestinasiLanding
import com.example.mieyummy.halaman.DestinasiLanding.LandingScreen
import com.example.mieyummy.halaman.DestinasiLogin
import com.example.mieyummy.halaman.DestinasiMenu
import com.example.mieyummy.halaman.DestinasiMenuCust
import com.example.mieyummy.halaman.DestinasiRecap
import com.example.mieyummy.halaman.EditDestination
import com.example.mieyummy.halaman.EditMenuScreen
import com.example.mieyummy.halaman.LoginScreen
import com.example.mieyummy.halaman.MenuCustomerScreen
import com.example.mieyummy.halaman.MenuScreen
import com.example.mieyummy.halaman.RecapScreen


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
        startDestination = "SplashScreen",
        modifier = Modifier
    ) {
        composable("SplashScreen"){
            SplashScreen(navController = navController)
        }
        composable(DestinasiLanding.route){
            LandingScreen (onLoginClick = {navController.navigate(DestinasiLogin.route)},
                onMenuCustClick = {navController.navigate(DestinasiMenuCust.route)},
                )
        }
        composable(DestinasiLogin.route){
            LoginScreen (onLogin = {navController.navigate(DestinasiMenu.route)})

        }
        composable(DestinasiMenuCust.route){
            MenuCustomerScreen()
            
        }
        composable(DestinasiRecap.route){
            RecapScreen(navigateBack = { /*TODO*/ })
        }
        composable(DestinasiMenu.route) {
            MenuScreen(navigateToItemEntry = { navController.navigate(DestinasiCreate.route) },
                onDetailClick = {
                    navController.navigate("${EditDestination.route}/$it")
                },
                onLandingClick = {navController.navigate(DestinasiLanding.route)}

                )
        }
        composable(DestinasiCreate.route) {
            CreateMenuScreen(navigateBack = { navController.popBackStack()},
                )
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

