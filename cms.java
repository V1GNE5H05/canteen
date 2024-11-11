import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CanteenManagementSystem2 extends JFrame implements ActionListener
{
    JPanel loginPanel;
    JTextField userField;
    JPasswordField passField;
    //student login info
    JPanel head, menu, details;
    //worker info
    JLabel lmenu, l4, l5, l6;
    JTextArea Menu;
    JTextField itemNameField, quantityField, totalField;
    JButton addButton, calculateButton, resetButton, removeItemButton, clearBillButton;
    JTextArea billArea;
    JLabel l1, l2, l3;
    HashMap<String, Double> menuItems;//Data Structure
    double totalAmount;
    CanteenManagementSystem2()
    {
        setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        loginPanel = new JPanel(new GridLayout(4, 1));
        /*Login page start */
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.ORANGE);
        JLabel header = new JLabel(" SNV Canteen ");
        header.setBounds(580, 20, 600, 100);
        header.setFont(new Font("Arial", Font.BOLD, 65));
        p1.add(header);
        JLabel subheader1 = new JLabel("Created by 'Sujan', 'Pothiraju', 'Vigneshwaran'");
        subheader1.setFont(new Font("Arial", Font.BOLD, 12));
        subheader1.setBounds(650, 75, 300, 100);
        p1.add(subheader1);
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        JLabel username = new JLabel(" Username ");
        username.setBounds(300, 150, 250, 30);
        username.setFont(new Font("Arial", Font.ITALIC, 40));
        p2.add(username);
        userField = new JTextField();
        userField.setBounds(600, 145, 700, 50);
        userField.setFont(new Font("Arial", Font.ITALIC, 25));
        p2.add(userField);
        JPanel p3 = new JPanel();
        p3.setLayout(null);
        JLabel password = new JLabel(" Password ");
        password.setBounds(300, 100, 200, 30);
        password.setFont(new Font("Arial", Font.ITALIC, 40));
        p3.add(password);
        passField = new JPasswordField();
        passField.setBounds(600, 95, 700, 50);
        p3.add(passField);
        JPanel p4 = new JPanel();
        p4.setLayout(null);
        JButton loginbtn = new JButton("Login");
        loginbtn.setBounds(550, 50, 250, 60);
        loginbtn.addActionListener(this);
        p4.add(loginbtn);
        loginPanel.add(p1);
        loginPanel.add(p2);
        loginPanel.add(p3);
        loginPanel.add(p4);
        /*Login page end */
        add(loginPanel);
        setVisible(true);
    }
    //Student Page start
    public void StudentPage()
    {
        head = new JPanel();
        head.setLayout(null);
        head.setBackground(Color.ORANGE);
        head.setPreferredSize(new Dimension(1200, 150));
        JLabel header = new JLabel(" SNV Canteen ");
        header.setBounds(600, 0, 300, 100);
        header.setFont(new Font("Arial", Font.BOLD, 35));
        head.add(header);
        JLabel subheader = new JLabel("Created by 'Sujan', 'Pothiraju', 'Vigneshwaran'");
        subheader.setFont(new Font("Arial", Font.BOLD, 12));
        subheader.setBounds(600, 50, 300, 100);
        head.add(subheader);
        add(head, BorderLayout.NORTH);

        //Student Menu Start

        menu = new JPanel();
        menu.setBackground(Color.gray);
        menu.setPreferredSize(new Dimension(500, 800));
        menu.setLayout(null);
        menu.setSize(500, 1000);
        menu.setLocation(0, 0);
        menu.setBackground(new Color(100, 100, 0, 100));
        JLabel studentDetails = new JLabel("Student Details");
        studentDetails.setBounds(120, 100, 200, 30);
        studentDetails.setFont(new Font("Arial", Font.BOLD, 20));
        studentDetails.setForeground(Color.BLUE);
        
        menu.add(studentDetails);
        JLabel R_history = new JLabel("Recharge History");
        R_history.setForeground(Color.BLUE);
        R_history.setBounds(120, 150, 200, 30);
        R_history.setFont(new Font("Arial", Font.BOLD, 20));
        
        menu.add(R_history);
        JLabel P_history = new JLabel("Purchase History");
        P_history.setForeground(Color.BLUE);
        P_history.setBounds(120, 200, 200, 30);
        P_history.setFont(new Font("Arial", Font.BOLD, 20));
        menu.add(P_history);

        JLabel balance = new JLabel("Balance");
        balance.setForeground(Color.BLUE);
        balance.setBounds(120, 250, 200, 30);
        balance.setFont(new Font("Arial", Font.BOLD, 20));
        menu.add(balance);

        JLabel recharge = new JLabel("Recharge");
        recharge.setForeground(Color.BLUE);
        recharge.setBounds(120, 300, 200, 30);
        recharge.setFont(new Font("Arial", Font.BOLD, 20));
        menu.add(recharge);

        add(menu, BorderLayout.WEST);

        
        //Student Menu End

        //Student Details Start

        details = new JPanel();
        details.setLayout(null);
        details.setBackground(new Color(100, 100, 100, 100));
        details.setPreferredSize(new Dimension(1050, 150));
        JLabel name = new JLabel("Name : ");
        name.setBounds(100, 100, 100, 30);
        name.setFont(new Font("Arial", Font.BOLD, 15));
        details.add(name);
        JLabel admn_no = new JLabel("Admission number : ");
        admn_no.setBounds(100, 150, 200, 30);
        admn_no.setFont(new Font("Arial", Font.BOLD, 15));
        details.add(admn_no);
        JLabel roll_no = new JLabel("Roll number : ");
        roll_no.setBounds(100, 200, 200, 30);
        roll_no.setFont(new Font("Arial", Font.BOLD, 15));
        details.add(roll_no);
        JLabel mail = new JLabel("Mail ID : ");
        mail.setBounds(100, 250, 100, 30);
        mail.setFont(new Font("Arial", Font.BOLD, 15));
        details.add(mail);
        setVisible(true);
        add(details, BorderLayout.EAST);
        ImageIcon image = new ImageIcon("photo.jpg");
        JLabel imgLabel = new JLabel(image);
        imgLabel.setBounds(650, 100, 100, 100);
        details.add(imgLabel);
        //Student Details End
        studentDetails.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e) {
                details.setVisible(true);
                revalidate();
                repaint();
            }
        });

        R_history.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e) {
                details.setVisible(false);
                JOptionPane.showMessageDialog(null, "Recharge history page is working");
                revalidate();
                repaint();
            }
        });

        P_history.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e) {
                details.setVisible(false);
                JOptionPane.showMessageDialog(null, "Purchase history page is working");
                revalidate();
                repaint();
            }
        });

        balance.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e) {
                details.setVisible(false);
                JOptionPane.showMessageDialog(null, "Balance history page is working");
                revalidate();
                repaint();
            }
        });

        recharge.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e) {
                details.setVisible(false);
                JOptionPane.showMessageDialog(null, "Recharge page is working");
                revalidate();
                repaint();
            }
        });
    }
    public void workerPage()
    {
        menuItems = new HashMap<>();
        menuItems.put("Vada", 8.0);
        menuItems.put("Bajji", 10.0);
        menuItems.put("Veg-puff", 15.0);
        menuItems.put("Egg-puff", 20.0);
        menuItems.put("Chicken-puff", 25.0);
        menuItems.put("Milkshake", 35.0);

        // Create panel and set layout
        JPanel billPanel = new JPanel();
        billPanel.setLayout(null);
        
        setTitle("Canteen Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.GRAY);

        // Initialize components
        l1 = new JLabel("Item Name");
        l1.setBounds(60, 400, 70, 30);
        billPanel.add(l1);
        itemNameField = new JTextField(20);
        itemNameField.setBounds(150, 400, 200, 30);
        billPanel.add(itemNameField);

        l2 = new JLabel("Quantity");
        l2.setBounds(60, 450, 70, 30);
        billPanel.add(l2);
        quantityField = new JTextField(20);
        quantityField.setBounds(150, 450, 200, 30);
        billPanel.add(quantityField);

        addButton = new JButton("Add Item");
        addButton.addActionListener(this);
        addButton.setBackground(Color.WHITE);
        addButton.setBounds(150, 500, 200, 30);
        billPanel.add(addButton);

        l3 = new JLabel("Current Orders");
        l3.setBounds(700, 90, 100, 30);
        billPanel.add(l3);

        billArea = new JTextArea(10, 40);
        billArea.setBounds(700, 120, 300, 200);
        billArea.setEditable(false);
        billArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        billPanel.add(billArea);

        removeItemButton = new JButton("Remove Item");
        removeItemButton.addActionListener(this);
        removeItemButton.setBackground(Color.WHITE);
        removeItemButton.setBounds(750, 350, 200, 30);
        billPanel.add(removeItemButton);

        calculateButton = new JButton("Calculate Bill");
        calculateButton.addActionListener(this);
        calculateButton.setBackground(Color.WHITE);
        calculateButton.setBounds(750, 500, 250, 40);
        billPanel.add(calculateButton);

        clearBillButton = new JButton("Clear Bill");
        clearBillButton.addActionListener(this);
        clearBillButton.setBackground(Color.WHITE);
        clearBillButton.setBounds(650, 400, 150, 30);
        billPanel.add(clearBillButton);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        resetButton.setBackground(Color.WHITE);
        resetButton.setBounds(950, 400, 150, 30);
        billPanel.add(resetButton);

        l5 = new JLabel("Total Amount");
        l5.setBounds(700, 600, 100, 30);
        billPanel.add(l5);
        totalField = new JTextField(20);
        totalField.setBounds(800, 600, 200, 30);
        totalField.setEditable(false);  // Make it non-editable
        billPanel.add(totalField);

        lmenu = new JLabel("MENU");
        lmenu.setBounds(60, 50, 250, 30);
        billPanel.add(lmenu);
        Menu = new JTextArea("");
        Menu.setEditable(false);
        Menu.setBounds(60, 90, 500, 250);
        Menu.setText("\tItems\t\t\tPrice\n--------------------------------------------------------------------------------------------------------------------------------------\n\tVada\t\t\t8\n\n\tBajji\t\t\t10\n\n\tVeg-puff\t\t\t15\n\n\tEgg-puff\t\t\t20\n\n\tChicken-puff\t\t\t25\n\n\tMilkshake\t\t\t35");
        billPanel.add(Menu);

        // Add panel to frame
        add(billPanel);
    }
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        String s = userField.getText();
        String p = new String(passField.getPassword());
        if(command.equals("Login"))
        {
            if(s.equals("20116") && p.equals("vikki"))
            { 
                loginPanel.setVisible(false);
                StudentPage();
                revalidate();
                repaint();
            }
            else if(s.endsWith("w"))
            {
                loginPanel.setVisible(false);
                workerPage();
                revalidate();
                repaint();
            }
            else
            {
                userField.setText("Invalid username or password");
                passField.setText("");
            }
        }
        else if(command.equals("Add Item"))
        {
            String itemName = itemNameField.getText();
            String quantityText = quantityField.getText();
            if(menuItems.containsKey(itemName)) 
            {
                double price = menuItems.get(itemName);
                int quantity = Integer.parseInt(quantityText);
                double totalItemPrice = price * quantity;
                totalAmount += totalItemPrice;
                billArea.append(itemName + " x " + quantity + " = " + totalItemPrice + "\n");
                itemNameField.setText("");
                quantityField.setText("");
            } 
            else 
            {
                itemNameField.setText("Item not found!");
            }
        } 
        else if(command.equals("Remove Item")) 
        {
            String itemName = itemNameField.getText();
            String quantityText = quantityField.getText();
            if(menuItems.containsKey(itemName))
            {
                double price = menuItems.get(itemName);
                int quantity = Integer.parseInt(quantityText);
                double totalItemPrice = price * quantity;
                totalAmount -= totalItemPrice;
                billArea.append("Removed: " + itemName + " x " + quantity + "\n");
                itemNameField.setText("");
                quantityField.setText("");
            }
            else 
            {
                itemNameField.setText("Item not found!");
            }
        } 
        else if(command.equals("Calculate Bill"))
        {
            totalField.setText(String.valueOf(totalAmount));
        } 
        else if (command.equals("Clear Bill")) 
        {
            totalField.setText("");
            billArea.setText("");
            totalAmount = 0;
        } 
        else if (command.equals("Reset")) 
        {
            itemNameField.setText("");
            quantityField.setText("");
            totalField.setText("");
            billArea.setText("");
            totalAmount = 0;
        }
    }
    public static void main(String[] args) {
        new CanteenManagementSystem2();
    }
}
