package Generator;

import Locomotive.Locomotive;
import Stations.Graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LocomotiveGenerate {
    private static List<Locomotive> locomotives;

    public LocomotiveGenerate() {
        this.locomotives = new ArrayList<>();
        }

    public static void removeLocomotiveByName(String name) {
        for (Locomotive locomotive : locomotives) {
            if (locomotive.getName().equals(name)) {
                locomotives.remove(locomotive);
                break;
            }
        }
    }

    public List<Locomotive> generateLocomotives(int n) {
        System.out.println("Creating Stations");
        Graph route = new Graph(20);
        List<Locomotive> locomotives = new ArrayList<>();
        String path = "src/Generator/TrainNames.txt";
        System.out.println("Creating Locomotives\n");
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String locomotiveName;
            int counter = 0;
            Random rand = new Random();
            while ((locomotiveName = br.readLine()) != null && counter < n) {
                Locomotive locomotive = new Locomotive(locomotiveName, route);
                locomotives.add(locomotive);
                counter++;
                System.out.println(locomotive);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        return locomotives;
    }

    public static List<Locomotive> getLocomotives() {
        return locomotives;
    }
}
