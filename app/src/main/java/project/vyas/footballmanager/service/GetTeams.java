package project.vyas.footballmanager.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by vyas on 11/30/16.
 */

public class GetTeams extends AsyncTask<Void, Void, Boolean> {

    private ProgressDialog pd;
    private Context context;
    private String Lcode;
    private ListView lv;
    private ArrayList<String> list;

    public GetTeams(ListView view, Context c, String code) {
        this.context = c;
        this.Lcode = code;
        this.lv = view;
    }

    protected void onPreExecute() {
        pd = new ProgressDialog(context);
        pd.setMessage("Loading");
        pd.show();

    }

    protected Boolean doInBackground(Void... aParams) {
        String url = "http://192.168.43.59:5000" + "/League/Teams/" + Lcode;
        list = new ArrayList<>();
        try {
            OkHttpClient client = new OkHttpClient();
            Log.d("URL", url);
            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();

            Response response;

            response = client.newCall(request).execute();
            String result = response.body().string().replace("\"", "");

            JSONObject object1 = new JSONObject(result);
            JSONArray array = object1.getJSONArray("result");
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                list.add(object.getString("Team_name"));
            }
            return true;
        } catch (Exception e) {
            Log.d("LOG", e.toString());
            return false;
        }

    }

    protected void onPostExecute(Boolean status) {
        pd.dismiss();
        if (status) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, list);
            lv.setAdapter(adapter);
        } else {
            Toast.makeText(context, "Network Error", Toast.LENGTH_LONG).show();
        }
    }
}