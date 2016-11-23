package project.vyas.footballmanager.adpater;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import project.vyas.footballmanager.tabs.FixtureViewFragment;
import project.vyas.footballmanager.tabs.TeamSquadFragment;
import project.vyas.footballmanager.tabs.TeamStatFragment;

/**
 * Created by vyas on 11/19/16.
 */

public class TeamViewPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 3;
    Context context;
    private String tabtitles[] = new String[]{"About", "Fixtures", "Squad"};
    private String TeamName;

    public TeamViewPagerAdapter(FragmentManager fm, String TeamName) {
        super(fm);
        this.TeamName = TeamName;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                TeamStatFragment teamStatFragment = TeamStatFragment.newInstance(TeamName);
                return teamStatFragment;

            case 1:
                FixtureViewFragment fixtureViewFragment = FixtureViewFragment.newInstance(true, false, false, TeamName, null, 0);
                return fixtureViewFragment;

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
