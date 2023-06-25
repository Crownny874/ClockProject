/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clock;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;

/**
 *
 * @author leonovo
 */
public class ClockInterface implements ActionListener {
    
    JFrame frame;
    
    JPanel panel;
    
    JLabel label;
    
    private static int seconds;
    private static int mins;
    private static int hours;
    
    private static int currentseconds;
    private static int currentmins;
    private static int currenthour;
    
    private static String type = "";
    JLabel ap;
    public ClockInterface() {
        Border border = BorderFactory.createLineBorder(Color.gray, 5);
        //getting current time
        LocalTime lt = LocalTime.now();
        currentseconds= lt.getSecond();
        currentmins = lt.getMinute();
        currenthour = lt.getHour();
        
     
        //assigning current time to new variable
         seconds = currentseconds;
         mins = currentmins;
         hours = currenthour;
         
         //setting post meridian and after meridian for clock
         ap = new JLabel();
         ap.setBounds(160, 50, 150, 55);
         ap.setOpaque(true);
         ap.setFont(new Font(Font.SERIF,5,15));
  
         if(hours >= 0 && hours < 12) {
            ap.setText("AM");
           type = ap.getText();
         }
         else if(hours >= 12) {
          ap.setText("PM");
          type = ap.getText();
        }
   
         
      //defining and instantiatin JLabel
      label = new JLabel();
      label.setBounds(40, 50, 150, 55);
      label.setOpaque(true);
      label.setVerticalAlignment(SwingConstants.CENTER);
      label.setHorizontalAlignment(SwingConstants.CENTER);
      label.setBackground(Color.GREEN);
      label.setText("");
      label.setFont(new Font(Font.SANS_SERIF,5,19));
      label.setBorder(border);
      
      
      //defining and instantiating JPanel
      panel  = new JPanel();
      panel.setSize(250, 250);
      panel.setLayout(null);
      panel.add(label);
      panel.setBackground(Color.DARK_GRAY);
      
      Timer timer = new Timer(1000,this);
      timer.start();
      
      
      //defining and instatiating JFrame
      frame = new JFrame();
      frame.setSize(250, 250);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
      frame.setLayout(null);
      frame.add(panel);
      frame.setTitle("Clock");
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      //incrementing seconds per timer
            seconds++;
            
      //incrementing minutes if seconds reach some certain value
        if(seconds == 60) {
            mins++;
           seconds = 0;
        }
     //incrementing hours if minutes reach some certain value
      if(mins == 60) {
      hours++;
      mins =0;
      seconds =0;
    }
     //re processing function if hours reaches maximum value
    if(hours == 23 && seconds ==59) {
    hours =0;
    mins = 0;
    seconds =0;
       }
    printFormat(hours,mins,seconds,type);
     }
public void printFormat(int hours,int mins, int seconds,String type) {
      if(hours < 10 && mins < 10 && seconds <  10){
      label.setText("0"+hours+" : 0"+mins+" : 0"+seconds+" "+type); 
     }
     if(hours < 10 && mins >= 10 && seconds >= 10) {
     label.setText("0"+hours+" : "+mins+" : "+seconds+" "+type);
     }
     if(hours < 10 && mins >= 10 && seconds < 10){
     label.setText("0"+hours+" : "+mins+" : 0"+seconds+" "+type);
     }
     if(hours < 10 && mins < 10 && seconds >= 10) {
     label.setText("0"+hours+" : 0"+mins+" : "+seconds+" "+type);   
     }
     
    if(hours >= 10 && mins >= 10 && seconds >= 10) {
       label.setText(hours+" : "+mins+" : "+seconds+" "+type);
    }
    if(hours >= 10 && mins < 10 && seconds < 10) {
      label.setText(hours+" : 0"+mins+" : 0"+seconds+" "+type);
     }
     if(hours >= 10 && mins < 10 && seconds >= 10){
      label.setText(hours+" : 0"+mins+" : "+seconds+" "+type);
     }
     if(hours >= 10 && mins >= 10 && seconds < 10) {
     label.setText(hours+" : "+mins+" : 0"+seconds+" "+type);
     }
  }
}
