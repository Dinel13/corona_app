package id.ac.unhas.infocovid19.ui.provinsi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class ProvinsiViewModelFactory (
    private val repository: ProvinsiRepository
):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ProvinsiRepository::class.java).newInstance(repository)
    }
}