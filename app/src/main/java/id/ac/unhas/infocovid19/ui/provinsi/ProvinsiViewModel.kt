package id.ac.unhas.infocovid19.ui.provinsi

import androidx.lifecycle.ViewModel
import id.ac.unhas.infocovid19.model.Provinsi

class ProvinsiViewModel(
    private val repository: ProvinsiRepository
) : ViewModel() {
    private var _movies = ArrayList<Provinsi>()
    val movies:ArrayList<Provinsi>
        get() = _movies

    fun getMoviesFromRepo(){
        //_movies.clear()
        _movies.apply {
            if(isEmpty()){
                addAll(repository.getMoviesFromJsonString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        _movies.clear()
    }
}
