package modul9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dz9 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a string:");
        String str = input.readLine();
        System.out.println("Enter a encode key");
        int key = Integer.parseInt(input.readLine());
        System.out.println("Encode string: "+encode(str, key));
        System.out.println(decode(encode(str, key), key));
    }

    public static String decode(String enc, int key) {
        return encode(enc, 26 - key);
    }

    public static String encode(String enc, int key) {
        key = key % 26 + 26;
        StringBuilder encoded = new StringBuilder();
        for (char i : enc.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encoded.append((char) ('A' + (i - 'A' + key) % 26));
                } else {
                    encoded.append((char) ('a' + (i - 'a' + key) % 26));
                }
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }
}
