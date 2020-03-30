package id.ac.unhas.infocovid19.kasus

import androidx.lifecycle.ViewModel
import id.ac.unhas.infocovid19.kasus.Perkasus
import id.ac.unhas.infocovid19.kasus.PerkasusRepository

class PerkasusViewModel(
    private val repository: PerkasusRepository
) : ViewModel() {
    private var _movies = ArrayList<Perkasus>()
    val movies:ArrayList<Perkasus>
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
