package project.vyas.footballmanager.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import project.vyas.footballmanager.R;
import project.vyas.footballmanager.service.GetTeamStat;

/**
 * Created by vyas on 11/19/16.
 */

public class TeamStatFragment extends Fragment {


    public static TeamStatFragment newInstance(String TeamName) {
        TeamStatFragment myFragment = new TeamStatFragment();

        Bundle args = new Bundle();
        args.putString("TeamName", TeamName);
        myFragment.setArguments(args);

        return myFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.team_view_info_fragment, container, false);
        String TeamName = getArguments().getString("TeamName");

        ListView lv = (ListView) view.findViewById(R.id.statlist);
        new GetTeamStat(lv, TeamName, view.getContext()).execute();

        return view;
    }



}
