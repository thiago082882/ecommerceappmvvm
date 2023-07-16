package com.thiago.ecommerceappmvvm.presentation.screens.auth.register.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thiago.ecommerceappmvvm.R

@Composable
fun HeaderBanner() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(top=35.dp, bottom = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .height(80.dp)
                .width(80.dp)
                .padding(top = 20.dp),
            painter = painterResource(id = R.drawable.user_form),
            contentDescription = ""
        )
        Text(
            modifier = Modifier
                .padding(top = 7.dp, start = 10.dp),
            text = "INGRESSAR ESTA INFORMAÇÃO",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.White
        )
    }
}