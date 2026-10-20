import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.Border;

// Hardware Multitool v1.0
// Author - John Kyriai
// License = MIT
// Date built 20/10/2026
// Time compiled 18:18 UTC+0
// Enjoy!

public class Main{
    public static void main(String[] args){

        HardwareLogicLegacy logic = new HardwareLogicLegacy();

        // Frame setup
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        frame.setTitle("Hardware Multitool - Legacy"); // Legacy because no Win11 support
        frame.setLayout(new BorderLayout());
        // End of Frame setup

        // Panel which hosts the elements on screen
        JPanel upPanel = new JPanel(new BorderLayout()); // Was originally the upmost of two panels but I got rid of the other one because it had no use

        // Menu bar setup
        JMenuBar menuBar = new JMenuBar();

        // This makes the two buttons on the menu bar
        JMenu viewMenu = new JMenu("View");
        JMenu helpMenu = new JMenu("Help");

        // These are all the items under the view menu
        JMenuItem cpuItem = new JMenuItem("CPU Information");
        JMenuItem ramItem = new JMenuItem("RAM Information");
        JMenuItem biosItem = new JMenuItem("BIOS Information");
        JMenuItem motherBoardItem = new JMenuItem("Motherboard Information");
        JMenuItem drivesItem = new JMenuItem("Drive Information");
        JMenuItem gpuItem = new JMenuItem("GPU Information");
        JMenuItem networtkItem = new JMenuItem("Network Information");
        JMenuItem fanItem = new JMenuItem("Fan Information");
        JMenuItem soundItem = new JMenuItem("Sound Information");
        // And these end here

        // These are the 
        JMenuItem sourceCodeItem = new JMenuItem("Source code");
        JMenuItem helpItem = new JMenuItem("About Hardware Multitool");
        // End of Menu bar setup

        // The label that appears on launch
        JLabel label = new JLabel("Welcome!", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 30)); // Makes it bold and new font
        label.setForeground(new Color(51, 51, 51)); // Sets the colour
        label.setBorder(BorderFactory.createEmptyBorder(10, 0, 15, 0));
          
        // Uses HTML
        JLabel label2 = new JLabel(
            "<html><div style='text-align: center; width: 350px;'>" +
            "- Welcome to the Hardware Multitool with a GUI, built in JAVA!<br><br>" +
            "- To begin with selection, cick on <b>View</b> and select an option." +
            "</div></html>"
        );
        label2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        label2.setForeground(new Color(100, 100, 100));

        label2.setVerticalAlignment(SwingConstants.TOP);
        label2.setHorizontalAlignment(SwingConstants.CENTER);

        // adds the central image to the launch menu
        ImageIcon icon = new ImageIcon("image.png");
        java.awt.Image scaledImage = icon.getImage().getScaledInstance(430, 370, java.awt.Image.SCALE_SMOOTH); // sets the size of the image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER); 

        label2.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        // Adds the items to the view Menu
        viewMenu.add(cpuItem);
        viewMenu.add(ramItem);
        viewMenu.add(biosItem);
        viewMenu.add(motherBoardItem);
        viewMenu.add(drivesItem);
        viewMenu.add(gpuItem);
        viewMenu.add(networtkItem);
        viewMenu.add(fanItem);
        viewMenu.add(soundItem);
        // These end here

        // Adds items to the help menu
        helpMenu.add(sourceCodeItem);
        helpMenu.add(helpItem);
        // Ends here
 
