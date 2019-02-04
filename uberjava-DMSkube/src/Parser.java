public class Parser {

    // Instance Variables
    int numPassengers;
    int distance;
    int minutes;
    double fare;
    boolean surgePricing = false;
    boolean doubleSurgePricing = false;
    String content;
    String rideNumber;
    String riderName;
    String start;
    String destination;
    String completionURL;
    String additionalInfoURL;
    //Parser[] parserInfo = [3];

    // Constructor
    public Parser(String content) {
        this.content = content;
    }

    // Methods

    public int getDistance(){
        WebFetcher fetcher = new WebFetcher(getCompletionURL());
        String distanceString = fetcher.result.substring(fetcher.result.indexOf("ce:") + 4, fetcher.result.indexOf("miles") - 1);
        return distance = Integer.parseInt(distanceString);
    }

    public int getRating(){
        WebFetcher fetcher = new WebFetcher(getAdditionalInfoURL());
        String[] starSplit = fetcher.result.split("golden-star");
        return starSplit.length - 1;
    }

    public int getMinutes(){
        WebFetcher fetcher = new WebFetcher(getCompletionURL());
        String minutesString = fetcher.result.substring(fetcher.result.indexOf("utes: ") + 6, fetcher.result.indexOf("<br />" , fetcher.result.indexOf("utes: ") + 6));
        return minutes = Integer.parseInt(minutesString);
    }

    public String getRideNumber() {
        try {
            rideNumber = (content.substring(content.indexOf("#"), content.indexOf("#") + 11));
        } catch (NullPointerException e) {
            return e.toString();
        }
        return rideNumber;
    }

    public String getRiderName() {
        try {
            riderName = (content.substring(content.indexOf("Rider: ") + 7, content.indexOf("</b>", 50)));
        } catch (NullPointerException e) {
            return e.toString();
        }
        return riderName;
    }

    public int getNumPassengers() {
        try {
            if (content.contains("people")) {
                String numPassengersString = content.substring(content.indexOf("people") - 2, content.indexOf("people") - 1);
                numPassengers = Integer.parseInt(numPassengersString);
            } else {
                String numPassengersString = content.substring(content.indexOf("person") - 2, content.indexOf("person") - 1);
                numPassengers = Integer.parseInt(numPassengersString);
            }
        } catch (NullPointerException e) {
            System.out.println(e);
            return -1;
        }
        return numPassengers;
    }

    public String getStart() {
        try {
            start = content.substring(content.indexOf("FROM") + 5, content.indexOf(" to"));
        } catch (NullPointerException e) {
            return e.toString();
        }
        return start;
    }

    public String getDestination() {
        try {
            destination = content.substring(content.indexOf(" to ") + 4, content.indexOf("<br/>", content.indexOf("FROM")));
        } catch (NullPointerException e) {
            return e.toString();
        }
        return destination;
    }

    public double getFare() {
        try {
            String fareString = content.substring(content.indexOf("$") + 1, content.indexOf("<br/>", content.indexOf("Fare")));
            fare = Double.parseDouble(fareString);
        } catch (NullPointerException e) {
            System.out.println(e);
            return -1;
        }
        return fare;
    }

    public boolean isSurgePricing(){
        if (content.contains("SURGE PRICING") && !content.contains("DOUBLE")){
            surgePricing = true;
        }
        return surgePricing;
    }

    public boolean isDoubleSurgePricing() {
            if (content.contains("DOUBLE SURGE PRICING")) {
                doubleSurgePricing = true;
            }
            return doubleSurgePricing;
    }

    public String getCompletionURL(){
        return completionURL = content.substring(content.indexOf("https"), content.indexOf("</a>"));
    }

    public String getAdditionalInfoURL(){
        return additionalInfoURL = content.substring(content.indexOf("/>https") + 2, content.indexOf("</a>", content.indexOf("/>https")));
            }

}
