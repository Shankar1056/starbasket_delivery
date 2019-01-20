package apextechies.starbasket_delivery.retrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import apextechies.starbasket_delivery.R;
import apextechies.starbasket_delivery.model.OrderLisModel;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Shankar on 1/27/2018.
 */

public class RetrofitDataProvider extends AppCompatActivity implements ServiceMethods {
    Context context;

    private ApiRetrofitService createRetrofitService() {

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiRetrofitService.class);
    }

    public RetrofitDataProvider(Context context) {
        this.context = context;
    }

    @Override
    public void OrderHistory(String user_id, final DownlodableCallback<OrderLisModel> callback) {
        createRetrofitService().getOrderDetails(user_id).enqueue(
                new Callback<OrderLisModel>() {
                    @Override
                    public void onResponse(@NonNull Call<OrderLisModel> call, @NonNull final Response<OrderLisModel> response) {
                        if (response.isSuccessful()) {
                            OrderLisModel mobileRegisterPojo = response.body();
                            callback.onSuccess(mobileRegisterPojo);

                        } else {
                            if (response.code() == 401) {
                                callback.onUnauthorized(response.code());
                            } else {
                                Toast.makeText(context, context.getResources().getString(R.string.something_went_wrong_error_message), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<OrderLisModel> call, @NonNull Throwable t) {
                        Log.d("Result", "t" + t.getMessage());
                        callback.onFailure(t.getMessage());
                    }
                }
        );
    }




}