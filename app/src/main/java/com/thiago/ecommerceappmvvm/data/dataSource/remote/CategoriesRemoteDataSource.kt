package com.thiago.ecommerceappmvvm.data.dataSource.remote

import com.thiago.ecommerceappmvvm.domain.model.Category
import retrofit2.Response
import java.io.File

interface CategoriesRemoteDataSource {

    suspend fun create(category:Category,file:File):Response<Category>
    suspend fun getCategories(): Response<List<Category>>
    suspend fun update(id: String,category:Category): Response<Category>
    suspend fun updateWithImage(id: String, category:Category, file: File): Response<Category>

    suspend fun delete(id: String): Response<Unit>

}