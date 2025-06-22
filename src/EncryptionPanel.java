import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class EncryptionPanel extends JPanel{

    //everything for ENCRYPTOR
    Caesar encryptor = new Caesar(3);
    private static JLabel title;
    private static JTextField userInput;
    private static JTextField shiftInput;
    private static JLabel result;

    //everything for DECRYPTOR
    Caesar decryptor = new Caesar(3);
    private static JLabel title2;
    private static JTextField userInput2;
    private static JTextField shiftInput2;
    private static JLabel result2;

    public void paintComponent(Graphics g) {

        g.setColor(new Color(147, 185, 194));
        g.fillRect(0,0,600,600);
        g.setColor(new Color(132, 165, 173));
        g.fillRect(0,275,600,500);
    }
    public EncryptionPanel() {

        //sets layout
        setLayout(new FlowLayout());

        //CHANGE THIS TO CHANGE THE FONT
        String uniFont = "monospaced";

        title = new JLabel("Caesar Encryptor Tool");
        title.setFont(new Font(uniFont , Font.BOLD, 42));
        add(title);

        JLabel Spacer1 = new JLabel("         ");
        Spacer1.setFont(new Font(uniFont, Font.BOLD, 42));
        JLabel Spacer2 = new JLabel("                ");
        Spacer2.setFont(new Font(uniFont, Font.BOLD, 42));
        JLabel Spacer3 = new JLabel("         ");
        Spacer3.setFont(new Font(uniFont, Font.BOLD, 42));
        JLabel Spacer4 = new JLabel("                             ");
        Spacer4.setFont(new Font(uniFont, Font.BOLD, 42));
        JLabel Spacer5 = new JLabel("                             ");
        Spacer5.setFont(new Font(uniFont, Font.BOLD, 42));

        add(Spacer1);

        JButton encryptButton = new JButton("Encrypt");
        encryptButton.addActionListener(new encryptListener());
        add(encryptButton);

        add(Spacer3);

        JLabel inputLabel = new JLabel("Message: ");
        inputLabel.setFont(new Font(uniFont , Font.BOLD, 20));
        add(inputLabel);

        userInput = new JTextField("" , 10);
        userInput.setHorizontalAlignment(SwingConstants.RIGHT);
        add(userInput);

        JLabel shiftLabel = new JLabel("Shift: ");
        shiftLabel.setFont(new Font(uniFont , Font.BOLD, 20));
        add(shiftLabel);

        shiftInput = new JTextField("" , 10);
        shiftInput.setHorizontalAlignment(SwingConstants.RIGHT);
        add(shiftInput);

        add(Spacer4);

        result = new JLabel(":Encrypted Message:");
        result.setFont(new Font(uniFont , Font.BOLD, 20));
        add(result);

        add(Spacer5);

        title2 = new JLabel("Caesar Decryptor Tool");
        title2.setFont(new Font(uniFont , Font.BOLD, 42));
        add(title2);

        JLabel Spacer6 = new JLabel("         ");
        Spacer6.setFont(new Font(uniFont, Font.BOLD, 42));
        JLabel Spacer7 = new JLabel("                ");
        Spacer7.setFont(new Font(uniFont, Font.BOLD, 42));
        JLabel Spacer8 = new JLabel("         ");
        Spacer8.setFont(new Font(uniFont, Font.BOLD, 42));
        JLabel Spacer9 = new JLabel("                             ");
        Spacer9.setFont(new Font(uniFont, Font.BOLD, 42));
        JLabel Spacer10 = new JLabel("                             ");
        Spacer10.setFont(new Font(uniFont, Font.BOLD, 42));

        JLabel LearnMoreSpacer = new JLabel("                         ");
        LearnMoreSpacer.setFont(new Font(uniFont, Font.BOLD, 42));

        add(Spacer6);

        JButton encryptButton2 = new JButton("Decrypt");
        encryptButton2.addActionListener(new decryptListener());
        add(encryptButton2);

        add(Spacer8);

        JLabel inputLabel2 = new JLabel("Message: ");
        inputLabel2.setFont(new Font(uniFont , Font.BOLD, 20));
        add(inputLabel2);

        userInput2 = new JTextField("" , 10);
        userInput2.setHorizontalAlignment(SwingConstants.RIGHT);
        add(userInput2);

       add(Spacer9);

        result2 = new JLabel(":Decrypted Message:");
        result2.setFont(new Font(uniFont , Font.BOLD, 20));
        add(result2);

       add(LearnMoreSpacer);

        JButton linkButton = new JButton("Learn More About Caesar Cipher");
        linkButton.addActionListener(new linkListener());
        add(linkButton);


    }

    private class encryptListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String shift = shiftInput.getText();
            String word = userInput.getText();
            if (word.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter a message to encrypt.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
            if (!word.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(null, "Only letters are allowed for encryption.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
            if (shift.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter a number for shift.", "Shift Error", JOptionPane.ERROR_MESSAGE);
            }
            if(!shift.matches("\\d+"))
            {
                JOptionPane.showMessageDialog(null, "Only positive numbers are allowed for shift.", "Shift Error", JOptionPane.ERROR_MESSAGE);
            }
            encryptor.setShift(Integer.parseInt(shift));
            word = encryptor.cipher(word);
            result.setText(word);
        }
    }

    private class decryptListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String shift = shiftInput.getText();
            String word = userInput2.getText();
            if (word.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter a message to decrypt.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
            if (!word.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(null, "Only letters are allowed for decryption.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
            if (shift.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please enter a number for shift.", "Shift Error", JOptionPane.ERROR_MESSAGE);
            }
            if(!shift.matches("\\d+"))
            {
                JOptionPane.showMessageDialog(null, "Only positive numbers are allowed for shift.", "Shift Error", JOptionPane.ERROR_MESSAGE);
            }

            decryptor.setShift(Integer.parseInt(shift) * -1);
            word = decryptor.cipher(word);
            result2.setText(word);
        }
    }

    private class linkListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try{
                Desktop.getDesktop().browse(new URL("https://www.google.com").toURI());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Failed to open browser: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}