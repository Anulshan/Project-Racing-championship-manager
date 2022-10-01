package racingleague.model;

public class Formula1Driver extends Driver {

    private String raceDate;
    protected Integer noOfParticipatedRaces;
    protected Integer seasonPoints;
    protected Integer position;

    public Formula1Driver() {
    }

    public Formula1Driver(String driverName, String driverCode, String driverLocation, String driverTeam,
                          String raceDate, Integer noOfParticipatedRaces, Integer seasonPoints, Integer position) {
        super(driverName, driverCode, driverLocation, driverTeam);
        this.raceDate = raceDate;
        this.noOfParticipatedRaces = noOfParticipatedRaces;
        this.seasonPoints = seasonPoints;
        this.position = position;
    }

    public String getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(String raceDate) {
        this.raceDate = raceDate;
    }

    public Integer getNoOfParticipatedRaces() {
        return noOfParticipatedRaces;
    }

    public void setNoOfParticipatedRaces(Integer noOfParticipatedRaces) {
        this.noOfParticipatedRaces = noOfParticipatedRaces;
    }

    public Integer getSeasonPoints() {
        return seasonPoints;
    }

    public void setSeasonPoints(Integer seasonPoints) {
        this.seasonPoints = seasonPoints;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Formula1Driver{" +
                "driverName='" + driverName + '\'' +
                ", driverCode='" + driverCode + '\'' +
                ", driverLocation='" + driverLocation + '\'' +
                ", driverTeam='" + driverTeam + '\'' +
                ", raceDate='" + raceDate + '\'' +
                ", noOfParticipatedRaces=" + noOfParticipatedRaces +
                ", seasonPoints=" + seasonPoints +
                ", position=" + position +
                '}' + "\n";
    }
}
