package com.thiago.ecommerceappmvvm.presentation.screens.client.product.detail.components

import android.widget.Space
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.thiago.ecommerceappmvvm.presentation.components.DefaultButton
import com.thiago.ecommerceappmvvm.presentation.components.DotsIndicator
import com.thiago.ecommerceappmvvm.presentation.components.SliderView
import com.thiago.ecommerceappmvvm.presentation.screens.client.product.detail.ClientProductDetailViewModel
import com.thiago.ecommerceappmvvm.presentation.ui.theme.Gray100
import com.thiago.ecommerceappmvvm.presentation.ui.theme.Gray200
import com.thiago.ecommerceappmvvm.presentation.ui.theme.Gray700
import kotlinx.coroutines.delay


@OptIn(ExperimentalPagerApi::class, ExperimentalFoundationApi::class)
@Composable
fun ClientProductDetailContent(paddingValues: PaddingValues, vm: ClientProductDetailViewModel = hiltViewModel()) {
    val state = rememberPagerState()
    Box(
        modifier = Modifier.padding(paddingValues).fillMaxSize()
    ) {
        Column(
        ) {
            SliderView(state = state, images = vm.productImages)
            Spacer(modifier = Modifier.height(4.dp))
            DotsIndicator(totalDots = vm.productImages.size, selectedIndex = state.currentPage)
        }

        Card(
            modifier = Modifier.padding(top = 310.dp),
            shape = RoundedCornerShape(
                topEnd = 40.dp,
                topStart = 40.dp,
            ),
            backgroundColor = Color.White
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 7.dp),
                    text = vm.product.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp
                )
                Divider(
                    modifier = Modifier.padding(vertical = 10.dp),
                    color = Gray100
                )
                Text(
                    modifier = Modifier.padding(bottom = 7.dp),
                    text = "Descrição",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = vm.product.description,
                    fontSize = 15.sp
                )
                Divider(
                    modifier = Modifier.padding(vertical = 10.dp),
                    color = Gray100
                )
                Text(
                    modifier = Modifier.padding(bottom = 7.dp),
                    text = "Preço",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = vm.product.price.toString(),
                    fontSize = 15.sp
                )
                Divider(
                    modifier = Modifier.padding(vertical = 10.dp),
                    color = Gray100
                )
                Text(
                    modifier = Modifier.padding(bottom = 7.dp),
                    text = "Seu pedido",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "Quantidade: ${vm.quantity}",
                    fontSize = 15.sp
                )
                Text(
                    text = "Preço: ${vm.price}",
                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        modifier = Modifier.width(100.dp).height(35.dp),
                        shape = RoundedCornerShape(10.dp),
                        backgroundColor = Gray700
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        )   {
                            Text(
                                modifier = Modifier.clickable { vm.remove() },
                                text = "-",
                                fontSize = 18.sp,
                                color = Color.White
                            )
                            Text(
                                text = vm.quantity.toString(),
                                fontSize = 19.sp,
                                color = Color.White
                            )
                            Text(
                                modifier = Modifier.clickable { vm.add() },
                                text = "+",
                                fontSize = 19.sp,
                                color = Color.White
                            )
                        }
                    }

                    DefaultButton(
                        modifier = Modifier.width(200.dp),
                        text = "ADICIONAR",
                        onClick = { vm.saveItem() }
                    )
                }

            }
        }
    }

    LaunchedEffect(key1 = state.currentPage) {
        delay(10000)
        var newPosition = state.currentPage + 1
        if (newPosition > vm.productImages.size - 1) {
            newPosition = 0
        }
        state.animateScrollToPage(newPosition)
    }
}