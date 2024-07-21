package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton submit, reset, close;
    JTextField tfUsername;
    JPasswordField tfPassword;
    
    public Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lbUsername = new JLabel("Username");
        lbUsername.setBounds(20, 20, 100, 20);
        add(lbUsername);
        
        tfUsername = new JTextField();
        tfUsername.setBounds(130, 20, 200, 20);
        add(tfUsername);
        
        JLabel lbPassword = new JLabel("Password");
        lbPassword.setBounds(20, 60, 100, 20);
        add(lbPassword);
        
        tfPassword = new JPasswordField();
        tfPassword.setBounds(130, 60, 200, 20);
        add(tfPassword);
        
        reset = new JButton("Reset");
        reset.setBounds(40, 120, 120, 20);
        reset.addActionListener((ActionListener)this);
        add(reset);
        
        submit = new JButton("Submit");
        submit.setBounds(190, 120, 120, 20);
        submit.addActionListener((ActionListener)this);
        add(submit);
        
        close = new JButton("Close");
        close.setBounds(110, 160, 120, 20);
        close.addActionListener((ActionListener)this);
        add(close);
        
        setSize(400,250);
        setLocation(600, 250);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String username = tfUsername.getText();
            String password = tfPassword.getText();
            
            try{
                Conn c = new Conn();
                
                String query = "SELECT * FROM login WHERE username = '" + username+ "'and password ='" +password + "'" ;
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    new Home();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                }
                
            } catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == close){
            setVisible(false);
        }else if(ae.getSource() == reset){
            tfUsername.setText("");
            tfPassword.setText("");
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}
