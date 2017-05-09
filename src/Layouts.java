import javax.swing.*;

/**
 * Created by sofia on 26.04.17.
 */
public class Layouts {
    public static void create(){
        Window.pp.add(Window.sortL); Window.pp.add(Window.sortB);
        Window.pp.add(Window.imp); Window.pp.add(Window.tree);
        Window.pp.add(Window.rb); Window.pp.add(Window.sortList);
        Window.pp.add(Window.imp_f_name);Window.pp.add(Window.imp);
        Window.pp.add(Window.name);Window.pp.add(Window.rem_l);
        Window.pp.add(Window.del); Window.pp.add(Window.fileproblem);
        Window.pp.add(Window.add); Window.pp.add(Window.delete);
        Window.pp.add(Window.selectghost);

        //tree
        Window.layout.putConstraint(SpringLayout.WEST, Window.tree, 5, SpringLayout.WEST, Window.pp);
        Window.layout.putConstraint(SpringLayout.NORTH, Window.tree, 5, SpringLayout.NORTH, Window.pp);
        Window.layout.putConstraint(SpringLayout.SOUTH, Window.tree, 300, SpringLayout.NORTH, Window.tree);
        Window.layout.putConstraint(SpringLayout.EAST, Window.tree, 150, SpringLayout.WEST, Window.tree);

        //sort & filter
        Window.layout.putConstraint(SpringLayout.WEST, Window.sortL, 5, SpringLayout.WEST, Window.pp);
        Window.layout.putConstraint(SpringLayout.WEST, Window.sortList, 5, SpringLayout.WEST, Window.pp);
        Window.layout.putConstraint(SpringLayout.WEST, Window.sortB, 5, SpringLayout.WEST, Window.pp);
        Window.layout.putConstraint(SpringLayout.WEST, Window.rb, 5, SpringLayout.WEST, Window.pp);
        Window.layout.putConstraint(SpringLayout.NORTH, Window.sortL, 5, SpringLayout.SOUTH, Window.tree);
        Window.layout.putConstraint(SpringLayout.NORTH, Window.sortList, 5, SpringLayout.SOUTH, Window.sortL);
        Window.layout.putConstraint(SpringLayout.NORTH, Window.sortB, 5, SpringLayout.SOUTH, Window.sortList);
        Window.layout.putConstraint(SpringLayout.NORTH, Window.rb, 5, SpringLayout.SOUTH, Window.sortB);

        //import
        Window.layout.putConstraint(SpringLayout.EAST, Window.imp_f_name, -10, SpringLayout.EAST, Window.pp);
        Window.layout.putConstraint(SpringLayout.EAST, Window.imp, -10, SpringLayout.EAST, Window.pp);
        Window.layout.putConstraint(SpringLayout.NORTH, Window.imp_f_name, 5, SpringLayout.NORTH, Window.pp);
        Window.layout.putConstraint(SpringLayout.NORTH, Window.imp, 2, SpringLayout.SOUTH, Window.imp_f_name);
        Window.layout.putConstraint(SpringLayout.SOUTH, Window.imp_f_name, 50, SpringLayout.NORTH, Window.imp_f_name);
        Window.layout.putConstraint(SpringLayout.WEST, Window.imp_f_name, -200, SpringLayout.EAST, Window.imp_f_name);
        Window.layout.putConstraint(SpringLayout.EAST, Window.fileproblem, -10, SpringLayout.EAST, Window.pp);
        Window.layout.putConstraint(SpringLayout.NORTH, Window.fileproblem, 5, SpringLayout.SOUTH, Window.imp);


        //remove_lower
        Window.layout.putConstraint(SpringLayout.EAST, Window.name, -30, SpringLayout.EAST, Window.pp);
        Window.layout.putConstraint(SpringLayout.EAST, Window.rem_l, -30, SpringLayout.EAST, Window.pp);
        Window.layout.putConstraint(SpringLayout.NORTH, Window.name, 200, SpringLayout.NORTH, Window.pp);
        Window.layout.putConstraint(SpringLayout.NORTH, Window.rem_l, 2, SpringLayout.SOUTH, Window.name);
        Window.layout.putConstraint(SpringLayout.SOUTH, Window.name, 40, SpringLayout.NORTH, Window.name);
        Window.layout.putConstraint(SpringLayout.WEST, Window.name, -200, SpringLayout.EAST, Window.name);


        //delete
        Window.layout.putConstraint(SpringLayout.EAST, Window.del, -30, SpringLayout.EAST, Window.pp);
        Window.layout.putConstraint(SpringLayout.SOUTH, Window.del, -30, SpringLayout.SOUTH, Window.pp);

        //edit
        Window.layout.putConstraint(SpringLayout.EAST, Window.selectghost, -10, SpringLayout.EAST, Window.pp);
        Window.layout.putConstraint(SpringLayout.SOUTH, Window.selectghost, 50, SpringLayout.SOUTH, Window.imp);
        Window.layout.putConstraint(SpringLayout.WEST, Window.selectghost, 0, SpringLayout.WEST, Window.imp_f_name);
        Window.layout.putConstraint(SpringLayout.NORTH, Window.selectghost, 5, SpringLayout.SOUTH, Window.imp);
        Window.layout.putConstraint(SpringLayout.EAST, Window.add, 0, SpringLayout.EAST, Window.selectghost);
        Window.layout.putConstraint(SpringLayout.NORTH, Window.add, 10, SpringLayout.SOUTH, Window.selectghost);
        Window.layout.putConstraint(SpringLayout.WEST, Window.delete, 0, SpringLayout.WEST, Window.selectghost);
        Window.layout.putConstraint(SpringLayout.NORTH, Window.delete, 10, SpringLayout.SOUTH, Window.selectghost);






    }
}
