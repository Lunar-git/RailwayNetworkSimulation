package RailRoadCarTypes;

import Exceptions.LoadException;

public class GaseousMaterialCar extends RailRoadCar {
    private static final int maxCapacity, maxPressure;
    private static int currentLoad, pressure;
    private static boolean isLeak;

    static {
        maxCapacity = 60000;
        maxPressure = 600;
        currentLoad = 0;
        pressure = 200;
        isLeak = false;
    }

    public GaseousMaterialCar(String shipper) {
        super(shipper);
        type = "Gas";
        this.grossWeight = Math.round(Math.random()*60000 + 80000);
    }

    public void loadGas(int amount) throws LoadException {
        if (currentLoad + amount > maxCapacity) {
            throw new LoadException("Cannot load more than capacity");
        }
        this.currentLoad += amount;
    }

    public void removeGas(int amount) throws LoadException {
        if (currentLoad <= 0) {
            throw new LoadException("The Gaseous Car is empty, there is nothing to unload");
        }
        this.currentLoad -= amount;
    }

    public void setLeak() {
        this.pressure += 1000;
        isLeak = true;
    }

    public boolean isLeak() {
        if (pressure > maxPressure || isLeak) {
            System.out.println("There is a leak! Use fixLeak() to prevent the car from explosion!");
            return isLeak = true;
        }
        System.out.println("There is no leak yet");
        return isLeak = false;
    }

    public void fixLeak() {
        this.currentLoad = 0;
        this.pressure = 0;
        System.out.println("Gas was successfully released! The exploision is prevented");
    }

    @Override
    public String toString() {
        return "Type: Gaseous Material Car " + " ID " + this.getID() + " Current Weight Load " + this.grossWeight + " kilos";
    }
}
