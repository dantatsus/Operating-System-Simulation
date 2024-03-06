package Interfaces;

public interface IFileIO {
	
	// return how many lines do we have in a txt or a csv file.
	public int getLengthOfFile(String path);
	
	// return datas from file in a String array.
	public String[] getDatasFromFile(String path);
	
}
