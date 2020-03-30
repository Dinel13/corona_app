package id.ac.unhas.infocovid19.kasus

data class Datakasus(
    val data: List<Perkasus?>?
){
    override fun toString(): String {
        var stringOutput = ""
        data?.forEach{
            stringOutput += it.toString()
        }
        return stringOutput
    }
}

data class Perkasus(
    val id: Int?,
    val kasus: Int?,
    val klaster: String?,
    val umur: Int?,
    val gender: String?,
    val wn: String?
){
    override fun toString(): String {
        return "kasus ke- ${this.kasus}[klaster: ${this.klaster}, umur: ${this.umur}, gender: ${this.gender}, warganegara:${this.wn}]"
    }
}