package id.ac.unhas.infocovid19.kasus



class PerkasusRepository(
    private val jsonString: String
) {
    fun getMoviesFromJsonString(): ArrayList<Perkasus> {
        val listPerkasus = ArrayList<Perkasus>()
        val dataPerkasus: Datakasus = DataSumber.createDataSet(jsonString)
        dataPerkasus.data?.forEach {
            if (it != null) {
                listPerkasus.add(it)
            }
        }
        return listPerkasus
    }
}