import javax.swing.*;

public class EncryptionDriver {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Hackathon 2025");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(600,700);
        frame.setLocation(200,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(false);
        frame.setContentPane(new EncryptionPanel());

    }
}