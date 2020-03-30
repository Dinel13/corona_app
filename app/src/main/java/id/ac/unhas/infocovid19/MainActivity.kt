package id.ac.unhas.infocovid19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import id.ac.unhas.infocovid19.kasus.Perkasus
import id.ac.unhas.infocovid19.kasus.PerkasusFragment
import id.ac.unhas.infocovid19.ui.provinsi.ProvinsiListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var dataProvinsi : Button
    private lateinit var datPerkasus: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        datPerkasus = findViewById(R.id.kasus)
        dataProvinsi = findViewById(R.id.prov)

        Log.d("MainActivity","Test2")
       if (savedInstanceState == null) {
           supportFragmentManager.beginTransaction()
                   .replace(R.id.container, ProvinsiListFragment.newInstance())
                   .commitNow()
       }

        datPerkasus.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PerkasusFragment.newInstance())
                .commitNow()

        }
        dataProvinsi.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ProvinsiListFragment.newInstance())
                .commitNow()

        }
    }
}
