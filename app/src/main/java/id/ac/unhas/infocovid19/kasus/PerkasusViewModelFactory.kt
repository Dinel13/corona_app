package id.ac.unhas.infocovid19.kasus

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PerkasusViewModelFactory (
    private val repository: PerkasusRepository
):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(PerkasusRepository::class.java).newInstance(repository)
    }
}