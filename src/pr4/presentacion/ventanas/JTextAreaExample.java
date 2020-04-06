package pr4.presentacion.ventanas;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import java.util.concurrent.atomic.AtomicInteger;



public class JTextAreaExample {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable(){

                @Override public void run(){

                    final JFrame frame = new JFrame("JTextArea Example");

                    final JTextArea input = new JTextArea();

                    final JScrollPane scroller = new JScrollPane(input);

                    final Timer timer = new Timer(10, new ActionListener(){

                        private final AtomicInteger counter = new AtomicInteger(0);

                        @Override public void actionPerformed(ActionEvent event){

                            if(input.getLineCount() > 2000) input.setText("");

                            input.append(String.format("%s %d%n","Hello", counter.incrementAndGet()));

                        }

                    });

                    frame.add(scroller);

                    frame.setPreferredSize(new Dimension(600,400));

                    frame.pack();

                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);

                    frame.addWindowListener(new WindowAdapter(){

                        @Override public void windowOpened(WindowEvent event){

                            timer.start();

                        }

                        @Override public void windowClosing(WindowEvent event){

                            timer.stop();

                        }

                    });

                }

            });

    }

}