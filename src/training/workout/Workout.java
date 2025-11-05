package training.workout;

/**
 * Represents a specific exercise performed during a workout.
 * It links an ExerciseTemplate to a list of actual Sets.
 */


public class Workout {
    private Exercise[] exercises;
    private int exerciseCount;
    private String name;
    private String date;

    public Workout (String name, String date, int maxExercises) {
        this.name = name;
        this.date = date;
        this.exercises = new Exercise[maxExercises];
        exerciseCount = 0;
    }

    public void addExercise(Exercise e) {
        if (exerciseCount >= exercises.length ) {
            System.out.println("Too much exercises.");
            return;
        }
        exercises[exerciseCount] = e;
        exerciseCount++;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public void showWorkoutDetails() {
        System.out.println("Your workout:");
        System.out.println(getName());
        System.out.println(getDate());
        for (int i = 0; i < exerciseCount; i++) {
            exercises[i].showExercise();
        }
    }

    public double calculateTotalWorkoutWeight() {
        double totalWeight = 0;
        for (int i = 0; i < exerciseCount; i++) {
            totalWeight = totalWeight + exercises[i].getTotalWeight();
        }
        return totalWeight;
    }
}
