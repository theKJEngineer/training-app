package training.workout;

import training.catalog.ExerciseTemplate;

// Represents a specific exercise performed during a workout
public class Exercise {
    private ExerciseTemplate template;
    private Set[] sets;
    private int setCount;

    // Creates an exercise based on a template and maximum number of sets
    public Exercise(ExerciseTemplate template, int maxSets) {
        if (template == null) {
            System.out.println("Error: exercise template cannot be null. Exercise not created.");
            return;
        }
        if (maxSets <= 0) {
            System.out.println("Invalid number of sets. Default value of 5 will be used.");
            maxSets = 5;
        }
        this.template = template;
        this.sets = new Set[maxSets];
        this.setCount = 0;
    }

    // Adds a new set to this exercise (if space available)
    public void addSet(Set set) {
        if (set == null) {
            System.out.println("Error: cannot add null set.");
            return;
        }
        if (this.setCount >= sets.length ) {
            System.out.println("Cannot add more sets. Exercise is full.");
            return;
        }
        this.sets[this.setCount] = set;
        this.setCount++;
        System.out.println("Set added successfully.");
    }

    // Displays information about the exercise and all its sets
    public void showExercise() {
        if (this.template == null) {
            System.out.println("Error: exercise template missing.");
            return;
        }
        if (this.setCount == 0) {
            System.out.println("No sets added yet.");
            return;
        }
        System.out.println("--- Exercise Details ---");
        template.info();
        for (int i = 0; i < setCount; i++) {
            System.out.println("Set " + (i + 1) + ":");
            sets[i].info();
        }
        System.out.println("------------------------");
    }

    // Calculates total lifted weight in this exercise
    public double getTotalWeight() {
        double total = 0;
        if (this.setCount == 0) {
            System.out.println("No sets to calculate.");
            return 0;
        }
        for (int i = 0; i < this.setCount; i++) {
            total += this.sets[i].totalWeight();
        }
        return total;
    }
}
