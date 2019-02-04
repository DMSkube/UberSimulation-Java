package vehicle;

import java.util.ArrayList;
import location.Location;

public class Car extends Vehicle {

    // Instance Variables
    String name;
    String make;
    int year;
    Integer purchaseCost;
    Integer milesPerGallon;
    boolean parked;
    Location location;
    static ArrayList<Car> allCars = new ArrayList<Car>();


    public Car(String name, int year, String make){
        this.location = Location.getByName("San Francisco");
        this.name = name;
        this.year = year;
        this.make = make;
        parked = true;
        purchaseCost = null;
        milesPerGallon = null;
        allCars.add(this);

    }

    public Car(String name, int year, String make, String location){
        super(location);
        this.name = name;
        this.year = year;
        this.make = make;
        purchaseCost = null;
        milesPerGallon = null;
        parked = true;
    }

    // Methods

    String getName(){
        return name;
    }

    public void Park(){
        parked = true;
    }

    public boolean isParked(){
        return parked;
    }
/*
    @Override
    public boolean driveTo(String newLocation){
        parked = false;
        super(newLocation);
    }

    static Car[] getCars{
        return allCars;
    }

*/

}
