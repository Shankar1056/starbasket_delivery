package apextechies.starbasket_delivery

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import apextechies.starbasket.adapter.OrderDetailsAdapter
import apextechies.starbasket_delivery.model.OrderLisModel
import apextechies.starbasket_delivery.retrofit.DownlodableCallback
import apextechies.starbasket_delivery.retrofit.RetrofitDataProvider
import kotlinx.android.synthetic.main.activity_main.*
import apextechies.starbasket_delivery.model.OrderLidtData


class MainActivity : AppCompatActivity() {

    var orderList = ArrayList<OrderLidtData>()
    var retrofitDataProvider: RetrofitDataProvider? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                setAdapter(1)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                setAdapter(2)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                setAdapter(3)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun setAdapter(s: Int) {
        rv_category.adapter = OrderDetailsAdapter(s, this@MainActivity, orderList, object : OrderDetailsAdapter.OnItemClickListener {
            override fun onItemClick(pos: Int) {

            }

        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        retrofitDataProvider = RetrofitDataProvider(this)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        rv_category.layoutManager = LinearLayoutManager(this)
        callCatApi()


    }

    private fun callCatApi() {
        retrofitDataProvider!!.OrderHistory("1", object : DownlodableCallback<OrderLisModel> {
            override fun onSuccess(result: OrderLisModel?) {
                if (result != null) {
                    orderList = result.data!!

                }
            }

            override fun onFailure(error: String?) {
            }

            override fun onUnauthorized(errorNumber: Int) {
            }

        })
    }

}
