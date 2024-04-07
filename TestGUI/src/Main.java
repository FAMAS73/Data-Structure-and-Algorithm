import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JPanel panel1;
    private JButton button1;

    public Main(JPanel panel1, JButton button1) {
        this.panel1 = panel1;
        this.button1 = button1;
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
