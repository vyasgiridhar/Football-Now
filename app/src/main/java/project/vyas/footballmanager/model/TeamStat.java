package project.vyas.footballmanager.model;

/**
 * Created by vyas on 11/23/16.
 */

public class TeamStat {

    private String Captain;
    private String Manager;
    private String Stadium;

    public String getStadium() {
        return Stadium;
    }

    public void setStadium(String stadium) {
        Stadium = stadium;
    }

    public String getManager() {
        return Manager;
    }

    public void setManager(String manager) {
        Manager = manager;
    }

    public String getCaptain() {
        return Captain;
    }

    public void setCaptain(String captain) {
        Captain = captain;
    }
}
