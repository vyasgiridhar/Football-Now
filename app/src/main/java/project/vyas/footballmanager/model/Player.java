package project.vyas.footballmanager.model;

/**
 * Created by vyas on 11/20/16.
 */

public class Player {


    private String id;
    private String fName;
    private String lName;
    private String TeamName;
    private String Nationality;
    private String Foot;
    private int Rating;
    private String Position;
    private String ImageUrl;
    private int Pace;
    private int Dribbling;
    private int Shot;
    private int Passing;
    private int Defence;
    private int Age;
    private int Strength;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public String getFoot() {
        return Foot;
    }

    public void setFoot(String foot) {
        Foot = foot;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public int getDefence() {
        return Defence;
    }

    public void setDefence(int defence) {
        Defence = defence;
    }

    public int getPassing() {
        return Passing;
    }

    public void setPassing(int passing) {
        Passing = passing;
    }

    public int getShot() {
        return Shot;
    }

    public void setShot(int shot) {
        Shot = shot;
    }

    public int getDribbling() {
        return Dribbling;
    }

    public void setDribbling(int dribbling) {
        Dribbling = dribbling;
    }

    public int getPace() {
        return Pace;
    }

    public void setPace(int pace) {
        Pace = pace;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }
}
