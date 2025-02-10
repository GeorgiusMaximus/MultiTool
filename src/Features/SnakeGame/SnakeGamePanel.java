package Features.SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Time;
import java.util.Random;

public class SnakeGamePanel extends JPanel implements ActionListener {


    static final int SNAKE_SCREEN_WIDTH = 600;
    static final int SNAKE_SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int SNAKE_GAME_UNITS = (SNAKE_SCREEN_WIDTH*SNAKE_SCREEN_HEIGHT/UNIT_SIZE);
    static final int DELAY = 75;
    final int[] x = new int[SNAKE_GAME_UNITS];
    final int[] y = new int[SNAKE_GAME_UNITS];
    int snake_body_parts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;

    public SnakeGamePanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(SNAKE_SCREEN_WIDTH, SNAKE_SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame(){

        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){

        if (running) {

            //---WHITE GRID---
            for (int i = 0; i < SNAKE_SCREEN_HEIGHT / UNIT_SIZE; i++) {
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SNAKE_SCREEN_HEIGHT);
                g.drawLine(0, i * UNIT_SIZE, SNAKE_SCREEN_WIDTH, i * UNIT_SIZE);
            }

            g.setColor(Color.red);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            for (int i = 0; i < snake_body_parts; i++) {
                if (i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    g.setColor(new Color(45, 180, 0));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }

            g.setColor(Color.orange);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: " + applesEaten, (SNAKE_SCREEN_WIDTH- metrics.stringWidth("Score: " + applesEaten))/2, g.getFont().getSize());

        }
        else {
            gameOver(g);
        }

    }
    public void newApple(){
        appleX = random.nextInt((int)(SNAKE_SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        appleY = random.nextInt((int)(SNAKE_SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    }
    public void move(){
        for (int i = snake_body_parts; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch (direction){
            case 'U':
                y[0] = y[0]-UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0]+UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0]-UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0]+UNIT_SIZE;
                break;

        }
    }
    public void checkApple(){
        if ((x[0] == appleX) && (y[0] == appleY)){
            snake_body_parts++;
            applesEaten++;
            newApple();
        }
    }
    public void checkCopllisions(){
        //this checks if snakes head collides with its body
        for (int i = snake_body_parts; i > 0; i--){
            if ((x[0]  == x[i]) && (y[0] == y[i])){
                running = false;
            }
        }
        //this checks if snakes head touches left border
        if (x[0] < 0){
            running = false;
        }
        //this checks if snakes head touches right border
        if (x[0] > SNAKE_SCREEN_WIDTH){
            running = false;
        }
        //this checks if head touches top border
        if (y[0] < 0){
            running = false;
        }
        //this checks if head touches bottom border
        if (y[0] > SNAKE_SCREEN_HEIGHT){
            running = false;
        }
        if (!running){
            timer.stop();
        }


    }
    public void gameOver(Graphics g){
        //Displays the score
        g.setColor(Color.orange);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: " + applesEaten, (SNAKE_SCREEN_WIDTH- metrics1.stringWidth("Score: " + applesEaten))/2, g.getFont().getSize());


        //Game Over Text
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over :(", (SNAKE_SCREEN_WIDTH- metrics2.stringWidth("Game Over :("))/2, SNAKE_SCREEN_HEIGHT/2);
    }

    public void restartGame() {
        // Setzen Sie die Startwerte für das Spiel zurück
        snake_body_parts = 6;
        applesEaten = 0;
        direction = 'R';
        running = true;
        // Setzen Sie die Positionen des Schlangenkörpers zurück
        for (int i = 0; i < snake_body_parts; i++) {
            x[i] = 0;
            y[i] = 0;
        }
        // Erzeugen Sie einen neuen Apfel
        newApple();
        // Starten Sie den Timer neu
        timer.restart();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCopllisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){

            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;

                case KeyEvent.VK_R:
                    if (!running) {
                        restartGame();
                    }


            }

        }
    }
}
