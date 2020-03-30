package id.ac.unhas.infocovid19.kasus

import android.content.Context
import com.google.gson.Gson
import java.io.IOException

class DataSumber {
    companion object{
        fun createDataSet(jsonString: String): Datakasus {

            val gson = Gson()
            val data: Datakasus = gson.fromJson(jsonString, Datakasus::class.java)

            return data
        }

        fun getJsonDataFromAsset(context: Context, fileName: String): String? {
            val jsonString: String
            try {
                jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return null
            }
            return jsonString
        }
    }
}