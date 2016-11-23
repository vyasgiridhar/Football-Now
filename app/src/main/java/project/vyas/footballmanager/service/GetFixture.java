package project.vyas.footballmanager.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Calendar;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by vyas on 11/24/16.
 */

public class GetFixture extends AsyncTask<Void, Void, Boolean> {

    Boolean Team;
    Boolean League;
    Boolean Day;

    String TeamName;
    String LeagueName;

    int day;
    ListView lv;
    private Context context;
    private ProgressDialog pd;

    public GetFixture(ListView lv, Context c, Boolean team, Boolean league, Boolean day, String teamname, String leaguename, int days) {
        this.Team = team;
        this.League = league;
        this.Day = day;
        this.TeamName = teamname;
        this.LeagueName = leaguename;
        this.day = days;
        this.context = c;
        this.lv = lv;
    }

    protected void onPreExecute() {
        pd = new ProgressDialog(context);
        pd.setMessage("Loading");
        pd.show();

    }

    protected Boolean doInBackground(Void... aParams) {
        String url = "";
        try {
            if (Team) {
                url = "/Fixture/team/" + TeamName;
                url = url.replace(" ", "%20");
            } else if (League) {
                url = "/Fixture/league/" + LeagueName;
                url = url.replace(" ", "%20");
            } else if (Day) {
                final Calendar c = Calendar.getInstance();
                String date = new StringBuilder()
                        .append(c.get(Calendar.DATE) + day).append("-")
                        .append(c.get(Calendar.MONTH) + 1).append("-")
                        .append(c.get(Calendar.YEAR)).toString();
                url = "/Fixture/day/" + date;
            }
            Log.d("Here ", "OK");
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://192.168.43.58:5000" + url)
                    .build();
            Response response = client.newCall(request).execute();
            String result = response.body().string();

        } catch (Exception e) {
            Log.d("Error : ", e.toString());
        }

        return true;
    }

    protected void onPostExecute(Boolean status) {
        pd.dismiss();
        if (status) {

        } else {
            Toast.makeText(context, "Network Error", Toast.LENGTH_LONG).show();
        }
    }


}
