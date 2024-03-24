package com.thiago.ecommerceappmvvm.di

import android.app.Application
import androidx.room.Room
import com.thiago.ecommerceappmvvm.data.dataSource.local.dao.CategoriesDao
import com.thiago.ecommerceappmvvm.data.dataSource.local.dao.ProductsDao
import com.thiago.ecommerceappmvvm.data.dataSource.local.db.EcommerceDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModel {

    @Provides
    @Singleton
    fun providerDatabase(app:Application):EcommerceDB = Room.databaseBuilder(app,EcommerceDB::class.java,"ecommerce_db").fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun providerCategoriesDao(db:EcommerceDB):CategoriesDao = db.categoriesDao()

    @Provides
    @Singleton
    fun providerProductsDao(db:EcommerceDB):ProductsDao = db.productsDao()
}
