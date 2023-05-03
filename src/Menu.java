import Generator.AppState;
import Generator.LocomotiveGenerate;
import Generator.TrainSetGenerate;
import Locomotive.*;
import RailRoadCarTypes.RailRoadCar;
import Stations.Graph;
import Stations.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        ArrayList<TrainSet> trainSetsMenu = new ArrayList<>();
        ArrayList<Locomotive> locomotives = new ArrayList<>();
        Graph graph = new Graph(100);
        ArrayList<TrainSet> trainSets = TrainSetGenerate.generateTrainSets(graph, 25);
        for (TrainSet trainSet : trainSets){
            Thread speedThread = new Thread(trainSet.getLocomotive(), "Speed");
            Thread moveThread = new Thread(trainSet.getMovement(),"Move");
            speedThread.start();
            moveThread.start();
        }
        Thread logThread = new Thread(()->{
            while (true){
                for (TrainSet trainSet : trainSets) {
                    Collections.sort(trainSet.getCars(), new Comparator<RailRoadCar>() { // sort cars by GrossWeight
                        @Override
                        public int compare(RailRoadCar o1, RailRoadCar o2) {
                            return (int) ( o1.getGrossWeight() - o2.getGrossWeight());
                        }
                    });
                }
                Collections.sort(trainSets, new Comparator<TrainSet>() {
                    @Override
                    public int compare(TrainSet T1, TrainSet T2) {
                        return (int) (T2.getLocomotive().totalDistance - T1.getLocomotive().totalDistance);
                    }
                });
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                for (TrainSet trainSet : trainSets) {
                    AppState.redirectConsoleToFile("AppState.txt.txt",trainSet.toString());
                }
            }
        });
        logThread.start();

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Main menu : \n");
            System.out.println("1. Locomotive \n");
            System.out.println("2. TrainSet \n");
            System.out.println("3. Station \n");
            System.out.println("4. Show Statistics \n");

            System.out.println("Press 'Enter' to Exit");

            choice = input.nextInt();
            switch (choice) {
                case 1:
                    int submenuChoice;
                    System.out.println("1. Add New Locomotive \n");
                    System.out.println("2. Remove Locomotive \n");

                    System.out.println("3. Back to Main Menu \n");
                    do {
                        Scanner scanner = new Scanner(System.in);
                        submenuChoice = input.nextInt();

                        switch (submenuChoice) {
                            case 1:
                                Locomotive locomotive = new Locomotive("New Locomotive", graph);
                                locomotives.add(locomotive);
                                System.out.println("Created Locomotive ->" + locomotive + "\n");
                                System.out.println("List of Locomotives ->" + locomotives);
                                break;
                            case 2:
                                System.out.println("Choose Locomotive by entering id from 0 to " +
                                        (locomotives.size()-1) + " -> " );
                                int inputs = scanner.nextInt();
                                locomotives.remove(inputs);
                                System.out.println("Successfully deleted Locomotive with name ->" + inputs);
                                break;
                            case 3:
                                System.out.println("Returning to Main Menu \n");
                                break;
                            default:
                                System.out.println("Invalid choice. Try again \n");
                                break;
                        }
                    } while (submenuChoice != 3);
                    break;
                case 2:
                    int subMenuChoice;
                    System.out.println("1. Add new TrainSet \n");
                    System.out.println("2. Remove TrainSet \n");
                    System.out.println("3. Back to Menu \n");
                    do {
                        Scanner scanner = new Scanner(System.in);
                        subMenuChoice = input.nextInt();
                        switch (subMenuChoice) {
                            case 1:
                                Locomotive lc = new Locomotive("TrainSet Locomotive", graph);
                                TrainSet trainSet = new TrainSet(lc);
                                trainSetsMenu.add(trainSet);
                                System.out.println("Created TrainSet ->" + trainSet + "\n");
                                System.out.println("List of TrainSets ->" + trainSetsMenu);
                                break;
                            case 2:
                                System.out.println("Choose TrainSet by entering id from 0 to " +
                                        (trainSetsMenu.size()-1) + " -> " );
                                int inpute = scanner.nextInt();
                                    trainSetsMenu.remove(inpute);
                                System.out.println("Successfully deleted TrainSet with name ->" + inpute);
                                break;
                            case 3:
                                System.out.println("Returning to Main Menu \n");
                            default:
                                System.out.println("Invalid choice. Try again \n");
                                break;
                        }
                    }
                    while (subMenuChoice != 3);
                    break;
                case 3:
                    int submenUChoice;
                    System.out.println("1. Add new Station \n");
                    System.out.println("2. Remove Station \n");
                    System.out.println("3. Back to Menu \n");
                    do {
                        Scanner scanner = new Scanner(System.in);
                        submenUChoice = input.nextInt();


                        switch (submenUChoice) {
                            case 1:
                                System.out.println("Station was created ->" + graph.getRandomStartingStation() + "\n");
                                System.out.println("List of stations -> " + graph.getStations() + "\n");
                                break;
                            case 2:
                                System.out.println("Warning, deleting a station, would also delete it's connections \n");
                                Station station = graph.getRandomStartingStation();
                                System.out.println("Choose Station to delete entering its ->" + station);
                                int inputz = scanner.nextInt();
                                graph.deleteStation(station);
                                System.out.println("Successfully deleted Station with name ->" + inputz);
                                break;
                            case 3:
                                System.out.println("Returning to Main Menu \n");
                            default:
                                System.out.println("Invalid choice. Try again \n");
                        }

                    }
                    while (submenUChoice != 3);
                    break;
                case 4:
                    int trainSetId;
                    do {
                        System.out.println("Enter TrainSet ID to show it statistics: ");
                        Scanner scanner = new Scanner(System.in);
                        trainSetId = scanner.nextInt();
                        System.out.println("Stat for " + trainSets.get(trainSetId));
                        trainSets.get(trainSetId).getLocomotive().statistics = true;
                        trainSets.get(trainSetId).getMovement().statistics = true;
                        Scanner sc = new Scanner(System.in);
                        sc.nextLine();
                        trainSets.get(trainSetId).getLocomotive().statistics = false;
                        trainSets.get(trainSetId).getMovement().statistics = false;
                        break;
                    } while(true);
                default:
                    System.out.println("Back to menu\n");
                    break;
            }
        }
        while (choice != 5);
    }
}

