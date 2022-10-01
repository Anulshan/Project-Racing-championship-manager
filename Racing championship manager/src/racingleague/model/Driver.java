package racingleague.model;

public abstract class Driver {
    protected String driverName;
    protected String driverCode;
    protected String driverLocation;
    protected String driverTeam;

    public Driver() {
    }

    public Driver(String driverName, String driverCode, String driverLocation, String driverTeam) {
        this.driverName = driverName;
        this.driverCode = driverCode;
        this.driverLocation = driverLocation;
        this.driverTeam = driverTeam;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverCode() {
        return driverCode;
    }

    public void setDriverCode(String driverCode) {
        this.driverCode = driverCode;
    }

    public String getDriverLocation() {
        return driverLocation;
    }

    public void setDriverLocation(String driverLocation) {
        this.driverLocation = driverLocation;
    }

    public String getDriverTeam() {
        return driverTeam;
    }

    public void setDriverTeam(String driverTeam) {
        this.driverTeam = driverTeam;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverName='" + driverName + '\'' +
                ", driverCode='" + driverCode + '\'' +
                ", driverLocation='" + driverLocation + '\'' +
                ", driverTeam='" + driverTeam + '\'' +
                '}';
    }
}
