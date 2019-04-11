package demo.simple.adder;
/**
 * @author Yuan-Fang Li & Yan Liu
 * @version $Id: 02$
 */
public class Adder {

    public int add(String argument) {
        if (argument == null)
            throw new IllegalArgumentException("String should not be null");

        String[] parts = argument.split(",");
        int sum = 0;
        for (String s : parts) {
            if (!s.trim().isEmpty()) {
                int partInt = Integer.parseInt(s.trim());
                if (partInt < 0) {
                    throw new IllegalArgumentException("Non-negative integer expected");
                }
                sum += partInt;
            }
        }

        return sum;
    }
}
