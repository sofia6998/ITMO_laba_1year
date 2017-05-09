import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by sofia on 07.04.17.
 */
public class surewindow extends JFrame{
    surewindow(){
        super("Delete");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200,100);
        JPanel pp = new JPanel();
        SpringLayout layout = new SpringLayout();
        pp.setLayout(layout);
        JLabel text= new JLabel("Sure?");
        final JList list = new JList(new String[]{"yes", "no"});
        JButton ok = new JButton("ok");

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(list.getSelectedValue().equals("yes")){
                    commands.clear();
                    Tree.createParent(Window.shownarr,Window.realarr);
                }
                close();
            }
        });
        pp.add(text);
        pp.add(list);
        pp.add(ok);
        int x = pp.getWidth()/5;

        layout.putConstraint(SpringLayout.WEST, text, 10, SpringLayout.WEST, pp);
        layout.putConstraint(SpringLayout.EAST, text, -10, SpringLayout.EAST, pp);

        layout.putConstraint(SpringLayout.NORTH, text, 5, SpringLayout.NORTH, pp);

        layout.putConstraint(SpringLayout.WEST, list, 10, SpringLayout.WEST, pp);
        layout.putConstraint(SpringLayout.EAST, list, -10, SpringLayout.EAST, pp);
        layout.putConstraint(SpringLayout.NORTH, list, 10, SpringLayout.SOUTH, text);

        layout.putConstraint(SpringLayout.WEST, ok, 10, SpringLayout.WEST, pp);
        layout.putConstraint(SpringLayout.EAST, ok, -10, SpringLayout.EAST, pp);
        layout.putConstraint(SpringLayout.NORTH, ok, 5, SpringLayout.SOUTH, list);


        setContentPane(pp);
    }
    public void close(){
        this.setVisible(false);
    }

}

