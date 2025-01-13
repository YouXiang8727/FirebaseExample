package com.youxiang8727.firebaseexample.ui.account.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.youxiang8727.firebaseexample.ui.account.login.mvi.SignInWithEmailAndPasswordPageViewModel

@Composable
fun SignInWithEmailAndPasswordPage() {
    val signInWithEmailAndPasswordPageViewModel: SignInWithEmailAndPasswordPageViewModel = hiltViewModel()

    Card(
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = signInWithEmailAndPasswordPageViewModel.state.email,
                onValueChange = {
                    signInWithEmailAndPasswordPageViewModel.inputEmailAddress(it)
                },
                singleLine = true,
                label = {
                    Text(
                        text = "電子信箱"
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = signInWithEmailAndPasswordPageViewModel.state.password,
                onValueChange = {
                    signInWithEmailAndPasswordPageViewModel.inputPassword(it)
                },
                singleLine = true,
                label = {
                    Text(
                        text = "密碼"
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        signInWithEmailAndPasswordPageViewModel.createUserWithEmailAndPassword()
                    },
                    enabled = signInWithEmailAndPasswordPageViewModel.state.isLoginButtonEnabled
                ) {
                    Text(
                        text = "註冊"
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = {
                        signInWithEmailAndPasswordPageViewModel.signInWithEmailAndPassword()
                    },
                    enabled = signInWithEmailAndPasswordPageViewModel.state.isLoginButtonEnabled
                ) {
                    Text(
                        text = "登入"
                    )
                }
            }
        }
    }
}