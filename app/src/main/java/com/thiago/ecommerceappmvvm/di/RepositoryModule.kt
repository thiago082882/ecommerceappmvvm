package com.thiago.ecommerceappmvvm.di

import com.thiago.ecommerceappmvvm.data.repository.AuthRepositoryImpl
import com.thiago.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.thiago.ecommerceappmvvm.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.thiago.ecommerceappmvvm.data.service.AuthService
import com.thiago.ecommerceappmvvm.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideAuthRepository(authRemoteDataSource: AuthRemoteDataSource): AuthRepository =
        AuthRepositoryImpl(authRemoteDataSource)
}