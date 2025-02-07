package Features.SnakeGame;

import javax.swing.*;

public class SnakeGameFrame extends JFrame {



    public SnakeGameFrame(){

        this.add(new SnakeGamePanel());
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
