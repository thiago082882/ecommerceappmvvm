package com.thiago.ecommerceappmvvm.presentation.screens.profile.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.thiago.ecommerceappmvvm.presentation.MainActivity
import com.thiago.ecommerceappmvvm.presentation.components.DefaultButton
import com.thiago.ecommerceappmvvm.presentation.screens.profile.ProfileViewModel

@Composable
fun ProfileContent(vm: ProfileViewModel = hiltViewModel()) {
    val activity = LocalContext.current as? Activity
    DefaultButton(
        modifier = Modifier.padding(),
        text = "Encerrar Sessão",
        onClick = {
            vm.logout()
            activity?.finish()
            activity?.startActivity(Intent(activity,MainActivity::class.java))

        })

}