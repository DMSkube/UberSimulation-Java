package uberjava;

public class Rider {

    // Instance Variables
    String name;
    double totalBill = 0;
    int totalFares = 0;
    int totalMinutesTraveled = 0;

    // Constructor
    public Rider(String name){
        this.name = name;
    }

    // Methods
    public void addFare(){
        ++totalFares;
    }

    public void addBill(double amount){
        totalBill += amount;
    }

    public void addMinutes(int time){
        totalMinutesTraveled += time;
    }

    // Getters
    public String getName(){
        return name;
    }

    public double getTotalBill(){
        return totalBill;
    }

    public int getTotalFares(){
        return totalFares;
    }

    public int getTotalMinutesTraveled(){
        return totalMinutesTraveled;
    }


}
