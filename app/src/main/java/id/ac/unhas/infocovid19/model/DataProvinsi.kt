package id.ac.unhas.infocovid19.model

data class DataProvinsi(
    val data: List<Provinsi?>?
){
    override fun toString(): String {
        var stringOutput = ""
        data?.forEach{
            stringOutput += it.toString()
        }
        return stringOutput
    }
}

data class Provinsi(
    val fid: Int?,
    val kasusMeni: Int?,
    val kasusPosi: Int?,
    val kasusSemb: Int?,
    val kodeProvi: Int?,
    val provinsi: String?
){
    override fun toString(): String {
        return "Provinsi ${this.provinsi}[kode: ${this.kodeProvi}, #positif: ${this.kasusPosi}, #meninggal: ${this.kasusMeni}, #sembuh:${this.kasusSemb}]"
    }
}