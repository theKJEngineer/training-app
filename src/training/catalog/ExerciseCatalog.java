package training.catalog;

public class ExerciseCatalog {
    private ExerciseTemplate[] exercises; // storage array
    private int count;                    // how many items are used

    public ExerciseCatalog(int size) {
        // default capacity if invalid size provided
        if (size <= 0) {
            size = 100;
        }
        this.exercises = new ExerciseTemplate[size];
        this.count = 0;
        System.out.println("Catalog of " + size + " exercises created.");
    }

    public void addExercise(ExerciseTemplate e) {
        if (e == null) {
            System.out.println("Cannot add null exercise");
            return;
        }
        if (count >= exercises.length) {
            System.out.println("Catalog is full");
            return;
        }
        // reject duplicates by name
        for (int i = 0; i < count; i++) {
            if (exercises[i].getName().equalsIgnoreCase(e.getName())) {
                System.out.println("Exercise with this name already exists");
                return;
            }
        }

        exercises[count] = e;
        count++;
        System.out.println("Exercise added.");
    }

    public void showAll() {
        System.out.println("Available exercises:");
        if (count == 0) {
            System.out.println("(empty)");
            return;
        }
        for (int i = 0; i < count; i++) {
            // short listing: index, name, muscle group
            System.out.println((i + 1) + ") " + exercises[i].getName()
                    + " — " + exercises[i].getMuscleGroup());
            // or, if you prefer full details:
            // exercises[i].info();
        }
        System.out.println("Total: " + count);
    }

    public ExerciseTemplate getByName(String name) {
        if (name == null) return null;
        for (int i = 0; i < count; i++) {
            if (name.equalsIgnoreCase(exercises[i].getName())) {
                return exercises[i];
            }
        }
        return null; // not found
    }
}
