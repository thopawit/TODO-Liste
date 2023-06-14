import javax.swing.*;

public class TextFrame extends JFrame {

    JLabel jLabel;

    TextFrame(int width, int height, String titel, String text) {

        jLabel = new JLabel();
        jLabel.setText(text);
        jLabel.setBounds(0, 0, width - 10, height - 10);

        this.setLayout(null);
        this.setVisible(true);
        this.setSize(width, height);
        this.setTitle(titel);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);

        this.add(jLabel);

    }
}
