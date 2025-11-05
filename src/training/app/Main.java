package training.app;

import training.catalog.ExerciseCatalog;
import training.catalog.ExerciseTemplate;
import training.workout.Exercise;
import training.workout.Set;
import training.workout.Workout; // Required import for the full test

public class Main {
    public static void main(String[] args) {

        // --- Tests: ExerciseTemplate ---
        System.out.println("--- Tests: ExerciseTemplate ---");
        ExerciseTemplate exerciseTemplate = new ExerciseTemplate
                ("Squad", "Legs", "Improves leg power and stability");
        ExerciseTemplate exerciseTemplate2 = new ExerciseTemplate
                ("Bench Press", "Chest", "Develops chest, shoulders, and triceps");
        exerciseTemplate.info();
        System.out.println();
        exerciseTemplate2.info();

        // --- Tests: ExerciseCatalog ---
        System.out.println("\n--- Tests: ExerciseCatalog ---");
        ExerciseCatalog catalog = new ExerciseCatalog(5);
        ExerciseTemplate squat = new ExerciseTemplate("Squat", "Legs", "Basic lower-body exercise");
        ExerciseTemplate bench = new ExerciseTemplate("Bench Press", "Chest", "Push exercise for chest");
        catalog.addExercise(squat);
        catalog.addExercise(bench);
        catalog.showAll();
        System.out.println("Test: adding 'null'");
        catalog.addExercise(null);
        System.out.println("Test: finding 'Squat'");
        ExerciseTemplate found = catalog.getByName("Squat");
        if (found != null) {
            System.out.println("Found: " + found.getName());
        }

        // --- Tests: Set ---
        System.out.println("\n--- Tests: Set ---");
        Set s1 = new Set(10, 60);
        s1.info();
        System.out.println("Total weight: " + s1.totalWeight());
        System.out.println();
        System.out.println("Test: invalid 'reps' (-5) and 'weight' (-40)");
        Set s2 = new Set(-5, -40); // Should correct to 1 rep and 0 kg
        s2.info();
        System.out.println("Total weight: " + s2.totalWeight());

        // --- Tests: Exercise (Basic) ---
        System.out.println("\n--- Tests: Exercise (Basic) ---");
        ExerciseTemplate bp = new ExerciseTemplate(
                "Bench Press", "Chest", "Barbell press for chest strength"
        );
        Exercise benchExercise = new Exercise(bp, 3); // Limit of 3 sets
        benchExercise.addSet(new Set(10, 60)); // Set 1
        benchExercise.addSet(new Set(8, 65));  // Set 2
        benchExercise.showExercise();
        System.out.println("Total weight: " + benchExercise.getTotalWeight());

        // --- Additional Tests: Exercise ---
        System.out.println("\n--- Additional Tests: Exercise ---");

        // Test 4: Test overflow (Limit was 3)
        System.out.println("\n--- Test 4: Set overflow (limit 3) ---");
        benchExercise.addSet(new Set(5, 70)); // Set 3 (OK)
        System.out.println("Attempting to add 4th set (should fail):");
        benchExercise.addSet(new Set(5, 75)); // Set 4 (ERROR)
        benchExercise.showExercise(); // Should only show 3 sets

        // Test 5: Invalid constructor args (maxSets = 0)
        System.out.println("\n--- Test 5: Invalid maxSets (should default to 5) ---");
        Exercise exercise2 = new Exercise(bp, 0); // Should default to 5 sets
        exercise2.addSet(new Set(1, 10));
        exercise2.addSet(new Set(1, 10));
        exercise2.addSet(new Set(1, 10));
        exercise2.addSet(new Set(1, 10));
        exercise2.addSet(new Set(1, 10)); // Set 5 (OK)
        System.out.println("Attempting to add 6th set (should fail):");
        exercise2.addSet(new Set(1, 10)); // Set 6 (ERROR)

        // Test 6: Add 'null' set
        System.out.println("\n--- Test 6: Attempting to add 'null' set ---");
        benchExercise.addSet(null); // Should show error "Cannot add null set"

        // Test 7: Weight for empty exercise
        System.out.println("\n--- Test 7: Weight for empty exercise ---");
        Exercise exercise3 = new Exercise(bp, 5);
        double emptyTotal = exercise3.getTotalWeight(); // Should show "No sets to calculate"
        System.out.println("Expected: 0.0, Calculated: " + emptyTotal);
        if (emptyTotal == 0.0) System.out.println("STATUS: OK");
        else System.out.println("STATUS: ERROR");

        // --- Tests: Workout (Full Integration) ---
        System.out.println("\n--- Tests: Workout (Full Integration) ---");
        Workout myWorkout = new Workout("Full Body A", "2025-11-05", 3);

        // Add the benchExercise we already made (with its 3 sets)
        myWorkout.addExercise(benchExercise);

        // Create and add a Squat exercise
        Exercise squatExercise = new Exercise(catalog.getByName("Squat"), 5);
        squatExercise.addSet(new Set(10, 80));
        squatExercise.addSet(new Set(8, 100));
        myWorkout.addExercise(squatExercise);

        // Show full workout summary
        myWorkout.showWorkoutDetails();

        // Show total workout volume
        double totalVolume = myWorkout.calculateTotalWorkoutWeight();
        System.out.println("--- Workout Volume ---");
        System.out.println("Total Workout Volume: " + totalVolume + " kg");

        System.out.println("\n--- All tests finished ---");
    }
}