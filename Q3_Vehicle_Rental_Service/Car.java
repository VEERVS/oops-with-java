class Car implements Rentable {

    static final double TAX_RATE = 0.05;
    static int totalVehiclesRented = 0;

    @Override
    public double calculateRent(int days) {
        totalVehiclesRented++;
        return 1500 * days;
    }
}