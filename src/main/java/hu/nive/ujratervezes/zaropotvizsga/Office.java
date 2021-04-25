package hu.nive.ujratervezes.zaropotvizsga;

public class Office implements Cleanable{

    private String address;
    private int area;
    private int levelNum;
    private Type type = Type.OFFICE;

    public Type getType() {
        return type;
    }

    public Office(String address, int area, int levelNum) {
        this.address = address;
        this.area = area;
        this.levelNum = levelNum;
    }

    @Override
    public int clean() {
        return 100 * area * levelNum;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
