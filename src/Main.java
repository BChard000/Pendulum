import javax.swing.*;

class Main {
    public static void main(String[] args) {
        // Create the main window for the pendulum simulation
        JFrame frame = new JFrame("Pendulum Simulation");
        // Create the pendulum panel with an initial angle of 30 degrees
        Interface pendulumPanel = new Interface(Math.PI / 6); // 30 degrees

        // Ensure the application exits when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Add the pendulum panel to the frame
        frame.add(pendulumPanel);
        // Pack the frame's components tightly together
        frame.pack();
        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
        // Make the frame visible
        frame.setVisible(true);

        // Timer to update and repaint the pendulum at regular intervals for smooth animation
        new Timer(10, e -> {
            pendulumPanel.step();
            pendulumPanel.repaint();
        }).start();
    }
}