        // Adds the menus to the main Menu bar
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);
        // Ends here

        // Adds all the components to the upPanel
        upPanel.add(label, BorderLayout.NORTH); 
        upPanel.add(label2, BorderLayout.CENTER);
        upPanel.add(imageLabel, BorderLayout.SOUTH);
        // Ends here

        // ACTION LISTENERS

        // Cpu actionlistener
        cpuItem.addActionListener(e -> {
            String cpuData = logic.getCPUInfo();
            updateDisplayArea(upPanel, cpuData);
        });

        // Ram actionlistener
        ramItem.addActionListener(e -> {
            String ramData = logic.getRAMInfo();
            updateDisplayArea(upPanel, ramData);
        });

        // Bios actionlistener
        biosItem.addActionListener(e -> {
            String biosData = logic.getBIOSInfo();
            updateDisplayArea(upPanel, biosData);
        });

        // Motherboard actionlistener
        motherBoardItem.addActionListener(e -> {
            String motherboardData = logic.getMOTHERBOARDInfo();
            updateDisplayArea(upPanel, motherboardData);
        });
          
        // Drives actionlistener
        drivesItem.addActionListener(e -> {
            String drivesData = logic.getDRIVEInfo();
            updateDisplayArea(upPanel, drivesData);
        });

        // Gpu actionlistener
        gpuItem.addActionListener(e -> {
            String gpuData = logic.getGPUInfo();
            updateDisplayArea(upPanel, gpuData);
        });
         
        // Network actionlistener
        networtkItem.addActionListener(e -> {
            String networkData = logic.getNETWORKInfo();
            updateDisplayArea(upPanel, networkData);
        });

        // Fan actionlistener
        fanItem.addActionListener(e -> {
            String fanData = logic.getFANInfo();
            updateDisplayArea(upPanel, fanData);
        });

        // Sound actionlistener
        soundItem.addActionListener(e -> {
            String soundData = logic.getSOUNDInfo();
            updateDisplayArea(upPanel, soundData);
        });

        // About window actionlistener
        helpItem.addActionListener(e -> {

            JFrame aboutFrame = new JFrame();
            aboutFrame.setTitle("About Hardware Multitool - Legacy"); // Title on titlebar
            aboutFrame.setSize(500,500);
            aboutFrame.setLayout(new BorderLayout());

            JPanel aboutPanelUp = new JPanel(new BorderLayout());
            JPanel aboutPanelBottom = new JPanel(new BorderLayout());

            // Title on the window not the titlebar
            JLabel label3 = new JLabel("About Hardware Multitool v1.0", SwingConstants.CENTER);
            label3.setFont(new Font("SansSerif", Font.BOLD, 30));
            label3.setForeground(new Color(51, 51, 51));
            label3.setBorder(BorderFactory.createEmptyBorder(10, 0, 15, 0));

            // Text on the about window
            JLabel label4 = new JLabel(
            "<html><div style='text-align: center; width: 350px;'>" +
            "- Hardware Multitool is a tool that allows you to check information on your hardware. It is made in Java and there is a also a Batch file version of it too!<br><br>" +
            "- This app only works on <b>Windows 7 to Windows 10</b> because the 'wmic' function was removed later on." +
            "This is licensed under the <b>MIT license.</b>  Enjoy!" +
            "</div></html>"
            ); 

            label4.setFont(new Font("SansSerif", Font.PLAIN, 14));
            label4.setForeground(new Color(100, 100, 100));

            
            label4.setVerticalAlignment(SwingConstants.TOP);
            label4.setHorizontalAlignment(SwingConstants.CENTER);

            ImageIcon icon2 = new ImageIcon("assets/logo.png"); // The About image
            java.awt.Image scaledImage2 = icon2.getImage().getScaledInstance(330, 230, java.awt.Image.SCALE_SMOOTH); // Sets the size
            icon2 = new ImageIcon(scaledImage2);

            JLabel aboutimageLabel = new JLabel(icon2);
            aboutimageLabel.setHorizontalAlignment(SwingConstants.CENTER);

            label4.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

            JButton okButton = new JButton("Okay"); // An okay button which closes the window

            okButton.addActionListener(s -> {
                aboutFrame.dispose(); // Disposes of the frame
            });

            aboutPanelUp.add(label3, BorderLayout.NORTH);
            aboutPanelUp.add(label4, BorderLayout.CENTER);
            aboutPanelUp.add(aboutimageLabel, BorderLayout.SOUTH);

            aboutPanelBottom.add(okButton, BorderLayout.SOUTH);

            aboutFrame.add(aboutPanelBottom, BorderLayout.SOUTH);
            aboutFrame.add(aboutPanelUp, BorderLayout.CENTER);
            aboutFrame.setResizable(false);
            aboutFrame.setVisible(true); // Sets the window visible

        });

        // END OF ACTION LISTENERS


        frame.setJMenuBar(menuBar); // Adds the menu bar
        frame.add(upPanel, BorderLayout.CENTER);
        frame.setVisible(true); // Makes the window visible
        frame.setResizable(false); // Makes it so you can not resize the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // This makes it so it does not run in the background when you close it

    }

       private static void updateDisplayArea(JPanel panel, String data) {
        panel.removeAll();

        JTextArea displayArea = new JTextArea(data);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 13)); // Font of the text of the system specs displayed on the area
        displayArea.setEditable(false);
        displayArea.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JScrollPane scrollPane = new JScrollPane(displayArea); // Adds a scrollbar so you can scroll if the results are long
        panel.add(scrollPane, BorderLayout.CENTER);

        panel.revalidate();
        panel.repaint();
    }
} 
// End of program :(
