package project.vyas.footballmanager;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;

import project.vyas.footballmanager.service.GetPlayer;

/**
 * Created by vyas on 11/20/16.
 */

public class PlayerViewActivity extends AppCompatActivity {

    Toolbar toolbar;
    ActionBar actionBar;
    String PlayerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_view_activity);

        Bundle teamInfo = getIntent().getExtras();
        PlayerName = teamInfo.getString("Player Name");

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(PlayerName);
        }
        TextView tv = (TextView) findViewById(R.id.player_name);
        ListView listView = (ListView) findViewById(R.id.player_details);
        new GetPlayer(listView, this, tv, PlayerName).execute();
    }
}