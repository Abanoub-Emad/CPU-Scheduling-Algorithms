# CPU-Scheduling-Algorithms

# CPU Scheduling Algorithms Visualizer

A **Java GUI-based project** that simulates and visualizes multiple CPU scheduling algorithms.  
This project was developed as part of an **Operating Systems course** assignment to help demonstrate how different CPU schedulers operate and affect process execution order and waiting time.

## 🧠 Features

- Graphical User Interface built with Java Swing
- Visual and step-by-step simulation of:
  - **FCFS (First-Come First-Served)**
  - **SJF (Shortest Job First)**
  - **Round Robin**
  - **Non-Preemptive Priority**
  - **Preemptive Priority**
- Displays key metrics like:
  - Gantt chart
  - Average waiting time
  - Turnaround time
  - CPU utilization

## 📌 Technologies Used

- Java
- Swing (for GUI)
- NetBeans (optional for building/running)

## 📷 Demo Screenshots

<img width="584" height="461" alt="CPU Scheduling Algorithms" src="https://github.com/user-attachments/assets/387d81f0-011e-4f21-9f17-7986144804c4" />

![Screenshot ](https://github.com/user-attachments/assets/c5a389a8-af0e-4dda-9a2d-a3fcac4e5162)

## 📁 Project Structure

```

CPU-Scheduling-Algorithms/
├── src/
│   └── schedulermain/
│       ├── FCFS.java
│       ├── SJF.java
│       ├── RoundRobin.java
│       ├── NonPreemptivePriority.java
│       ├── PreemptivePriority.java
│       ├── SchedulerGUI.java
│       └── SchedulerMain.java
├── build.xml
├── manifest.mf
└── README.md

````

## 📚 How to Run

1. Clone the repository:

   git clone https://github.com/Abanoub-Emad/CPU-Scheduling-Algorithms.git
   cd CPU-Scheduling-Algorithms
````

2. Compile and run the application:

   * Using an IDE (like **NetBeans** or **IntelliJ**)
   * Or from terminal:


     javac src/schedulermain/*.java
     java schedulermain.SchedulerMain


> Make sure you have Java 8+ installed.

## 🧑‍💻 Author

**Abanoub Emad**
[GitHub Profile](https://github.com/Abanoub-Emad)
