enum CarType {
    PREMIUM_CAR,
    FAMILY_CAR,
    CITY_CAR
}

public class Car extends Vehicle {

    private CarType carType;

    public Car(String brand, int year, double rentalPrice, CarType carType) {
        super(brand, year, rentalPrice);
        this.carType = carType;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public double carDiscount() {
        double discount = 0;
        if (getYear() < 2010) {
            discount = getRentalPrice() * 0.1;
        }

        switch (carType) {
            case PREMIUM_CAR:
                discount += getRentalPrice() * 0.1;
                break;
            case FAMILY_CAR:
                discount += getRentalPrice() * 0.05;
                break;
            case CITY_CAR:
                break;
        }
        return discount;
    }

    @Override
    public void displayInfo() {
       // super.displayInfo();
        System.out.println("Detail Mobil :");
        System.out.println("Merk : " + getBrand());
        System.out.println("Tahun : " + getYear());
        System.out.println("Harga Sewa : " + getRentalPrice());
        System.out.println("Tipe Mobil : " + carType);
        System.out.println("Total Diskon : " + carDiscount());
        System.out.println("Harga sewa setelah diskon : " + (getRentalPrice() - carDiscount()));
        System.out.println("-------------------------------------------------------");
    }
}
