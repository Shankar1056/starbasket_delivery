package apextechies.starbasket_delivery.retrofit;


import apextechies.starbasket_delivery.model.OrderLisModel;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by Shankar on 1/27/2018.
 */

public interface ApiRetrofitService {
    @POST(ApiUrl.ORDER_DETAILS)
    @FormUrlEncoded
    Call<OrderLisModel> getOrderDetails(@Field("user_id") String user_id);

}
