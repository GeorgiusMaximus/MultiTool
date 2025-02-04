package Features;

import ProjectBase.ProjectFrame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;



public class TextEditor extends JFrame implements ActionListener {

    JTextArea text_editor_textArea;
    Font text_editor_font;
    JScrollPane text_editor_scrollPane;
    JLabel text_editor_fontInfoLabel;
    JSpinner text_editor_fontSizeSpinner;
    JButton text_editor_fontColorButton;
    JComboBox text_editor_fontBox;

    JMenuBar text_editor_menuBar;
    JMenu text_editor_fileMenu;
    JMenuItem text_editor_openItem;
    JMenuItem text_editor_saveItem;
    JMenuItem text_editor_exitItem;

    public TextEditor(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("TextEditor");
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        text_editor_textArea = new JTextArea();
        text_editor_textArea.setLineWrap(true);
        text_editor_textArea.setWrapStyleWord(true); //words are shifted to the next line in one intire piece and not split at two letters
        text_editor_font = new Font("Arial", Font.PLAIN, 20); //the font
        text_editor_textArea.setFont(text_editor_font);

        text_editor_scrollPane = new JScrollPane(text_editor_textArea);
        text_editor_scrollPane.setPreferredSize(new Dimension(450, 450));
        text_editor_scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        text_editor_fontInfoLabel = new JLabel("Font-Size: ");

        text_editor_fontSizeSpinner = new JSpinner();
        text_editor_fontSizeSpinner.setPreferredSize(new Dimension(50, 25));
        text_editor_fontSizeSpinner.setValue(20);
        text_editor_fontSizeSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                text_editor_textArea.setFont(new Font(text_editor_textArea.getFont().getFamily(), Font.PLAIN, (int) text_editor_fontSizeSpinner.getValue()));
            }
        });

        text_editor_fontColorButton = new JButton("Font-Color");
        text_editor_fontColorButton.addActionListener(this);

        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        text_editor_fontBox = new JComboBox(fonts);
        text_editor_fontBox.addActionListener(this);
        text_editor_fontBox.setSelectedItem("Arial"); //Default font is set to Arial

        //------menu bar START-------


        text_editor_menuBar = new JMenuBar();
        text_editor_fileMenu = new JMenu("File");
        text_editor_openItem = new JMenuItem("Open");
        text_editor_saveItem = new JMenuItem("Save");
        text_editor_exitItem = new JMenuItem("Exit");

        text_editor_openItem.addActionListener(this);
        text_editor_saveItem.addActionListener(this);
        text_editor_exitItem.addActionListener(this);

        text_editor_fileMenu.add(text_editor_openItem);
        text_editor_fileMenu.add(text_editor_saveItem);
        text_editor_fileMenu.add(text_editor_exitItem);

        text_editor_menuBar.add(text_editor_fileMenu);



        //------menu bar END---------


        this.setJMenuBar(text_editor_menuBar);
        this.add(text_editor_fontInfoLabel);
        this.add(text_editor_fontSizeSpinner);
        this.add(text_editor_fontColorButton);
        this.add(text_editor_fontBox);
        this.add(text_editor_scrollPane);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == text_editor_fontColorButton){
            JColorChooser text_editor_colorChooser = new JColorChooser();

            Color color = text_editor_colorChooser.showDialog(null, "Choose a color ", Color.BLACK);

            text_editor_textArea.setForeground(color);
        }

        if (e.getSource() == text_editor_fontBox){
            text_editor_textArea.setFont(new Font((String)text_editor_fontBox.getSelectedItem(), Font.PLAIN, text_editor_textArea.getFont().getSize()));
        }

        if (e.getSource() == text_editor_openItem) {

            JFileChooser text_editor_fileChooser =  new JFileChooser();

            text_editor_fileChooser.setCurrentDirectory(new File("C:\\Users"));

            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");

            text_editor_fileChooser.setFileFilter(filter);

            int response = text_editor_fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION){
                File file = new File(text_editor_fileChooser.getSelectedFile().getAbsolutePath());
                Scanner fileIn = null;

                try {
                    fileIn = new Scanner(file);
                    if (file.isFile()){
                        while (fileIn.hasNextLine()){
                            String line = fileIn.nextLine()+"\n";
                            text_editor_textArea.append(line);
                        }
                    }
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                finally {
                    fileIn.close();
                }

            }
        }

        if (e.getSource() == text_editor_saveItem) {
            JFileChooser text_editor_fileChooser = new JFileChooser();
            text_editor_fileChooser.setCurrentDirectory(new File("C:\\Users"));

            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");

            text_editor_fileChooser.setFileFilter(filter);

            int response = text_editor_fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION){
                File file;
                PrintWriter fileOut = null;

                file = new File(text_editor_fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    fileOut = new PrintWriter(file);
                    fileOut.println(text_editor_textArea.getText());
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                finally {
                    fileOut.close();
                }
            }
        }

        if (e.getSource() == text_editor_exitItem) {
            this.dispose();
        }

    }
}
