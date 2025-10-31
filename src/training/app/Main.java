package training.app;

import training.catalog.ExerciseCatalog;
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
    }
}