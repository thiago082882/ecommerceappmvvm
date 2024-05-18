package com.thiago.ecommerceappmvvm.data.dataSource.remote

import com.thiago.ecommerceappmvvm.data.dataSource.remote.service.AddressService
import com.thiago.ecommerceappmvvm.domain.model.Address
import retrofit2.Response

class AddressRemoteDataSourceImpl(private val addressService: AddressService) :
    AddressRemoteDataSource {
    override suspend fun create(address: Address): Response<Address> =
        addressService.create(address)

    override suspend fun findByUser(idUser: String): Response<List<Address>> =
        addressService.findByUser(idUser)
}