package com.thiago.ecommerceappmvvm.presentation.screens.auth.register.mapper

import com.thiago.ecommerceappmvvm.domain.models.User
import com.thiago.ecommerceappmvvm.presentation.screens.auth.register.RegisterState

fun RegisterState.toUser(): User {
    return User(
        name = name,
        lastname = lastname,
        email = email,
        phone = phone,
        password = password
    )
}