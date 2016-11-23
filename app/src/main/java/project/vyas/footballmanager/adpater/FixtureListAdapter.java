package project.vyas.footballmanager.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import project.vyas.footballmanager.R;
import project.vyas.footballmanager.model.Fixture;

/**
 * Created by vyas on 11/20/16.
 */

public class FixtureListAdapter extends ArrayAdapter<Fixture> {


    private Context context;
    private ArrayList<Fixture> Data;
    private int lastPosition = -1;


    public FixtureListAdapter(ArrayList<Fixture> data, Context context) {
        super(context, R.layout.fixture_view_list_item, data);
        this.Data = data;
        this.context = context;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Fixture data = getItem(position);

        FixtureListAdapter.ViewHolder viewHolder;


        if (convertView == null) {

            viewHolder = new FixtureListAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.fixture_view_list_item, parent, false);
            viewHolder.Team1 = (TextView) convertView.findViewById(R.id.team1);
            viewHolder.Team2 = (TextView) convertView.findViewById(R.id.team2);
            viewHolder.Score = (TextView) convertView.findViewById(R.id.score);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (FixtureListAdapter.ViewHolder) convertView.getTag();
        }

        lastPosition = position;

        viewHolder.Team1.setText(data.getHomeTeam());
        viewHolder.Team2.setText(data.getAwayTeam());
        viewHolder.Score.setText(data.getHomeScore()+ " - " + data.getAwayScore());
        return convertView;
    }

    private static class ViewHolder {
        TextView Team1;
        TextView Team2;
        TextView Score;
    }


}
