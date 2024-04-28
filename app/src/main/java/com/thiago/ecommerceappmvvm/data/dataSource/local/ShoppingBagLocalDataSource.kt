package com.thiago.ecommerceappmvvm.data.dataSource.local

import com.thiago.ecommerceappmvvm.data.dataSource.local.entity.ShoppingBagProductEntity
import kotlinx.coroutines.flow.Flow

interface ShoppingBagLocalDataSource {
    suspend fun insert(product: ShoppingBagProductEntity)
    suspend fun insertAll(products: List<ShoppingBagProductEntity>)
    suspend fun getTotal(): Double
    fun findAll(): Flow<List<ShoppingBagProductEntity>>
    suspend fun findById(id: String): ShoppingBagProductEntity
    suspend fun update(id: String, quantity: Int)
    suspend fun delete(id: String)
}