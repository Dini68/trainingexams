package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {

    private List<Photo> photos = new ArrayList<>();

    public List<Photo> getPhotos() {
        return photos;
    }

    public void addPhoto(String... names) {
        for (String name: names) {
            photos.add(new Photo(name));
        }
    }

    public void starPhoto(String name, Quality quality) {
        for (Photo p: photos) {
            if (p.getName().equals(name)) {
                p.setQuality(quality);
                return;
            }
        }
        throw new PhotoNotFoundException("No such photo");
    }

    public int numberOfStars() {
        int starNumbers = 0;
        for (Photo p: photos) {
            starNumbers += p.getQuality().getStarNumber();
        }
        return starNumbers;
    }
}
