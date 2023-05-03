import Exceptions.*;
import RailRoadCarTypes.*;

public class Presentation {
    public static void main(String[] args) {
        BaggageAndMailCar car = new BaggageAndMailCar("ABC Shipping");
        try {
            car.loadBaggage(5000);
            System.out.println("Successfully loaded " + car.getNumberOfBaggage() + " baggage into the car.");
        } catch (LoadException e) {
            System.out.println(e.getMessage());
        }

        try {
            car.unloadBaggage(2000);
            System.out.println("Successfully unloaded " + 2000 + " baggage from the car.");
        } catch (LoadException e) {
            System.out.println(e.getMessage());
        }

        try {
            car.loadMail(500);
            System.out.println("Successfully loaded " + car.getNumberOfMail() + " mail into the car.");
        } catch (LoadException e) {
            System.out.println(e.getMessage());
        }

        try {
            car.unloadMail(100);
            System.out.println("Successfully unloaded " + 100 + " mail from the car.");
        } catch (LoadException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Current number of baggage in the car: " + car.getNumberOfBaggage());
        System.out.println("Current number of mail in the car: " + car.getNumberOfMail());
        System.out.println(car.toString());

        //

        BaggageAndMailCar car1 = new BaggageAndMailCar("UPS");

        // Print information about the car
        System.out.println(car1.toString());

        // Load 5000 pieces of baggage
        try {
            car1.loadBaggage(5000);
            System.out.println("Loaded " + car1.getNumberOfBaggage() + " pieces of baggage");
        } catch (LoadException e) {
            System.out.println(e.getMessage());
        }

        // Load 1500 pieces of mail
        try {
            car1.loadMail(1500);
            System.out.println("Loaded " + car1.getNumberOfMail() + " pieces of mail");
        } catch (LoadException e) {
            System.out.println(e.getMessage());
        }

        // Unload 2000 pieces of baggage
        try {
            car1.unloadBaggage(2000);
            System.out.println("Unloaded 2000 pieces of baggage");
        } catch (LoadException e) {
            System.out.println(e.getMessage());
        }

        // Unload 1000 pieces of mail
        try {
            car1.unloadMail(1000);
        } catch (LoadException e) {
            System.out.println(e.getMessage());
        }

        // Print information about the car again
        System.out.println(car1.toString());

        //

        ExplosiveMaterialsCar car2 = new ExplosiveMaterialsCar("Acme Explosives");
        System.out.println(car.toString()); // prints car information

        try {
            car2.addExplosives(50000); // adds explosives to the car
        } catch (LoadException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Current Load: " + car2.currentLoad); // prints current load

        try {
            car2.checkRiskOfExplosion(); // checks if there is a risk of explosion
        } catch (OverHeatException e) {
            System.out.println(e.getMessage());
        }

        car2.setRiskOfExplosion(); // sets a risk of explosion

        try {
            car2.checkRiskOfExplosion(); // checks if there is a risk of explosion
        } catch (OverHeatException e) {
            System.out.println(e.getMessage());
        }

        car2.fixRiskOfExplosion(); // fixes the risk of explosion

        System.out.println("Current Load: " + car2.currentLoad); // prints current load after unloading

        //

        GaseousMaterialCar gaseousCar = new GaseousMaterialCar("Acme Inc.");

        // Load gas into the car
        try {
            gaseousCar.loadGas(50000);
            System.out.println("Gas loaded successfully!");
        } catch (LoadException e) {
            System.out.println(e.getMessage());
        }

        // Check for leaks
        gaseousCar.isLeak();

        // Set a leak
        gaseousCar.setLeak();

        // Check for leaks again
        gaseousCar.isLeak();

        // Fix the leak
        gaseousCar.fixLeak();

        // Try to remove gas from an empty car
        try {
            gaseousCar.removeGas(1000);
        } catch (LoadException e) {
            System.out.println(e.getMessage());
        }

        // Remove gas from the car
        try {
            gaseousCar.removeGas(30000);
            System.out.println("Gas removed successfully!");
        } catch (LoadException e) {
            System.out.println(e.getMessage());
        }

        // Print the current state of the car
        System.out.println(gaseousCar.toString());

        //

//        RailRoadCar car4 = new RailRoadCar("DFC");
//        System.out.println(car1.toString());
//
//        try {
//            car2.load(50000);
//            System.out.println("Loaded 50000 kilos into car2, current load: " + car2.getCurrentLoad());
//
//            car2.load(20000); // This should throw a LoadException
//        } catch (LoadException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            car2.unload(30000);
//            System.out.println("Unloaded 30000 kilos from car2, current load: " + car2.getCurrentLoad());
//
//            car2.unload(40000); // This should throw a LoadException
//        } catch (LoadException e) {
//            System.out.println(e.getMessage());
        }
    }