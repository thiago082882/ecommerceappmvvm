package com.thiago.ecommerceappmvvm.data.repository.dataSourceImpl

import com.thiago.ecommerceappmvvm.data.repository.dataSource.CategoriesRemoteDataSource
import com.thiago.ecommerceappmvvm.data.service.CategoriesService
import com.thiago.ecommerceappmvvm.domain.models.Category
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import java.io.File

class CategoriesRemoteDataSourceImpl(private val categoriesService: CategoriesService): CategoriesRemoteDataSource {



    override suspend fun create(category: Category,file: File): Response<Category> {
        val connection = file.toURI().toURL().openConnection()
        val mimeType = connection.contentType // "image/png | image/jpg"
        val contentType = "text/plain"
        val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
        val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
        val nameData = category.name.toRequestBody(contentType.toMediaTypeOrNull())
        val descriptionData = category.description.toRequestBody(contentType.toMediaTypeOrNull())


        return categoriesService.create(fileFormData,nameData, descriptionData)
    }

    override suspend fun getCategories(): Response<List<Category>> = categoriesService.getCategories()

    override suspend fun update(id: String, category: Category): Response<Category> = categoriesService.update(id, category)
    override suspend fun updateWithImage(
        id: String,
        category: Category,
        file: File
    ): Response<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Response<Unit> {
        TODO("Not yet implemented")
    }


}