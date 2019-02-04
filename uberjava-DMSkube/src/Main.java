//package uberjava;

import location.Location;
import uberjava.Driver;
import vehicle.Car;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Car tesla = new Car("Roadster", 2019, "Tesla");
        Car porsche = new Car("911 Turbo S Cabriole", 2018, "Porsche");
        Car honda = new Car("Accord", 2006, "Honda");



        Driver james = new Driver("James", porsche);
        Driver prateek = new Driver("Prateek", tesla);
        Driver daniel = new Driver("Daniel", honda);

        Driver[] drivers = new Driver[3];
        drivers[0] = james;
        drivers[1] = prateek;
        drivers[2] = daniel;

	    WebFetcher wf = new WebFetcher("https://www.cs.usfca.edu/~dhalperin/nextFare.cgi?driver=james");
	    Parser parse = new Parser(wf.toString());

	    james.startSession(parse.getRiderName(), parse.getStart(), parse.getDestination());
	    prateek.startSession(parse.getRiderName(), parse.getStart(), parse.getDestination());
	    daniel.startSession(parse.getRiderName(), parse.getStart(), parse.getDestination());

    }
}
