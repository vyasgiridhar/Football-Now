package project.vyas.footballmanager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import project.vyas.footballmanager.adpater.LeagueViewPagerAdapter;

/**
 * Created by vyas on 11/19/16.
 */

public class LeagueViewActivity extends AppCompatActivity {

    Toolbar toolbar;
    ActionBar actionBar;
    String LeagueName;
    ViewPager viewPager;
    Toolbar myToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.league_view_activity);

        Bundle teamInfo = getIntent().getExtras();
        LeagueName = teamInfo.getString("League Name");


        Log.d("Hi ", (Integer.toString(R.id.league_pager)));
        viewPager = (ViewPager) findViewById(R.id.league_pager);
        viewPager.setAdapter(new LeagueViewPagerAdapter(getSupportFragmentManager(), LeagueName));
        viewPager.setCurrentItem(0);
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(LeagueName);
        }


    }
}
