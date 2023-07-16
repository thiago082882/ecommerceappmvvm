package com.thiago.ecommerceappmvvm.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.thiago.ecommerceappmvvm.presentation.ui.theme.Blue500

@Composable
fun DefaultTextField (
    modifier: Modifier,
    value : String,
    onValueChange :(value :String)-> Unit,
    label : String,
    icon : ImageVector,
    keyboardType: KeyboardType =  KeyboardType.Text,
    hideText : Boolean = false

) {

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        label = {
            Text(text = label)
        },
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription ="",
                tint = Blue500
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType=keyboardType),
        visualTransformation = if(hideText) PasswordVisualTransformation() else VisualTransformation.None
    )
}