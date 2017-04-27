package project.vyas.footballmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import project.vyas.footballmanager.service.GetTeamStanding;

/**
 * Created by Prasanna on11/30/16.
 */

public class LeagueFactsActivity extends AppCompatActivity {

    private ListView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_facts_view);

        view = (ListView) findViewById(R.id.team_facts);
        new GetTeamStanding(this, view, getIntent().getStringExtra("Team Name")).execute();
    }
}
