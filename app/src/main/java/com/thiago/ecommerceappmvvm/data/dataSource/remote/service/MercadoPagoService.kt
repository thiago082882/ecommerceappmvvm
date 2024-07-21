package com.thiago.ecommerceappmvvm.data.dataSource.remote.service

import com.optic.ecommerceappmvvm.domain.model.*
import com.thiago.ecommerceappmvvm.domain.model.CardTokenBody
import com.thiago.ecommerceappmvvm.domain.model.IdentificationType
import com.thiago.ecommerceappmvvm.domain.model.Installment
import com.thiago.ecommerceappmvvm.domain.model.PaymentResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MercadoPagoService {

    @GET("mercadopago/identification_types")
    suspend fun getIdentificationTypes(): Response<List<IdentificationType>>

    @GET("mercadopago/installments/{first_six_digits}/{amount}")
    suspend fun getInstallments(
        @Path("first_six_digits") firstSixDigits: Int,
        @Path("amount") amount: Double
    ): Response<Installment>

    @POST("mercadopago/card_token")
    suspend fun createCardToken(
        @Body cardTokenBody: CardTokenBody
    ): Response<CardTokenResponse>

    @POST("mercadopago/payments")
    suspend fun createPayment(
        @Body paymentBody: PaymentBody
    ): Response<PaymentResponse>

}