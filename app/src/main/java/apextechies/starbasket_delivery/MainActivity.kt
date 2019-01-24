package apextechies.starbasket_delivery

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import apextechies.starbasket.adapter.OrderDetailsAdapter
import apextechies.starbasket_delivery.model.OrderLidtData
import apextechies.starbasket_delivery.model.OrderLisModel
import apextechies.starbasket_delivery.retrofit.DownlodableCallback
import apextechies.starbasket_delivery.retrofit.RetrofitDataProvider
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var orderList = ArrayList<OrderLidtData>()
    var newList = ArrayList<OrderLidtData>()
    var deliveredList = ArrayList<OrderLidtData>()
    var pendingList = ArrayList<OrderLidtData>()
    var retrofitDataProvider: RetrofitDataProvider? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                callCatApi(1) //new
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                callCatApi(2) //pending
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                callCatApi(3) //delivered
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        retrofitDataProvider = RetrofitDataProvider(this)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        rv_category.layoutManager = LinearLayoutManager(this)
        callCatApi(1)


    }

    private fun callCatApi(deliveryStatus: Int) {
        retrofitDataProvider!!.OrderHistory("1", ""+deliveryStatus ,object : DownlodableCallback<OrderLisModel> {
            override fun onSuccess(result: OrderLisModel?) {
                if (result != null) {
                    orderList = result.data!!
                    rv_category.adapter =
                            OrderDetailsAdapter(this@MainActivity, orderList, object : OrderDetailsAdapter.OnItemClickListener {
                                override fun onItemClick(pos: Int) {

                                }

                            })
                }
            }

            override fun onFailure(error: String?) {
            }

            override fun onUnauthorized(errorNumber: Int) {
            }

        })
    }

}
