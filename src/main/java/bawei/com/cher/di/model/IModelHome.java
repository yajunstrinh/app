package bawei.com.cher.di.model;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import bawei.com.cher.App;
import bawei.com.cher.data.Bean;
import bawei.com.cher.di.Cons;
import bawei.com.cher.di.IConstans.IConstansHome;

/*
 *@Auther:张亚军
 *@Date: 2019/7/8
 *@Time:10:55
 *@Description:15901514581
 * */public class IModelHome implements IConstansHome.IModelHome {
    @Override
    public void resultHome(int page,final CallBackHome callBackHome) {


        RequestQueue requestQueue = Volley.newRequestQueue(App.context);
        StringRequest stringRequest = new StringRequest(Cons.LIE_URL+page, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Bean bean = gson.fromJson(response, Bean.class);
                callBackHome.reponsHome(bean);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }
}
