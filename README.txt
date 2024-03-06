Operating System Simulation
This project entails the implementation of an "Operating System Simulation" in Java, where tasks are managed and executed based on their arrival dates, priorities, and burst times. The simulation aims to emulate the behavior of an operating system in scheduling and executing tasks efficiently.

Project Overview
The Operating System Simulation manages a set of tasks with varying priorities and burst times. Tasks arrive at the system with specific arrival dates and times, and they are prioritized based on their importance and urgency. The simulation implements two different execution orderings for the tasks:

Priority-Based Ordering: Tasks are sorted according to their arrival time and priority. Higher priority tasks are executed first, with priority taking precedence over arrival time.
Burst Time-Based Ordering: Tasks are sorted according to their arrival time and shortest burst time. Tasks with shorter burst times are executed first, with arrival time breaking ties.
The project involves reading task properties from a file ("tasks.txt"), creating a list of tasks ordered by arrival time, and managing waiting lines based on priority and burst time.

Implementation Details
Task Initialization: Read task properties from the "tasks.txt" file, including task type, burst time, arrival date, and arrival time. Store tasks in a list ordered by their arrival time.

Print Listed Tasks: Display the tasks with their names, burst times, and arrival times.

Waiting Line and Waiting Pile Creation:

Waiting Priority Line: Organize tasks based on their priority, considering both priority and arrival time. Tasks with higher priority are executed first, with priority taking precedence over arrival time.
Waiting Burst Time Pile: Organize tasks based on their burst times, with tasks having shorter burst times prioritized. Arrival time breaks ties if burst times are equal.
Print Waiting Lines:

Print the waiting priority line, displaying tasks in order of execution time with all their information.
Print the waiting burst time pile, showing tasks in order of execution time with all their information.
Handling Task Termination:

Ensure that if a task terminates unexpectedly before execution, the next available task gets its turn. Priority is maintained in determining the next task.
Printing Remaining Tasks:

After every 5 executions, print the remaining tasks in both the waiting priority line and waiting burst time pile.

Conclusion
The Operating System Simulation project provides a comprehensive emulation of task scheduling and execution in an operating system environment. By implementing priority-based and burst time-based ordering, the simulation offers insights into task management strategies and their impact on system efficiency.

For any inquiries or feedback, please contact the project maintainers.

Contact Information
For inquiries, feedback, or collaboration opportunities, please reach out to the project maintainers:

Project Maintainer: Mustafa Sahin
Email: dantatsus@gmail.com or mustafasahin@std.iyte.edu.tr