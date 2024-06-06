import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HRISGUI extends JFrame {
    private JFrame frame;

    private JComboBox<String> departmentComboBox;
    private JTextField nameField;
    private JTextField birthDateField;
    private JComboBox<String> positionComboBox;
    private JButton addEmployeeButton;
    private JButton cancelButton;

    private JTextArea displayArea;
    private JTextField findIdField;

    private JButton addButton;
    private JButton showAllButton;
    private JButton backButton;

    private List<Employee> employees;

    public HRISGUI() {
        employees = new ArrayList<>();
        frame = new JFrame("HRIS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(showMainPanel(), BorderLayout.CENTER);
        frame.pack();
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    private JPanel showMainPanel() {
        addButton = new JButton("Add Data");
        showAllButton = new JButton("Show Data");

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.add(addButton);
        buttonPanel.add(showAllButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintPanel(showInputPanel());
            }
        });

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintPanel(showAllDataPanel());
            }
        });

        return buttonPanel;
    }

    private JPanel showAllDataPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        cancelButton = new JButton("Back to Main Menu");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintPanel(showMainPanel());
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(cancelButton);

        displayArea = new JTextArea(15, 50);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        updateDisplayArea();

        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private void updateDisplayArea() {
        StringBuilder strBuilder = new StringBuilder();
        for (Employee emp : employees) {
            strBuilder.append(emp.toString()).append("\n");
        }
        if (displayArea != null) {
            displayArea.setText(strBuilder.toString());
        }
    }

    private void repaintPanel(JPanel newPanel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(newPanel);
        frame.revalidate();
        frame.repaint();
    }

    private JPanel showInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(7, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(15);

        JLabel birthDateLabel = new JLabel("Birth Date (DD-MM-YYYY):");
        birthDateField = new JTextField(10);

        JLabel departmentLabel = new JLabel("Department:");
        String[] departments = Employee.getDepartment();
        departmentComboBox = new JComboBox<>(departments);

        JLabel positionLabel = new JLabel("Position:");
        String[] positions = {"Manager", "Developer", "HR Staff"};
        positionComboBox = new JComboBox<>(positions);

        addEmployeeButton = new JButton("Add Data");
        backButton = new JButton("Back to Main Menu");

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(birthDateLabel);
        inputPanel.add(birthDateField);
        inputPanel.add(departmentLabel);
        inputPanel.add(departmentComboBox);
        inputPanel.add(positionLabel);
        inputPanel.add(positionComboBox);
        inputPanel.add(addEmployeeButton);
        inputPanel.add(backButton);

        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String birthDate = birthDateField.getText();
                String department = departmentComboBox.getSelectedItem().toString();
                String position = positionComboBox.getSelectedItem().toString();

                Employee employee = null;
                switch (position) {
                    case "Manager":
                        employee = new Manager(name, birthDate, department);
                        break;
                    case "Developer":
                        employee = new Developer(name, birthDate, department);
                        break;
                    case "HR Staff":
                        employee = new HRStaff(name, birthDate, department);
                        break;
                }

                if (employee != null) {
                    employees.add(employee);
                    JOptionPane.showMessageDialog(HRISGUI.this, "Employee added: " + employee.toString());
                } else {
                    JOptionPane.showMessageDialog(HRISGUI.this, "Error adding employee.");
                }

                // Clear input fields after adding
                nameField.setText("");
                birthDateField.setText("");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintPanel(showMainPanel());
            }
        });

        return inputPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HRISGUI();
            }
        });
    }
}
