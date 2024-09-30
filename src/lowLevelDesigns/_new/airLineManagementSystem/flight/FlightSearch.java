package lowLevelDesigns._new.airLineManagementSystem.flight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightSearch {
    private List<Flight> flights;

    public FlightSearch(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> flightSearch(String source, String destination, LocalDate date) {
//        return flights.stream()
//                .filter(flight -> flight.getSource().equalsIgnoreCase(source) &&
//                        flight.getDestination().equalsIgnoreCase(destination) &&
//                        flight.getDepartureTime().toLocalDate().isEqual(date))
//                .toList();

        List<Flight> result = new ArrayList<>();
        for (Flight flight:flights){
            if (flight.getSource().equalsIgnoreCase(source) &&
                    flight.getDestination().equalsIgnoreCase(destination) &&
                    flight.getDepartureTime().toLocalDate().isEqual(date)){
                result.add(flight);
            }
        }

        if (result.isEmpty()){
            throw new RuntimeException("No flight found for source: "+source+" destination: "+destination+" date: "+date);
        }

        return result;
    }
}
