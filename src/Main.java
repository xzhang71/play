/**
 * Created by xzhang71 on 6/3/14.
 */
public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 9999; i += 8) {
            for (int j = 1; j <= 9999; j += 8) {
                int t = (i + j) % 6;
                if (t == 1) {
                    System.out.println(i + ", " + j + ", " + t);
                }
            }
        }
    }
}
