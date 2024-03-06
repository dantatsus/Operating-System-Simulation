package Interfaces;

import java.time.LocalDate;
import java.time.LocalTime;

import Task_Package.Task;

public interface ITask extends Comparable<Task>{
	
	// Getters
	public String getTask_type();
	public int getBurst_time();
	public LocalDate getArrival_date();
	public LocalTime getArrival_time();
	public int getPriority_score();
	
	// Compare methods
	public int compareTo(Task task);
	public int compareDate(Task task);
	public int compareBurst(Task task);
	
	
}
