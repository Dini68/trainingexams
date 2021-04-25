package hu.nive.ujratervezes.zaropotvizsga;

import java.util.ArrayList;
import java.util.List;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();

    public List<Cleanable> getCleanables() {
        return cleanables;
    }

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public int cleanAll() {
        int sumPrice = 0;
        for(Cleanable c: cleanables) {
            sumPrice += c.clean();
        }
        cleanables.clear();
        return sumPrice;
    }

    public int cleanOnlyOffices() {
        List<Cleanable> offices = new ArrayList<>();
        int sumPrice = 0;
        for (Cleanable c: cleanables) {
            if (c.getType() == Type.OFFICE) {
                sumPrice += c.clean();
                offices.add(c);
            }
        }
        cleanables.removeAll(offices);
        return sumPrice;
    }

    public List<Cleanable> findByAddressPart(String address) {
        List<Cleanable> result = new ArrayList<>();
        for (Cleanable c: cleanables) {
            if (c.getAddress().contains(address)) {
                result.add(c);
            }
        }
        return result;
    }

    public String getAddresses() {
        StringBuilder sb = new StringBuilder();
        for (Cleanable c: cleanables) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(c.getAddress());
        }
        return sb.toString();
    }
}
//    Legyen egy Cleanable interfészed, annak int clean() és String getAddress() metódusa.
//    Ez azt jelenti, hogy valamit ki lehet takarítani (amit visszaad a metódus, az a takarítás ára),
//    valamint lennie kell egy címének is.
//
//Legyen két osztály, mely implementálja, a House és a Office! A House egy családi ház,
//melynek meg lehessen adni a címét és az alapterületét. A ház kitakarítása négyzetméterenként 80 Ft.
//Az Office egy iroda, melynek meg lehessen adni a címét, az alapterületét és a szintek számát.
//Az iroda kitakarítása négyzetméterenként 100 Ft. Természetesen az összes szintet számolni kell.
//
//Legyen egy CleaningService osztály, mely nyilvántartja az ingatlanokat. A következő metódusokat implementáld:
//
//void add(Cleanable cleanable) - hozzáaad egy ingatlant
//int cleanAll() - kitakarítja az összes ingatlant, és visszaadja, hogy mennyibe került, ezután nem marad egy ingatlan sem
//int cleanOnlyOffices() - kitakarítja csak az irodákat, és visszaadja, hogy mennyibe került. Ezután csak a házak maradnak.
//List<Cleanable> findByAddressPart(String address) - visszaadja azokat az ingatlanokat, melynek címében szerepel a paraméterként megadott érték
//String getAddresses() - visszaadja az ingatlanok címeit vesszővel és egy szóközzel elválasztva
//Ez két feladatnak számít, első az osztályok és interfész létrehozása, és a CleaningService osztály első metódusa egy feladat.
// A többi metódus még egy feladatnak számít.