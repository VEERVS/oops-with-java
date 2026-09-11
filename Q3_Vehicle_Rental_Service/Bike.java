class Bike implements Rentable {

    static final double TAX_RATE = 0.05;

    @Override
    public double calculateRent(int days) {
        Car.totalVehiclesRented++;
        return 500 * days;
    }
}