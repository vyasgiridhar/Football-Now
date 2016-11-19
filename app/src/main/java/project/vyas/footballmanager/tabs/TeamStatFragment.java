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

        Card card1 = new Card(getActivity());
        CardHeader header1 = new CardHeader(getActivity());
        header1.setTitle("Captain : ");
        card1.addCardHeader(header1);
        CardView cardView1 = (CardView) view.findViewById(R.id.team_stat_captain);
        cardView1.setCard(card1);

        Card card2 = new Card(getActivity());
        CardHeader header2 = new CardHeader(getActivity());
        header2.setTitle("Stadium : ");
        card2.addCardHeader(header2);
        //Set card in the cardView
        CardView cardView2 = (CardView) view.findViewById(R.id.team_stat_stadium);
        cardView2.setCard(card);

        return view;
    }



}
