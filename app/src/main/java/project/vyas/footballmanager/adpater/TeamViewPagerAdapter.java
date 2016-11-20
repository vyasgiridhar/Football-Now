package project.vyas.footballmanager.adpater;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import project.vyas.footballmanager.tabs.TeamSquadFragment;
import project.vyas.footballmanager.tabs.TeamStatFragment;
import project.vyas.footballmanager.tabs.TodayFragment;

/**
 * Created by vyas on 11/19/16.
 */

public class TeamViewPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 3;
    Context context;
    private String tabtitles[] = new String[]{"About", "Fixtures", "Squad"};

    public TeamViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                TeamStatFragment teamStatFragment = new TeamStatFragment();
                return teamStatFragment;

            case 1:
                TodayFragment todayFragment = new TodayFragment();
                return todayFragment;

            case 2:
                TeamSquadFragment teamSquadFragment = new TeamSquadFragment();
                return teamSquadFragment;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }
}