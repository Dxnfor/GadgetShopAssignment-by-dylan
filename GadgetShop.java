import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GadgetShop extends JFrame implements ActionListener {
    // 1. Storage for all gadgets
    private ArrayList<Gadget> gadgets = new ArrayList<>();
    
    // 2. Text Fields for data entry
    private JTextField modelField = new JTextField(10);
    private JTextField priceField = new JTextField(10);
    private JTextField weightField = new JTextField(10);
    private JTextField sizeField = new JTextField(10);
    private JTextField creditField = new JTextField(10);
    private JTextField memoryField = new JTextField(10);
    private JTextField indexField = new JTextField(5);
    private JTextField phoneField = new JTextField(10);
    private JTextField durationField = new JTextField(5);
    private JTextField downloadField = new JTextField(5);

    // 3. Buttons
    private JButton addMobileButton = new JButton("Add Mobile");
    private JButton addMP3Button = new JButton("Add MP3");
    private JButton displayAllButton = new JButton("Display All");
    private JButton makeCallButton = new JButton("Make a Call");
    private JButton downloadButton = new JButton("Download Music");
    private JButton clearButton = new JButton("Clear Fields");

    public GadgetShop() {
        setTitle("Gadget Shop System 2026");
        setSize(450, 550);
        setLayout(new GridLayout(0, 2, 5, 5)); // Clean 2-column layout

        // Adding Input Fields and Labels
        add(new JLabel("Model:")); add(modelField);
        add(new JLabel("Price (£):")); add(priceField);
        add(new JLabel("Weight (g):")); add(weightField);
        add(new JLabel("Size:")); add(sizeField);
        add(new JLabel("Initial Credit (Mins):")); add(creditField);
        add(new JLabel("Initial Memory (MB):")); add(memoryField);
        
        // Buttons to add items
        add(addMobileButton); add(addMP3Button);
        
        // Selection and Actions
        add(new JLabel("Gadget Number:")); add(indexField);
        add(new JLabel("Phone No / Download Size:")); add(phoneField);
        add(new JLabel("Call Duration (Mins):")); add(durationField);
        
        add(makeCallButton); add(downloadButton);
        add(displayAllButton); add(clearButton);

        // Link all buttons to the listener
        addMobileButton.addActionListener(this);
        addMP3Button.addActionListener(this);
        displayAllButton.addActionListener(this);
        makeCallButton.addActionListener(this);
        downloadButton.addActionListener(this);
        clearButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == addMobileButton) {
            addMobile();
        } else if (source == addMP3Button) {
            addMP3();
        } else if (source == displayAllButton) {
            displayAll();
        } else if (source == makeCallButton) {
            makeCall();
        } else if (source == downloadButton) {
            downloadMusic();
        } else if (source == clearButton) {
            clearFields();
        }
    }

    private void addMobile() {
        try {
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            int weight = Integer.parseInt(weightField.getText());
            String size = sizeField.getText();
            int credit = Integer.parseInt(creditField.getText());
            gadgets.add(new Mobile(model, price, weight, size, credit));
            JOptionPane.showMessageDialog(this, "Mobile added!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Check price, weight, and credit inputs.");
        }
    }

    private void addMP3() {
        try {
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            int weight = Integer.parseInt(weightField.getText());
            String size = sizeField.getText();
            double memory = Double.parseDouble(memoryField.getText());
            gadgets.add(new MP3(model, price, weight, size, memory));
            JOptionPane.showMessageDialog(this, "MP3 added!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Check price, weight, and memory inputs.");
        }
    }

    private void makeCall() {
        try {
            int index = Integer.parseInt(indexField.getText());
            String phone = phoneField.getText();
            int duration = Integer.parseInt(durationField.getText());
            
            if (index >= 0 && index < gadgets.size()) {
                Gadget g = gadgets.get(index);
                if (g instanceof Mobile) {
                    ((Mobile) g).makeCall(phone, duration);
                    JOptionPane.showMessageDialog(this, "Call task processed. Check terminal.");
                } else {
                    JOptionPane.showMessageDialog(this, "This index is not a Mobile!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Gadget Number!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: Enter valid Index and Duration.");
        }
    }

    private void downloadMusic() {
        try {
            int index = Integer.parseInt(indexField.getText());
            double size = Double.parseDouble(phoneField.getText()); // Using phoneField for download size
            
            if (index >= 0 && index < gadgets.size()) {
                Gadget g = gadgets.get(index);
                if (g instanceof MP3) {
                    ((MP3) g).downloadMusic(size);
                    JOptionPane.showMessageDialog(this, "Download task processed. Check terminal.");
                } else {
                    JOptionPane.showMessageDialog(this, "This index is not an MP3!");
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: Enter valid Index and Size.");
        }
    }

    private void displayAll() {
        if (gadgets.isEmpty()) {
            System.out.println("No gadgets in the shop.");
        } else {
            for (int i = 0; i < gadgets.size(); i++) {
                System.out.println("--- Gadget #" + i + " ---");
                gadgets.get(i).display();
            }
        }
    }

    private void clearFields() {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        indexField.setText("");
        phoneField.setText("");
        durationField.setText("");
    }

    public static void main(String[] args) {
        new GadgetShop();
    }
}