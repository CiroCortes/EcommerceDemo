package com.cirodevs.onlineshop2025.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.cirodevs.onlineshop2025.Domain.BannerModel
import com.cirodevs.onlineshop2025.Domain.CategoryModel
import com.cirodevs.onlineshop2025.Repository.MainRepository

class MainViewModel : ViewModel() {
    private val repository = MainRepository ()

    fun loaldBanner() : LiveData<MutableList<BannerModel>> {

        return repository.loadBanner()
    }

    fun loadCategory() : LiveData<MutableList<CategoryModel>> {

        return repository.loadCategory()
    }

}