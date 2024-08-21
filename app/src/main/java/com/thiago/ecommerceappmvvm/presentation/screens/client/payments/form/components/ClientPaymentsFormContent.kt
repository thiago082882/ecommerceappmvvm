package com.thiago.ecommerceappmvvm.presentation.screens.client.payments.form.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.presentation.components.DefaultButton
import com.thiago.ecommerceappmvvm.presentation.components.DefaultTextField
import com.thiago.ecommerceappmvvm.presentation.navigation.screen.client.ShoppingBagScreen
import com.thiago.ecommerceappmvvm.presentation.screens.client.payments.form.ClientPaymentsFormViewModel
import com.thiago.ecommerceappmvvm.presentation.screens.client.payments.form.mapper.toCardTokenBody

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ClientPaymentsFormContent(
    paddingValues: PaddingValues,
    navController: NavHostController,
    identificationType: List<String>,
    vm: ClientPaymentsFormViewModel = hiltViewModel()
) {

    val state = vm.state
    var selectedItem by remember { mutableStateOf(identificationType[0]) }
    vm.onIdentificationTypeInput(selectedItem)
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(20.dp)
    ) {

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.cardNumber,
            onValueChange = { vm.onCardNumberInput(it) },
            label = "Número do cartão",
            icon = Icons.Default.Settings,
            keyboardType = KeyboardType.Number
        )
        Spacer(modifier = Modifier.height(5.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            DefaultTextField(
                modifier = Modifier.weight(1f),
                value = state.expirationYear,
                onValueChange = { vm.onYearExpirationInput(it) },
                label = "Ano de expiração YYYY",
                icon = Icons.Default.DateRange,
                keyboardType = KeyboardType.Number,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(5.dp))

            DefaultTextField(
                modifier = Modifier.weight(1f),
                value = state.expirationMonth,
                onValueChange = { vm.onMonthExpirationInput(it) },
                label = "Mês de expiração  MM",
                icon = Icons.Default.DateRange,
                keyboardType = KeyboardType.Number,
                fontSize = 12.sp
            )
        }
        Spacer(modifier = Modifier.height(5.dp))

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.name,
            onValueChange = { vm.onNameInput(it) },
            label = "Nome do titular",
            icon = Icons.Default.Person
        )
        Spacer(modifier = Modifier.height(5.dp))

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.securityCode,
            onValueChange = { vm.onSecurityCodeInput(it) },
            label = "Código de segurança",
            icon = Icons.Default.Lock
        )
        Spacer(modifier = Modifier.height(5.dp))
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
           OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = selectedItem,
                onValueChange = {},
                readOnly = true,
                label = {
                    Text(text = "Tipo de Identificação")
                },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White
                )
            )
            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                identificationType.forEachIndexed { index, identification ->
                    DropdownMenuItem(
                        onClick = {
                            selectedItem = identification
                            vm.onIdentificationTypeInput(selectedItem)
                            expanded = false
                        }
                    ) {
                        Text(text = identification)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.number,
            onValueChange = { vm.onIdentificationNumberInput(it) },
            label = "Número de identificação",
            icon = Icons.Default.List,
            keyboardType = KeyboardType.Number
        )
        Spacer(modifier = Modifier.weight(1f))
        DefaultButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Continuar",
            onClick = {
                navController.navigate(route = ShoppingBagScreen.PaymentsInstallments.passPaymentForm(state.toCardTokenBody().toJson())) {
                    popUpTo(ShoppingBagScreen.PaymentsForm.route) { inclusive = true }
                }
            }
        )

    }
}