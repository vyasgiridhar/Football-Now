package project.vyas.footballmanager.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import it.gmariotti.cardslib.library.internal.CardHeader;
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
    private CardHeader ch1, ch2, ch3;

    public GetTeamStat(CardHeader c, CardHeader c1, CardHeader c2, String Name, Context context) {
        this.ch1 = c;
        this.ch2 = c1;
        this.ch3 = c2;
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
                    .url("http://192.168.43.58:5000/Team/stat/" + TeamName)
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
            ch1.setTitle("Manager : " + stat.getManager());
            ch2.setTitle("Captain : " + stat.getCaptain());
            ch3.setTitle("Stadium : " + stat.getStadium());
        } else {
            Toast.makeText(context, "Network Error", Toast.LENGTH_LONG).show();
        }
    }
}