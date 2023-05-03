package Generator;

import RailRoadCarTypes.*;

import java.util.ArrayList;
import java.util.Random;

public class RailRoadGenerate {
    static final String path = "src/Generator/TrainNames.txt";


    public static ArrayList<RailRoadCar> generateCars(String shipper) {
        Random random = new Random();
        ArrayList<RailRoadCar> generated = new ArrayList<>();
        int maxCars = random.nextInt(6) + 5;
        String[] types = {"basic", "heavy", "restaurant", "baggage", "passenger",
                          "post", "liquid", "toxic", "gas", "explosgeives", "toxicLiquid"};
        for (int i = 0; i < maxCars; i++) {
            int index = random.nextInt(types.length);
            String type = types[index];
            RailRoadCar car = new BasicFreightCar(shipper) ;
            switch (type) {
                case "basic": {
                    car = new BasicFreightCar(shipper);
                    break;
                }
                case "heavy": {
                    car = new HeavyFreightCar(shipper);
                    break;
                }
                case "restaurant": {

                    car = new RestrauntCar(shipper);
                    break;
                }
                case "baggage": {
                    car = new BaggageAndMailCar(shipper);
                    break;
                }
                case "passenger": {

                    car = new PassengerCar(shipper);
                    break;
                }
                case "post": {
                    car = new PostOfficeCar(shipper);
                    break;
                }
                case "liquid": {
                   car = new LiquidMaterialCar(shipper);
                   break;
                }
                case "toxic": {
                    car = new ToxicMaterialsCar(shipper);
                    break;
                }
                case "gas": {
                    car = new GaseousMaterialCar(shipper);
                    break;
                }
                case "explosives": {
                    car = new ExplosiveMaterialsCar(shipper);
                    break;
                }
                case "toxicLiquid": {
                    car = new LiquidToxicCar(shipper);
                    break;
                }
            }
            generated.add(car);
        }
        return generated;
    }
}
