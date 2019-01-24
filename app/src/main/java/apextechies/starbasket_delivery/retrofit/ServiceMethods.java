package apextechies.starbasket_delivery.retrofit;


import apextechies.starbasket_delivery.model.OrderLisModel;

/**
 * Created by Shankar on 1/27/2018.
 */

public interface ServiceMethods {
    void OrderHistory(String user_id, String deliveryStatus, DownlodableCallback<OrderLisModel> callback);


}
