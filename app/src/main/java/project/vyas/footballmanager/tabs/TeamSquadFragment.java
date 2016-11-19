package project.vyas.footballmanager.tabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import project.vyas.footballmanager.R;

/**
 * Created by vyas on 11/19/16.
 */

public class TeamSquadFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.team_view_info_fragment, container, false);
        return view;
    }

}