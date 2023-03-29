import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
* This is very good and easy to understand.
just wanted to show a simpler way to implement the single interface ActionListener() using lambda

Instead of creating a whole new inner Class and new object, you can do this:

startButton.addActionListener((e)-> createGameScreen());

This one line is enough. You don't need the extra inner class or an object of the class.
* */
public class Main {

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel;
    JLabel titleNameLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 65);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    JButton startButton;
    JTextArea mainTextArea;

    TitleScreenHandler tsHandler = new TitleScreenHandler();

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        window.setVisible(true);//causes the window to be visible
        con = window.getContentPane();//create container within the window

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 135);
        titleNamePanel.setBackground(Color.BLACK);
        titleNameLabel = new JLabel("ADVENTURE N00B");
        titleNameLabel.setForeground(Color.WHITE);
        titleNameLabel.setFont(titleFont);//set the font

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.BLACK);

        //start button actions
        startButton = new JButton("START");
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler); //create event

        titleNamePanel.add(titleNameLabel);//add label to panel
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);//create a container for the title panel
        con.add(startButtonPanel);//add container for title panel
    }

    public void createGameScreen() {

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.BLACK);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("Text Area");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.BLACK);
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);//wrap texts
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.BLACK);
        choiceButtonPanel.setLayout(new GridLayout(4,1));//create a layout grid of 4 rows 1 column.
        con.add(choiceButtonPanel);

        JButton choice1 = choiceButton("Attack");
        JButton choice2 = choiceButton("Defend");
        JButton choice3 = choiceButton("Run");
        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        choiceButtonPanel.add(choice3);
    }
    public JButton choiceButton(String text) {
        JButton button;
        button = new JButton();
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(normalFont);
        button.setText(text);
        return button;
    }
    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }
}