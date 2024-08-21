package com.thiago.ecommerceappmvvm.presentation.screens.client.payments.installments.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.thiago.ecommerceappmvvm.domain.model.PayerCost
import com.thiago.ecommerceappmvvm.presentation.components.DefaultButton
import com.thiago.ecommerceappmvvm.presentation.screens.client.payments.installments.ClientPaymentsInstallmentsViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ClientPaymentsInstallmentsContent(paddingValues: PaddingValues, installment: List<PayerCost>,vm :ClientPaymentsInstallmentsViewModel= hiltViewModel()) {

    var expanded by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(20.dp)
    ) {

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = vm.selectedInstallment?.recommendedMessage ?: "",
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
                installment.forEachIndexed { index, installment ->
                    DropdownMenuItem(onClick = {
                        vm.selectedInstallment = installment
                        expanded = false
                    }) {
                        Text(text = installment.recommendedMessage)
                    }
                }
            }
        }
}
}