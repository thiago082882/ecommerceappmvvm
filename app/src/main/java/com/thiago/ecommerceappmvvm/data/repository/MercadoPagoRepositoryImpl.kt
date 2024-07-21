package com.thiago.ecommerceappmvvm.data.repository

import com.optic.ecommerceappmvvm.domain.model.CardTokenResponse
import com.optic.ecommerceappmvvm.domain.model.PaymentBody
import com.thiago.ecommerceappmvvm.data.dataSource.remote.MercadoPagoRemoteDataSource
import com.thiago.ecommerceappmvvm.domain.model.CardTokenBody
import com.thiago.ecommerceappmvvm.domain.model.IdentificationType
import com.thiago.ecommerceappmvvm.domain.model.Installment
import com.thiago.ecommerceappmvvm.domain.model.PaymentResponse
import com.thiago.ecommerceappmvvm.domain.repository.MercadoPagoRepository
import com.thiago.ecommerceappmvvm.domain.util.Resource
import com.thiago.ecommerceappmvvm.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MercadoPagoRepositoryImpl(private val remoteDataSource: MercadoPagoRemoteDataSource) :
    MercadoPagoRepository {
    override fun getIdentificationTypes(): Flow<Resource<List<IdentificationType>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.getIdentificationTypes()))
    }

    override fun getInstallments(firstSixDigits: Int, amount: Double): Flow<Resource<Installment>> =
        flow {
            emit(ResponseToRequest.send(remoteDataSource.getInstallments(firstSixDigits, amount)))
        }

    override suspend fun createCardToken(cardTokenBody: CardTokenBody): Resource<CardTokenResponse> =
        ResponseToRequest.send(
            remoteDataSource.createCardToken(cardTokenBody)
        )

    override suspend fun createPayment(paymentBody: PaymentBody): Resource<PaymentResponse> =
        ResponseToRequest.send(
            remoteDataSource.createPayment(paymentBody)
        )
}