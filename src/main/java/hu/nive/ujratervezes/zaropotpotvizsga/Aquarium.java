package hu.nive.ujratervezes.zaropotpotvizsga;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private List<Fish> fishes = new ArrayList<>();

    public void addFish(Fish fish) {
        fishes.add(fish);
    }

    public void feed() {
        for (Fish f: fishes) {
            f.feed();
        }
    }

    public void removeFish() {
        List<Fish> moreThan11 = new ArrayList<>();
        for (Fish f: fishes) {
            if (f.getWeight() >= 11){
                moreThan11.add(f);
            }
        }
        fishes.removeAll(moreThan11);
    }


    public List<String> getStatus() {
        List<String> result = new ArrayList<>();
        for (Fish f: fishes) {
            result.add(f.status());
        }
        return result;
    }
}
