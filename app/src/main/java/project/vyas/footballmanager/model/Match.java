package project.vyas.footballmanager.model;

import java.util.ArrayList;

/**
 * Created by vyas on 11/20/16.
 */

public class Match {
    private String Winner;
    private String HomeTeam;
    private String AwayTeam;
    private ArrayList<String> HomeScorers;
    private ArrayList<String> AwayScorers;

    public String getWinner() {
        return Winner;
    }

    public void setWinner(String winner) {
        Winner = winner;
    }

    public String getHomeTeam() {
        return HomeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        HomeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return AwayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        AwayTeam = awayTeam;
    }

    public ArrayList<String> getHomeScorers() {
        return HomeScorers;
    }

    public void setHomeScorers(ArrayList<String> homeScorers) {
        HomeScorers = homeScorers;
    }

    public ArrayList<String> getAwayScorers() {
        return AwayScorers;
    }

    public void setAwayScorers(ArrayList<String> awayScorers) {
        AwayScorers = awayScorers;
    }
}
