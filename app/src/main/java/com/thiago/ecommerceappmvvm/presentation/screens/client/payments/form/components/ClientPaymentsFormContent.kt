package com.thiago.ecommerceappmvvm.presentation.screens.client.payments.form.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.thiago.ecommerceappmvvm.presentation.components.DefaultButton
import com.thiago.ecommerceappmvvm.presentation.components.DefaultTextField
import com.thiago.ecommerceappmvvm.presentation.screens.client.payments.form.ClientPaymentsFormViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ClientPaymentsFormContent(
    paddingValues: PaddingValues,
    identificationType: List<String>,
    vm: ClientPaymentsFormViewModel = hiltViewModel()
) {

    val state = vm.state

    var expanded by remember { mutableStateOf(false) }

    var selectedItem by remember {
        mutableStateOf(identificationType[0])

    }

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
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.name,
            onValueChange = { vm.onNameInput(it) },
            label = "Nome do titular",
            icon = Icons.Default.Person
        )

        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.securityCode,
            onValueChange = { vm.onSecurityCodeInput(it) },
            label = "Código de segurança",
            icon = Icons.Default.Lock
        )

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
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
                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )
            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                identificationType.forEachIndexed { index, identification ->
                    DropdownMenuItem(onClick = {
                        selectedItem = identification
                        expanded = false
                    }) {
                        Text(text = identification)
                    }
                }
            }
        }
        DefaultTextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.securityCode,
            onValueChange = { vm.onIdentificationNumberInput(it) },
            label = "Número de identificação",
            icon = Icons.Default.List,
            keyboardType = KeyboardType.Number
        )
        Spacer(modifier = Modifier.weight(1f))
        DefaultButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Continuar",
            onClick = { /*TODO*/ })

    }

}
