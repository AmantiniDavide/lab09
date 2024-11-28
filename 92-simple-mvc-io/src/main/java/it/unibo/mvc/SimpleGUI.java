package it.unibo.mvc;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final String TITLE = "My first java graphical interface";
    private final JFrame frame = new JFrame(TITLE);


    private SimpleGUI(final Controller ctrl){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextArea text = new JTextArea();
        final JPanel panel1 = new JPanel();
        final LayoutManager layout = new BorderLayout();
        panel1.setLayout(layout);
        //SaveButton
        final JButton SaveButton = new JButton("Save");
        SaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent event) {
                try{
                    ctrl.save(text.getText());
                }catch(IOException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(),"An error occurred", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        //GUI assemblage
        panel1.add(text,BorderLayout.CENTER);
        panel1.add(SaveButton, BorderLayout.SOUTH);
        frame.setContentPane(panel1);
        //Frame size and locations
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        frame.setLocationByPlatform(true);
    }

    private void display(){
        frame.setVisible(true);
    }

    public static void main(final String... a){
        final SimpleGUI gui = new SimpleGUI(new Controller());
        gui.display();
    }

}
