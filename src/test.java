import javax.swing.*;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by sofia on 20.04.17.
 */
public class test {
    public  static void main(String[]args){
        JFrame w= new Window();

        Collections.sort(Window.shownarr, new Comparator<Ghost>() {
            @Override
            public int compare(Ghost ghost, Ghost t1) {
                return ghost.Gname().charAt(0)-t1.Gname().charAt(0);
            }
        });
        System.out.println("eceiurhiueuier");
        System.out.println(Window.shownarr.get(0).Gname());
        System.out.println(Window.shownarr.get(1).Gname());
        System.out.println(Window.shownarr.get(2).Gname());

    }
}
