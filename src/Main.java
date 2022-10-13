import java.util.Arrays;

/**
 * Created by Mihran Galstyan
 * All rights reserved
 */
public class Main {
    public static void main(final String[] args) {
        int[] array = extractNumbersFromString("asd558 777.02..sPo[8ep}w 78 7 2-36q 78");
        System.out.println(Arrays.toString(array));

    }

    public static int[] extractNumbersFromString(String string) {
        int[] numbers = new int[string.length() / 2 + 1];
        int index = 0;

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
                if (i > 0 && string.charAt(i - 1) == '-') {
                    buffer.append('-');
                }
                buffer.append(string.charAt(i));

            } else if (buffer.length() > 0) {
                numbers[index++] = Integer.parseInt(buffer.toString());
                buffer.setLength(0);
            }
        }

        if (buffer.length() > 0) {
            numbers[index++] = Integer.parseInt(buffer.toString());
            buffer.setLength(0);
        }
        numbers = Arrays.copyOf(numbers, index);
        return numbers;
    }
}
