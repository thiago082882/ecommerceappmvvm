package com.thiago.ecommerceappmvvm.presentation.screens.client.address.create.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Info

import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

import com.thiago.ecommerceappmvvm.R
import com.thiago.ecommerceappmvvm.presentation.components.DefaultButton
import com.thiago.ecommerceappmvvm.presentation.components.DefaultTextField
import com.thiago.ecommerceappmvvm.presentation.screens.client.address.create.ClientAddressCreateViewModel

@Composable
fun ClientAddressCreateContent(vm: ClientAddressCreateViewModel = hiltViewModel()) {

        val state = vm.state

        Column(
                modifier = Modifier
                        .padding()
                        .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
                Spacer(modifier = Modifier.height(40.dp))
                Image(
                        modifier = Modifier
                                .size(150.dp)
                                .clip(CircleShape)
                                .align(Alignment.CenterHorizontally),
                        painter = painterResource(id = R.drawable.map),
                        contentDescription = ""
                )
                Spacer(modifier = Modifier.height(40.dp))
                Card(
                        modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                        shape = RoundedCornerShape(
                                topEnd = 40.dp,
                                topStart = 40.dp
                        ),
                        backgroundColor = Color.White
                ) {

                        Column(
                                modifier = Modifier.padding(30.dp)
                        ) {

                                DefaultTextField(
                                        modifier = Modifier.fillMaxWidth(),
                                        value = state.address,
                                        onValueChange = { vm.onAddressInput(it) },
                                        label = "Endereço",
                                        icon = Icons.Default.LocationOn
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                DefaultTextField(
                                        modifier = Modifier.fillMaxWidth(),
                                        value = state.neighborhood,
                                        onValueChange = { vm.onNeighborhoodInput(it) },
                                        label = "Bairro",
                                        icon = Icons.Default.Info
                                )
                                Spacer(modifier = Modifier.weight(1f))
                                DefaultButton(
                                        modifier = Modifier.fillMaxWidth(),
                                        text = "Criar endereço",
                                        onClick = { vm.createAddress() }
                                )
                        }

                }

        }

}