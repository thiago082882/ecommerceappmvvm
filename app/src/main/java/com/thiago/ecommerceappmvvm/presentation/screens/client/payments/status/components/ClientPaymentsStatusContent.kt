package com.thiago.ecommerceappmvvm.presentation.screens.client.payments.status.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.presentation.screens.client.payments.status.ClientPaymentsStatusViewModel
import com.thiago.ecommerceappmvvm.R
import com.thiago.ecommerceappmvvm.presentation.MainActivity
import com.thiago.ecommerceappmvvm.presentation.components.DefaultButton

@Composable
fun ClientPaymentsStatusContent(paddingValues: PaddingValues, navController: NavHostController, vm: ClientPaymentsStatusViewModel = hiltViewModel()) {

    val activity = LocalContext.current as? Activity

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(150.dp),
            painter = painterResource(id = R.drawable.comprobado),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Seu pedido foi processado com sucesso /nUsando o cartão ${vm.paymentResponse.paymentMethodID} **** ${vm.paymentResponse.card.lastFourDigits}",
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(7.dp))
        Text(
            text = "Veja o status da sua compra na seção de pedidos",
            textAlign = TextAlign.Center,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        DefaultButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Finalizar compra",
            onClick = {
                activity?.finish()
                activity?.startActivity(Intent(activity, MainActivity::class.java))
            }
        )
    }
    
}
