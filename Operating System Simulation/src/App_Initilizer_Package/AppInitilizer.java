package App_Initilizer_Package;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

import ADT_Stack_Package.TaskStack;
import File_Read_Package.FileIO;
import Interfaces.IAppInitilizer;
import Linked_List_Package.LinkedList;
import Priority_Queue_Package.PriorityQueue;
import Task_Package.Task;

public class AppInitilizer implements IAppInitilizer{
	
	public void initilizeTheApp() throws Exception {
		
		FileIO read_file = new FileIO();
		int lineLength = read_file.getLengthOfFile("src/tasks.txt");
		
		String[] task_data = read_file.getDatasFromFile("src/tasks.txt");
		
		LinkedList<Task> orderedTasks = new LinkedList<>();
		
		Task[] taskArray = dataToTask(task_data, lineLength);
		
		
		// Part 1:
		for (Task task: timeSort(taskArray)) {
			orderedTasks.add(task);		
		}
		
		
		Task[] taskListArray = orderedTasks.toArray();
		
		// Part 2:
		System.out.println("Listed tasks (Sorted according to arrival time): ");
		System.out.println("------------------------------------------------");
		for (Task task: taskListArray) {
			System.out.println("Task Type: " + task.getTask_type()
			+ ", priority score: " + task.getPriority_score()
			+ ", burst time: " + task.getBurst_time()
			+ ", arrival date: " + task.getArrival_date() 
			+ ", arrival time: " + task.getArrival_time());
		}
		
		// Part 3.a :
		PriorityQueue<Task> waitingPriorityLine = new PriorityQueue<Task>();
		for (Task task : taskListArray) {
			waitingPriorityLine.add(task);
		}	
		
		// Part 3.b :
		TaskStack<Task> burstPile = new TaskStack<Task>(taskListArray.length);
		for (Task task : reverseArray(burstSort(taskArray))) {
			// Insert reverse array because stack is LIFO (Last in - first out)
			burstPile.push(task);
		}
		
		// Part 4 & 6 (waiting priority line):
		System.out.println("---------------------");
		System.out.println("Waiting priority line");
		System.out.println("---------------------");
		printTasks(waitingPriorityLine);
		System.out.println("--------------------------------------------------");
		execute(waitingPriorityLine);
		System.out.println("--------------------------------------------------");
		
		// Part 4 & 6 (Pile)
		System.out.println("----");
		System.out.println("Pile");
		System.out.println("----");
		printTasks(burstPile);
		System.out.println("---------------------------------");
		execute(burstPile);
		System.out.println("---------------------------------");
		
		System.out.println("Operations completed successfully.");
		
	}
	
	private Task[] dataToTask(String[] data, int lineLength) {
		
		// Purpose: Take the task datas and make task objects with that data.
		
		Task[] result = new Task[lineLength];
		int numberOfTask = 0;
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		for (String task : data) {
			
			StringTokenizer tokenizer = new StringTokenizer(task, ",");
			
			if (!tokenizer.hasMoreTokens()) {break;}
			
			String task_type = tokenizer.nextToken();
			int burst_time = Integer.parseInt(tokenizer.nextToken());
			
			String date = tokenizer.nextToken();
			
			LocalDate arrival_date = LocalDate.parse(date, df);
			
			LocalTime arrival_time = LocalTime.parse(tokenizer.nextToken());
			
			Task taskToAdd = new Task(task_type, burst_time, arrival_date, arrival_time);
			
			result[numberOfTask] = taskToAdd;
			numberOfTask++;
		}
		
		return result;
	}
	
	private Task[] timeSort(Task[] taskArray) {
		
		// Purpose: Sort the task array according to their arrival time.
		
		Task[] result = new Task[taskArray.length]; 
		
		for (Task taskToAdd : taskArray) {
			
			int indexToAdd = taskArray.length - 1;
			
			for (Task taskToCompare: taskArray) {
				if (taskToAdd.compareDate(taskToCompare) > 0)
					indexToAdd--;
			}
			result[indexToAdd] = taskToAdd;
		}
		
		return result;
	}
	
