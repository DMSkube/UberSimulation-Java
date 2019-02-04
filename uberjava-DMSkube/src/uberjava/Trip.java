package uberjava;

import location.Location;
import uberjava.Driver;

public class Trip {

    // Instance Variables
    Driver driver;
    Rider rider;
    Location start;
    Location destination;

    public Trip(Driver driver, Rider rider, Location start, Location destination){
        this.driver = driver;
        this.rider = rider;
        this.start = start;
        this.destination = destination;
    }
/*
    private double tripDistance(){
        return start.milesTo(destination);
    }
    */
}
