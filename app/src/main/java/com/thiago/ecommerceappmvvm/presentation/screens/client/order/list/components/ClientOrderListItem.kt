package com.thiago.ecommerceappmvvm.presentation.screens.client.order.list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.thiago.ecommerceappmvvm.presentation.navigation.screen.client.ClientOrderScreen
import com.thiago.ecommerceappmvvm.domain.model.Order
import com.thiago.ecommerceappmvvm.presentation.ui.theme.Gray100

@Composable
fun ClientOrderListItem(order: Order, navController: NavHostController) {

    Column(
        modifier = Modifier
            .padding(top = 20.dp, start = 20.dp, end = 20.dp)
            .clickable {
                navController.navigate(
                    route = ClientOrderScreen.OrderDetail.passOrder(
                        order.toJson()
                    )
                )
            }
//            .clickable { navController.navigate(route = AdminOrderScreen.OrderDetail.route) }
    ) {
        Text(
            text = "ordem #${order.id}",
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )

        Text(
            modifier = Modifier.padding(top = 15.dp),
            text = "Pedido ${order.createdAt}",
            fontSize = 15.sp
        )
        Text(
            modifier = Modifier.padding(top = 5.dp),
            text = "Cliente ${order.client?.name} ${order.client?.lastname}",
            fontSize = 15.sp
        )
        Text(
            modifier = Modifier.padding(top = 5.dp),
            text = "Entregar em ${order.address?.address}",
            fontSize = 15.sp
        )
        Text(
            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
            text = "Status: ${order.status}",
            fontSize = 15.sp
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            color = Gray100
        )
    }

}