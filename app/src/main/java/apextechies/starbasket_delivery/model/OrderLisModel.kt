package apextechies.starbasket_delivery.model

import com.google.gson.annotations.SerializedName

class OrderLisModel {

    @SerializedName("status")
    var status: String?= null
    @SerializedName("msg")
    var msg: String?= null
    @SerializedName("data")
    var data: ArrayList<OrderLidtData>?= null

}

class OrderLidtData {
    @SerializedName("order_id")
    var order_id: String?= null
    @SerializedName("assign_date")
    var assign_date: String?= null
    @SerializedName("payment_type")
    var payment_type: String?= null
    @SerializedName("delivery_status")
    var delivery_status: String?= null
    @SerializedName("delivered_date")
    var delivered_date: String?= null
    @SerializedName("data")
    var prodDetails: ArrayList<ProdDetails>?= null
    @SerializedName("deliveryBoyDetails")
    var deliveryBoyDetails: ArrayList<DeliveryBoyDetails>?= null
    @SerializedName("userDetails")
    var userDetails: ArrayList<UserDetails>?= null
}

class UserDetails {
    @SerializedName("id")
    var id: String?= null
    @SerializedName("name")
    var name: String?= null
    @SerializedName("last_name")
    var last_name: String?= null
    @SerializedName("email")
    var email: String?= null
    @SerializedName("mobile")
    var mobile: String?= null
    @SerializedName("address")
    var address: String?= null
    @SerializedName("device_token")
    var device_token: String?= null
    @SerializedName("created_at")
    var created_at: String?= null
    @SerializedName("status")
    var status: String?= null
}

class DeliveryBoyDetails {
    @SerializedName("id")
    var id: String?= null
    @SerializedName("name")
    var name: String?= null
    @SerializedName("mobile")
    var mobile: String?= null
    @SerializedName("email")
    var email: String?= null
    @SerializedName("address")
    var address: String?= null
    @SerializedName("state")
    var state: String?= null
    @SerializedName("city")
    var city: String?= null
    @SerializedName("joining_date")
    var joining_date: String?= null
    @SerializedName("postal_code")
    var postal_code: String?= null
    @SerializedName("last_login")
    var last_login: String?= null
    @SerializedName("status")
    var status: String?= null
}

class ProdDetails {
    @SerializedName("id")
    var id: String?= null
    @SerializedName("transaction_id")
    var transaction_id: String?= null
    @SerializedName("price")
    var price: String?= null
    @SerializedName("delivery_charge")
    var delivery_charge: String?= null
    @SerializedName("discount")
    var discount: String?= null
    @SerializedName("coupon_code")
    var coupon_code: String?= null
    @SerializedName("total_price")
    var total_price: String?= null
    @SerializedName("address_id")
    var address_id: String?= null
    @SerializedName("user_id")
    var user_id: String?= null
    @SerializedName("order_date")
    var order_date: String?= null
    @SerializedName("order_status")
    var order_status: String?= null
    @SerializedName("seller_id")
    var seller_id: String?= null
    @SerializedName("payment_type")
    var payment_type: String?= null
    @SerializedName("refund_type")
    var refund_type: String?= null
}