	private Task[] burstSort(Task[] taskArray) {
		
		// Purpose: Sort the task array according to their burst time.
		
		Task[] result = new Task[taskArray.length];
		
		for (Task taskToAdd : taskArray) {
			
			int indexToAdd = taskArray.length - 1;
			
			for (Task taskToCompare: taskArray) {
				if (taskToAdd.compareBurst(taskToCompare) > 0)
					indexToAdd--;
				else if(taskToAdd.compareBurst(taskToCompare) == 0) {
					if (taskToAdd.compareDate(taskToCompare) > 0) {indexToAdd--;}
				}
			}
			result[indexToAdd] = taskToAdd;
		}
		
		return result;
		
	}
	
	private Task[] reverseArray(Task[] taskArray){
		
		int length = taskArray.length;
		Task[] result = new Task[length];
		
		for (int index = 0; index < length; index ++) {
			int reverse_index = length - index - 1;
			result[index] = taskArray[reverse_index];
		}
		
		return result;
		
	}
	
	private void printTasks(TaskStack<Task> TS) {
		int index = 1;
		// Using reverseArray because stack is LIFO 
		for (Task task: reverseArray(TS.toArray())) {
			
			if(task == null) {break;}
			System.out.println(index + "- " +"Task Type: " + task.getTask_type() 
			+ ", priority score: " + task.getPriority_score()
			+ ", burst time: " + task.getBurst_time()
			+ ", arrival date: " + task.getArrival_date() 
			+ ", arrival time: " + task.getArrival_time());
			index++;
		}
	}
	
	private void printTasks(PriorityQueue<Task> PQ) {
		int index = 1;
		for (Task task: PQ.toArray()) {
			System.out.println(index + "- " + "Task Type: " + task.getTask_type()
			+ ", priority score: " + task.getPriority_score()
			+ ", burst time: " + task.getBurst_time()
			+ ", arrival date: " + task.getArrival_date() 
			+ ", arrival time: " + task.getArrival_time());
			index++;
		}
	}
	
	private void execute(PriorityQueue<Task> PQ) {
		
		System.out.println("Execute operation start for waiting priority line.");
		while(!PQ.isEmpty()) {
			
			if (PQ.getSize() == 1) {
				System.out.println("Last task executed successfully.");
				Task finalTask = PQ.remove();
				System.out.println("Task Type: " + finalTask.getTask_type()
				+ ", priority score: " + finalTask.getPriority_score()
				+ ", burst time: " + finalTask.getBurst_time()
				+ ", arrival date: " + finalTask.getArrival_date() 
				+ ", arrival time: " + finalTask.getArrival_time());
				break;
			}
			
			PQ.remove();
			
			if (PQ.getSize() % 5 == 0) {
				System.out.println("-----------------------------------");
				System.out.println("5 task in waiting priority line executed successfully.");
				System.out.println("Remaining tasks:");
				printTasks(PQ);
			}
		}
		
		System.out.println("Task execute operation in waiting priority line is finished.");
		
	}
	
	private void execute(TaskStack<Task> stack) throws Exception {
		
		System.out.println("Execute operation start for pile.");
		int executed = 0;
		
		while (!stack.isEmpty()) {
			
			Task ifFinal = stack.pop();
			executed++;
			
			
			if (stack.isEmpty()) {
				System.out.println("Last task executed successfully.");
				System.out.println("Task Type: " + ifFinal.getTask_type()
				+ ", priority score: " + ifFinal.getPriority_score()
				+ ", burst time: " + ifFinal.getBurst_time()
				+ ", arrival date: " + ifFinal.getArrival_date() 
				+ ", arrival time: " + ifFinal.getArrival_time());
				break;
			}
			
			if (executed == 5) {
				System.out.println("-----------------------------------");
				System.out.println("5 task in pile executed successfully.");
				System.out.println("Remaining tasks:");
				printTasks(stack);
				executed = 0;
			} 
		}
		
		System.out.println("Task execute operation in pile is finished.");
	}
} 