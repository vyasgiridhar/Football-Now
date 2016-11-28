package project.vyas.footballmanager.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import project.vyas.footballmanager.adpater.FixtureListAdapter;
import project.vyas.footballmanager.model.Fixture;

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
    ArrayList<Fixture> fixtures;
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
        JSONObject json = null;
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
                        .append(c.get(Calendar.YEAR)).append("-")
                        .append(c.get(Calendar.MONTH) + 1).append("-")
                        .append(c.get(Calendar.DATE)).toString();

                url = "/Fixture/day/" + date;
            }
            Log.d("Here ", "OK");
            OkHttpClient client = new OkHttpClient();
            url = "http://192.168.43.58:5000" + url;
            Log.d("URL", url);
            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();

            Response response = client.newCall(request).execute();
            String result = response.body().string();

            result = result.replace("\n", "");
            result = result.replace("\"", "");

            json = new JSONObject(result);
            fixtures = new ArrayList<>();
            JSONArray array = json.getJSONArray("result");
            for (int i = 0; i < array.length(); i++) {
                Fixture f = new Fixture();
                JSONObject object = array.getJSONObject(i);
                if (!object.isNull("Away_team_score"))
                    f.setAwayScore(object.getInt("Away_team_score"));
                if (!object.isNull("Home_team_score"))
                    f.setHomeScore(object.getInt("Home_team_score"));
                f.setAwayTeam(object.getString("Away_team"));
                f.setHomeTeam(object.getString("Home_team"));
                DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
                f.setMatchDate(formatter.parse(object.getString("M_date")));
                f.setGameWeek(object.getInt("Gameweek"));
                f.setGameNo(object.getInt("Gameno"));
                f.setLeagueCode(object.getString("League_code"));
                fixtures.add(f);
            }
        } catch (Exception e) {
            Log.d("Error : ", e.toString());
            return false;
        }

        return true;
    }

    protected void onPostExecute(Boolean status) {
        pd.dismiss();
        if (status) {
            FixtureListAdapter adapter = new FixtureListAdapter(fixtures, context);
            lv.setAdapter(adapter);
        } else {
            Toast.makeText(context, "Network Error", Toast.LENGTH_LONG).show();
        }
    }

}
