package com.thiago.ecommerceappmvvm.di

import com.thiago.ecommerceappmvvm.data.repository.AuthRepositoryImpl
import com.thiago.ecommerceappmvvm.data.repository.CategoriesRepositoryImpl
import com.thiago.ecommerceappmvvm.data.repository.UsersRepositoryImpl
import com.thiago.ecommerceappmvvm.data.dataSource.local.AuthLocalDataSource
import com.thiago.ecommerceappmvvm.data.dataSource.local.CategoriesLocalDataSource
import com.thiago.ecommerceappmvvm.data.dataSource.local.ProductsLocalDataSource
import com.thiago.ecommerceappmvvm.data.dataSource.remote.AuthRemoteDataSource
import com.thiago.ecommerceappmvvm.data.dataSource.remote.CategoriesRemoteDataSource
import com.thiago.ecommerceappmvvm.data.dataSource.remote.ProductsRemoteDataSource
import com.thiago.ecommerceappmvvm.data.dataSource.remote.UsersRemoteDataSource
import com.thiago.ecommerceappmvvm.data.repository.ProductsRepositoryImpl
import com.thiago.ecommerceappmvvm.domain.repository.AuthRepository
import com.thiago.ecommerceappmvvm.domain.repository.CategoriesRepository
import com.thiago.ecommerceappmvvm.domain.repository.ProductsRepository
import com.thiago.ecommerceappmvvm.domain.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
        authLocalDataSource: AuthLocalDataSource
    ): AuthRepository = AuthRepositoryImpl(authRemoteDataSource, authLocalDataSource)

    @Provides
    fun provideUsersRepository(
        usersRemoteDataSource: UsersRemoteDataSource,
    ): UsersRepository = UsersRepositoryImpl(usersRemoteDataSource)

    @Provides
    fun provideCategoriesRepository(
        categoriesRemoteDataSource: CategoriesRemoteDataSource,
        categoriesLocalDataSource: CategoriesLocalDataSource
    ): CategoriesRepository = CategoriesRepositoryImpl(categoriesRemoteDataSource,categoriesLocalDataSource)
    @Provides
    fun provideProductsRepository(
        productsRemoteDataSource: ProductsRemoteDataSource,
        productsLocalDataSource: ProductsLocalDataSource
    ): ProductsRepository = ProductsRepositoryImpl(productsRemoteDataSource, productsLocalDataSource)

}