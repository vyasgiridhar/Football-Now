package project.vyas.footballmanager.adpater;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import project.vyas.footballmanager.tabs.FixtureViewFragment;
import project.vyas.footballmanager.tabs.LeagueStandingsFragment;

/**
 * Created by Prasanna on11/19/16.
 */

public class LeagueViewPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 2;
    private Context context;
    private String tabtitles[] = new String[]{"Table", "Fixtures"};
    private String LeagueName;

    public LeagueViewPagerAdapter(FragmentManager fm, String ln) {
        super(fm);
        this.LeagueName = ln;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                return LeagueStandingsFragment.newInstance(LeagueName);

            case 1:
                return FixtureViewFragment.newInstance(false, true, false, null, LeagueName, 0);
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }
}

