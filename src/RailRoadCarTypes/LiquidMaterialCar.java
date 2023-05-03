package RailRoadCarTypes;

import Exceptions.LoadException;

public class LiquidMaterialCar extends RailRoadCar{
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
    public LiquidMaterialCar(String shipper) {
        super(shipper);
        type = "Liquid";
        this.grossWeight = Math.round(Math.random()*10000 + 40000);
    }

    public void setExploisionRisk() {
        this.pressure += 1000;
        isLeak = true;
    }

    public boolean checkExplosionRisk() {
        if(pressure > maxPressure || isLeak) {
            System.out.println("The pressure is too high! Use fixExplosionRisk() to prevent the car from explosion!");
            return isLeak = true;
        }
        System.out.println("There is no risk of Explosion yet");
        return isLeak = false;
    }

    public void fixExplosionRisk() {
        this.currentLoad = 0;
        this.pressure = 0;
        System.out.println("Liquid was successfully poured out! The exploision is prevented");
    }

    public void addLiquid(int amount) throws LoadException {
        if(currentLoad + amount > maxCapacity) {
            throw new LoadException("Cannot load more than capacity");
        }
        this.currentLoad += amount;
    }

    public void removeLiquid(int amount) throws LoadException {
        if(currentLoad <= 0) {
            throw new LoadException("The Refrigerated Car is empty, there is nothing to unload");
        }
        this.currentLoad -= amount;
    }
    @Override
    public String toString() {
        return "Type: Liquid Material Car " + " ID " + this.getID() + " Current Weight Load " + this.grossWeight + " kilos";
    }
}
