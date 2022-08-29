//package Receptionist ;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.*;

public class ReceptionistPage extends JFrame {
    JLabel backgroundImageLabel;
    JPanel MainPanel;
    JTable dataTable ;
    JScrollPane TablescrollPane;

    ReceptionistPage(){
        ImageIcon backgroundImage = new ImageIcon("Media/Background.jpg");
        backgroundImageLabel = new JLabel();
        backgroundImageLabel.setIcon(backgroundImage);

        String[][] row = {
                            {"1","Name 1"," Father's Name 1","Mother's Name","017432738","Address 1"},
                            {"2","Name 2"," Father's Name 1","Mother's Name","017432738","Address 1"},
                            {"3","Name 3"," Father's Name 1","Mother's Name","017432738","Address 1"},
                            {"","Name 4"," Father's Name 1","Mother's Name","017432738","Address 1"},
                            {"","","","","",""}

        };
        row[3][0]="6";
        row[4][0]="10";
        row[4][1]="10";
        row[4][2]="10";
        row[4][3]="10";
        row[4][4]="10";
        row[4][5]="10";

        String[] colum={"Serial No","Name","Father's Name","Mother's Name","Mobile Number","Address"};

        dataTable = new JTable(row,colum);
        //dataTable.setBounds(50,50,1000,600);

        TablescrollPane = new JScrollPane(dataTable);
        TablescrollPane.setBounds(50,50,1000,600);
        TablescrollPane.setViewportView(dataTable);

        MainPanel = new JPanel();
        MainPanel.setVisible(true);
        MainPanel.setLayout(null);
        MainPanel.setBounds(50,50,1100,700);
        MainPanel.add(TablescrollPane);
        MainPanel.setBackground(new Color(1f,1f,1f,0.5f));

        this.setVisible(true);
        this.add(MainPanel);
        this.add(backgroundImageLabel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1200,800);
        //this.setLayout(null);
        this.setBackground(new Color(244,244,244));
        this.setLocationRelativeTo(null);
    }
     public static void main(String[] args) {
        ReceptionistPage obj = new ReceptionistPage();
       // LoginPage obj2 = new LoginPage();
    }
}
