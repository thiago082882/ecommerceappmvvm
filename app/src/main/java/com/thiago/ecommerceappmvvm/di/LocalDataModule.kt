package com.thiago.ecommerceappmvvm.di

import com.thiago.ecommerceappmvvm.data.dataSource.local.datastore.AuthDatastore
import com.thiago.ecommerceappmvvm.data.dataSource.local.AuthLocalDataSource
import com.thiago.ecommerceappmvvm.data.dataSource.local.AuthLocalDataSourceImpl
import com.thiago.ecommerceappmvvm.data.dataSource.local.CategoriesLocalDataSource
import com.thiago.ecommerceappmvvm.data.dataSource.local.CategoriesLocalDataSourceImpl
import com.thiago.ecommerceappmvvm.data.dataSource.local.ProductsLocalDataSource
import com.thiago.ecommerceappmvvm.data.dataSource.local.ProductsLocalDataSourceImpl
import com.thiago.ecommerceappmvvm.data.dataSource.local.dao.CategoriesDao
import com.thiago.ecommerceappmvvm.data.dataSource.local.dao.ProductsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {
    @Provides
    fun provideAuthLocalDataSource(authDataStore: AuthDatastore): AuthLocalDataSource =
        AuthLocalDataSourceImpl(authDataStore = authDataStore)



    @Provides
    fun provideCategoriesLocalDataSource(categoriesDao: CategoriesDao): CategoriesLocalDataSource =
        CategoriesLocalDataSourceImpl(categoriesDao = categoriesDao)

    @Provides
    fun provideProductsLocalDataSource(productsDao: ProductsDao): ProductsLocalDataSource = ProductsLocalDataSourceImpl(productsDao)

}