package com.thiago.ecommerceappmvvm.presentation.screens.client.address.list.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.thiago.ecommerceappmvvm.domain.model.Address

@Composable
fun ClientAddressListContent(addressList: List<Address>) {

    LazyColumn() {
        items(
            items = addressList
        ) { address ->
            ClientAddressListItem(address = address)
        }
    }

}