import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;


public class commands {
    /**
     * Данная функция сохраняет текущее состояние коллекции в файл, заданный параметром окружения
     */

    public static void save() {
                Json.SaveGhost();
    }

    public static void delete(String s){
        for (int  i = 0; i<Window.shownarr.size(); i++) {
            if (Window.shownarr.get(i).Gname().equals(s)) {
                Window.shownarr.remove(i);
                i--;
                break;
            }
        }
    }
    public static void add(String s){
        String arr[] = s.split(" ");
        Ghost g  = new Ghost(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
        if(!Window.shownarr.contains(g)) {
            Window.shownarr.add(g);
        }
    }
    /**
     * Данная функция удаляет всех приведений младше заданного
     *
     * @param s - запрос в формате "remove_lower {name}"
     */

    public static void remove_lower(String s) {
        long max = 1000000000000000000L;
        boolean exist = false;
        for (Ghost per : (Window.shownarr)) {
            if (per.Gname().equals(s)) {
                max = per.Gage();
                exist = true;
                break;
            }
        }
        if(exist) {
            Iterator<Ghost> itr = Window.shownarr.iterator();
            ArrayList<Ghost> left = new ArrayList<>();
            while (itr.hasNext()) {
                Ghost per = itr.next();
                if (per.Gage() < max) {
                    System.out.println("11111111111111");
                    left.add(per);
                }
            }
            Window.shownarr.removeAll(left);
            //Json.SaveGhost();
            System.out.println("Молодец!");
        }else{
            System.out.println("Приведение не найдено");
        }
    }

    /**
     * данная функция добавляет в коллекцию объекты из файла
     *
     * @param s - запрос в формате "import {имя файла}"
     * @throws FileNotFoundException
     */
    public static void imp(final String s){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Json.GetGhost(Window.shownarr, s);
                Tree.createParent(Window.shownarr,Window.realarr);
            }
        });
        t1.start();
        System.out.println("Молодец!");
    }

    /**
     * данная функция отчищает коллекцию
     */
    public static void clear() {
        Window.shownarr.clear();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Json.SaveGhost();
            }
        });
        t2.start();
        System.out.println("Молодец!");
    }


    public static void sortTree(ArrayList<Ghost> arr, int param) {
        switch (Window.sort_type) {
            case 0:
                Collections.sort(Window.shownarr, new Comparator<Ghost>() {
                    @Override
                    public int compare(Ghost ghost, Ghost t1) {
                        return ghost.Gname().charAt(0) - t1.Gname().charAt(0);
                    }
                });
                break;
            case 2:
                Collections.sort(arr, new Comparator<Ghost>() {
                    @Override
                    public int compare(Ghost ghost, Ghost t1) {
                        return ghost.Gheigh() - t1.Gheigh();
                    }
                });
                break;
            default:
                Collections.sort(arr);
                break;
        }
    }

}