package project.vyas.footballmanager.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import java.util.List;

import project.vyas.footballmanager.model.Player;

/**
 * Created by vyas on 11/21/16.
 */

public class GetSquad extends AsyncTask<Void, Void,Void> {
    private ListView lv;
    private String TeamName;
    private Context context;
    private ProgressDialog pd;

    public GetSquad(ListView listView,String Name,Context context) {
        this.lv = listView;
        this.TeamName = Name;
        this.context = context;
    }
    protected void onPreExecute() {
        pd = new ProgressDialog(context);
        pd.setMessage("Loading");
        pd.show();

    }

    protected void doInBackground(Void... aParams) {

    }

    protected void onPostExecute() {
        // background work is finished,
        // we can update the UI here
        // including removing the dialog
    }
}
