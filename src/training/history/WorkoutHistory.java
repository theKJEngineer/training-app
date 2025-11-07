package training.history;

import training.workout.Workout;

/**
 * Stores a user's workout history.
 */

public class WorkoutHistory {
    private Workout[] workouts;
    private int workoutCount;
    private String userName;

    public WorkoutHistory (String userName, int maxHistorySize) {
        this.workouts = new Workout[maxHistorySize];
        this.userName = userName;
        this.workoutCount = 0;
    }


    //Adds a completed workout to the history.
    public void addWorkout (Workout workout) {
        if (workout == null) {
            System.out.println("Error: Cannot add null workout to history.");
            return;
        }
        if (this.workoutCount < workouts.length) {
            this.workouts[workoutCount] = workout;
            this.workoutCount++;
        } else {
            System.out.println("History is full. Cannot add more workouts.");
        }
    }


    // Displays a summary list of all workouts.
    public void showHistorySummary() {
        if (this.workoutCount == 0) {
            System.out.println("History is empty.");
            return;
        }
        System.out.println("--- Workout History for: " + this.userName + " ---");
        for (int i = 0; i < this.workoutCount; i++) {
            System.out.println((i + 1) + ". " + workouts[i].getDate() + " - " + workouts[i].getName());
        }
    }


    // Finds and displays details for workouts on a specific date.
    public void showWorkoutDetailsByDate(String date) {
        boolean found = false;
        for (int i = 0; i < this.workoutCount; i++) {
            if (this.workouts[i].getDate().equals(date)) {
                this.workouts[i].showWorkoutDetails();
                found = true;
                System.out.println();
            }
        }
        if (!found) {
            System.out.println("No workout found for date: " + date);
        }
    }


    // Finds and returns a workout from a specific date.
    public Workout getWorkoutByDate(String date) {
        for (int i = 0; i < this.workoutCount; i++) {
            if (this.workouts[i].getDate().equals(date)) {
                return workouts[i];
            }
        }

        return null;
    }
}
