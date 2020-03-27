package id.ac.unhas.infocovid19.ui.provinsi

import id.ac.unhas.infocovid19.model.DataProvinsi
import id.ac.unhas.infocovid19.model.DataSource
import id.ac.unhas.infocovid19.model.Provinsi

class ProvinsiRepository(
    private val jsonString: String
) {
    fun getMoviesFromJsonString() : ArrayList<Provinsi>{
        val listProvinsi = ArrayList<Provinsi>()
        val dataProvinsi: DataProvinsi = DataSource.createDataSet(jsonString)
        dataProvinsi.data?.forEach {
            if (it != null) {
                listProvinsi.add(it)
            }
        }
        return listProvinsi
    }
}
