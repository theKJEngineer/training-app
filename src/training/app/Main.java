package training.app;

import training.catalog.ExerciseTemplate;

public class Main {
    public static void main(String[] args) {

        // Create example exercise templates
        ExerciseTemplate exerciseTemplate = new ExerciseTemplate
                ("Squad", "Legs", "Improves leg power and stability");

        ExerciseTemplate exerciseTemplate2 = new ExerciseTemplate
                ("Bench Press", "Chest", "Develops chest, shoulders, and triceps");

        exerciseTemplate.info();
        System.out.println(" ");
        exerciseTemplate2.info();

    }
}