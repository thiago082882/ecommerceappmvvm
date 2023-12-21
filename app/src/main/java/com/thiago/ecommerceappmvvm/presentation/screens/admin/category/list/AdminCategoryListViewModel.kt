package com.thiago.ecommerceappmvvm.presentation.screens.admin.category.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiago.ecommerceappmvvm.domain.model.Category
import com.thiago.ecommerceappmvvm.domain.useCase.categories.CategoriesUseCase
import com.thiago.ecommerceappmvvm.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminCategoryListViewModel @Inject constructor(private val categoriesUseCase: CategoriesUseCase): ViewModel() {

    var categoriesResponse by mutableStateOf<Resource<List<Category>>?>(null)
        private set

    init {
        getCategories()
    }
    fun getCategories() = viewModelScope.launch {
 categoriesResponse = Resource.Loading
        categoriesUseCase.getCategoriesUseCase().collect(){data->
            categoriesResponse = data

        }

    }
}