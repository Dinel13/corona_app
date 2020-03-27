package id.ac.unhas.infocovid19.ui.provinsi

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import id.ac.unhas.infocovid19.R
import id.ac.unhas.infocovid19.model.DataSource

class ProvinsiListFragment : Fragment() {

    companion object {
        fun newInstance() = ProvinsiListFragment()
    }

    private lateinit var viewModel: ProvinsiViewModel
    private lateinit var viewModelFactory: ProvinsiViewModelFactory

    private lateinit var listView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.provinsilist_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val jsonList:String =
            activity?.applicationContext?.let {
                DataSource.getJsonDataFromAsset(it, "provinsi.json")
            }.toString()

        val provinsiRepository = ProvinsiRepository(jsonList)

        viewModelFactory =ProvinsiViewModelFactory(provinsiRepository)

        viewModel = ViewModelProvider(this,viewModelFactory).get(ProvinsiViewModel::class.java)

        viewModel.getMoviesFromRepo()

        Log.d("MainFragment","createView")
        listView = view.findViewById(R.id.list_view_provinsi)

        val listItems = arrayOfNulls<String>(viewModel.movies.size)

        viewModel.movies.forEachIndexed { index, provinsi ->
            listItems[index] = provinsi.toString()
        }

        val adapter = context?.let { ArrayAdapter(it,R.layout.listview_item_provinsi,listItems) }

        listView.adapter = adapter
    }

}
