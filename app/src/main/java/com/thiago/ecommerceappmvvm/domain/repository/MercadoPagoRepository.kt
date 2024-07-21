package com.thiago.ecommerceappmvvm.domain.repository

import com.optic.ecommerceappmvvm.domain.model.CardTokenResponse
import com.optic.ecommerceappmvvm.domain.model.PaymentBody
import com.thiago.ecommerceappmvvm.domain.model.CardTokenBody
import com.thiago.ecommerceappmvvm.domain.model.IdentificationType
import com.thiago.ecommerceappmvvm.domain.model.Installment
import com.thiago.ecommerceappmvvm.domain.model.PaymentResponse
import com.thiago.ecommerceappmvvm.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface MercadoPagoRepository {

    fun getIdentificationTypes(): Flow<Resource<List<IdentificationType>>>
    fun getInstallments(firstSixDigits: Int, amount: Double): Flow<Resource<Installment>>
    suspend fun createCardToken(cardTokenBody: CardTokenBody): Resource<CardTokenResponse>
    suspend fun createPayment(paymentBody: PaymentBody): Resource<PaymentResponse>
}