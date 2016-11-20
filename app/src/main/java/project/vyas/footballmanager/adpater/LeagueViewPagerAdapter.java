package project.vyas.footballmanager.adpater;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import project.vyas.footballmanager.tabs.TodayFragment;
import project.vyas.footballmanager.tabs.TomorrowFragment;
import project.vyas.footballmanager.tabs.YesterdayFragment;

/**
 * Created by vyas on 11/19/16.
 */

public class LeagueViewPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 3;
    Context context;
    private String tabtitles[] = new String[]{"Stats", "Table", "Fixtures"};

    public LeagueViewPagerAdapter(FragmentManager fm) {
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
                YesterdayFragment yesterdayFragment = new YesterdayFragment();
                return yesterdayFragment;

            case 1:
                TodayFragment todayFragment = new TodayFragment();
                return todayFragment;

            case 2:
                TomorrowFragment tomorrowFragment = new TomorrowFragment();
                return tomorrowFragment;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }
}

