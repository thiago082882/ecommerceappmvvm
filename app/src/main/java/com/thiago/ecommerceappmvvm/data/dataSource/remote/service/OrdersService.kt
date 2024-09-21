package com.thiago.ecommerceappmvvm.data.dataSource.remote.service


import com.thiago.ecommerceappmvvm.domain.model.Category
import com.thiago.ecommerceappmvvm.domain.model.Order
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface OrdersService {

    @GET("orders")
    suspend fun findAll(): Response<List<Order>>

    @GET("orders/{id_client}")
    suspend fun findByClient(@Path("id_client")idClient:String): Response<List<Order>>

    @PUT("orders/{id}")
    suspend fun updateStatus(@Path("id")id:String): Response<Order>


}