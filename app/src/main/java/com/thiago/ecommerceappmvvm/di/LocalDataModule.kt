package com.thiago.ecommerceappmvvm.di

import com.thiago.ecommerceappmvvm.data.datastore.AuthDatastore
import com.thiago.ecommerceappmvvm.data.repository.dataSource.AuthLocalDataSource
import com.thiago.ecommerceappmvvm.data.repository.dataSourceImpl.AuthLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {
    @Provides
    fun provideAuthLocalDataSource(authDataStore:AuthDatastore): AuthLocalDataSource =
        AuthLocalDataSourceImpl(authDataStore)
}