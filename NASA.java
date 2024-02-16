import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class NASA extends JFrame implements ActionListener {

    Border b = BorderFactory.createLineBorder(Color.WHITE,3);

    // Combine the two borders to create the two-color border


    JButton login = new JButton("Log In ");
    JButton Next = new JButton("START");
    //Declaration
    JFrame frame = new JFrame();
    JLabel username = new JLabel("UserName  ");
    JLabel Project = new JLabel("NASA");
    JTextField user = new JTextField(10);
    JLabel password = new JLabel("Password  ");
    JPasswordField Passwoprd = new JPasswordField();
    ImageIcon image = new ImageIcon("Nasa512.png");

    JButton easy = new JButton("Digit Dash");
    JButton medium = new JButton("Snap Riddler");
    JPanel SelectionPannel = new JPanel();
    JLabel selection = new JLabel("Select one level :");
    JPanel LoginPannel = new JPanel();
    JLabel Question = new JLabel("Here you'll be given simple math questions ");
    JLabel Questions = new JLabel("");
    JLabel answer = new JLabel("Answer");
    JTextField ans = new JTextField();
    JPanel EasyPanel = new JPanel(null);
    JLabel picture = new JLabel("Guess the flags and conquer the challenge! ");

    String operatorSymbol;
    int[] num1 = new int[15];
    int[] num2 = new int[15];
    int[] operator = new int[15];
    int score = 1;
    int mediumScore = 1;
    int[] answr = new int[15];
    int j = 0;
    int max_easy;
    int max_medium;
    ImageIcon d = new ImageIcon("Flags//1.png");

    JPanel mediumPanel = new JPanel(null);
    JRadioButton option1 = new JRadioButton("1");
    JRadioButton option2 = new JRadioButton("2");
    JRadioButton option3 = new JRadioButton("3");
    JRadioButton option4 = new JRadioButton("4");
    ButtonGroup group = new ButtonGroup();
    JButton mediumNext = new JButton("Next");
    String[] mediumOptions = new String[44];
    String[] mediumAnswers = new String[11];
    int[] mediumRandom = new int[10];
    JButton easyeasy = new JButton("easy");
    JButton easymedium = new JButton("medium");
    JButton easyhard = new JButton("hard");
    JButton mediumhard = new JButton("hard");
    JButton mediumeasy = new JButton("easy");
    JButton mediumedium = new JButton("medium");
    JPanel el = new JPanel(new GridLayout(3,1,0,14));
    JPanel ml = new JPanel(new GridLayout(3,1,0,14));
    JPanel HomeScreen = new JPanel();
    JLabel Math = new JLabel("");

    public void setEl(){
        el.setBackground(Color.BLUE);
        el.setBounds(450, 250, 300, 250);
        easyeasy.setBounds(30,139,100,50);
        easymedium.setBounds(30,209,100,50);
        easyhard.setBounds(30,269,100,50);
        el.add(easyeasy);
        el.add(easymedium);
        el.add(easyhard);
        el.setVisible(false);
    }
    public void setMl(){
        ml.setBackground(Color.BLUE);
        ml.setBounds(450, 250, 300, 250);

        mediumeasy.addActionListener(this);
        mediumedium.addActionListener(this);
        mediumhard.addActionListener(this);
        mediumeasy.setBounds(30,139,100,50);
        mediumedium.setBounds(30,209,100,50);
        mediumhard.setBounds(30,269,100,50);

        ml.add(mediumeasy);
        ml.add(mediumedium);
        ml.add(mediumhard);
        ml.setVisible(false);
    }

    NASA() throws IOException {

        //setting
        this.setIconImage(image.getImage());
        Project.setIcon(image);
        this.setTitle("NASA");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1400, 720);
        this.setVisible(true);
        //this.setBackground(Color.BLUE);
        this.setLayout(null);
        //lAYOUT
        LoginPannel.setLayout(new BoxLayout(LoginPannel, BoxLayout.Y_AXIS));
        SelectionPannel.setLayout(new GridLayout(2,1,0,10));
        Bounds();
        this.add(Math);
        Math.setIcon(new ImageIcon("math.png"));
        Math.setHorizontalTextPosition(JLabel.CENTER);
        Math.setVerticalTextPosition(JLabel.CENTER);
        Math.setVisible(false);

        //Font
        FontSetter();

        login.setBackground(Color.GREEN);

        ForeGround();

        BackGround();

        picture.setBounds(100, 10, 700, 250);
        picture.setIcon(d);
        picture.setHorizontalTextPosition(JLabel.CENTER);
        picture.setVerticalTextPosition(JLabel.TOP);
        picture.setIconTextGap(1);
        picture.setBorder(BorderFactory.createMatteBorder(3,0,3,0,Color.WHITE));
        setEl();
        LoginPannel.add(username);
        LoginPannel.add(user);
        LoginPannel.add(password);
        LoginPannel.add(Passwoprd);
        SelectionPannel.add(easy);
        SelectionPannel.add(medium);
        easyeasy.setBorder(b);
        easymedium.setBorder(b);
        easyhard.setBorder(b);
        mediumeasy.setBorder(b);
        mediumedium.setBorder(b);
        mediumhard.setBorder(b);
        Question.setBounds(100, 0, 1000, 180);
        Questions.setBounds(200, 300, 700, 80);
        EasyPanel.add(Question);
        EasyPanel.add(Questions);
        answer.setBounds(100, 120, 450, 80);
        ans.setBounds(220, 130, 50, 50);
        EasyPanel.add(answer);
        EasyPanel.add(ans);
        EasyPanel.add(Next);

        Project.setBorder(b);
        login.setBorder(b);
        Next.setBorder(b);
        easy.setBorder(b);
        medium.setBorder(b);
        this.add(login);

        this.add(Project);
        EasyPanel.setVisible(false);
        SelectionPannel.setVisible(false);
        selection.setVisible(false);
        this.add(LoginPannel);
        this.add(SelectionPannel);
        this.add(selection);
        medium.addActionListener(this);
        mediumNext.addActionListener(this);
        login.addActionListener(this);
        easy.addActionListener(this);
        Next.addActionListener(this);
        this.add(EasyPanel);
        setMl();
        this.add(ml);

        setMediumPanel();
        login.setBackground(Color.BLUE);

        login.setForeground(Color.WHITE);

        /*login.addActionListener(e ->{

        } );*/
        FileReaderforoptions();
        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                login.setBackground(Color.WHITE);
                login.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                login.setBackground(Color.BLUE);
                login.setForeground(Color.WHITE);
            }
        });
        this.add(el);
        easyeasy.addActionListener(this);
        easymedium.addActionListener(this);
        easyhard.addActionListener(this);
    }

    public void setMediumPanel() {
        mediumPanel.setBounds(250, 10, 750, 560);
        mediumPanel.setBackground(Color.BLUE);
        option1.setBounds(120, 310, 150, 50);
        option2.setBounds(550, 310, 150, 50);
        option3.setBounds(120, 450, 150, 50);
        option4.setBounds(550, 450, 150, 50);
        mediumNext.setBounds(350, 400, 130, 80);

        mediumPanel.add(picture);
        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);
        mediumPanel.add(option1);
        mediumPanel.add(option2);
        mediumPanel.add(option3);
        mediumPanel.add(option4);
        mediumPanel.add(mediumNext);
        mediumPanel.setVisible(false);
        this.add(mediumPanel);
        option1.addActionListener(this);
        option2.addActionListener(this);
        option3.addActionListener(this);
        option4.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {
            String usernameInput = user.getText();
            String passwordInput = new String(Passwoprd.getPassword());
            if (usernameInput.equals("sa") && passwordInput.equals("Login")) {
                LoginPannel.setVisible(false);
                SelectionPannel.setVisible(true);
                selection.setVisible(true);
                login.setVisible(false);
                Project.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password!");

            }
        }

        if (e.getSource() == easy) {
            selection.setText("Select difficulty of level :");
            SelectionPannel.setVisible(false);
            el.setVisible(true);
            Math.setIcon(new ImageIcon("math.png"));
            Math.setVisible(true);
        }
        if(e.getSource()==easyeasy){
            selection.setVisible(false);
            EasyPanel.setVisible(true);
            answer.setVisible(false);
            ans.setVisible(false);
            el.setVisible(false);


            Random random = new Random();
            j = 0;
            max_easy=5;
            for (int i = 0; i <= 5; i++) {
                num1[i] = random.nextInt( 15) + 1;
                num2[i] = random.nextInt( 20) + 1;
                operator[i] = random.nextInt(3);
            }

        }if(e.getSource()==easymedium){
            selection.setVisible(false);
            EasyPanel.setVisible(true);
            answer.setVisible(false);
            ans.setVisible(false);
            el.setVisible(false);
            Random random = new Random();
            j = 0;
            max_easy=10;
            for (int i = 0; i <= 10; i++) {
                num1[i] = random.nextInt( 10,15) + 1;
                num2[i] = random.nextInt( 10,20) + 1;
                operator[i] = random.nextInt(3);
            }

        }

        if (e.getSource() == Next) {

            answer.setVisible(true);
            ans.setVisible(true);
            Next.setText("Next");
            j++;

            if (j <= max_easy) {
                int anss = Mathquestion(num1[j], num2[j], operator[j]);
                int userAnswer = Integer.parseInt(ans.getText());

                if (userAnswer == anss) {
                    Questions.setText("Correct!");
                    Questions.setForeground(Color.GREEN);
                    ++score;
                } else {
                    Questions.setText("Incorrect! The Correct answer is " + anss);
                    Questions.setForeground(Color.red);
                }
                ans.setText("");
            } else {
                selection.setVisible(true);
                SelectionPannel.setVisible(true);
                EasyPanel.setVisible(false);
                Math.setVisible(false);
                Next.setText("START");
                Question.setText("One question is of one mark");
                JOptionPane.showMessageDialog(this, "Your score is " + score + " Out of "+ max_easy);
                score = 1;
            }

        }
        if (e.getSource() == medium) {
            mediumScore=1;
            j = 0;
            selection.setText("Select difficulty of level :");
            SelectionPannel.setVisible(false);
            ml.setVisible(true);
            Math.setIcon(new ImageIcon("picture1.png"));
            Math.setVisible(true);

        }
        if(e.getSource()==mediumeasy){
            picture.setText("Guess the flags and conquer the challenge!");
            option1.setVisible(false);
            option2.setVisible(false);
            option3.setVisible(false);
            option4.setVisible(false);
            selection.setVisible(false);
            mediumPanel.setVisible(true);
            ml.setVisible(false);
            max_medium = 5;

        }
        if(e.getSource()==mediumedium){
            picture.setText("Guess the flags and conquer the challenge!");
            option1.setVisible(false);
            option2.setVisible(false);
            option3.setVisible(false);
            option4.setVisible(false);
            selection.setVisible(false);
            mediumPanel.setVisible(true);
            ml.setVisible(false);
            max_medium = 7;

        }
        if(e.getSource()==mediumhard){
            mediumScore=1;
            picture.setText("Guess the flags and conquer the challenge!");
            option1.setVisible(false);
            option2.setVisible(false);
            option3.setVisible(false);
            option4.setVisible(false);
            selection.setVisible(false);
            mediumPanel.setVisible(true);
            ml.setVisible(false);
            max_medium = 10;

        }

        if (e.getSource() == mediumNext) {
            picture.setText("      ");
            option1.setVisible(true);
            option2.setVisible(true);
            option3.setVisible(true);
            option4.setVisible(true);
            if (j < max_medium) {
                if (option1.isSelected()) {
                    if (option1.getText().equals(mediumAnswers[mediumRandom[j] - 1])) {
                        mediumScore++;
                    }
                }
                if (option2.isSelected()) {
                    if (option2.getText().equals(mediumAnswers[mediumRandom[j] - 1])) {
                        mediumScore++;

                    }
                }
                if (option3.isSelected()) {
                    if (option3.getText().equals(mediumAnswers[mediumRandom[j] - 1])) {
                        mediumScore++;
                    }
                }
                if (option4.isSelected()) {
                    if (option4.getText().equals(mediumAnswers[mediumRandom[j] - 1])) {
                        mediumScore++;
                    }
                }

                j++;

                String g = mediumRandom[j] + ".png";
                d = new ImageIcon(g);
                picture.setIcon(d);

                option1.setText(mediumOptions[(mediumRandom[j] - 1) * 4]);
                option2.setText(mediumOptions[((mediumRandom[j] - 1) * 4) + 1]);
                option3.setText(mediumOptions[((mediumRandom[j] - 1) * 4) + 2]);
                option4.setText(mediumOptions[((mediumRandom[j] - 1) * 4) + 3]);
            } else {
                JOptionPane.showMessageDialog(this, "your score is " + mediumScore);
                mediumPanel.setVisible(false);
                selection.setVisible(true);
                SelectionPannel.setVisible(true);
                Math.setVisible(false);

            }

        }


    }

    public void FileReaderforoptions() throws IOException {
        FileReader f = new FileReader("Options.txt");
        Scanner input = new Scanner(f);
        for (int i = 0; i < 44; i++) {
            mediumOptions[i] = input.nextLine();
        }
        f.close();
        FileReader an = new FileReader("Answers.txt");
        input = new Scanner(an);
        for (int i = 0; i < 11; i++) {
            mediumAnswers[i] = input.nextLine();
        }
        f.close();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            boolean foundDuplicate = true;

            while (foundDuplicate) {
                int randomNumber = random.nextInt(1, 11);
                foundDuplicate = false;

                for (int k = 0; k < i; k++) {
                    if (mediumRandom[k] == randomNumber) {
                        foundDuplicate = true;
                        break;
                    }
                }

                if (!foundDuplicate) {
                    mediumRandom[i] = randomNumber;
                }
            }
        }
    }

    public int Mathquestion(int x, int y, int z) {


        switch (z) {
            case 0 -> {
                operatorSymbol = "+";
                answr[j] = x + y;
            }
            case 1 -> {
                operatorSymbol = "-";
                answr[j] = x - y;
            }
            case 2 -> {
                operatorSymbol = "*";
                answr[j] = x * y;
            }
            default -> {
                operatorSymbol = "+";
                answr[j] = x + y;
            }
        }

        Question.setText("What is " + x + "" + operatorSymbol + "" + y);


        return answr[j - 1];
    }

    public static void main(String[] args) throws IOException {


        NASA panel = new NASA();


    }

    public void FontSetter() {
        Font largerFont = username.getFont().deriveFont(30f);
        Font smallFont = username.getFont().deriveFont(20f);
        Font larger = username.getFont().deriveFont(40f);
        Font largerFon = username.getFont().deriveFont(50f);
        Project.setFont(largerFon);
        username.setFont(largerFont);
        password.setFont(largerFont);
        selection.setFont(larger);
        easy.setFont(largerFont);
        easyeasy.setFont(largerFont);
        easymedium.setFont(largerFont);
        easyhard.setFont(largerFont);
        medium.setFont(largerFont);
        mediumedium.setFont(largerFont);
        mediumeasy.setFont(largerFont);
        mediumhard.setFont(largerFont);
        option1.setFont(smallFont);
        option2.setFont(smallFont);
        option3.setFont(smallFont);
        option4.setFont(smallFont);
        mediumNext.setFont(largerFont);

        Question.setFont(largerFont);
        Questions.setFont(largerFont);
        ans.setFont(largerFont);
        answer.setFont(largerFont);
        login.setFont(largerFont);
        picture.setFont(largerFont);
    }

    public void BackGround() {
        ans.setBackground(Color.BLUE);
        EasyPanel.setBackground(Color.BLUE);
        medium.setBackground(Color.WHITE);
        mediumedium.setBackground(Color.blue);
        mediumeasy.setBackground(Color.blue);
        mediumhard.setBackground(Color.blue);
        easyeasy.setBackground(Color.blue);
        easymedium.setBackground(Color.blue);
        easyhard.setBackground(Color.blue);
        easy.setBackground(Color.WHITE);
        this.getContentPane().setBackground(Color.BLUE);
        LoginPannel.setBackground(Color.BLUE);
        SelectionPannel.setBackground(Color.BLUE);
        option1.setBackground(Color.blue);
        option2.setBackground(Color.blue);
        option3.setBackground(Color.blue);
        option4.setBackground(Color.blue);
        mediumNext.setBackground(Color.blue);
    }

    public void ForeGround() {
        username.setForeground(Color.WHITE);
        password.setForeground(Color.WHITE);
        selection.setForeground(Color.WHITE);

        medium.setForeground(Color.BLUE);
        mediumeasy.setForeground(Color.WHITE);
        mediumedium.setForeground(Color.white);
        mediumhard.setForeground(Color.white);
        easy.setForeground(Color.BLUE);
        easyeasy.setForeground(Color.white);
        easymedium.setForeground(Color.white);
        easyhard.setForeground(Color.white);
        Questions.setForeground(Color.WHITE);
        Question.setForeground(Color.WHITE);
        answer.setForeground(Color.WHITE);
        ans.setForeground(Color.WHITE);
        picture.setForeground(Color.WHITE);
        option1.setForeground(Color.WHITE);
        option2.setForeground(Color.WHITE);
        option3.setForeground(Color.WHITE);
        option4.setForeground(Color.WHITE);
        mediumNext.setForeground(Color.WHITE);
    }

    public void Bounds() {
        selection.setBounds(420, 150, 550, 80);
        login.setBounds(600, 420, 110, 50);
        Next.setBounds(70, 320, 110, 50);
        LoginPannel.setBounds(570, 250, 200, 150);
        SelectionPannel.setBounds(570, 250, 250, 160);
        Math.setBounds(840, 250, 1150, 512);
        Math.setBounds(840, 250, 1150, 512);
        EasyPanel.setBounds(50, 150, 750, 460);
        Project.setBounds(470, 30, 500, 120);
    }

}

