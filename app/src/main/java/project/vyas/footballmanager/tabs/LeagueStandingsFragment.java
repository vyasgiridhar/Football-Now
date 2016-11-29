package project.vyas.footballmanager.tabs;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import project.vyas.footballmanager.LeagueFactsActivity;
import project.vyas.footballmanager.R;
import project.vyas.footballmanager.service.GetTeams;

/**
 * Created by vyas on 11/29/16.
 */

public class LeagueStandingsFragment extends Fragment {
    private ListView lv;

    public static LeagueStandingsFragment newInstance(String LeagueName) {
        LeagueStandingsFragment myFragment = new LeagueStandingsFragment();

        Bundle args = new Bundle();
        args.putString("League Name", LeagueName);
        myFragment.setArguments(args);

        return myFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.league_table_fragment, container, false);
        lv = (ListView) view.findViewById(R.id.team_list);
        String LeagueName = getArguments().getString("League Name");
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String TeamName = (String) lv.getAdapter().getItem(i);
                Intent intent = new Intent(view.getContext(), LeagueFactsActivity.class);
                intent.putExtra("Team Name", TeamName);
                startActivity(intent);
            }
        });

        new GetTeams(lv, view.getContext(), LeagueName).execute();
        return view;
    }
}
