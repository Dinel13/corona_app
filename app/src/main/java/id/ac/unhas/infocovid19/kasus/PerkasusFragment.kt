package id.ac.unhas.infocovid19.kasus


import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.unhas.infocovid19.R
import kotlinx.android.synthetic.main.fragment_perkasus.*

class PerkasusFragment : Fragment() {

    companion object {
        fun newInstance() = PerkasusFragment()
    }

    private lateinit var viewModel: PerkasusViewModel
    private lateinit var viewModelFactory: PerkasusViewModelFactory

    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.provinsilist_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val jsonList:String =
            activity?.applicationContext?.let {
                DataSumber.getJsonDataFromAsset(it, "kasus.json")
            }.toString()

        val perkasusRepository = PerkasusRepository(jsonList)

        viewModelFactory = PerkasusViewModelFactory(perkasusRepository)

        viewModel = ViewModelProvider(this,viewModelFactory).get(PerkasusViewModel::class.java)

        viewModel.getMoviesFromRepo()

        Log.d("MainFragment","createView")

        linearLayoutManager = LinearLayoutManager(context)
        recyclerview.layoutManager = linearLayoutManager

        val adapter = PerkasusAdapter(viewModel.movies)

        recyclerview.adapter = adapter

    }

}
