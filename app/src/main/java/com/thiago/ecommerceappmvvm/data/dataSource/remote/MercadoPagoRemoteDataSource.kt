package com.thiago.ecommerceappmvvm.data.dataSource.remote

import com.thiago.ecommerceappmvvm.domain.model.CardTokenBody
import com.thiago.ecommerceappmvvm.domain.model.CardTokenResponse
import com.thiago.ecommerceappmvvm.domain.model.IdentificationType
import com.thiago.ecommerceappmvvm.domain.model.Installment
import com.thiago.ecommerceappmvvm.domain.model.PaymentBody
import com.thiago.ecommerceappmvvm.domain.model.PaymentResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header

interface MercadoPagoRemoteDataSource {

    suspend fun getIdentificationTypes(): Response<List<IdentificationType>>
    suspend fun getInstallments(firstSixDigits: Int, amount: Double): Response<Installment>
    suspend fun createCardToken(cardTokenBody: CardTokenBody): Response<CardTokenResponse>
    //suspend fun createPayment( paymentBody: PaymentBody): Response<PaymentResponse>
    suspend fun createPayment(
        idempotencyKey: String,
        paymentBody: PaymentBody
    ): Response<PaymentResponse>


}