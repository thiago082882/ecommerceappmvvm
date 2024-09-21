package com.thiago.ecommerceappmvvm.di

import com.thiago.ecommerceappmvvm.domain.repository.AddressRepository
import com.thiago.ecommerceappmvvm.domain.repository.AuthRepository
import com.thiago.ecommerceappmvvm.domain.repository.CategoriesRepository
import com.thiago.ecommerceappmvvm.domain.repository.MercadoPagoRepository
import com.thiago.ecommerceappmvvm.domain.repository.OrdersRepository
import com.thiago.ecommerceappmvvm.domain.repository.ProductsRepository
import com.thiago.ecommerceappmvvm.domain.repository.ShoppingBagRepository
import com.thiago.ecommerceappmvvm.domain.repository.UsersRepository
import com.thiago.ecommerceappmvvm.domain.useCase.address.AddressUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.address.CreateAddressUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.address.FindByUserAddressUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.auth.GetSessionDataUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.auth.LoginUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.auth.LogoutUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.auth.RegisterUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.auth.SaveSessionUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.auth.UpdateSessionUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.categories.CategoriesUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.categories.CreateCategoryUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.categories.DeleteCategoryUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.categories.GetCategoriesUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.categories.UpdateCategoryUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.categories.UpdateCategoryWithImageUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.mercado_pago.CreateCardTokenUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.mercado_pago.CreatePaymentUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.mercado_pago.GetIdentificationTypeUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.mercado_pago.GetInstallmentsUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.mercado_pago.MercadoPagoUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.orders.FindAllOrdersUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.orders.FindByClientOrdersUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.orders.OrdersUseCases
import com.thiago.ecommerceappmvvm.domain.useCase.orders.UpdateStatusOrdersUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.products.CreateProductUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.products.DeleteProductUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.products.FindAllUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.products.FindByCategoryUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.products.FindByNameUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.products.ProductsUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.products.UpdateProductUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.products.UpdateProductWithImageUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.shopping_bag.AddUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.shopping_bag.DeleteUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.shopping_bag.FindAllShoppingBagUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.shopping_bag.FindByIdShoppingBagUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.shopping_bag.GetTotalUseCase
import com.thiago.ecommerceappmvvm.domain.useCase.shopping_bag.ShoppingBagUseCase
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
        updateCategoryWithImage = UpdateCategoryWithImageUseCase(categoriesRepository),
        deleteCategoryUseCase = DeleteCategoryUseCase(categoriesRepository)

    )

    @Provides
    fun provideProductsUseCase(productsRepository: ProductsRepository) = ProductsUseCase(
        createProduct = CreateProductUseCase(productsRepository),
        findByCategory = FindByCategoryUseCase(productsRepository),
        findAll = FindAllUseCase(productsRepository),
        updateProduct = UpdateProductUseCase(productsRepository),
        updateProductWithImage = UpdateProductWithImageUseCase(productsRepository),
        deleteProduct = DeleteProductUseCase(productsRepository),
        findByName = FindByNameUseCase(productsRepository)
    )


    @Provides
    fun provideShoppingBagUseCase(shoppingBagRepository: ShoppingBagRepository) = ShoppingBagUseCase(
        add = AddUseCase(shoppingBagRepository),
        delete = DeleteUseCase(shoppingBagRepository),
        findAll = FindAllShoppingBagUseCase(shoppingBagRepository),
        findById = FindByIdShoppingBagUseCase(shoppingBagRepository),
        getTotal = GetTotalUseCase(shoppingBagRepository)
    )


    @Provides
    fun provideAddressUseCase(addressRepository: AddressRepository) = AddressUseCase(
        createAddress = CreateAddressUseCase(addressRepository),
        findByUserAddress = FindByUserAddressUseCase(addressRepository)
    )

    @Provides
    fun provideMercadoPagoUseCase(mercadoPagoRepository: MercadoPagoRepository) = MercadoPagoUseCase(
        getIdentificationType = GetIdentificationTypeUseCase(mercadoPagoRepository),
        getInstallments = GetInstallmentsUseCase(mercadoPagoRepository),
        createCardToken = CreateCardTokenUseCase(mercadoPagoRepository),
        createPayment = CreatePaymentUseCase(mercadoPagoRepository),
    )

    @Provides
    fun provideOrdersUseCase(ordersRepository: OrdersRepository) = OrdersUseCases(
        findAllOrdersUseCase = FindAllOrdersUseCase(ordersRepository),
        findByClientOrdersUseCase = FindByClientOrdersUseCase(ordersRepository),
        updateStatusOrdersUseCase = UpdateStatusOrdersUseCase(ordersRepository)
    )


}