package Stations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph {
    private HashMap<Station,Double> intersectWith;
    protected ArrayList<Station> stations;
    public Map<Station, Double> graph = new HashMap<>();

    private static List<Station> route;

    public Graph(int amount) {
        this.stations = generateStations(amount);
        this.intersectWith = new HashMap<>();
        createConnections();
        buildRoute(getRandomStartingStation(),
                getRandomEndStation(getRandomStartingStation()));
    }


    public ArrayList<Station> getStations() {
        return stations;
    }

    public List<Station> getRoute() {
        return route;
    }



    public Station getRandomStartingStation() {
        Random random = new Random();
        int randomIndex = random.nextInt(stations.size());
        return stations.get(randomIndex);
    }

    public Station getRandomEndStation(Station start) {
        Random random = new Random();
        int randomIndex = random.nextInt(stations.size());
        while (stations.get(randomIndex).equals(start)) {
            randomIndex = random.nextInt(stations.size());
        }
        return stations.get(randomIndex);
    }

    public void deleteStation(Station station) {
        // Remove the station from the list of stations
        stations.remove(station);

        // Remove the station from the "intersectWith" maps of all connected stations
        for (Station s : stations) {
            s.intersectsWith.remove(station);
        }

        // Remove all connections to the deleted station
        for (Station s : station.intersectsWith.keySet()) {
            s.intersectsWith.remove(station);
        }
    }

    //It took 16 hours of no sleep and my sanity....

    public ArrayList<Station> buildRoute(Station start, Station end) {
        ArrayList<Station> visited = new ArrayList<>();
        HashMap<Station, Double> distance = new HashMap<>();
        HashMap<Station, Station> previous = new HashMap<>();

        // Initialize distance to all stations as infinite except for the start station
        for (Station station : stations) {
            if (station == start) {
                distance.put(station, 0.0);
            } else {
                distance.put(station, Double.MAX_VALUE);
            }
            previous.put(station, null);
        }

        PriorityQueue<Station> queue = new PriorityQueue<>(Comparator.comparingDouble(distance::get));
        queue.add(start);

        while (!queue.isEmpty()) {
            Station current = queue.poll();

            // If we have reached the end station, we can stop
            if (current == end) {
                break;
            }

            visited.add(current);

            for (Map.Entry<Station, Double> entry : current.intersectsWith.entrySet()) {
                Station neighbor = entry.getKey();
                Double weight = entry.getValue();
                Double alt = distance.get(current) + weight;

                if (alt < distance.get(neighbor)) {
                    distance.put(neighbor, alt);
                    previous.put(neighbor, current);
                    queue.remove(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        // If the end station was not reached, there is no route
        if (previous.get(end) == null) {
            return null;
        }

        ArrayList<Station> path = new ArrayList<>();
        Station current = end;
        double totalDistance = 0;
        while (current != null) {
            path.add(current);
            Station prev = previous.get(current);
            if (prev != null) {
                totalDistance += prev.intersectsWith.get(current);
            }
            current = prev;
        }

        // Reverse the path to get it from start to end
        Collections.reverse(path);
        return path;
    }

    public static double getDistanceBetweenStations(List<Station> route) {
        double sumDistance = 0;
        Station current = route.get(0);
        for (Station station : route) {
            if (station != current) {
                for (Map.Entry<Station, Double> entry : current.getIntersectsWith(station).entrySet()) {
                    if (entry.getKey() == current) {
                        current = station;
                        sumDistance += entry.getValue();
                        break;
                    }
                }
            }
        }
        return sumDistance;
    }

    public void showConnectionsBetweenStations() {
        for(Station station : stations) {
            System.out.println("Station [ " + station + "]" + " Intersects with:");
            for(Map.Entry<Station, Double> entry : station.intersectsWith.entrySet()) {
                System.out.println(" [Connected] " + entry.getKey() + " " + entry.getValue() + " ");
            }}
        System.out.println();
    }

    public void createConnections() {
        Random random = new Random();
        for (Station station : stations) {
            int numConnections = random.nextInt(1) + 4; // If we make it less, sometimes we can't find intersections
            for(int i = 0; i < numConnections; i++) {
                int randomIndex = random.nextInt(stations.size());
                Station test = stations.get(randomIndex);
                if(station != stations.get(randomIndex)) {
                    station.addIntersectionWith(test, new Random().nextDouble(500) + 200);
                }
            }
        }
    }

    public static ArrayList<Station> generateStations(int n) {
        ArrayList<Station> stations = new ArrayList<Station>();
        String path = "src/Generator/Stations.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String stationName;
            int counter = 0;
            Random rand = new Random();
            while ((stationName = br.readLine()) != null && counter <= n) {
                Station station = new Station(stationName);
                stations.add(station);
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stations;
    }

    public String toString() {
        return " | " + this.stations.toString();
    }
}
