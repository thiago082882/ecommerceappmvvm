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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.thiago.ecommerceappmvvm.presentation.ui.theme.Blue500

@Composable
fun DefaultTextField (
    modifier: Modifier,
    value : String,
    onValueChange :(value :String)-> Unit,
    label : String,
    icon : ImageVector,
    keyboardType: KeyboardType =  KeyboardType.Text,
    hideText : Boolean = false,
    fontSize : TextUnit = 15.sp

) {

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        label = {
            Text(text = label,fontSize=fontSize)
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