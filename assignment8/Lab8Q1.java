import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.*;

public class Lab8Q1 extends JFrame {
    private JTextField urlTextField;
    private JButton findButton;

    public Lab8Q1() {
        super("IP Address Finder");


        try {
            // set the look and feel of the application
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        // Set up the main frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up the text field for entering the URL
        urlTextField = new JTextField(20);
        urlTextField.setFont(new Font("Arial", Font.PLAIN, 50));

        // Set up the button for finding the IP address
        findButton = new JButton("Find IP Address");
        findButton.setFont(new Font("Arial", Font.PLAIN, 50));
        findButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String url = urlTextField.getText();
                try {
                    InetAddress ipAddress = InetAddress.getByName(url);
                    JOptionPane.showMessageDialog(Lab8Q1.this, "The IP address of " + url + " is " + ipAddress.getHostAddress(), "IP Address", JOptionPane.INFORMATION_MESSAGE);
                } catch (UnknownHostException ex) {
                    JOptionPane.showMessageDialog(Lab8Q1.this, "Invalid URL", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(1000, 500));
        panel.add(urlTextField);
        panel.add(findButton);
        urlTextField.setFont(new Font("Arial", Font.PLAIN, 50));
        getContentPane().add(panel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Lab8Q1();
    }
}
