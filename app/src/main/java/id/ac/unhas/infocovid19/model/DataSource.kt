package id.ac.unhas.infocovid19.model

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class DataSource {
    companion object{
        fun createDataSet(jsonString: String): DataProvinsi{

            val gson = Gson()
            val data: DataProvinsi = gson.fromJson(jsonString, DataProvinsi::class.java)

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