package myFirstproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIcalc extends JFrame implements ActionListener {
    private JTextField display;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decimalButton, equalsButton, clearButton, delButton;
    private JPanel buttonPanel;
    private GUI2d customPanel;

    private Calculator calculator;

    public GUIcalc() {
        calculator = new Calculator();

        setTitle("Calculator");
        setSize(420, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        Font font = new Font("Arial", Font.BOLD, 24);
        Color buttonColor = new Color(75, 75, 75);
        Color textColor = new Color(255, 255, 255);

        customPanel = new GUI2d();
        customPanel.setBounds(0, 0, 420, 100);
        add(customPanel);

        display = new JTextField();
        display.setBounds(50, 110, 300, 50);
        display.setFont(font);
        display.setEditable(false);
        display.setBackground(buttonColor);
        display.setForeground(textColor);
        add(display);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = createStyledButton(String.valueOf(i), font, buttonColor, textColor);
        }

        addButton = createStyledButton("+", font, buttonColor, textColor);
        subButton = createStyledButton("-", font, buttonColor, textColor);
        mulButton = createStyledButton("*", font, buttonColor, textColor);
        divButton = createStyledButton("/", font, buttonColor, textColor);
        decimalButton = createStyledButton(".", font, buttonColor, textColor);
        equalsButton = createStyledButton("=", font, buttonColor, textColor);
        clearButton = createStyledButton("C", font, buttonColor, textColor);
        delButton = createStyledButton("Del", font, buttonColor, textColor);

        operatorButtons = new JButton[]{addButton, subButton, mulButton, divButton, decimalButton, equalsButton, clearButton, delButton};

        buttonPanel = new JPanel();
        buttonPanel.setBounds(50, 180, 300, 300);
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
        buttonPanel.setBackground(new Color(50, 50, 50));

        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(addButton);
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(subButton);
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(mulButton);
        buttonPanel.add(decimalButton);
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(equalsButton);
        buttonPanel.add(divButton);

        add(buttonPanel);
        setVisible(true);
    }

    private JButton createStyledButton(String text, Font font, Color background, Color foreground) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setBackground(background);
        button.setForeground(foreground);
        button.addActionListener(this);
        button.setFocusPainted(false);
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(background.brighter());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(background);
            }
        });
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decimalButton) {
            display.setText(display.getText().concat("."));
        }

        if (e.getSource() == addButton) {
            calculator.setNum1(Double.parseDouble(display.getText()));
            calculator.setOperator('+');
            display.setText("");
        }

        if (e.getSource() == subButton) {
            calculator.setNum1(Double.parseDouble(display.getText()));
            calculator.setOperator('-');
            display.setText("");
        }

        if (e.getSource() == mulButton) {
            calculator.setNum1(Double.parseDouble(display.getText()));
            calculator.setOperator('*');
            display.setText("");
        }

        if (e.getSource() == divButton) {
            calculator.setNum1(Double.parseDouble(display.getText()));
            calculator.setOperator('/');
            display.setText("");
        }

        if (e.getSource() == equalsButton) {
            calculator.setNum2(Double.parseDouble(display.getText()));
            try {
                double result = calculator.calculate();
                display.setText(String.valueOf(result));
            } catch (ArithmeticException | IllegalArgumentException ex) {
                display.setText("Error");
            }
        }

        if (e.getSource() == clearButton) {
            display.setText("");
        }

        if (e.getSource() == delButton) {
            String text = display.getText();
            if (text.length() > 0) {
                display.setText(text.substring(0, text.length() - 1));
            }
        }
    }

    public static void main(String[] args) {
        new GUIcalc();
    }
}
