/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sms_services;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author shibly
 */
public class SMS extends JFrame{

    private JFrame f = new JFrame("BL RENEWAL PANEL"); //create Frame
   
    private JPanel pnlTxt = new JPanel(); // East quadrant
    private JPanel pnlSrvices = new JPanel(); // West quadrant
    private JPanel pnltdSrvices = new JPanel(); // Center quadrant

	
    private JButton startService = new JButton("Start Renewal");
    private JButton stopService = new JButton("Stop Renewal");

    private String txtareaText = "<html><font color=black><p> <ul>"
            + "<li>To run <b>Subscription SMS Service</b> click on 'Start Renewal'.</li>"
            +"<li>Press 'Stop Service' to stop the whole Renewal service application.</li>"
            +"<li>After updating today SMS press 'Start Today Renewal Service'.</li>"
            + "</ul></p></font></html>";
    private JLabel jl = new JLabel(txtareaText);

    
    

  
    private JMenuBar mb = new JMenuBar(); // Menubar
    private JMenu mnuFile = new JMenu("File"); // File Entry on Menu bar
    private JMenuItem mnuItemQuit = new JMenuItem("Quit"); // Quit sub item
   

    /** Constructor for the GUI */
    public SMS(){
		// Set menubar
        f.setJMenuBar(mb);

		//Build Menus
        mnuFile.add(mnuItemQuit);  // Create Quit line
        mb.add(mnuFile);        // Add Menu items to form

       
        pnlTxt.add(jl);
       
        
        pnlSrvices.add(startService);
        pnlSrvices.add(stopService);
  
        
        

        // Setup Main Frame
        
         f.getContentPane().add(pnlTxt, BorderLayout.NORTH);
         f.getContentPane().add(pnlSrvices, BorderLayout.CENTER);
         f.getContentPane().add(pnltdSrvices, BorderLayout.SOUTH);

		// Allows the Swing App to be closed
        f.addWindowListener(new ListenCloseWdw());

		//Add Menu listener
        mnuItemQuit.addActionListener(new ListenMenuQuit());
        startService.addActionListener(new ListenStart());
        stopService.addActionListener(new ListenMenuQuit());

    }

    public class ListenMenuQuit implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }

    public class ListenCloseWdw extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e){
            System.exit(0);
        }
    }
   public class ListenStart implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Sms_Finder SF = new Sms_Finder();
            SF.start();
        } 

    }


    public void launchFrame(){
        
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack(); 
        f.setSize(500,250);
        f.setVisible(true);
    }

    public static void main(String args[]){
        SMS gui = new SMS();
        gui.launchFrame();
    }
              




    

}