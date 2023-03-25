
import javax.swing.*;
import java.awt.event.*;

public class Lab8Q2 extends JFrame implements ActionListener {
    JTextArea textArea;
    JLabel wordCountLabel, charCountLabel;

    public Lab8Q2() {
        try {
            // set the look and feel of the application
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setTitle("Word Counter");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);

        JPanel buttonPanel = new JPanel();
        JButton wordCountButton = new JButton("Count Words");
        wordCountButton.addActionListener(this);
        buttonPanel.add(wordCountButton);
        JButton charCountButton = new JButton("Count Characters");
        charCountButton.addActionListener(this);
        buttonPanel.add(charCountButton);
        panel.add(buttonPanel);

        wordCountLabel = new JLabel();
        panel.add(wordCountLabel);
        charCountLabel = new JLabel();
        panel.add(charCountLabel);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String text = textArea.getText();
        int wordCount = 0;
        int charCount = 0;

        if (e.getActionCommand().equals("Count Words")) {
            String[] words = text.split("\\s+");
            wordCount = words.length;
            wordCountLabel.setText("Word Count: " + wordCount);
        } else if (e.getActionCommand().equals("Count Characters")) {
            charCount = text.length();
            charCountLabel.setText("Character Count (including spaces): " + charCount);
        }
    }

    public static void main(String[] args) {
        new Lab8Q2();
    }
}
