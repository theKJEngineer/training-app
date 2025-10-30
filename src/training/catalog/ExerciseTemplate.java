package training.catalog;

public class ExerciseTemplate {
    private String name;
    private String muscleGroup;
    private String description;

    public ExerciseTemplate(String name, String muscleGroup, String description) {
        this.name = name;
        this.muscleGroup = muscleGroup;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public String getDescription() {
        return description;
    }

    public void info() {
        System.out.println("Exercise name: " + this.name);
        System.out.println("Muscle group: " + this.muscleGroup);
        System.out.println("Exercise Description: " + this.description);
    }
}
