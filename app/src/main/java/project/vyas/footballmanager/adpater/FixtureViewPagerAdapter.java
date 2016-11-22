package project.vyas.footballmanager.adpater;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import project.vyas.footballmanager.tabs.FixtureViewFragment;

public class FixtureViewPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 3;
    Context context;
    private String tabtitles[] = new String[]{"Yesterday", "Today", "Tomorrow"};

    public FixtureViewPagerAdapter(FragmentManager fm) {
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
                FixtureViewFragment fixtureViewFragment= FixtureViewFragment.newInstance(false,false,true,"","",-1);
                return fixtureViewFragment;

            case 1:
                FixtureViewFragment fixtureViewFragment1 = FixtureViewFragment.newInstance(false,false,false,"","",0);
                return fixtureViewFragment1;

            case 2:
                FixtureViewFragment fixtureViewFragment2= FixtureViewFragment.newInstance(false,false,true,"","",1);
                return fixtureViewFragment2;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }
}
