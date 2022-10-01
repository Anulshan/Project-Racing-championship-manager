package main;
import java.io.Serializable;
import java.util.Date;

public class Race implements Serializable {
    private Date date;
    private int code;
    private int location;
    public Race() {

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}

   