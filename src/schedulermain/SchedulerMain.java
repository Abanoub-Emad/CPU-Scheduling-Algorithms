/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package schedulermain;

import java.util.Scanner;

public class SchedulerMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose scheduling algorithm:");
        System.out.println("1. First Come First Serve (FCFS)");
        System.out.println("2. Shortest Job First (SJF)");
        System.out.println("3. Round Robin (RR)");
        System.out.println("4. Preemptive Priority Scheduling (PPS)");
        System.out.println("5. Non-Preemptive Priority Scheduling (NPPS)");
        System.out.print("Enter your choice (1, 2, 3, 4, or 5): ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                FCFS fcfsScheduler = new FCFS();
                fcfsScheduler.runScheduler();
                break;
            case 2:
                SJF sjfScheduler = new SJF();
                sjfScheduler.runScheduler();
                break;
            case 3:
                RoundRobin rrScheduler = new RoundRobin();
                rrScheduler.runScheduler();
                break;
            case 4:
                PreemptivePriority ppsScheduler = new PreemptivePriority();
                ppsScheduler.runScheduler();
                break;
            case 5:
                NonPreemptivePriority nppsScheduler = new NonPreemptivePriority();
                nppsScheduler.runScheduler();
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
        } 
    }
}



