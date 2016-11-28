package project.vyas.footballmanager.tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardView;
import project.vyas.footballmanager.R;
import project.vyas.footballmanager.service.GetTeamStat;

/**
 * Created by vyas on 11/19/16.
 */

public class TeamStatFragment extends Fragment {


    private CardHeader header;
    private CardHeader header1;
    private CardHeader header2;

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
        Card card = new Card(view.getContext());
        header = new CardHeader(view.getContext());
        card.addCardHeader(header);
        CardView cardView = (CardView) view.findViewById(R.id.team_stat_manager);
        cardView.setCard(card);

        Card card1 = new Card(view.getContext());
        header1 = new CardHeader(view.getContext());
        card1.addCardHeader(header1);
        CardView cardView1 = (CardView) view.findViewById(R.id.team_stat_captain);
        cardView1.setCard(card1);

        Card card2 = new Card(view.getContext());
        header2 = new CardHeader(view.getContext());
        card2.addCardHeader(header2);
        CardView cardView2 = (CardView) view.findViewById(R.id.team_stat_stadium);
        cardView2.setCard(card2);
        new GetTeamStat(header, header1, header2, TeamName, view.getContext()).execute();

        return view;
    }



}
