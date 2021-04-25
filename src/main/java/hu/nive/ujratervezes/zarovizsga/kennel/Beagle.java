package hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog{

    public Beagle(String name) {
        super(name);
    }

    @Override
    public void feed() {
        addHappiness(2);
    }

    @Override
    public void play(int hours) {
        addHappiness(hours * 2);
    }
}
