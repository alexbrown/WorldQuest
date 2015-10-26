package io.zipcoder.production.worldquest.models;

/**
 * Class Team
 */
public class Team {
    private String name;
    private int teamId;
    private int score;
    private String hash;

    /**
     * Default constructor
     */
    public Team() {}

    /**
     * Name-Hash constructor
     * @param name  User/Team name
     * @param hash  Password hash
     */
    public Team(String name, String hash) {
        this.teamId = 0;
        this.name = name;
        this.hash = hash;
        this.score = 0;
    }

    /**
     * Get name
     * @return  this team's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the team's name
     * @param name  team name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get team id
     * @return  the team's id
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     * Set team id
     * @param teamId    the new team id
     */
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    /**
     * Get score
     * @return  the team's current score
     */
    public int getScore() {
        return score;
    }

    /**
     * Set the score
     * @param score     the new score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Get the current hash
     * @return  the team's password's hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * Set hash
     * @param hash  the team's password's new hash
     */
    public void setHash(String hash) {
        this.hash = hash;
    }
}
