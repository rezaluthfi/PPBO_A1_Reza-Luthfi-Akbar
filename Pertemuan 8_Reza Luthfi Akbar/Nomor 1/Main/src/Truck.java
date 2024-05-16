<<<<<<< HEAD
public class Truck extends Vehicle {

    private int cargoCapacity;

    public Truck(String brand, int year, double rentalPrice, int cargoCapacity) {
        super(brand, year, rentalPrice);
        this.cargoCapacity = cargoCapacity;
    }
    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public double truckDiscount() {
        double discount = 0;
        if (getYear() < 2010) {
            discount = getRentalPrice() * 0.1;
        }

        if (cargoCapacity > 2000) {
            discount += getRentalPrice() * 0.1;
        } else {
            discount = 0;
        }
        return discount;
    }

    @Override
    public void displayInfo() {
       // super.displayInfo();
        System.out.println("Detail Truk :");
        System.out.println("Merk : " + getBrand());
        System.out.println("Tahun : " + getYear());
        System.out.println("Harga Sewa : " + getRentalPrice());
        System.out.println("Kapasitas Kargo : " + cargoCapacity);
        System.out.println("Total Diskon : " + truckDiscount());
        System.out.println("Harga sewa setelah diskon : " + (getRentalPrice() - truckDiscount()));
        System.out.println("-------------------------------------------------------");
    }
}
=======
public class Truck extends Vehicle {

    private int cargoCapacity;

    public Truck(String brand, int year, double rentalPrice, int cargoCapacity) {
        super(brand, year, rentalPrice);
        this.cargoCapacity = cargoCapacity;
    }
    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public double truckDiscount() {
        double discount = 0;
        if (getYear() < 2010) {
            discount = getRentalPrice() * 0.1;
        }

        if (cargoCapacity > 2000) {
            discount += getRentalPrice() * 0.1;
        } else {
            discount = 0;
        }
        return discount;
    }

    @Override
    public void displayInfo() {
       // super.displayInfo();
        System.out.println("Detail Truk :");
        System.out.println("Merk : " + getBrand());
        System.out.println("Tahun : " + getYear());
        System.out.println("Harga Sewa : " + getRentalPrice());
        System.out.println("Kapasitas Kargo : " + cargoCapacity);
        System.out.println("Total Diskon : " + truckDiscount());
        System.out.println("Harga sewa setelah diskon : " + (getRentalPrice() - truckDiscount()));
        System.out.println("-------------------------------------------------------");
    }
}
>>>>>>> origin/master
