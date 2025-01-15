package com.youxiang8727.firebaseexample.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.youxiang8727.firebaseexample.MainViewModel
import com.youxiang8727.firebaseexample.ui.account.login.SignInWithEmailAndPasswordPage
import com.youxiang8727.firebaseexample.ui.main.MainPage

@Composable
fun MainNavigation() {
    val mainViewModel: MainViewModel = hiltViewModel()

    val user = mainViewModel.getFirebaseUser().collectAsState()

    val controller = rememberNavController()

    LaunchedEffect(user.value) {
        controller.navigateToScreen(
            if (user.value == null) Navigation.SIGN_IN_WITH_EMAIL_AND_PASSWORD_PAGE else Navigation.MAIN_PAGE
        )
    }

    NavHost(
        navController = controller,
        startDestination = Navigation.SIGN_IN_WITH_EMAIL_AND_PASSWORD_PAGE.route
    ) {
        composable(Navigation.MAIN_PAGE.route) {
            MainPage(mainViewModel)
        }

        composable(Navigation.SIGN_IN_WITH_EMAIL_AND_PASSWORD_PAGE.route) {
            SignInWithEmailAndPasswordPage()
        }
    }
}

enum class Navigation(
    val route: String,
    val enableBack: Boolean = false,
) {
    MAIN_PAGE("MAIN_PAGE"),
    SIGN_IN_WITH_EMAIL_AND_PASSWORD_PAGE("SIGN_IN_WITH_EMAIL_AND_PASSWORD_PAGE"),
}

fun NavHostController.navigateToScreen(navigation: Navigation) {
    this.navigate(navigation.route) {
        launchSingleTop = true

        popUpTo(this@navigateToScreen.graph.id) {
            inclusive = !navigation.enableBack
        }
    }
}