package Stations;

import java.util.Comparator;

public class SortByDistance implements Comparator<Station> {
    @Override
    public int compare(Station station1, Station station2) {
        if(station1.distToStation(station1) == station2.distToStation(station2)) {
            return 0;
        }

        if(station1.distToStation(station1) < station2.distToStation(station2)) {
            return -1;
        }
        return 1;
    }
}
