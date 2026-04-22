package user_code;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.OutputStream;
import java.io.PrintStream;

// Ensure these imports match your project structure
import feature_five.Student;
import feature_five.Student_queue;
import feature_four.Manager;
import feature_one.Found_lost_list;
import feature_one.Lost_item;
import feature_six.Locker;
import feature_six.Locker_bst;
import feature_three.Graph_list;
import feature_two.RoomBookingQueue;
import feature_two.RoomRequest;

public class ManagementSystemGUI extends JFrame {

    // Backend System Instances
    private Found_lost_list lostFound = new Found_lost_list();
    private RoomBookingQueue bookingQueue = new RoomBookingQueue();
    private Graph_list campusGraph = new Graph_list(10);
    private Manager undoRedo = new Manager();
    private Student_queue eventQueue = new Student_queue();
    private Locker_bst lockerTree = new Locker_bst();

    // UI Components
    private JTextArea consoleOutput;

    public ManagementSystemGUI() {
        setTitle("University Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create main tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 14));

        // Add tabs
        tabbedPane.addTab("Lost & Found", createLostFoundPanel());
        tabbedPane.addTab("Room Booking", createRoomBookingPanel());
        tabbedPane.addTab("Event Reg", createEventPanel());
        tabbedPane.addTab("Locker Allocation", createLockerPanel());
        // Note: Graph and Undo/Redo tabs follow the exact same pattern and can be added here.

        add(tabbedPane, BorderLayout.CENTER);

        // Setup Application Console Output
        consoleOutput = new JTextArea();
        consoleOutput.setEditable(false);
        consoleOutput.setFont(new Font("Monospaced", Font.PLAIN, 12));
        consoleOutput.setBackground(Color.BLACK);
        consoleOutput.setForeground(Color.GREEN);
        
        JScrollPane scrollPane = new JScrollPane(consoleOutput);
        scrollPane.setPreferredSize(new Dimension(800, 200));
        scrollPane.setBorder(BorderFactory.createTitledBorder("System Logs"));
        add(scrollPane, BorderLayout.SOUTH);

        // Redirect System.out to the JTextArea
        redirectSystemStreams();
    }

    private JPanel createLostFoundPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JTextField descField = new JTextField(20);
        JTextField dateField = new JTextField(20);
        JTextField locField = new JTextField(20);
        JButton submitBtn = new JButton("Report Lost Item");

        gbc.gridx = 0; gbc.gridy = 0; panel.add(new JLabel("Description:"), gbc);
        gbc.gridx = 1; panel.add(descField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panel.add(new JLabel("Date:"), gbc);
        gbc.gridx = 1; panel.add(dateField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panel.add(new JLabel("Location:"), gbc);
        gbc.gridx = 1; panel.add(locField, gbc);

        gbc.gridx = 1; gbc.gridy = 3; panel.add(submitBtn, gbc);

        submitBtn.addActionListener(e -> {
            String desc = descField.getText();
            String date = dateField.getText();
            String loc = locField.getText();
            
            if(!desc.isEmpty() && !date.isEmpty() && !loc.isEmpty()) {
                lostFound.addItem(new Lost_item(desc, date, loc));
                System.out.println("Item added successfully.");
                lostFound.displayItems();
                
                // Clear fields
                descField.setText(""); dateField.setText(""); locField.setText("");
            } else {
                System.out.println("Error: All fields must be filled.");
            }
        });

        return panel;
    }

    private JPanel createRoomBookingPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JTextField nameField = new JTextField(20);
        JTextField roomField = new JTextField(20);
        JTextField timeField = new JTextField(20);
        JTextField priorityField = new JTextField(20);
        JButton submitBtn = new JButton("Book Room");

        gbc.gridx = 0; gbc.gridy = 0; panel.add(new JLabel("Student Name:"), gbc);
        gbc.gridx = 1; panel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panel.add(new JLabel("Room Number:"), gbc);
        gbc.gridx = 1; panel.add(roomField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panel.add(new JLabel("Time:"), gbc);
        gbc.gridx = 1; panel.add(timeField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3; panel.add(new JLabel("Priority (1=High):"), gbc);
        gbc.gridx = 1; panel.add(priorityField, gbc);

        gbc.gridx = 1; gbc.gridy = 4; panel.add(submitBtn, gbc);

        submitBtn.addActionListener(e -> {
            try {
                String name = nameField.getText();
                String room = roomField.getText();
                String time = timeField.getText();
                int priority = Integer.parseInt(priorityField.getText());
                
                bookingQueue.addRequest(new RoomRequest(name, room, time, priority));
                System.out.println("Room request submitted.");
                bookingQueue.displayRequests();
                
                nameField.setText(""); roomField.setText(""); timeField.setText(""); priorityField.setText("");
            } catch (NumberFormatException ex) {
                System.out.println("Error: Priority must be a valid number.");
            }
        });

        return panel;
    }

    private JPanel createEventPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JTextField nameField = new JTextField(20);
        JTextField eventField = new JTextField(20);
        JButton submitBtn = new JButton("Register for Event");

        gbc.gridx = 0; gbc.gridy = 0; panel.add(new JLabel("Student Name:"), gbc);
        gbc.gridx = 1; panel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panel.add(new JLabel("Event Name:"), gbc);
        gbc.gridx = 1; panel.add(eventField, gbc);

        gbc.gridx = 1; gbc.gridy = 2; panel.add(submitBtn, gbc);

        submitBtn.addActionListener(e -> {
            String name = nameField.getText();
            String event = eventField.getText();
            if(!name.isEmpty() && !event.isEmpty()) {
                eventQueue.register(new Student(name, event));
                System.out.println("Student registered for event.");
                eventQueue.showQueue();
                nameField.setText(""); eventField.setText("");
            }
        });

        return panel;
    }

    private JPanel createLockerPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JTextField idField = new JTextField(20);
        JTextField lockerField = new JTextField(20);
        
        JButton assignBtn = new JButton("Assign Locker");
        JButton searchBtn = new JButton("Search by ID");
        JButton displayBtn = new JButton("Display All");

        gbc.gridx = 0; gbc.gridy = 0; panel.add(new JLabel("Student ID:"), gbc);
        gbc.gridx = 1; panel.add(idField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panel.add(new JLabel("Locker Number:"), gbc);
        gbc.gridx = 1; panel.add(lockerField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(assignBtn);
        buttonPanel.add(searchBtn);
        buttonPanel.add(displayBtn);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; 
        panel.add(buttonPanel, gbc);

        assignBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String locker = lockerField.getText();
                lockerTree.insert(new Locker(id, locker));
                System.out.println("Locker assigned to ID: " + id);
            } catch (NumberFormatException ex) {
                System.out.println("Error: Student ID must be a number.");
            }
        });

        searchBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                System.out.println("Searching for ID: " + id + "...");
                lockerTree.search(id);
            } catch (NumberFormatException ex) {
                System.out.println("Error: Student ID must be a number.");
            }
        });

        displayBtn.addActionListener(e -> {
            System.out.println("--- All Locker Assignments ---");
            lockerTree.displayInOrder();
        });

        return panel;
    }

    // Helper method to catch your backend System.out.println calls and show them in the UI
    private void redirectSystemStreams() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) {
                updateConsole(String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) {
                updateConsole(new String(b, off, len));
            }
        };
        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }

    private void updateConsole(final String text) {
        SwingUtilities.invokeLater(() -> {
            consoleOutput.append(text);
            // Auto-scroll to the bottom
            consoleOutput.setCaretPosition(consoleOutput.getDocument().getLength());
        });
    }

    public static void main(String[] args) {
        // Run GUI on the Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(() -> {
            ManagementSystemGUI gui = new ManagementSystemGUI();
            gui.setVisible(true);
        });
    }
}