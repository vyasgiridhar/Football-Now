package project.vyas.footballmanager.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import project.vyas.footballmanager.R;
import project.vyas.footballmanager.model.Player;

/**
 * Created by vyas on 11/20/16.
 */

public class SquadListAdapter extends ArrayAdapter<Player> implements View.OnClickListener {

    private Context context;
    private ArrayList<Player> Data;
    private int lastPosition = -1;


    public SquadListAdapter(ArrayList<Player> data, Context context) {
        super(context, R.layout.team_view_squad_item, data);
        this.Data = data;
        this.context = context;

    }


    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        Player data = (Player) object;

        /*Intent i = new Intent(getContext(), PlayerViewActivity.class);
        i.putExtra("Player",PlayerViewActivity.class);
        */

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Player data = getItem(position);

        ViewHolder viewHolder;


        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.team_view_squad_item, parent, false);
            viewHolder.Name = (TextView) convertView.findViewById(R.id.player_name);
            viewHolder.Position = (TextView) convertView.findViewById(R.id.player_position);
            viewHolder.Picture = (ImageView) convertView.findViewById(R.id.player_image);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        lastPosition = position;

        viewHolder.Name.setText(data.getfName() + " " + data.getlName());
        viewHolder.Position.setText(data.getPosition());
        Picasso.with(context)
                .load(data.getImageUrl())
                .resize(50, 50)
                .centerCrop()
                .into(viewHolder.Picture);

        return convertView;
    }

    private static class ViewHolder {
        TextView Name;
        TextView Position;
        ImageView Picture;
    }

}
