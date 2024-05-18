package com.thiago.ecommerceappmvvm.domain.repository

import com.thiago.ecommerceappmvvm.domain.model.Address
import com.thiago.ecommerceappmvvm.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface AddressRepository {

    suspend fun create(address: Address): Resource<Address>
    fun findByUser(idUser: String): Flow<Resource<List<Address>>>

}