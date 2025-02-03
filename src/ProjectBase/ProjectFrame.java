package ProjectBase;

import Features.Calulator;
import Features.CircleCalculator;

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
    int circle_calculator_counter = 1; //counts how many cirlce-calculators the user has created in one session with in the MultiTool

    JButton circle_calculator;


    public ProjectFrame(){

        project_title = "Multi Tool";

        calculator = new JButton("Calculator");
        calculator.addActionListener(this);

        circle_calculator = new JButton("Cirlce-Calculator");
        circle_calculator.addActionListener(this);


        west_panel = new JPanel();
        north_panel = new JPanel();
        east_panel = new JPanel();
        south_panel = new JPanel();
        center_panel = new JPanel();

        west_panel.setPreferredSize(new Dimension(50, 50));
        north_panel.setPreferredSize(new Dimension(50, 50));
        east_panel.setPreferredSize(new Dimension(50, 50));
        south_panel.setPreferredSize(new Dimension(50, 50));
        center_panel.setPreferredSize(new Dimension(50, 50));

        center_panel.add(calculator);
        center_panel.add(circle_calculator);


        this.setTitle(project_title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //this.getContentPane().setBackground(new Color(150, 150, 150));
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
    }
}
