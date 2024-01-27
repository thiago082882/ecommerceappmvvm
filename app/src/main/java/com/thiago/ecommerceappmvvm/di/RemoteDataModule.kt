package com.thiago.ecommerceappmvvm.di

import com.thiago.ecommerceappmvvm.data.dataSource.remote.AuthRemoteDataSource
import com.thiago.ecommerceappmvvm.data.dataSource.remote.CategoriesRemoteDataSource
import com.thiago.ecommerceappmvvm.data.dataSource.remote.UsersRemoteDataSource
import com.thiago.ecommerceappmvvm.data.dataSource.remote.AuthRemoteDataSourceImpl
import com.thiago.ecommerceappmvvm.data.dataSource.remote.CategoriesRemoteDataSourceImpl
import com.thiago.ecommerceappmvvm.data.dataSource.remote.UsersRemoteDataSourceImpl
import com.thiago.ecommerceappmvvm.data.dataSource.remote.service.AuthService
import com.thiago.ecommerceappmvvm.data.dataSource.remote.service.CategoriesService
import com.thiago.ecommerceappmvvm.data.dataSource.remote.service.UsersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource = AuthRemoteDataSourceImpl(authService)


    @Provides
    fun provideUsersRemoteDataSource(usersService: UsersService): UsersRemoteDataSource = UsersRemoteDataSourceImpl(usersService)

    @Provides
    fun provideCategoriesRemoteDataSource(categoriesService: CategoriesService): CategoriesRemoteDataSource = CategoriesRemoteDataSourceImpl(categoriesService)

}