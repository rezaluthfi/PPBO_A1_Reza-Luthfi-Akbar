import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TravelAgent {

    private ArrayList<Trip> trips = new ArrayList<>();
    private HashMap<String, Customer> customers = new HashMap<>();
    private int nextBookingId = 1;


    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    public void showAvailableTrip() {
        int availableTripsCount = 0;

        for (Trip trip : trips) {
            if (trip.getQty() > 0) {
                availableTripsCount++;
            }
        }

        System.out.println("Terdapat " + availableTripsCount + " trip yang masih tersedia : ");
        for (Trip trip : trips) {
            if (trip.getQty() > 0) {
                System.out.println("Destinasi : " + trip.getDestination()
                        + " -- Keberangkatan : " + trip.getDepartureDate()
                        + " -- Harga : " + trip.getPrice()
                        + " -- Qty : " + trip.getQty()
                        + " -- Jenis : " + trip.getTripType());
            }
        }
    }

    public void bookTrip(String customerName, String destination) {
        Trip selectedTrip = null;
        for (Trip trip : trips) {
            if (trip.getDestination().equals(destination) && trip.getQty() > 0){
                selectedTrip = trip;
                break;
            }
        }

        for (Customer customer : customers.values()) {
            if (customer.getTrip().getDestination().equals(destination) && customer.getName().equals(customerName)) {
                System.out.println("Pemesanan gagal, pengguna telah memiliki pesanan pada trip yang sama dengan id "
                        + customer.getBookingId());
                return;
            }
        }

        if (selectedTrip != null) {
            if (selectedTrip.getQty() > 0) {
                selectedTrip.setQty(selectedTrip.getQty() - 1);
                Customer customer = new Customer(customerName, customerName + "@gmail.com");
                customer.setTrip(selectedTrip);
                customer.setBookingId( "00" + destination + "00" + selectedTrip.getTripType() + nextBookingId);
                nextBookingId++;
                customers.put(customer.getEmail(), customer);
                System.out.println("Pemesanan berhasil dilakukan dengan booking id " + customer.getBookingId());
            } else {
                System.out.println("Pemesanan gagal, perjalanan ke" + destination + " telah habis terjual.");
            }
        } else {
            System.out.println("Pemesanan gagal, perjalanan ke " + destination + " telah habis terjual.");
        }
    }

    public void cancelBooking(String customerEmail, String destination) {
        Customer customerToRemove = null;

        for (Map.Entry<String, Customer> entry : customers.entrySet()) {
            Customer customer = entry.getValue();
            if (customer.getEmail().equalsIgnoreCase(customerEmail) && customer.getTrip().getDestination().equalsIgnoreCase(destination)) {
                customerToRemove = customer;
                break;
            }
        }

        if (customerToRemove != null) {
            customerToRemove.getTrip().setQty(customerToRemove.getTrip().getQty() + 1);
            customers.remove(customerToRemove.getEmail());
            System.out.println("Pesanan dengan id booking " + customerToRemove.getBookingId() + " berhasil dibatalkan");
        } else {
            System.out.println("Pesanan tidak ditemukan");
        }
    }

    public void getBookingsByCustomerEmail(String customerEmail) {
        int getBookingsByCustomerEmail = 0;

        for (Customer customer : customers.values()) {
            if (customer.getEmail().equalsIgnoreCase(customerEmail)) {
                getBookingsByCustomerEmail++;
            }
        }

        if (getBookingsByCustomerEmail == 0) {
            System.out.println("Tidak ditemukan pesanan dengan email " + customerEmail);
        } else {
            for (Customer customer : customers.values()) {
                if (customer.getEmail().equalsIgnoreCase(customerEmail)) {
                    System.out.println("Pesanan dengan email " + customerEmail);
                    System.out.println("Booking ID: " + customer.getBookingId()
                            + ", Destinasi: " + customer.getTrip().getDestination());
                }
            }
        }

    }

    public void getAvailableTripsByType(TripType tripType) {
        int availableTripsCount = 0;

        for (Trip trip : trips) {
            if (trip.getTripType() == tripType && trip.getQty() > 0) {
                availableTripsCount++;
            }
        }

        if (availableTripsCount == 0) {
            System.out.println("Tidak ditemukan trip untuk jenis " + tripType);
        } else {
            System.out.println("Ditemukan " + availableTripsCount + " trip untuk jenis " + tripType.toString());
            for (Trip trip : trips) {
                if (trip.getTripType() == tripType && trip.getQty() > 0) {
                    System.out.println("Destinasi: " + trip.getDestination() +
                            " -- Keberangkatan: " + trip.getDepartureDate() +
                            " -- Harga: " + trip.getPrice() +
                            " -- Qty: " + trip.getQty() +
                            " -- Jenis: " + trip.getTripType());
                }
            }
        }

    }


    public void getAvailableTripsByDate(String s) {
        int availableTripsCount = 0;

        for (Trip trip : trips) {
            if (trip.getDepartureDate().equals(s)) {
                availableTripsCount++;
            }
        }

        if (availableTripsCount == 0) {
            System.out.println("Tidak ditemukan data trip dengan jadwal keberangkatan pada " + s);
        } else {
            System.out.println("Ditemukan " + availableTripsCount + " untuk keberangkatan tanggal " + s);
            for (Trip trip : trips) {
                if (trip.getDepartureDate().equals(s)) {
                    System.out.println("Destinasi : " + trip.getDestination()
                            + " -- Keberangkatan : " + trip.getDepartureDate()
                            + " -- Harga : " + trip.getPrice()
                            + " -- Qty : " + trip.getQty()
                            + " -- Jenis : " + trip.getTripType());
                }
            }
        }
    }

}
