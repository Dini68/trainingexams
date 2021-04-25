package hu.nive.ujratervezes.zaropotvizsga;

public class House implements Cleanable{

    private String address;
    private int area;
    private Type type = Type.HOUSE;

    public Type getType() {
        return type;
    }

    public House(String address, int area) {
        this.address = address;
        this.area = area;
    }

    @Override
    public int clean() {
        return 80 * area;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
