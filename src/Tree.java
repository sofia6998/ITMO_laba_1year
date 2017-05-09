import javax.swing.*;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by sofia on 20.04.17.
 */
public class Tree {

    public static void saveChanges(ArrayList<Ghost> shownarr){
        shownarr.clear();
        for(int i = 0; i<Window.model.getChildCount(Window.parent); i++){
            DefaultMutableTreeNode ghost = (DefaultMutableTreeNode)Window.model.getChild(Window.parent, i);
            Ghost gh = new Ghost(ghost.toString(),
                    Integer.parseInt(ghost.getChildAt(0).toString().split(" ")[1]),
                    Integer.parseInt(ghost.getChildAt(1).toString().split(" ")[1]));
            shownarr.add(gh);
        }

    }

    public static void createParent(ArrayList<Ghost> shownarr, ArrayList<Ghost> realarr){

        if(realarr.isEmpty()){
            Json.GetGhost(realarr, "in.json");
            Json.GetGhost(shownarr, "in.json");
        }else{
            Window.parent.removeAllChildren();
        }
        commands.sortTree(shownarr, Window.sort_type);

        for(int i = 0; i<shownarr.size(); i++){
            if((!Window.rb_on) || (Window.rb_on && shownarr.get(i).Gage()>=18)) {
                DefaultMutableTreeNode name = new DefaultMutableTreeNode(shownarr.get(i).Gname());
                DefaultMutableTreeNode age = new DefaultMutableTreeNode("age: " + shownarr.get(i).Gage());
                DefaultMutableTreeNode height = new DefaultMutableTreeNode("height: " + shownarr.get(i).Gheigh());
                Window.parent.add(name);
                name.add(age);
                name.add(height);
            }
        }


        Window.model.reload();
        for(int i  =0; i<Window.pre_tree.getRowCount(); i++) {
            Window.pre_tree.expandRow(i);
        }


    }
}
