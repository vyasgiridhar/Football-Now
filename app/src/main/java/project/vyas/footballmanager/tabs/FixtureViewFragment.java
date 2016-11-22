package project.vyas.footballmanager.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import project.vyas.footballmanager.R;

public class FixtureViewFragment extends Fragment {

    Boolean Team;
    Boolean League;
    Boolean Day;

    String TeamName;
    String LeagueName;

    public static FixtureViewFragment newInstance(Boolean team,Boolean league,Boolean day,String teamname ,String leaguename,int days) {
        FixtureViewFragment myFragment = new FixtureViewFragment();

        Bundle args = new Bundle();
        args.putBoolean("team", team);
        args.putBoolean("league",league);
        args.putBoolean("day",day);
        args.putString("teamname",teamname);
        args.putString("leaguename",leaguename);
        args.putInt("day",days);
        myFragment.setArguments(args);

        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fixture_view_fragment, container, false);

        ListView listView = (ListView) view.findViewById(R.id.fixturelist);

        Bundle bundle = getArguments();


     //   FixtureListAdapter fixtureListAdapter = new FixtureListAdapter();
        return view;
    }

}