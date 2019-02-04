package vehicle;

import location.Location;

public abstract class Vehicle {
    private Location currentLocation;
    private Location startLocation;

    public Vehicle(){

    }

    public Vehicle(String startLocation){
        this.startLocation = Location.getByName(startLocation);
    }
/*
    public boolean driveTo(String newLocation){
        if (Location.locations.containsKey(newLocation)) {
            currentLocation = Location.getByName(newLocation);
            return true;
        }
        return false;
    }

*/



}
