package project.vyas.footballmanager.model;

import java.util.Date;

/**
 * Created by vyas on 11/20/16.
 */


public class Fixture {

    private String LeagueCode;
    private int GameWeek;
    private int GameNo;
    private String HomeTeam;
    private String AwayTeam;
    private Date MatchDate;
    private class Score{
        public int homeScore;
        public int awayScore;
    }
    private Score MatchScore;

    public void setHomeScore(int homeScore){
        MatchScore.homeScore = homeScore;
    }

    public int getHomeScore(){
        return MatchScore.homeScore;
    }

    public void setAwayScore(int awayScore){
        MatchScore.awayScore = awayScore;
    }

    public int getAwayScore(){
        return MatchScore.awayScore;
    }

    public int getGameNo() {
        return GameNo;
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

    public void setGameNo(int gameNo) {
        GameNo = gameNo;
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
