package exam03;

import java.time.LocalDate;
import java.util.*;

public class Cruise {

    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void bookPassenger(Passenger passenger) {
        if (passengers.size() < boat.getMaxPassengers()) {
            passengers.add(passenger);
            return;
        }
        throw new IllegalArgumentException("No more place");
    }

    public double getPriceForPassenger(Passenger passenger) {
        return passenger.getCruiseClass().getMultiply() * getBasicPrice();
    }

    public Passenger findPassengerByName(String name) {
        for (Passenger p: passengers) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        throw new IllegalArgumentException("No such name");
    }

    public List<String >getPassengerNamesOrdered() {
        List<String> result = new ArrayList<>();
        for (Passenger p: passengers) {
            result.add(p.getName());
        }
        result.sort(Comparator.naturalOrder());
        return result;
    }

    public double sumAllBookingsCharged() {
        double sum = 0;
        for (Passenger p: passengers) {
            sum += getPriceForPassenger(p);
        }
        return sum;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> result = new HashMap<>();
        for (Passenger p: passengers) {
            if (p.getCruiseClass() == CruiseClass.LUXURY) {
                if (!result.containsKey(CruiseClass.LUXURY)) {
                    result.put(CruiseClass.LUXURY, 1);
                }
                else {
                    result.put(CruiseClass.LUXURY,  result.get(CruiseClass.LUXURY) + 1);
                }
            }
            if (p.getCruiseClass() == CruiseClass.FIRST) {
                if (!result.containsKey(CruiseClass.FIRST)) {
                    result.put(CruiseClass.FIRST, 1);
                }
                else {
                    result.put(CruiseClass.FIRST,  result.get(CruiseClass.FIRST) + 1);
                }
            }
            if (p.getCruiseClass() == CruiseClass.SECOND) {
                if (!result.containsKey(CruiseClass.SECOND)) {
                    result.put(CruiseClass.SECOND, 1);
                }
                else {
                    result.put(CruiseClass.SECOND,  result.get(CruiseClass.SECOND) + 1);
                }
            }
        }
        return result;
    }
}
