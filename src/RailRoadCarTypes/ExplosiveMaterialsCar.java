package RailRoadCarTypes;

import Exceptions.LoadException;
import Exceptions.OverHeatException;

public class ExplosiveMaterialsCar extends RailRoadCar {
    private static final int maxCapacity, maxTemperature;
    public static int currentLoad;
    private static int currentTemperature;
    public static boolean riskOfExplosion;
    static {
        maxCapacity = 60000;
        currentLoad = 0;
        currentTemperature = 27;
        maxTemperature = 50; // degrees Celsius
        riskOfExplosion = false;
    }
    public ExplosiveMaterialsCar(String shipper) {
        super(shipper);
        type = "Explosives";
        this.grossWeight = Math.round(Math.random() * 120000 + 150000);
    }

    public void addExplosives(int amount) throws LoadException {
        if(currentLoad + amount > maxCapacity) {
            throw new LoadException("Cannot load more than capacity");
        }
        this.currentLoad += amount;
    }

    public void removeExplosives(int amount) throws LoadException {
        if(currentLoad <= 0) {
            throw new LoadException("The Explosives Car is empty, there is nothing to unload");
        }
        this.currentLoad -= amount;
    }

    public void setRiskOfExplosion() {
        riskOfExplosion = true;
    }
    public void checkRiskOfExplosion() throws OverHeatException {
        if(currentTemperature >= maxTemperature) {
            throw new OverHeatException("The heating is to high! There is a risk of explosion");
        }
        System.out.println("The heating is stable! There is no risk yet");
    }

    public void fixRiskOfExplosion() {
        riskOfExplosion = false;
        currentLoad = 0;
        System.out.println("The risk was prevented! The train was unloaded to prevent the explosion");
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public boolean getRiskOfExplosion() {
        return riskOfExplosion;
    }
    @Override
    public String toString() {
        return "Type: Explosive Materials Car " + " ID " + this.getID() + " Current Weight Load " + this.grossWeight + " kilos";
    }
}
