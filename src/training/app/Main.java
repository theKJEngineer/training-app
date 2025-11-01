package training.app;

import training.catalog.ExerciseCatalog;
import training.catalog.ExerciseTemplate;
import training.workout.Exercise;
import training.workout.Set;


public class Main {
    public static void main(String[] args) {

        // test for class ExerciseTemplate:
        // Create example exercise templates
        ExerciseTemplate exerciseTemplate = new ExerciseTemplate
                ("Squad", "Legs", "Improves leg power and stability");

        ExerciseTemplate exerciseTemplate2 = new ExerciseTemplate
                ("Bench Press", "Chest", "Develops chest, shoulders, and triceps");

        exerciseTemplate.info();
        System.out.println(" ");
        exerciseTemplate2.info();

        // test for class Exercise catalog:
        // create catalog,
        ExerciseCatalog catalog = new ExerciseCatalog(5);
        // add templates
        ExerciseTemplate squat = new ExerciseTemplate("Squat", "Legs", "Basic lower-body exercise");
        ExerciseTemplate bench = new ExerciseTemplate("Bench Press", "Chest", "Push exercise for chest");

        catalog.addExercise(squat);
        catalog.addExercise(bench);

        //list
        catalog.showAll();

        // search
        ExerciseTemplate found = catalog.getByName("Squat");

        // validations
        catalog.addExercise(null);


        // test for class Set

        Set s1 = new Set(10, 60);
        s1.info();
        System.out.println("Total weight: " + s1.totalWeight());
        System.out.println();

        Set s2 = new Set(-5, 40);
        s2.info();
        System.out.println("Total weight: " + s2.totalWeight());
        System.out.println();

        // test for class Exercise

        // Test: create exercise and add sets
        ExerciseTemplate bench = new ExerciseTemplate(
                "Bench Press", "Chest", "Barbell press for chest strength"
        );

        Exercise benchExercise = new Exercise(bench, 3);

        benchExercise.addSet(new Set(10, 60));
        benchExercise.addSet(new Set(8, 65));

        benchExercise.showExercise();

        System.out.println("Total weight: " + benchExercise.getTotalWeight());

    }
}