package project.vyas.footballmanager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import project.vyas.footballmanager.adpater.TeamViewPagerAdapter;

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

        NestedScrollView scrollView = (NestedScrollView) findViewById(R.id.player_nest_scrollview);
        scrollView.setFillViewport(true);

        toolbar = (Toolbar) findViewById(R.id.player_name_toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(PlayerName);
        }


    }
}