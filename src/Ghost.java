import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ghost implements Comparable<Ghost> {
    private String name;
    private int age;
    private int heigh;

    Ghost(String s, int ag, int h) {
        this.name = s;
        this.age = ag;
        this.heigh = h;
    }

    public int Gheigh(){ return this.heigh; }
    public String Gname() {
        return this.name;
    }

    public int Gage() {
        return this.age;
    }

    @Override
    public int compareTo(Ghost g) {
        return this.Gage()-g.Gage();
    }
    @Override
    public boolean equals(Object g){
        if(this.Gname().equals(((Ghost)g).Gname()) &&
                this.Gage() == ((Ghost) g).Gage() &&
                this.Gheigh() == ((Ghost) g).Gheigh()){
            return true;
        }else{
            return false;
        }
    }
    public static void sort(ArrayList<Ghost> arr){
        switch (Window.sort_type){
            case 0:
                Collections.sort(Window.shownarr, new Comparator<Ghost>() {
                    @Override
                    public int compare(Ghost ghost, Ghost t1) {
                        return ghost.Gname().charAt(0)-t1.Gname().charAt(0);
                    }
                });
                break;
            case 2:
                Collections.sort(arr, new Comparator<Ghost>() {
                @Override
                public int compare(Ghost ghost, Ghost t1) {
                    return ghost.Gheigh()-t1.Gheigh();
                }
            });
                break;
            default: Collections.sort(arr);
                break;
        }
    }
}