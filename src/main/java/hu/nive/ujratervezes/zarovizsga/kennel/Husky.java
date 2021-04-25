package hu.nive.ujratervezes.zarovizsga.kennel;

public class Husky extends Dog{

    public Husky(String name) {
        super(name);
    }

    @Override
    public void feed() {
        addHappiness(4);
    }

    @Override
    public void play(int hours) {
        addHappiness(hours * 3);
    }
}
