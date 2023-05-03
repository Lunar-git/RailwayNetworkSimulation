package Generator;

import Locomotive.*;
import Stations.Graph;

import java.util.ArrayList;


public class TrainSetGenerate {
    private static ArrayList<TrainSet> trainSets;

    public static ArrayList<TrainSet> generateTrainSets(Graph graph, int n) {
        ArrayList<TrainSet> trainSets = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Locomotive locomotive = new Locomotive("Locomotive-" + i,graph);
            TrainSet trainSet = new TrainSet(locomotive);
            trainSets.add(trainSet);
        }
        return trainSets;
    }

    public static ArrayList<TrainSet> getTrainSets() {
        return trainSets;
    }

    public static void removeTrainSetByName(String name) {
        for (int i = 0; i < trainSets.size(); i++) {
            if (trainSets.get(i).getLocomotive().getName().equals(name)) {
                trainSets.remove(i);
                System.out.println("TrainSet with name " + name + " has been removed. \n");
                return;
            }
        }
        System.out.println("TrainSet with name " + name + " not found. \n");
    }
}
