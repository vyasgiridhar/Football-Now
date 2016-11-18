package project.vyas.footballmanager;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by vyas on 11/18/16.
 */

public class TeamViewActivity extends AppCompatActivity {

    Toolbar toolbar;
    ActionBar actionBar;
    String TeamName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_view_activity);

        Bundle teamInfo = getIntent().getExtras();
        TeamName = teamInfo.getString("Team Name");

        toolbar = (Toolbar) findViewById(R.id.team_name_toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle(TeamName);
        }

    }
}