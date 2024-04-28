package com.thiago.ecommerceappmvvm.presentation.screens.client.shopping_bag.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.thiago.ecommerceappmvvm.presentation.screens.client.shopping_bag.ClientShoppingBagViewModel
import com.thiago.ecommerceappmvvm.R
import com.thiago.ecommerceappmvvm.domain.model.ShoppingBagProduct
import com.thiago.ecommerceappmvvm.presentation.ui.theme.Gray100
import com.thiago.ecommerceappmvvm.presentation.ui.theme.Gray700

@Composable
fun ClientShoppingBagItem(
    shoppingBagProduct: ShoppingBagProduct,
    vm: ClientShoppingBagViewModel = hiltViewModel()
) {

    Row(
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        AsyncImage(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(color = Gray100),
            model = shoppingBagProduct.image1,
            contentDescription = "",
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column() {
            Text(
                modifier = Modifier.width(150.dp),
                text = shoppingBagProduct.name,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(5.dp))
            Card(
                modifier = Modifier
                    .width(100.dp)
                    .height(35.dp),
                shape = RoundedCornerShape(10.dp),
                backgroundColor = Gray700
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.clickable { vm.subtractItem(shoppingBagProduct) },
                        text = "-",
                        fontSize = 18.sp,
                        color = Color.White
                    )
                    Text(
                        text = shoppingBagProduct.quantity.toString(),
                        fontSize = 19.sp,
                        color = Color.White
                    )
                    Text(
                        modifier = Modifier.clickable { vm.addItem(shoppingBagProduct) },
                        text = "+",
                        fontSize = 19.sp,
                        color = Color.White,
                    )
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = (shoppingBagProduct.price * shoppingBagProduct.quantity).toString())
            Spacer(modifier = Modifier.height(7.dp))
            Image(
                modifier = Modifier
                    .size(30.dp)
                    .clickable { vm.deleteItem(shoppingBagProduct.id) },
                painter = painterResource(id = R.drawable.trash),
                contentDescription = ""
            )
        }


    }

}