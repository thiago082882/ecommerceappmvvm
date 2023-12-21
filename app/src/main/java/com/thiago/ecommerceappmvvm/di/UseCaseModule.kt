package com.thiago.ecommerceappmvvm.di

import com.thiago.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.thiago.ecommerceappmvvm.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.thiago.ecommerceappmvvm.data.service.AuthService
import com.thiago.ecommerceappmvvm.domain.repository.AuthRepository
import com.thiago.ecommerceappmvvm.domain.repository.CategoriesRepository
import com.thiago.ecommerceappmvvm.domain.repository.UsersRepository
import com.thiago.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.auth.GetSessionDataUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.auth.LoginUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.auth.LogoutUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.auth.RegisterUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.auth.SaveSessionUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.auth.UpdateSessionUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.categories.CategoriesUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.categories.CreateCategoryUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.categories.GetCategoriesUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.categories.UpdateCategoryUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.categories.UpdateCategoryWithImageUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.users.UpdateUserUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.users.UpdateUserWithImageUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.users.UsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        getSessionData = GetSessionDataUseCase(authRepository),
        logout = LogoutUseCase(authRepository),
        updateSession = UpdateSessionUseCase(authRepository)
    )

    @Provides
    fun provideUsersUseCase(usersRepository: UsersRepository) = UsersUseCase(
        updateUser = UpdateUserUseCase(usersRepository),
        updateUserWithImage = UpdateUserWithImageUseCase(usersRepository)
    )

    @Provides
    fun provideCategoriesUseCase(categoriesRepository: CategoriesRepository) = CategoriesUseCase(
        createCategory = CreateCategoryUseCase(categoriesRepository),
        getCategoriesUseCase = GetCategoriesUseCase(categoriesRepository),
        updateCategory = UpdateCategoryUseCase(categoriesRepository),
        updateCategoryWithImage = UpdateCategoryWithImageUseCase(categoriesRepository)

    )

}