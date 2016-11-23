package project.vyas.footballmanager.tabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import project.vyas.footballmanager.R;
import project.vyas.footballmanager.service.GetSquad;

/**
 * Created by vyas on 11/19/16.
 */

public class TeamSquadFragment extends Fragment {

    private String TeamName;

    public static TeamSquadFragment newInstance(String TeamName) {
        TeamSquadFragment myFragment = new TeamSquadFragment();

        Bundle args = new Bundle();
        args.putString("TeamName", TeamName);
        myFragment.setArguments(args);

        return myFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.team_view_squad_fragment, container, false);
        ListView squadList = (ListView) view.findViewById(R.id.squadlist);

        Bundle B = getArguments();
        TeamName = B.getString("TeamName");
        new GetSquad(squadList, TeamName, view.getContext());
        return view;
    }

}