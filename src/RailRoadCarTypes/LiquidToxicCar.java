package RailRoadCarTypes;

import Exceptions.LoadException;
import Exceptions.ToxicityException;

public class LiquidToxicCar extends RailRoadCar {
    private static final int maxCapacity, maxToxicity;
    private static int currentLoad, toxicity;
    static {
        maxCapacity = 60000;
        maxToxicity = 600;
        currentLoad = 0;
        toxicity = 200;
    }
    public LiquidToxicCar(String shipper) {
        super(shipper);
        type = "LiquidToxic";
        this.grossWeight = Math.round(Math.random()*10000 + 40000);
    }

    public void loadToxicLiquidMaterials(int amount) throws LoadException {
        if(currentLoad + amount > maxCapacity) {
            throw new LoadException("Cannot load more than capacity");
        }
        this.currentLoad += amount;
    }

    public void unloadToxicLiquidMaterials(int amount) throws LoadException {
        if(currentLoad <= 0) {
            throw new LoadException("The Toxic Car is empty, there is nothing to unload");
        }
        this.currentLoad -= amount;
    }

    public void checkLiquidToxicity() throws ToxicityException {
        if(toxicity >= maxToxicity) {
            throw new ToxicityException("Toxicity is too high! There is a risk of decomposition");
        }
        System.out.println("Toxicity is in a stable condition: " + this.toxicity);
    }
    @Override
    public String toString() {
        return "Type: Toxic Liquid Material Car " + " ID " + this.getID() + " Current Weight Load " + this.grossWeight + " kilos";
    }
}
