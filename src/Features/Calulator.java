package Features;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calulator implements ActionListener, KeyListener {

    JFrame calculator_frame;
    JTextField calculator_textField;
    JButton[] number_buttons = new JButton[10];
    JButton[] calculator_function_buttons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel calculator_panel;

    Font calculator_font = new Font("Arial", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public Calulator(){

        calculator_frame = new JFrame("Calculator");
        calculator_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        calculator_frame.setSize(420, 550);
        calculator_frame.setLayout(null);
        calculator_frame.setResizable(false);
        calculator_frame.setLocationRelativeTo(null);


        calculator_textField = new JTextField();
        calculator_textField.setBounds(50, 25, 300, 50);
        calculator_textField.setFont(calculator_font);
        calculator_textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        calculator_function_buttons[0] = addButton;
        calculator_function_buttons[1] = subButton;
        calculator_function_buttons[2] = mulButton;
        calculator_function_buttons[3] = divButton;
        calculator_function_buttons[4] = decButton;
        calculator_function_buttons[5] = equButton;
        calculator_function_buttons[6] = delButton;
        calculator_function_buttons[7] = clrButton;
        calculator_function_buttons[8] = negButton;

        for (int i = 0; i < 9; i++){
            calculator_function_buttons[i].addActionListener(this);
            calculator_function_buttons[i].setFont(calculator_font);
            calculator_function_buttons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++){
            number_buttons[i] = new JButton(String.valueOf(i));
            number_buttons[i].addActionListener(this);
            number_buttons[i].addKeyListener(this); //TEST
            number_buttons[i].setFont(calculator_font);
            number_buttons[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        calculator_panel = new JPanel();
        calculator_panel.setBounds(50, 100, 300, 300);
        calculator_panel.setLayout(new GridLayout(4, 4, 10, 10));
        //calculator_panel.setBackground(Color.GRAY);

        //Row for row adding components. Each row has 4 spaces so 4 buttons in one row with 10 pixe gap in between
        calculator_panel.add(number_buttons[1]);
        calculator_panel.add(number_buttons[2]);
        calculator_panel.add(number_buttons[3]);
        calculator_panel.add(addButton);
        calculator_panel.add(number_buttons[4]);
        calculator_panel.add(number_buttons[5]);
        calculator_panel.add(number_buttons[6]);
        calculator_panel.add(subButton);
        calculator_panel.add(number_buttons[7]);
        calculator_panel.add(number_buttons[8]);
        calculator_panel.add(number_buttons[9]);
        calculator_panel.add(mulButton);
        calculator_panel.add(decButton);
        calculator_panel.add(number_buttons[0]);
        calculator_panel.add(equButton);
        calculator_panel.add(divButton);

        calculator_frame.add(calculator_panel);
        calculator_frame.add(negButton);
        calculator_frame.add(delButton);
        calculator_frame.add(clrButton);
        calculator_frame.add(calculator_textField);
        calculator_frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i<10; i++){
            if (e.getSource() == number_buttons[i]){
                calculator_textField.setText(calculator_textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton){
            calculator_textField.setText(calculator_textField.getText().concat("."));
        }
        if (e.getSource() == addButton){
            //calculator_textField.setText(calculator_textField.getText().concat("+"));

            num1 = Double.parseDouble(calculator_textField.getText());
            operator = '+';
            calculator_textField.setText("");

        }
        if (e.getSource() == subButton){
            //calculator_textField.setText(calculator_textField.getText().concat("-"));

            num1 = Double.parseDouble(calculator_textField.getText());
            operator = '-';
            calculator_textField.setText("");

        }
        if (e.getSource() == mulButton){
            //calculator_textField.setText(calculator_textField.getText().concat("*"));

            num1 = Double.parseDouble(calculator_textField.getText());
            operator = '*';
            calculator_textField.setText("");

        }
        if (e.getSource() == divButton){
            //calculator_textField.setText(calculator_textField.getText().concat("/"));

            num1 = Double.parseDouble(calculator_textField.getText());
            operator = '/';
            calculator_textField.setText("");

        }
        if (e.getSource() == equButton){
            num2 = Double.parseDouble(calculator_textField.getText());

            switch (operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            calculator_textField.setText(String.valueOf(result));
            num1 = result;

        }

        if (e.getSource() == clrButton){
            calculator_textField.setText("");
        }
        if (e.getSource() == delButton){
            String string = calculator_textField.getText();
            calculator_textField.setText("");
            for (int i = 0; i < string.length()-1; i++){
                calculator_textField.setText(calculator_textField.getText()+string.charAt(i));
            }
        }
        if (e.getSource() == negButton){
            double temp = Double.parseDouble(calculator_textField.getText());
            temp*=-1;
            calculator_textField.setText(String.valueOf(temp));
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
