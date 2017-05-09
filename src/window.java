import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

/**
 * Created by sofia on 07.04.17.
 */
class Window extends JFrame{

    public static ArrayList<Ghost> realarr;
    public static ArrayList<Ghost> shownarr;
    public static int sort_type = 1;
    public static JTree pre_tree;
    public static JScrollPane tree;
    public static JLabel sortL;
    public static  JList sortList;
    public static JRadioButton rb;
    public  static JButton sortB;
    public static JEditorPane pre_imp_f_name;
    public static JTextArea pre_name;
    public static JButton del;
    public static JButton rem_l;
    public static JScrollPane imp_f_name;
    public static JButton imp;
    public static JPanel pp;
    public static SpringLayout layout;
    public static JScrollPane name;
    public static DefaultTreeModel model;
    public static DefaultMutableTreeNode parent;
    public static boolean rb_on = false;
    public static JLabel fileproblem;
    public static  JTextArea selectghost;
    public static JButton add;
    public static JButton delete;

    Window(){
            super("Ghosts");
            realarr = new ArrayList<Ghost>();
            shownarr = new ArrayList<Ghost>();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400,470);
            pp = new JPanel();
            layout = new SpringLayout();
            pp.setLayout(layout);

            parent = new DefaultMutableTreeNode("Ghosts", true);
            model = new DefaultTreeModel(parent);
            pre_tree = new JTree(Window.model);
            pre_tree.setEditable(true);
            Window.tree = new JScrollPane(Window.pre_tree);
            Tree.createParent(shownarr, realarr);

            sortL = new JLabel("Sort by:");
            sortList = new JList(new String[]{"name", "age", "height"});
            sortList.setSelectedIndex(1);
            rb = new JRadioButton("only adults");
            sortB = new JButton("sort");
            sortB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if(rb.isSelected()){
                        rb_on = true;
                    }else{
                        rb_on = false;
                    }
                    sort_type = sortList.getSelectedIndex();
                    Tree.saveChanges(shownarr);
                    Tree.createParent(shownarr, realarr);

                }
            });


            pre_imp_f_name = new JEditorPane();
            imp_f_name = new JScrollPane(pre_imp_f_name);
            imp = new JButton("import");
            imp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Tree.saveChanges(shownarr);
                    fileproblem.setVisible(false);
                    commands.imp(pre_imp_f_name.getText().split("\n")[0]);
                    //Tree.createParent(shownarr,realarr);
                }
            });
            fileproblem = new JLabel("File not found!");
            fileproblem.setVisible(false);


            pre_name = new JTextArea();
            name = new JScrollPane(pre_name);
            rem_l = new JButton("remove_lower");
            rem_l.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Tree.saveChanges(shownarr);
                    commands.remove_lower(pre_name.getText());
                    Tree.createParent(shownarr,realarr);
                }
            });

            del = new JButton("delete all");
            del.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Tree.saveChanges(shownarr);
                    surewindow sure = new surewindow();
                    sure.setVisible(true);
                }
            });

            selectghost = new JTextArea();
            add = new JButton("add");
            delete = new JButton("delete");
            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                        Tree.saveChanges(shownarr);
                        commands.delete(selectghost.getText().toString());
                        Tree.createParent(shownarr, realarr);
                    }catch (Exception e){
                        System.out.print("неверно задано имя");
                    }
                }
            });

            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                        Tree.saveChanges(shownarr);
                        commands.add(selectghost.getText().toString());
                    }catch (Exception e){
                        System.out.print("неверный формат  ввода");
                    }
                    Tree.createParent(shownarr,realarr);
                }
            });
            Layouts.create();
            setContentPane(pp);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {

            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                commands.save();
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {

            }

            @Override
            public void windowIconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowActivated(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {

            }
        });
        }
        }
public class window {

    public static void main(String[]args){
        JFrame w= new Window();
        w.setVisible(true);
        w.setResizable(false);
    }
}
