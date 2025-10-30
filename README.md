# 🏋️‍♂️ Training App (Java)

A simple **console-based training tracker** written in **Java**.  
This is an **educational project** created to learn and practice **Object-Oriented Programming (OOP)** concepts step by step — without using frameworks or collections.

---

## ⚙️ Overview

The app allows you to:
- Add and view exercises  
- Create workouts with multiple exercises  
- Track sets (reps, weight)  
- Store and view workout history  

Currently, it’s a console program focused on OOP learning.  
In the future, it will include:
- 🖥️ **Swing GUI interface**  
- 🗄️ **Database integration** for saving workouts  

---

## 🧩 Structure

src/
└── training/
    ├── app/
    │   └── Main.java                // Entry point
    ├── catalog/
    │   ├── ExerciseTemplate.java    // Exercise blueprint (name, muscleGroup, description)
    │   └── ExerciseCatalog.java     // Read-only list of available exercises
    ├── workout/
    │   ├── Set.java                 // Single set (reps, weight [, restSeconds, rpe])
    │   ├── Exercise.java            // Performed exercise (name, muscleGroup, sets[])
    │   └── Workout.java             // Whole workout (exercises[], date)
    └── history/
        └── WorkoutHistory.java      // Stores completed workouts


## 🧰 How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/<your-username>/training-app.git


Open the project in IntelliJ IDEA

Go to File → Open...

Select the project folder

Build and Run

Navigate to: src/training/app/Main.java

Right-click the file → Run 'Main.main()'

Expected Output

Exercise name: Squat
Muscle group: Legs
Exercise Description: Basic lower-body exercise
