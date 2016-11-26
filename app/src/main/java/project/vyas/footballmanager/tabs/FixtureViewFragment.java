package project.vyas.footballmanager.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import project.vyas.footballmanager.R;
import project.vyas.footballmanager.service.GetFixture;

public class FixtureViewFragment extends Fragment {


    public static FixtureViewFragment newInstance(Boolean team,Boolean league,Boolean day,String teamname ,String leaguename,int days) {
        FixtureViewFragment myFragment = new FixtureViewFragment();

        Bundle args = new Bundle();
        args.putBoolean("team", team);
        args.putBoolean("league",league);
        args.putBoolean("day",day);
        args.putString("TeamName", teamname);
        args.putString("LeagueName", leaguename);
        args.putInt("days", days);
        myFragment.setArguments(args);

        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fixture_view_fragment, container, false);

        ListView listView = (ListView) view.findViewById(R.id.fixturelist);

        Bundle bundle = getArguments();

        new GetFixture(listView, view.getContext(), bundle.getBoolean("team"), bundle.getBoolean("league"), bundle.getBoolean("day"), bundle.getString("TeamName"), bundle.getString("LeagueName"), bundle.getInt("days")).execute();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        return view;
    }

}