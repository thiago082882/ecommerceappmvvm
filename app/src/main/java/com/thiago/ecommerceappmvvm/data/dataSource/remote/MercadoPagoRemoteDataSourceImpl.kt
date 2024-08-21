package com.thiago.ecommerceappmvvm.data.dataSource.remote

import com.thiago.ecommerceappmvvm.domain.model.CardTokenResponse
import com.thiago.ecommerceappmvvm.domain.model.PaymentBody
import com.thiago.ecommerceappmvvm.data.dataSource.remote.service.MercadoPagoService
import com.thiago.ecommerceappmvvm.domain.model.CardTokenBody
import com.thiago.ecommerceappmvvm.domain.model.IdentificationType
import com.thiago.ecommerceappmvvm.domain.model.Installment
import com.thiago.ecommerceappmvvm.domain.model.PaymentResponse
import retrofit2.Response
import java.util.UUID

class MercadoPagoRemoteDataSourceImpl(private val mercadoPagoService: MercadoPagoService) :
    MercadoPagoRemoteDataSource {
    override suspend fun getIdentificationTypes(): Response<List<IdentificationType>> =
        mercadoPagoService.getIdentificationTypes()

    override suspend fun getInstallments(
        firstSixDigits: Int,
        amount: Double
    ): Response<Installment> = mercadoPagoService.getInstallments(firstSixDigits, amount)

    override suspend fun createCardToken(cardTokenBody: CardTokenBody): Response<CardTokenResponse> =
        mercadoPagoService.createCardToken(cardTokenBody)

    override suspend fun createPayment(
        idempotencyKey: String,
        paymentBody: PaymentBody
    ): Response<PaymentResponse> {
        return mercadoPagoService.createPayment(idempotencyKey, paymentBody)
    }
}