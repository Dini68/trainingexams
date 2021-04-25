package exam02;

public class ArraySelector {

    public String selectEvens(int[] arr) {

        if (arr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(arr[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
