package location;

import java.util.HashMap;
import java.util.Map;

/**
 * List of places that cars can go.
 * Each has a name, latitude, and longitude
 */
public class Location {
	private String name;
	private double latitude;
	private double longitude;

	private static Map<String, Location> locations = new HashMap<>();

	private static final double FACTOR_LATITUDE_LONGITUDE_TO_MILES = 1.5;

	static {
		/* real latitudes & longitudes
		new Location("Sacramento", 38.581572, -121.4944);
		new Location("Redding", 40.58654, -122.391675);
		new Location("San Francisco", 37.774929, -122.419416);
		new Location("San Jose", 37.338208, -121.886329);
		new Location("Fresno", 36.746842, -119.772587);
		new Location("Los Angeles", 34.052234, -118.243685);
		new Location("San Diego", 32.715738, -117.161084);
		new Location("San Bernadino", 34.108345, -117.289765);
		new Location("Yosemite Valley", 37.74557, -119.593604);
		new Location("Death Valley", 36.532265, -116.932541);
		*/
		//fake values to fit on the map (y=latitude,x=longitude in inverse order)
		new Location("Sacramento", 151, 101);
		new Location("Redding", 68, 69);
		new Location("San Francisco", 188, 64);
		new Location("San Jose", 209, 78);
		new Location("Fresno", 252, 171);
		new Location("Los Angeles", 346, 201);
		new Location("San Diego", 390, 241);
		new Location("San Bernadino", 336, 240);
		new Location("Yosemite", 205, 191);
		new Location("Death Valley", 250, 247);
	}

	/**
   * @return all location objects
	 */
	public static Location[] getLocations() {
		return locations.values().toArray(new Location[0]);
	}
	
	/**
	 * finds the Location by its name
	 *@param name
	 *@return matching Location object or null
	 */
	public static Location getByName(String name) {
		return locations.get(name);
	}

	private Location(String name, double latitude, double longitude) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		if (name != null) { //only add to list if we have a name
			locations.put(name, this);
		}
	}

	/**
	 * Get the as the crow flies miles gross approximation
	 *@param otherLocation where we're going
	 *@return estimated miles from this location to otherLocation
	 */
	double milesTo(Location otherLocation) {
		return FACTOR_LATITUDE_LONGITUDE_TO_MILES *
				Math.sqrt(Math.pow(latitude - otherLocation.latitude, 2) +
						Math.pow(longitude - otherLocation.longitude, 2));
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name + "[" + latitude + "," + longitude + "]";
	}
}
