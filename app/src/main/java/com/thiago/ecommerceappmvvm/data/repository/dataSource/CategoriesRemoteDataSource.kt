package com.thiago.ecommerceappmvvm.data.repository.dataSource

import com.thiago.ecommerceappmvvm.domain.models.Category
import com.thiago.ecommerceappmvvm.domain.models.User
import retrofit2.Response
import java.io.File

interface CategoriesRemoteDataSource {

    suspend fun create(category:Category,file:File):Response<Category>
    suspend fun getCategories(): Response<List<Category>>
    suspend fun update(id: String,category:Category): Response<Category>
    suspend fun updateWithImage(id: String, category:Category, file: File): Response<Category>

    suspend fun delete(id: String): Response<Unit>

}