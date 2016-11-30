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
import java.util.Arrays;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import project.vyas.footballmanager.model.TeamStat;

/**
 * Created by vyas on 11/23/16.
 */

public class GetTeamStat extends AsyncTask<Void, Void, Boolean> {

    private String TeamName;
    private Context context;
    private ProgressDialog pd;
    private TeamStat stat;
    private ListView view;

    public GetTeamStat(ListView lv, String Name, Context context) {
        this.view = lv;
        this.TeamName = Name;
        this.context = context;
    }

    protected void onPreExecute() {
        pd = new ProgressDialog(context);
        pd.setMessage("Loading");
        pd.show();

    }

    protected Boolean doInBackground(Void... aParams) {

        try {
            Log.d("Here ", "OK");
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://192.168.43.59:5000/Team/stat/" + TeamName)
                    .build();
            Response response = client.newCall(request).execute();
            String result = response.body().string().replace("\"", "");
            Log.d("result", result);
            stat = new TeamStat();
            try {
                JSONObject object = new JSONObject(result);
                JSONArray json = object.getJSONArray("result");
                for (int i = 0; i < json.length(); i++) {
                    JSONObject team = json.getJSONObject(i);
                    if (!team.isNull("Captain")) {
                        stat.setCaptain(team.getString("Captain"));
                    }
                    if (!team.isNull("Manager")) {
                        stat.setManager(team.getString("Manager"));
                    }
                    if (!team.isNull("Stadium")) {
                        stat.setStadium(team.getString("Stadium"));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

            Log.d("Result : ", "doInBackground: " + result);

            return true;
        } catch (Exception e) {
            Log.d("Error", e.toString());
            return false;
        }
    }

    protected void onPostExecute(Boolean status) {
        pd.dismiss();
        if (status) {
            ArrayList<String> data = new ArrayList<>(Arrays.asList("Manager : " + stat.getManager(), "Captain : " + stat.getCaptain(), "Stadium : " + stat.getStadium()));
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, data);
            view.setAdapter(adapter);
        } else {
            Toast.makeText(context, "Network Error", Toast.LENGTH_LONG).show();
        }
    }
}