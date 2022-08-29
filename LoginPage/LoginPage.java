
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class LoginPage extends JFrame implements ActionListener {
    JPanel LoginPanel ;
    JLabel backgroundLabel;
    JLabel LoginPng ;
    JButton logiButton;
    JOptionPane WrongPassMess ;

    JTextField user ;
    JPasswordField password ;
    public JPanel Panel( int x , int y,int width , int height){
        JPanel fnPanel = new JPanel();
        fnPanel.setVisible(true);
        fnPanel.setBounds(x,y, width, height);
        fnPanel.setLayout(null);
        return fnPanel;
    }

    /* The first perameter is the File name , the file must be (.txt) */
    public boolean checkUserPass(String FileName , String UserName, String Password){
        BufferedReader br = null ;
        boolean flag=false ;
        try{
               br = new BufferedReader(new FileReader(FileName));
               String templine ;
               while((templine=br.readLine()) !=null){
                String[] line = templine.split(";");
                if(line[0].equals(UserName)&&line[1].equals(Password)){
                    flag=true;
                }
                templine=null;
               }
    }catch(FileNotFoundException ex){
        ex.printStackTrace();
    } catch(IOException ioe){
        ioe.printStackTrace();
    }    


        return flag;
    }

    LoginPage(){
        ImageIcon background = new ImageIcon("Media/Background.jpg");
        ImageIcon loginpng = new ImageIcon("Media/login.png");

        logiButton = new JButton("Log In");
        logiButton.setBounds(150,350,200,40);
        logiButton.addActionListener(this);

        user = new JTextField();
       
        user.setBounds(150,250,200,40);

        password = new JPasswordField();
        password.setBounds(150,300,200,40);

        LoginPng = new JLabel();
        LoginPng.setBounds(200,130,100,100);
        LoginPng.setIcon(loginpng);

        backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0,0,1200,800);
        backgroundLabel.setIcon(background);

        LoginPanel = Panel(350,150,500, 500);
        LoginPanel.setBackground(new Color(1.0f,1.0f,1.0f,0.3f));
        LoginPanel.add(LoginPng);
        LoginPanel.add(user);
        LoginPanel.add(logiButton);
        LoginPanel.add(password);

        this.setVisible(true);
        this.setSize(1200,800);
        this.add(LoginPanel);
        this.add(backgroundLabel);
        this.setLocationRelativeTo(null);
        //this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
    }
    public void userln(){
        System.out.println(user.getText());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==logiButton && checkUserPass("Data/try.txt",user.getText(),password.getText())){
            this.dispose();
            
        }else{
            WrongPassMess.showMessageDialog(this,"Wrong PassWord or User ID","Alert",JOptionPane.WARNING_MESSAGE);

        }
        
    }
    public static void main(String[] args) {
        LoginPage obj = new LoginPage();
       
    }
}