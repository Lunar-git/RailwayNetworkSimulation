package RailRoadCarTypes;

import Exceptions.LoadException;
import Exceptions.ToxicityException;

public class ToxicMaterialsCar extends RailRoadCar {
    private static final int maxCapacity, maxToxicity;
    private static int currentLoad, toxicity;
    static {
        maxCapacity = 60000;
        maxToxicity = 600;
        currentLoad = 0;
        toxicity = 200;
    }
    public ToxicMaterialsCar(String shipper) {
        super(shipper);
        type = "Toxic";
        this.grossWeight = Math.round(Math.random()*20000 + 30000);
    }

    public void addToxicMaterials(int amount) throws LoadException {
        if(currentLoad + amount > maxCapacity) {
            throw new LoadException("Cannot load more than capacity");
        }
        this.currentLoad += amount;
    }

    public void removeToxicMaterials(int amount) throws LoadException {
        if(currentLoad <= 0) {
            throw new LoadException("The Toxic Car is empty, there is nothing to unload");
        }
        this.currentLoad -= amount;
    }

    public void checkToxicity() throws ToxicityException {
        if(toxicity >= maxToxicity) {
            throw new ToxicityException("Toxicity is too high! There is a risk of decomposition");
        }
        System.out.println("Toxicity is in a stable condition: " + this.toxicity);
    }

    @Override
    public String toString() {
        return "Type: Toxic Materials Car " + " ID " + this.getID() + " Current Weight Load " + this.grossWeight + " kilos";
    }
}
