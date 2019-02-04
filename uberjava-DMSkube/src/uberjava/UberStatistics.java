package uberjava;

import java.util.ArrayList;

public class UberStatistics {

    // Instance Variables
    ArrayList<UberStatistics> allStats= new ArrayList<>();
    private int numFares;
    private int minutesOnRoad;
    private double avgRating;
    private double milesDriven;
    private double dollarsEarned;
    private double operationCosts;
    private double effectiveHourlyEarnings;

    // Constructor
    public UberStatistics(int sessionNumber){
        allStats.add(this);
    }
    // Methods

    public void addFare(){
        ++numFares;
    }

    public void addMinutes(int minutes){
        minutesOnRoad += minutes;
    }

    public void addMiles(double miles){
        milesDriven += miles;
    }

    public void addDollars(double dollars){
        dollarsEarned += dollars;
    }



}
