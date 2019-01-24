package apextechies.starbasket.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import apextechies.starbasket_delivery.R
import apextechies.starbasket_delivery.model.OrderLidtData
import java.util.*

class OrderDetailsAdapter(
    private val context: Context,
    private val list: ArrayList<OrderLidtData>,
    private val mListener: OnItemClickListener
) : RecyclerView.Adapter<OrderDetailsAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var orderId: TextView
        var cusName: TextView
        var cusPhone: TextView
        var cusAddress: TextView

        init {
            orderId = itemView.findViewById<View>(R.id.orderId) as TextView
            cusName = itemView.findViewById<View>(R.id.cusName) as TextView
            cusPhone = itemView.findViewById<View>(R.id.cusPhone) as TextView
            cusAddress = itemView.findViewById<View>(R.id.cusAddress) as TextView

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.getContext())
        val itemView = inflater.inflate(R.layout.item_order_details, parent, false)


        return MyViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list!![position]
        holder.orderId.text = item.order_id
        holder.cusName.text = item.userDetails!![0].name
        holder.cusPhone.text = item.userDetails!![0].mobile
        holder.cusAddress.text = item.userDetails!![0].address


    }


    override fun getItemCount(): Int {
        return list.size
    }


    interface OnItemClickListener {
        fun onItemClick(pos: Int)
    }


}
