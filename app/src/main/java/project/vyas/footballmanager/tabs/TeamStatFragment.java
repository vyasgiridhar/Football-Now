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
import project.vyas.footballmanager.TeamViewActivity;

/**
 * Created by vyas on 11/19/16.
 */

public class TeamStatFragment extends Fragment {



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.team_view_info_fragment, container, false);

        Card card = new Card(getActivity());
        CardHeader header = new CardHeader(getActivity());
        header.setTitle("Manager : " );
        card.addCardHeader(header);
        //Set card in the cardView
        CardView cardView = (CardView) view.findViewById(R.id.team_stat_manager);
        cardView.setCard(card);

        return view;
    }



}
