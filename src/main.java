import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class main {
    //static ArrayList<Ghost> ghosts;
    static String filename;

    public static void main(String[] args) {
        /*filename = System.getenv("L5F");
        if (filename == null) {
            System.out.println("задайте переменную L5F");
            return;
        }
        */
        filename = "in.json";
        //Scanner sc = new Scanner(System.in);
        Places tv = new Places("Телевидение");
        Places home = new Places("Дом");

        She she = new She();
        she.goTo(home);

        Frida frida = new Frida();
        //ghosts = new ArrayList<Ghost>();
        //ghosts.add(new Ghost("gsdvjhds", 12, 145));

//        Json.GetGhost(ghosts, filename);
        Json.SaveGhost();

        frida.goTo(tv);
        frida.tell(frida.getGExp());

        /*while (true) {
            String s[] = sc.nextLine().split(" ");
            if (s[0].equals("save")) {
                commands.save();
            } else if (s[0].equals("clear")) {
                commands.clear();
            } else if (s[0].equals("remove_lower")) {
                commands.remove_lower(s);
            } else if (s[0].equals("import")) {
                try {
                    commands.imp(s);
                } catch (FileNotFoundException e) {
                    System.out.println("файл не найден");
                }
            }
        }
        */
    }
}