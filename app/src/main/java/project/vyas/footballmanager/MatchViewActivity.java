package project.vyas.footballmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import project.vyas.footballmanager.service.GetMatch;

/**
 * Created by vyas on 11/27/16.
 */

public class MatchViewActivity extends AppCompatActivity {

    private String HomeTeam;
    private String AwayTeam;
    private String Score;
    private TextView home, away, score;
    private int lc, gw, gn;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_view);

        HomeTeam = getIntent().getStringExtra("Home Team");
        AwayTeam = getIntent().getStringExtra("Away Team");
        Score = getIntent().getStringExtra("Score");
        lc = getIntent().getIntExtra("League Code", 0);
        gw = getIntent().getIntExtra("Game Week", 0);
        gn = getIntent().getIntExtra("Game No", 0);

        home = (TextView) findViewById(R.id.team1);
        away = (TextView) findViewById(R.id.team2);
        score = (TextView) findViewById(R.id.score);
        lv = (ListView) findViewById(R.id.match_facts);

        home.setText(HomeTeam);
        away.setText(AwayTeam);
        score.setText(Score);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MatchViewActivity.this, TeamViewActivity.class);
                i.putExtra("Team Name", HomeTeam);
                startActivity(i);
            }
        });

        away.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MatchViewActivity.this, TeamViewActivity.class);
                i.putExtra("Team Name", AwayTeam);
                startActivity(i);
            }
        });

        new GetMatch(this, lv, gw, gn, lc, HomeTeam, AwayTeam).execute();
    }
}
