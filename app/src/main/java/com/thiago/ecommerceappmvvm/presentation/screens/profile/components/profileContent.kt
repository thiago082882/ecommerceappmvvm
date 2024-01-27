package com.thiago.ecommerceappmvvm.presentation.screens.profile.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.thiago.ecommerceappmvvm.R
import com.thiago.ecommerceappmvvm.presentation.MainActivity
import com.thiago.ecommerceappmvvm.presentation.components.DefaultButton
import com.thiago.ecommerceappmvvm.presentation.navigation.Graph
import com.thiago.ecommerceappmvvm.presentation.screens.profile.info.ProfileViewModel

@Composable
fun ProfileContent(navController: NavHostController,vm: ProfileViewModel = hiltViewModel()) {
    val activity = LocalContext.current as? Activity
    Box(modifier = Modifier.padding(bottom = 55.dp)) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.profile_background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToScale(0.6f, 0.6f, 0.6f, 1f)
                }
            )
        )
        Column(modifier = Modifier.fillMaxWidth()) {
            IconButton(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 15.dp, top = 15.dp),
                onClick = {
                    vm.logout()
                    activity?.finish()
                    activity?.startActivity(Intent(activity, MainActivity::class.java))

                }
            ) {
                Image(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(id = R.drawable.logout),
                    contentDescription = "",

                    )

            }
            IconButton(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 15.dp, top = 15.dp),
                onClick = {
                    activity?.finish()
                    activity?.startActivity(Intent(activity, MainActivity::class.java))
                }
            ) {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "",
                    tint = Color.White
                )

                }

            if (!vm.user?.image.isNullOrBlank()) {
                AsyncImage(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    model = vm.user?.image,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }else{
                Image(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.user_image),
                    contentDescription = ""
                )

            }

            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ),
                backgroundColor = Color.White.copy(alpha = 0.75f)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        verticalAlignment = Alignment.CenterVertically


                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = ""
                        )
                        Column(modifier = Modifier.padding(horizontal = 5.dp)) {
                            Text(text = "${vm.user?.name } ${vm.user?.lastname }")
                            Text(text = "Nome do usuario", fontSize = 12.sp, color = Color.Gray)

                        }


                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        verticalAlignment = Alignment.CenterVertically


                    ) {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = ""
                        )
                        Column(modifier = Modifier.padding(horizontal = 5.dp)) {
                            Text(text = "${vm.user?.email}")
                            Text(text = "Email", fontSize = 12.sp, color = Color.Gray)

                        }


                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        verticalAlignment = Alignment.CenterVertically


                    ) {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = ""
                        )
                        Column(modifier = Modifier.padding(horizontal = 5.dp)) {
                            Text(text = vm.user?.phone ?: "")
                            Text(text = "Telefone", fontSize = 12.sp, color = Color.Gray)

                        }


                    }
                    Spacer(modifier = Modifier.height(40.dp))
                    DefaultButton(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Atualizar Informações",
                        onClick = {
                            navController.navigate(route = "${Graph.PROFILE}/${vm.user?.toJson()}")
                        })
                }

            }

        }

    }


}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun ProfileContentPreview() {
//
//    ProfileContent()
//
//}