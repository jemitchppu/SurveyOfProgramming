package Module2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class simple {
    
    public static void main(String[] args) {
        //First start is building a frame always in Java
        JFrame frame = new JFrame("User Information");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        //Create a label
        JLabel nameLabel = new JLabel("Enter your name:");
        nameLabel.setBounds(50, 30, 150, 25);
        frame.add(nameLabel);

        //create a text field
        JTextField nameField = new JTextField();
        nameField.setBounds(200, 30, 200, 25);
        frame.add(nameField);
        
        //Age a label
        JLabel ageLabel = new JLabel("Enter your name:");
        ageLabel.setBounds(50, 70, 150, 25);
        frame.add(ageLabel);

        //Age text field
        JTextField ageField = new JTextField();
        ageField.setBounds(200, 70, 200, 25);
        frame.add(ageField);

        //Height Componenets
        JLabel heightLabel = new JLabel("Enter your height(cm):");
        heightLabel.setBounds(50, 110, 200, 25);
        frame.add(heightLabel);

        JTextField heightField = new JTextField();
        heightField.setBounds(200, 110, 200, 25);
        frame.add(heightField);

        //create a Jbutton
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(50, 150, 150, 30);
        frame.add(submitButton);

        //create another label for display the greeting
        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(50, 200, 400, 25);
        frame.add(resultLabel);
        
        //Add Event
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String ageText = ageField.getText();
                String heightText = heightField.getText();

                if(name.isEmpty() || ageText.isEmpty() || heightText.isEmpty()) {
                    resultLabel.setText("Please fill out all fields");
                } else {
                    try {
                        int age = Integer.parseInt(ageText);
                        double height = Double.parseDouble(heightText);

                        resultLabel.setText(String.format("Hello, %s! You are %d years old and %.1f cm tall.", name, age, height));
                    } catch (NumberFormatException ex) {
                        resultLabel.setText("Please input valid numbers for age and height. ");
                    }
                }
            }
        });

        frame.setVisible(true);
        }
}
