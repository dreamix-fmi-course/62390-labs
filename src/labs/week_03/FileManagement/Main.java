package labs.week_03.FileManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        FileManagement fs = new FileManagement();
        Scanner sc = new Scanner(System.in);
        String line;
        do {
            line = sc.nextLine();
            fs.processCommand(line);
        } while (!line.equals("END"));
    }
}
