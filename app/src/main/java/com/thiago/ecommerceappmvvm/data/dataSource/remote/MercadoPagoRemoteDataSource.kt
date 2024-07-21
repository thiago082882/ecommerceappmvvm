package com.thiago.ecommerceappmvvm.data.dataSource.remote

import com.optic.ecommerceappmvvm.domain.model.*
import com.thiago.ecommerceappmvvm.domain.model.CardTokenBody
import com.thiago.ecommerceappmvvm.domain.model.IdentificationType
import com.thiago.ecommerceappmvvm.domain.model.Installment
import com.thiago.ecommerceappmvvm.domain.model.PaymentResponse
import retrofit2.Response

interface MercadoPagoRemoteDataSource {

    suspend fun getIdentificationTypes(): Response<List<IdentificationType>>
    suspend fun getInstallments(firstSixDigits: Int, amount: Double): Response<Installment>
    suspend fun createCardToken(cardTokenBody: CardTokenBody): Response<CardTokenResponse>
    suspend fun createPayment(paymentBody: PaymentBody): Response<PaymentResponse>

}