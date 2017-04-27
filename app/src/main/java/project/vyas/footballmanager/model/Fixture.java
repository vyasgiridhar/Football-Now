package project.vyas.footballmanager.model;

import java.util.Date;

/**
 * Created by Prasanna on11/20/16.
 */


public class Fixture {

    public int homeScore;
    public int awayScore;
    private String LeagueCode;
    private int GameWeek;
    private int GameNo;
    private String HomeTeam;
    private String AwayTeam;
    private Date MatchDate;

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore){
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore){
        this.awayScore = awayScore;
    }

    public int getGameNo() {
        return GameNo;
    }

    public void setGameNo(int gameNo) {
        GameNo = gameNo;
    }

    public String getLeagueCode() {
        return LeagueCode;
    }

    public void setLeagueCode(String leagueCode) {
        LeagueCode = leagueCode;
    }

    public int getGameWeek() {
        return GameWeek;
    }

    public void setGameWeek(int gameWeek) {
        GameWeek = gameWeek;
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

    public Date getMatchDate() {
        return MatchDate;
    }

    public void setMatchDate(Date matchDate) {
        MatchDate = matchDate;
    }
}
