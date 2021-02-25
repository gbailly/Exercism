public class Hamming {

    final String leftStrand, rightStrand;

    public Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty() && !rightStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightStrand.isEmpty() && !leftStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    public int getHammingDistance() {
        return getHammingDistance(leftStrand, rightStrand, 0);
    }

    public int getHammingDistance(final String leftStrand, final String rightStrand, final int acc) {
        if (leftStrand.isEmpty()) {
            return acc;
        } else {
            return getHammingDistance(
                    leftStrand.substring(1),
                    rightStrand.substring(1),
                    leftStrand.charAt(0) != rightStrand.charAt(0) ? acc + 1 : acc);
        }
    }
}
