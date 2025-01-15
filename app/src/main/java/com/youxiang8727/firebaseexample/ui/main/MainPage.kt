package com.youxiang8727.firebaseexample.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.youxiang8727.firebaseexample.MainViewModel

@Composable
fun MainPage(
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val user = mainViewModel.getFirebaseUser().collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "User: ${user.value}"
                )
            }
        }
    }
}