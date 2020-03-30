package id.ac.unhas.infocovid19.kasus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.unhas.infocovid19.R
import kotlinx.android.synthetic.main.recyclerview_item_perkasus.view.*

class PerkasusAdapter(private val daftarPerkasus: ArrayList<Perkasus>) :
    RecyclerView.Adapter<PerkasusAdapter.PerkasusHolder>() {
    class PerkasusHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bind(itemPerkasus: Perkasus){
            with(itemView){
                kasus.text = "Kasus ke-" + itemPerkasus.kasus.toString()
                data_perkasus.text = "lokasi : ${itemPerkasus.klaster}, gender : ${itemPerkasus.gender} \n" +
                        "umur : ${itemPerkasus.umur}, Warganegara : ${itemPerkasus.wn}"
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PerkasusAdapter.PerkasusHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recyclerview_item_perkasus,parent,false)
        return PerkasusHolder(view)
    }

    override fun getItemCount() = daftarPerkasus.size

    override fun onBindViewHolder(holder: PerkasusAdapter.PerkasusHolder, position: Int) {
        holder.bind(daftarPerkasus[position])
    }

}
