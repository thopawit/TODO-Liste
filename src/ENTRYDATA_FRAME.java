import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ENTRYDATA_FRAME extends JFrame implements ActionListener {

    JButton jButton;

    JTextField jTextFieldName;
    JComboBox jComboBoxPriority;
    JTextField jTextFieldDuration;

    TODO_LIST todoList;

    JLabel jLabelName;
    JLabel jLabelDuration;
    JLabel jLabelPriority;
    ENTRYDATA_FRAME(TODO_LIST todoListN) {

        todoList = todoListN;

        jButton = new JButton();

        jTextFieldName = new JTextField();
        jTextFieldDuration = new JTextField();

        String[] pririties = {"niedrig", "normal", "hoch"};
        jComboBoxPriority = new JComboBox(pririties);

        jLabelName = new JLabel();
        jLabelDuration = new JLabel();
        jLabelPriority = new JLabel();

        this.setLayout(null);
        this.setVisible(true);
        this.setSize(480, 270);
        this.setTitle("Your Entry");
        //Update this:
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        //stop
        this.setResizable(false);

        SetUp();
    }

    public void SetUp() {
        jTextFieldName.setBounds(20, 20, 300, 30);
        jTextFieldDuration.setBounds(20, 70, 300, 30 );
        jComboBoxPriority.setBounds(20, 120, 300, 30);

        jLabelName.setText("Enter name!");
        jLabelDuration.setText("Enter duration!");
        jLabelPriority.setText("Enter priority!");

        jLabelName.setBounds(330, 20, 100, 30);
        jLabelDuration.setBounds(330, 70, 100, 30);
        jLabelPriority.setBounds(330, 120, 100, 30);

        jButton.setBounds(20, 170, 200, 40);
        jButton.setText("APPLY");
        jButton.setFocusable(false);
        jButton.addActionListener(this);

        this.add(jTextFieldName);
        this.add(jTextFieldDuration);
        this.add(jComboBoxPriority);

        this.add(jLabelName);
        this.add(jLabelDuration);
        this.add(jLabelPriority);

        this.add(jButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {



        if (e.getSource() == jButton) {

            int duration = -1;

            try {
                duration = Integer.parseInt((jTextFieldDuration.getText()));
            } catch (Exception exception) {
                TextFrame textFrame = new TextFrame(400, 100, "Error", "Only Integer");
                return;
            }

            int priority = -1;
            if(jComboBoxPriority.getSelectedItem() == "niedrig") {
                priority = 0;
            } else if (jComboBoxPriority.getSelectedItem() == "normal") {
                priority = 1;
            } else if (jComboBoxPriority.getSelectedItem() == "hoch") {
                priority = 2;
            }

            ENTRY entry = new ENTRY(jTextFieldName.getText(), duration, false, priority);
            todoList.insert(entry);
            System.out.println("Inserted");
            this.dispose();
        }
    }
}
