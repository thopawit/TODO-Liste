import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TODOFRAME extends JFrame implements ActionListener {

    //JButton jButton;

    JPanel jPanelLow;
    JPanel jPanelNormal;
    JPanel jPanelHigh;

    JScrollPane jScrollPaneLow;

    TODO_LIST todoList;

    //region Initialize Menu
    JMenuBar jMenuBar;
    JMenu jFileMenu;
    JMenu jOptionsMenu;
    JMenu jAddMenu;
    JMenuItem jExitItem;
    JMenuItem jSaveItem;

    JMenuItem jEntryItem;
    //endregion
    TODOFRAME(TODO_LIST todoListN) {

        todoList = todoListN;

        jPanelLow = new JPanel();
        jPanelNormal = new JPanel();
        jPanelHigh = new JPanel();

        jPanelLow.setBackground(Color.lightGray);
        jPanelNormal.setBackground(Color.lightGray);
        jPanelHigh.setBackground(Color.lightGray);

        jPanelLow.setBounds(60, 5, 250, 530);
        jPanelNormal.setBounds(325, 5, 250, 530);
        jPanelHigh.setBounds(590, 5, 250, 530);


        //region menu
        jMenuBar = new JMenuBar();
        jFileMenu = new JMenu("File");
        jOptionsMenu = new JMenu("Options");
        jAddMenu = new JMenu("Add");

        jExitItem = new JMenuItem("Exit");
        jSaveItem = new JMenuItem("Save");

        jEntryItem = new JMenuItem("Entry");

        jMenuBar.setBorder(new LineBorder(Color.lightGray));

        jMenuBar.add(jFileMenu);
        jMenuBar.add(jOptionsMenu);
        jMenuBar.add(jAddMenu);

        jExitItem.addActionListener(this);
        jSaveItem.addActionListener(this);

        jEntryItem.addActionListener(this);

        jFileMenu.add(jSaveItem);
        jFileMenu.add(jExitItem);

        jAddMenu.add(jEntryItem);
        //endregion

        //region Button
        /*jButton = new JButton();
        jButton.setBounds(750, 000, 150, 50);
        jButton.setText("Add Element");
        jButton.setFocusable(false);
        jButton.setBackground(Color.lightGray);
        jButton.setFont(new Font("Comic Sans", Font.BOLD, 15));
        jButton.addActionListener(this);
         */
        //endregion

        //region Frame
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(960, 540);
        this.setTitle("Your To-Do-List");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        this.getContentPane().setBackground(Color.white);
        //endregion

        //this.add(jButton);
        this.setJMenuBar(jMenuBar);

        this.add(jPanelLow);
        this.add(jPanelNormal);
        this.add(jPanelHigh);

        /*needs fix
        ImageIcon todoimage = new ImageIcon("todoimage.jpg");
        this.setIconImage(todoimage.getImage());
        */

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == jEntryItem) {
            ENTRYDATA_FRAME entry = new ENTRYDATA_FRAME(todoList);
        }

        if(e.getSource() == jSaveItem) {
            System.out.println("Saved");
            //Synchronize with databank!
        }

        if(e.getSource() == jExitItem) {
            System.exit(0);
        }
    }

    public void printEntries() {

    }
}