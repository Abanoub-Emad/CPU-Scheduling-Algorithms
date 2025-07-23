package schedulermain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class SchedulerGUI extends JFrame {
    private JComboBox<String> algorithmCombo;
    private JTextArea inputArea;
    private JButton runButton;
    private JTextArea outputArea;

    public SchedulerGUI() {
        setTitle("CPU Scheduling Algorithms");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Top panel for algorithm selection
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Algorithm:"));
        algorithmCombo = new JComboBox<>(new String[] {
            "FCFS", "SJF", "Round Robin", "Preemptive Priority", "Non-Preemptive Priority"
        });
        topPanel.add(algorithmCombo);
        add(topPanel, BorderLayout.NORTH);

        // Center panel for input
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(new JLabel("Enter processes (name,burst,arrival,priority):"), BorderLayout.NORTH);
        inputArea = new JTextArea(8, 40);
        inputArea.setText("P1,5,0,2\nP2,3,1,1\nP3,8,2,3");
        JScrollPane inputScroll = new JScrollPane(inputArea);
        centerPanel.add(inputScroll, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // Bottom panel for run button and output
        JPanel bottomPanel = new JPanel(new BorderLayout());
        runButton = new JButton("Run");
        bottomPanel.add(runButton, BorderLayout.NORTH);
        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);
        JScrollPane outputScroll = new JScrollPane(outputArea);
        bottomPanel.add(outputScroll, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        runButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runSelectedAlgorithm();
            }
        });
    }

    private void runSelectedAlgorithm() {
        String selected = (String) algorithmCombo.getSelectedItem();
        String[] lines = inputArea.getText().split("\n");
        List<ProcessInput> processes = new ArrayList<>();
        int quantum = 2; // default quantum for Round Robin
        try {
            for (String line : lines) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                String name = parts[0].trim();
                int burst = Integer.parseInt(parts[1].trim());
                int arrival = Integer.parseInt(parts[2].trim());
                int priority = parts.length > 3 ? Integer.parseInt(parts[3].trim()) : 0;
                processes.add(new ProcessInput(name, burst, arrival, priority));
            }
        } catch (Exception ex) {
            outputArea.setText("Input error: " + ex.getMessage());
            return;
        }

        StringBuilder result = new StringBuilder();
        switch (selected) {
            case "FCFS":
                FCFS fcfs = new FCFS();
                result.append(fcfs.simulate(processes));
                break;
            case "SJF":
                SJF sjf = new SJF();
                result.append(sjf.simulate(processes));
                break;
            case "Round Robin":
                String quantumStr = JOptionPane.showInputDialog(this, "Enter quantum:", quantum);
                if (quantumStr != null) {
                    try { quantum = Integer.parseInt(quantumStr.trim()); } catch (Exception ex) {}
                }
                RoundRobin rr = new RoundRobin();
                result.append(rr.simulate(processes, quantum));
                break;
            case "Preemptive Priority":
                PreemptivePriority pre = new PreemptivePriority();
                result.append(pre.simulate(processes));
                break;
            case "Non-Preemptive Priority":
                NonPreemptivePriority nonpre = new NonPreemptivePriority();
                result.append(nonpre.simulate(processes));
                break;
        }
        outputArea.setText(result.toString());
    }

    // Helper class for process input
    public static class ProcessInput {
        public String name;
        public int burst;
        public int arrival;
        public int priority;
        public ProcessInput(String name, int burst, int arrival, int priority) {
            this.name = name;
            this.burst = burst;
            this.arrival = arrival;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SchedulerGUI().setVisible(true));
    }
} 