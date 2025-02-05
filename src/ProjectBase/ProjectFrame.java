package ProjectBase;

import Features.Calulator;
import Features.CircleCalculator;
import Features.TextEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectFrame extends JFrame implements ActionListener {

    String project_title;

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


    public ProjectFrame(){

        project_title = "Multi Tool";

        calculator = new JButton("Calculator");
        calculator.addActionListener(this);

        circle_calculator = new JButton("Cirlce-Calculator");
        circle_calculator.addActionListener(this);

        text_editor = new JButton("Text-Editor");
        text_editor.addActionListener(this);




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

        Color bgColor = new Color(150, 150, 150);
        west_panel.setBackground(bgColor);
        north_panel.setBackground(bgColor);
        east_panel.setBackground(bgColor);
        south_panel.setBackground(bgColor);
        center_panel.setBackground(bgColor);


        //All the features (Programs) are added to the Program Frame here
        center_panel.add(calculator);
        center_panel.add(circle_calculator);
        center_panel.add(text_editor);


        this.setTitle(project_title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(150, 150, 150));
        //this.setBackground(new Color(150, 150, 150));
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
    }
}
