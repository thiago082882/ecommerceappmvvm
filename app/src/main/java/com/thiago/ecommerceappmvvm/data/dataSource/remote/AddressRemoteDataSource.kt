package com.thiago.ecommerceappmvvm.data.dataSource.remote

import com.thiago.ecommerceappmvvm.domain.model.Address
import retrofit2.Response

interface AddressRemoteDataSource {

    suspend fun create(address: Address): Response<Address>
    suspend fun findByUser(idUser: String): Response<List<Address>>

}