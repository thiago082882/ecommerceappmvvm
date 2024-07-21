package com.thiago.ecommerceappmvvm.data.dataSource.remote

import com.optic.ecommerceappmvvm.domain.model.CardTokenResponse
import com.optic.ecommerceappmvvm.domain.model.PaymentBody
import com.thiago.ecommerceappmvvm.data.dataSource.remote.service.MercadoPagoService
import com.thiago.ecommerceappmvvm.domain.model.CardTokenBody
import com.thiago.ecommerceappmvvm.domain.model.IdentificationType
import com.thiago.ecommerceappmvvm.domain.model.Installment
import com.thiago.ecommerceappmvvm.domain.model.PaymentResponse
import retrofit2.Response

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

    override suspend fun createPayment(paymentBody: PaymentBody): Response<PaymentResponse> =
        mercadoPagoService.createPayment(paymentBody)
}