package project.vyas.footballmanager.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import project.vyas.footballmanager.model.Player;


/**
 * Created by vyas on 11/25/16.
 */

public class GetPlayer extends AsyncTask<Void, Void, Boolean> {

    Player player;
    private Context context;
    private ProgressDialog pd;
    private ListView lv;
    private TextView tv;
    private String PlayerName;

    public GetPlayer(ListView v, Context context, TextView textView, String PlayerName) {
        this.PlayerName = PlayerName;
        this.lv = v;
        this.tv = textView;
        this.context = context;
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
            OkHttpClient client = new OkHttpClient();
            url = "http://192.168.43.58:5000" + "/Player/" + PlayerName;
            Log.d("URL", url);
            url = url.replace(" ", "%20");
            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();

            Response response = null;

            response = client.newCall(request).execute();
            String result = response.body().string().replace("\"", "");
            JSONObject object1 = new JSONObject(result);
            JSONArray array = object1.getJSONArray("result");
            JSONObject object = array.getJSONObject(0);
            player = new Player();
            player.setTeamName(object.getString("Team_name"));
            player.setfName(object.getString("fname"));
            player.setlName(object.getString("l_name"));
            player.setPosition(object.getString("Pos"));
            player.setFoot(object.getString("Foot"));
            player.setRating(object.getInt("Overall_rating"));
            player.setShot(object.getInt("Shot"));
            player.setDefence(object.getInt("Defence"));
            player.setNationality(object.getString("Nationality"));
            player.setAge(object.getInt("Age"));
            player.setDribbling(object.getInt("Dribbling"));
            player.setStrength(object.getInt("Strength"));
            player.setPassing(object.getInt("Passing"));
            player.setPace(object.getInt("Pace"));
        } catch (Exception e) {
            Log.d("Error ", e.toString());
        }

        return true;
    }

    protected void onPostExecute(Boolean status) {
        pd.dismiss();
        if (status) {
            tv.setText(player.getfName() + " " + player.getlName());
            final ArrayList<String> list = new ArrayList<>(Arrays.asList("Team_name", "Overall_rating",
                    "Age", "Nationality", "Strength",
                    "Passing", "Pace", "Dribbling", "Defence",
                    "Shot", "Foot"));
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_2, android.R.id.text1, list) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                    TextView text2 = (TextView) view.findViewById(android.R.id.text2);
                    switch (position) {
                        case 0:
                            text1.setText(list.get(position));
                            text2.setText(player.getTeamName());
                            break;
                        case 1:
                            text1.setText(list.get(position));
                            text2.setText(player.getRating());
                            break;
                        case 2:
                            text1.setText(list.get(position));
                            text2.setText(player.getAge());
                            break;
                        case 3:
                            text1.setText(list.get(position));
                            text2.setText(player.getNationality());
                            break;
                        case 4:
                            text1.setText(list.get(position));
                            text2.setText(player.getStrength());
                            break;
                        case 5:
                            text1.setText(list.get(position));
                            text2.setText(player.getPassing());
                            break;
                        case 6:
                            text1.setText(list.get(position));
                            text2.setText(player.getPace());
                            break;
                        case 7:
                            text1.setText(list.get(position));
                            text2.setText(player.getDribbling());
                            break;
                        case 8:
                            text1.setText(list.get(position));
                            text2.setText(player.getDefence());
                            break;
                        case 9:
                            text1.setText(list.get(position));
                            text2.setText(player.getShot());
                            break;
                        case 10:
                            text1.setText(list.get(position));
                            text2.setText(player.getFoot());
                            break;
                        default:
                            break;
                    }
                    return view;
                }
            };
            lv.setAdapter(adapter);
        } else {
            Toast.makeText(context, "Bad Boy", Toast.LENGTH_LONG).show();
        }
    }
}