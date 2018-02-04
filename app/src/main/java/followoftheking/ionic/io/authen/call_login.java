package followoftheking.ionic.io.authen;

import android.os.AsyncTask;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by MFz on 4/2/2561.
 */

public class call_login extends AsyncTask<String,Void,String> {
    private String user_str, pass_str;

    public call_login(String user_str, String pass_str) {
        this.user_str = user_str;
        this.pass_str = pass_str;
    }

    @Override
    protected String doInBackground(String... strings) {

        try{

            FormBody.Builder formbody = new FormBody.Builder();
            final String url_login = strings[0];
            formbody.add("user", user_str);
            formbody.add("pass", pass_str);

            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(url_login).post(formbody.build()).build();

            Response response = okHttpClient.newCall(request).execute();

            if (response.code() == 200){
                return response.body().string();
            }else{
                return null;
            }

            
        }catch (Exception e){
            return null;
        }

    }
}
