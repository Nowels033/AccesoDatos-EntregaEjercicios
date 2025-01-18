package ejercicioJSON.input;

import java.util.Scanner;

public class Input {

    public static int getOptionMenu() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String getJSONPath() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
