package Task_Package;

import java.time.LocalDate;
import java.time.LocalTime;

import Interfaces.ITask;

public class Task implements Comparable<Task>, ITask{
	
	private String task_type;
	private int burst_time;
	private LocalDate arrival_date;
	private LocalTime arrival_time;
	private int priority_score;
	
	public Task(String task_type, int burst_time, LocalDate arrival_date, LocalTime arrival_time) {
		
		this.task_type = task_type;
		this.burst_time = burst_time;
		this.arrival_date = arrival_date;
		this.arrival_time = arrival_time;
		
		// At this block, we give priority score according to their tast type.
		
		switch(task_type.charAt(0)) {
			case 's' -> priority_score = 6;
			case 'p' -> priority_score = 5;
			case 'm' -> priority_score = 4;
			case 'u' -> priority_score = 3;
			case 'd' -> priority_score = 2;
			case 'f' -> priority_score = 1;
		}
		
	}
	
	public String getTask_type() {
		return task_type;
	}

	public int getBurst_time() {
		return burst_time;
	}

	public LocalDate getArrival_date() {
		return arrival_date;
	}

	public LocalTime getArrival_time() {
		return arrival_time;
	}
	
	public int getPriority_score() {
		return priority_score;
	}

	// Comparing according to their priority score and date/time.
	@Override
	public int compareTo(Task task) {
		
		int task_score = task.getPriority_score();
		
		if (priority_score > task_score) {return 1;}
		
		else if (priority_score < task_score) {return -1;}
		
		else {return compareDate(task);}
		
	}
	
	public int compareDate(Task task) {
		
		// Priority : earliest to latest.
		
		if (arrival_date.isBefore(task.getArrival_date())) {return 1;}    		// isBefore
		
		else if (arrival_date.isAfter(task.getArrival_date())) {return -1;}		// isAfter
		
		else {																	// if dates are same,
																				// Comparing times
			if (arrival_time.isBefore(task.getArrival_time())) {return 1;}
			
			else if (arrival_date.isAfter(task.getArrival_date())) {return -1;}
			
			else {return 0;}
		}
		
	}
	
	public int compareBurst(Task task) {
		
		if (burst_time > task.getBurst_time()) {return 1;}
		
		else if (burst_time < task.getBurst_time()) {return -1;}
		
		else {return 0;}
		
	}
		
}
