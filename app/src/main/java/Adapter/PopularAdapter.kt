package Adapter

import Domain.FoodDomain
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddeliveryapp.R
import com.example.fooddeliveryapp.ShowDetailActivity


class PopularAdapter(private val foodDomains: ArrayList<FoodDomain>) : RecyclerView.Adapter<PopularAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_popular, parent, false)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val foodDomain = foodDomains[position]
        holder.title.text = foodDomain.title
        holder.fee.text = foodDomain.fee.toString()


        holder.addBtn.setOnClickListener {
            val intent = Intent(holder.itemView.context, ShowDetailActivity::class.java)
            intent.putExtra("object", foodDomain)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = foodDomains.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val fee: TextView = itemView.findViewById(R.id.fee)
        val pic: ImageView = itemView.findViewById(R.id.pic)
        val addBtn: TextView = itemView.findViewById(R.id.addBtn)
    }
}
