enum TripType {
    FLIGHT,
    HOTEL,
    PACKAGE
}

public class Trip {

    private String destination;
    private int price;
    private String departureDate;
    private int qty;
    private TripType tripType;

    public Trip(String destination, int price, String departureDate, TripType tripType, int qty) {
        this.destination = destination;
        this.price = price;
        this.departureDate = departureDate;
        this.tripType = tripType;
        this.qty = qty;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public TripType getTripType() {
        return tripType;
    }

    public void setTripType(TripType tripType) {
        this.tripType = tripType;
    }

}
