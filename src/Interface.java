import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Interface extends JPanel {
    // Pendulum properties for visualization
    private static final double L = 100.0; // Length of the pendulum (pixels)
    private double theta; // Angular position (radians)

    // Simulation properties for the physics calculations
    private static final double g = 9.81; // Acceleration due to gravity (m/s^2)
    private static final double dt = 0.1; // Time step (seconds)
    private double omega; // Angular velocity (rad/s)

    // Constructor to initialize the interface with a given initial angle
    public Interface(double initialTheta) {
        this.theta = initialTheta;
        this.omega = 0.0;
        setPreferredSize(new Dimension(400, 300));
        setBackground(Color.WHITE);
    }

    // Update the state of the pendulum based on its physics
    public void step() {
        // Calculate angular acceleration and update angular velocity and position
        double alpha = -(g / L) * Math.sin(theta); // Angular acceleration (rad/s^2)
        omega += alpha * dt;
        theta += omega * dt;
    }

    // Paint method to draw the pendulum on the panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Calculate the pendulum's end point based on its current angle
        int originX = getWidth() / 2;
        int originY = 50;
        int endX = originX + (int) (L * Math.sin(theta));
        int endY = originY + (int) (L * Math.cos(theta));

        // Draw the pendulum
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(originX, originY, endX, endY);
        g2d.fill(new Ellipse2D.Double(endX - 10, endY - 10, 20, 20));
    }
}
