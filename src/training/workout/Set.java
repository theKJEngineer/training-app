package training.workout;

/**
 * Represents a single exercise set (number of reps and weight used)
 */

public class Set {
    private int reps;
    private double weight;

    /**
     * Creates a new set with given reps and weight.
     * If invalid values are provided, defaults are applied.
     */

    public Set(int reps, double weight) {
        this.reps = reps;
        this.weight = weight;
        if (reps <= 0) {
            System.out.println("Reps must be greater than 0. Set to 1 by default.");
            this.reps = 1;
        }
        if (weight <= 0) {
            System.out.println("Weight must be greater than 0. Set to 0 by default.");
            this.weight = 0;
        }

    }

    public int getReps() {
        return this.reps;
    }

    public double getWeight() {
        return this.weight;
    }

    // prints set details
    public void info() {
        System.out.println(reps + " reps x " + weight + " kg");
    }

    public double totalWeight() {
        return this.reps * this.weight;
    }
}
