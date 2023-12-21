package com.thiago.ecommerceappmvvm.presentation.screens.admin.category.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.thiago.ecommerceappmvvm.domain.model.Category
import com.thiago.ecommerceappmvvm.R
import com.thiago.ecommerceappmvvm.presentation.navigation.Graph
import com.thiago.ecommerceappmvvm.presentation.navigation.screen.admin.AdminCategoryScreen
import com.thiago.ecommerceappmvvm.presentation.screens.admin.category.list.AdminCategoryListViewModel

@Composable
fun AdminCategoryListItem(navController: NavHostController,category: Category) {

    Column(
        Modifier
            .padding(start = 20.dp, end = 20.dp, top = 15.dp)
            .height(90.dp)
            .clickable {  }
    ) {
        Row() {

            AsyncImage(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(10.dp)),
                model = category.image,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                Modifier.weight(1f)
            ) {
                Text(
                    text = category.name,
                    color = Color.Black,
                    fontSize = 17.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = category.description,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
            Spacer(Modifier.width(15.dp))

            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(27.dp)
                        .clickable {
                            navController.navigate(route = AdminCategoryScreen.CategoryUpdate.passCategory(category.toJson())
                            )
                        },
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.height(5.dp))
                Image(
                    modifier = Modifier
                        .size(27.dp)
                        .clickable {  },
                    painter = painterResource(id = R.drawable.trash),
                    contentDescription = ""
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            color = Color.LightGray,
            startIndent = 80.dp
        )
    }


}