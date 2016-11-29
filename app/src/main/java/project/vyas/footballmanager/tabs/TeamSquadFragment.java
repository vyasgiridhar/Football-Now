package project.vyas.footballmanager.tabs;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import project.vyas.footballmanager.PlayerViewActivity;
import project.vyas.footballmanager.R;
import project.vyas.footballmanager.TeamViewActivity;
import project.vyas.footballmanager.model.Player;
import project.vyas.footballmanager.service.GetSquad;

/**
 * Created by vyas on 11/19/16.
 */

public class TeamSquadFragment extends Fragment {

    private String TeamName;
    ListView squadList;
    public static TeamSquadFragment newInstance(String TeamName) {
        TeamSquadFragment myFragment = new TeamSquadFragment();

        Bundle args = new Bundle();
        args.putString("Team Name", TeamName);
        myFragment.setArguments(args);

        return myFragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.team_view_squad_fragment, container, false);
        squadList = (ListView) view.findViewById(R.id.squadlist);

        Bundle B = getArguments();
        TeamName = B.getString("Team Name");
        squadList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Player p = (Player) squadList.getAdapter().getItem(i);
                Intent intent = new Intent(view.getContext(), PlayerViewActivity.class);
                intent.putExtra("Player Name",p.getfName()+ " " + p.getlName());
                startActivity(intent);
            }
        });
        new GetSquad(squadList, TeamName, view.getContext()).execute();
        return view;
    }

}