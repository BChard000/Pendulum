public class Pendulum {
    // Constants for the pendulum's physical properties and simulation parameters
    private static final double g = 9.81; // Acceleration due to gravity (m/s^2)
    private static final double L = 1.0; // Length of the pendulum (m)
    private static final double dt = 0.01; // Time step (s)

    // State variables for the pendulum's position and velocity
    private double theta; // Angular position (radians)
    private double omega; // Angular velocity (rad/s)

    // Constructor to initialize the pendulum with a given initial angle
    public Pendulum(double initialTheta) {
        this.theta = initialTheta;
        this.omega = 0.0;
    }

    // Update the pendulum's state based on the physics of its motion
    public void step() {
        double alpha = -(g / L) * Math.sin(theta); // Angular acceleration (rad/s^2)
        omega += alpha * dt; // Update angular velocity
        theta += omega * dt; // Update angular position
    }
}
