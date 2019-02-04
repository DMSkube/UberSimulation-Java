package uberjava;

import location.Location;
import vehicle.Car;
//import vehicle.Vehicle;


public class Driver {
    /*
    Instance Variables
     - String: Name
     - Vehicle:  Model
     - Boolean: hasBeenDriving24Hours
     - Boolean: isInSanFran
     - Boolean: Premium
     */

    //private Location currentLocation;
    int sessionNumber;
    private String name;
    private Car car;
    private boolean isPremium;
    private boolean isInSanFran;
    private int numFares;
    private int minutesOnRoad;
    private double avgRating;
    private double milesDriven;
    private double dollarsEarned;
    private double operationCosts;
    private double effectiveHourlyEarnings;
    private Location currentLocation;



    public Driver(String name, Car car){
        this.name = name;
        isInSanFran = true;
        this.car = car;
        isPremium = (name == "James" || name == "Prateek" ? true: false);
    }

    public int startSession(String riderName, String startName, String destinationName)throws IllegalStateException {
        try {
            int sessionNumber = 100;
            Rider rider = new Rider(riderName);
            Location start = Location.getByName(startName);
            Location destination = Location.getByName(destinationName);
            while (minutesOnRoad < 1440 && this.car.isParked() == true) {
                Trip currentTrip = new Trip(this, rider, start, destination);
            }
            this.endSession();
            ++sessionNumber;
        } catch (IllegalStateException e) {
            System.out.println(e.toString());
        }
        return sessionNumber;
    }


        public Location getCurrentLocation () {
            return currentLocation;
        }

    @Override
    public String toString(){
        return ("Name: " + name + "\n" + name + " is " + (isPremium? "": "not ") + "a premium driver.");
    }


        public String endSession () {
            this.car.Park();
            return this.toString();
        }


}
