package com.thiago.ecommerceappmvvm.presentation.screens.profile.update.mapper

import com.thiago.ecommerceappmvvm.domain.models.User
import com.thiago.ecommerceappmvvm.presentation.screens.profile.update.ProfileUpdateState

fun ProfileUpdateState.toUser(): User {
    return User(
        name = name,
        lastname = lastname,
        phone = phone,
        image = image
    )
}