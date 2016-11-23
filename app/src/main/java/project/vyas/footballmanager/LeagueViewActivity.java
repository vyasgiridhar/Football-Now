package project.vyas.footballmanager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.league_view_activity);

        Bundle teamInfo = getIntent().getExtras();
        LeagueName = teamInfo.getString("League Name");

        NestedScrollView scrollView = (NestedScrollView) findViewById(R.id.league_nest_scrollview);
        scrollView.setFillViewport(true);

        Log.d("Hi ", (Integer.toString(R.id.league_pager)));
        viewPager = (ViewPager) findViewById(R.id.league_pager);
        viewPager.setAdapter(new LeagueViewPagerAdapter(getSupportFragmentManager(), LeagueName));
        viewPager.setCurrentItem(0);

        toolbar = (Toolbar) findViewById(R.id.league_name_toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(LeagueName);
        }


    }
}
