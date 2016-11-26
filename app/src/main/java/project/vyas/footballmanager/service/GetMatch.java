package project.vyas.footballmanager.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import project.vyas.footballmanager.model.Match;

/**
 * Created by vyas on 11/26/16.
 */

public class GetMatch extends AsyncTask<Void, Void, Boolean> {

    private ProgressDialog pd;
    private int GameWeek;
    private int GameNo;
    private int LeagueCode;
    private Context context;
    private ListView lv;
    private ArrayList<String> listInfo;
    private String HomeTeam;
    private String AwayTeam;
    private ArrayList<String> homeScorers;
    private ArrayList<String> awayScorers;
    private String Winner;

    public GetMatch(Context c, ListView listView, int GameWeek, int Gameno, int LeagueCode, String ht, String at) {
        this.context = c;
        this.HomeTeam = ht;
        this.AwayTeam = at;
        this.lv = listView;
        this.GameWeek = GameWeek;
        this.GameNo = Gameno;
        this.LeagueCode = LeagueCode;
    }

    protected void onPreExecute() {
        pd = new ProgressDialog(context);
        pd.setMessage("Loading");
        pd.show();

    }

    protected Boolean doInBackground(Void... aParams) {
        String url = "http://192.168.43.58:5000" + "/Match/" + LeagueCode + GameWeek + GameNo;
        Match m = new Match();
        homeScorers = new ArrayList<>();
        awayScorers = new ArrayList<>();
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
                Winner = object.getString("Winner");
                if (HomeTeam.equals(object.getString("Team_name"))) {
                    homeScorers.add(object.getString("fname") + " " + object.getString("l_name"));
                } else {
                    awayScorers.add(object.getString("fname") + " " + object.getString("l_name"));
                }
            }

        } catch (Exception e) {
            Log.d("Error ", e.toString());
        }
        return true;
    }

    protected void onPostExecute(Boolean status) {

    }

}