package ProjectBase;

import Features.Calulator;
import Features.CircleCalculator;
import Features.SnakeGame.SnakeGame;
import Features.TextEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectFrame extends JFrame implements ActionListener {

    String project_title;
    boolean resizable;

    JMenuBar menuBar;
    JMenu file_menu;
    JMenu info_menu;
    JMenuItem exit_item;
    JMenuItem info_item;

    JPanel west_panel;
    JPanel north_panel;
    JPanel east_panel;
    JPanel south_panel;
    JPanel center_panel;

    JButton calculator;
    int calculator_counter = 1; //counts how many calculators the user has created in one session with in the MultiTool

    JButton circle_calculator;
    int circle_calculator_counter = 1; //counts how many cirlce-calculators the user has created in one session with in the MultiTool

    JButton text_editor;
    int text_editor_counter = 1; //counts how many Text-Editors the user has created in one session with in the MultiTool

    JButton snake_game;
    int snake_game_counter = 1; //counts how many Snake-Games the user has created in one session with in the MultiTool

    Color backgroundColor;
    Color buttonColor;


    public ProjectFrame(){

        project_title = "Multi Tool";

        resizable = true;

        backgroundColor = new Color(150, 150, 150);
        buttonColor = new Color(72, 157, 129);

        //The buttons to create Features START

        calculator = new JButton("Calculator");
        calculator.addActionListener(this);
        calculator.setBackground(buttonColor);
        calculator.setFocusPainted(false);

        circle_calculator = new JButton("Cirlce-Calculator");
        circle_calculator.addActionListener(this);
        circle_calculator.setBackground(buttonColor);
        circle_calculator.setFocusPainted(false);

        text_editor = new JButton("Text-Editor");
        text_editor.addActionListener(this);
        text_editor.setBackground(buttonColor);
        text_editor.setFocusPainted(false);

        snake_game = new JButton("Snake");
        snake_game.addActionListener(this);
        snake_game.setBackground(buttonColor);
        snake_game.setFocusPainted(false);

        // The buttons to create new Features END

        west_panel = new JPanel();
        north_panel = new JPanel();
        east_panel = new JPanel();
        south_panel = new JPanel();
        center_panel = new JPanel();

        west_panel.setPreferredSize(new Dimension(25, 25));
        north_panel.setPreferredSize(new Dimension(25, 25));
        east_panel.setPreferredSize(new Dimension(25, 25));
        south_panel.setPreferredSize(new Dimension(25, 25));
        center_panel.setPreferredSize(new Dimension(25, 25));

        west_panel.setBackground(backgroundColor);
        north_panel.setBackground(backgroundColor);
        east_panel.setBackground(backgroundColor);
        south_panel.setBackground(backgroundColor);
        center_panel.setBackground(backgroundColor);


        //All the features (Programs) are added to the Program Frame here
        center_panel.add(calculator);
        center_panel.add(circle_calculator);
        center_panel.add(text_editor);
        center_panel.add(snake_game);

        menuBar = new JMenuBar();

        file_menu = new JMenu("File");
        info_menu = new JMenu("Info");

        exit_item = new JMenuItem("Exit");
        exit_item.addActionListener(this);

        info_item = new JMenuItem("What this should do");
        info_item.addActionListener(this);

        file_menu.add(exit_item);
        info_menu.add(info_item);
        menuBar.add(file_menu);
        menuBar.add(info_menu);



        this.setTitle(project_title);
        this.setJMenuBar(menuBar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setResizable(resizable);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(150, 150, 150));
        this.setLayout(new BorderLayout());

        this.add(west_panel, BorderLayout.WEST);
        this.add(north_panel, BorderLayout.NORTH);
        this.add(east_panel, BorderLayout.EAST);
        this.add(south_panel, BorderLayout.SOUTH);
        this.add(center_panel, BorderLayout.CENTER);


        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculator){
            new Calulator();
            System.out.println("Created new Calculator Nr: " + calculator_counter + "\n");
            calculator_counter++;
        }
        if (e.getSource() == circle_calculator){
            new CircleCalculator();
            System.out.println("Created new Circle-Calculator Nr: " + circle_calculator_counter + "\n");
            circle_calculator_counter++;
        }
        if (e.getSource() == text_editor){
            new TextEditor();
            System.out.println("Created new Text-Editor Nr: " + text_editor_counter + "\n");
            text_editor_counter++;
        }
        if (e.getSource() == snake_game){
            JOptionPane.showMessageDialog(null, "1: Use arrow-keys to controll the snake \n" +
                    "2. Use letter r to reset game :D");
            new SnakeGame();
            System.out.println("Created new Snake-Game Nr: " + snake_game_counter + "\n");
            snake_game_counter++;
        }

        if (e.getSource() == exit_item){
            System.exit(0);
        }

        if (e.getSource() == info_item){
            JOptionPane.showMessageDialog(null, "This is suppost to be\n" +
                    "a Multi-Tool containing several usefull programs \n" +
                    "for every day use.");

        }
    }
}
