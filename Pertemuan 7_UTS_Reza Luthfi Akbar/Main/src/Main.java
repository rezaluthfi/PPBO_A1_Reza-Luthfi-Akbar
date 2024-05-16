public class Main {
    public static void main(String[] args) {

    TravelAgent agent = new TravelAgent();

    Trip paris = new Trip("Paris", 15000000, "1-MAY-2024", TripType.FLIGHT, 2);
    Trip newYork = new Trip("New York", 20000000, "15-MAY-2024", TripType.FLIGHT, 3);
    Trip london = new Trip("London", 18000000, "22-APR-2024", TripType.HOTEL, 10);
    Trip tokyo = new Trip("Tokyo", 8000000, "25-APR-2024", TripType.PACKAGE, 7);

    agent.addTrip(paris);
    agent.addTrip(newYork);
    agent.addTrip(london);
    agent.addTrip(tokyo);
    agent.showAvailableTrip();
    System.out.println("-----------------------------------------------------------------------------------------");

    Customer resti = new Customer("Resti", "Resti@gmail.com");
    Customer hanif = new Customer("Hanif", "Hanif@gmail.com");
    Customer aziz = new Customer("Aziz", "Aziz@gmail.com");
    Customer revan = new Customer("Revan", "Revan@gmail.com");

    agent.bookTrip("resti", "Paris");
    agent.bookTrip("hanif", "Paris");
    agent.bookTrip("revan", "New York");
    agent.bookTrip("aziz", "Paris");
    agent.bookTrip("aziz", "New York");
    agent.bookTrip("aziz", "New York");

    System.out.println("-----------------------------------------------------------------------------------------");
    agent.showAvailableTrip();
    System.out.println("-----------------------------------------------------------------------------------------");

    agent.cancelBooking(resti.getEmail(), "Paris");
    agent.cancelBooking(hanif.getEmail(), "Paris");
    agent.cancelBooking(aziz.getEmail(), "Paris");
    System.out.println("-----------------------------------------------------------------------------------------");
    agent.showAvailableTrip();
    System.out.println("-----------------------------------------------------------------------------------------");

    //OPTIONAL METHOD
    System.out.println("OUTPUT OPSIONAL");
    agent.getBookingsByCustomerEmail(resti.getEmail());
    agent.getBookingsByCustomerEmail(hanif.getEmail());
    agent.getBookingsByCustomerEmail(revan.getEmail());
    agent.getBookingsByCustomerEmail(aziz.getEmail());
    System.out.println("-----------------------------------------------------------------------------------------");
    agent.getAvailableTripsByType(TripType.FLIGHT);
    System.out.println("-----------------------------------------------------------------------------------------");
    agent.getAvailableTripsByDate("20-MAY-2024");
    agent.getAvailableTripsByDate("1-MAY-2024");

    }
}