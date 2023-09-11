package aws3tier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger n = new BigInteger(st.nextToken());
            BigInteger m = new BigInteger(st.nextToken());
            System.out.println(n.divide(m));
            System.out.println(n.remainder(m));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
