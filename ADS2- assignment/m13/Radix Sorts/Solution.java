import java.util.Scanner;
/**
 * @author : nandakishore723
 */

public final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {
        //unused
    }

    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Quick3string q3s = new Quick3string();
        int n = Integer.parseInt(scan.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(scan.nextLine() + "::");
        }
        String[] lines = sb.toString().split("::");
        q3s.sort(lines);
        String str = "[";
        for (int i = 0; i < n; i++) {
            str += lines[i] + ", ";
        }
        System.out.println(str.substring(0, str.length() - 2) + "]");
    }
}
