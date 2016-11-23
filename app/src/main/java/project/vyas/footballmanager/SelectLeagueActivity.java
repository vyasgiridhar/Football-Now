package project.vyas.footballmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by vyas on 11/23/16.
 */

public class SelectLeagueActivity extends AppCompatActivity {

    private static ArrayList<String> Leagues = new ArrayList<>(Arrays.asList("Premier League", "EFL Championship", "EFL League One", "Bundesliga", "Bundesliga 2",
            "Eredivisie", "Ligue 1", "Ligue 2", "Liga BBVA", "Liga Adelante",
            "Serie A TIM", "Liga NOS"));

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_league_activity);

        lv = (ListView) findViewById(R.id.league_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Leagues);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SelectLeagueActivity.this, LeagueViewActivity.class);
                intent.putExtra("League Name", Leagues.get(i));
                startActivity(intent);
            }
        });
    }
}