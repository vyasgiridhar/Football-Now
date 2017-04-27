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
 * Created by Prasanna on11/30/16.
 */

public class GetTeamStanding extends AsyncTask<Void, Void, Boolean> {

    ProgressDialog pd;
    ListView lv;
    Context context;
    ArrayList<String> list;
    String TeamName;

    public GetTeamStanding(Context c, ListView lv, String TN) {
        this.context = c;
        this.lv = lv;
        this.TeamName = TN.replace(" ", "%20");
    }

    protected void onPreExecute() {
        pd = new ProgressDialog(context);
        pd.setMessage("Loading");
        pd.show();

    }

    protected Boolean doInBackground(Void... aParams) {

        String url = "http://172.104.51.13:5000" + "/Standings/" + TeamName;
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
                list.add("Team_name : " + object.getString("Team_name"));
                list.add("Games Played : " + object.getString("Games_played"));
                list.add("Rank : " + object.getString("Rank"));
                list.add("Goals : " + object.getString("Goals"));
                list.add("Draws : " + object.getString("Draws"));
                list.add("Losses : " + object.getString("Losses"));
                list.add("Goal_difference : " + object.getString("Goal_difference"));
            }
        } catch (Exception e) {
            Log.d("YO", e.toString());
        }
        return true;
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
