import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Reader {

	private String line;
	private List<Instance> dataset;
	
	public Reader(String filename){
		dataset = new ArrayList<Instance>();
		readFile(filename);
	}
	
	private void readFile(String filename){
		File f = new File(filename);
		try{
			Scanner s = new Scanner(f);
			while(s.hasNext()){
				line = s.nextLine();
				extractInstance(line);
				
			}
			
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	private void extractInstance(String line){
		String[] s = line.split(",");
		if(s.length != 1290){
			System.out.println("invalid attributes amount");
		}
		else{
			String name = s[0];
			String party = s[1];
			String[] votes = new String[1288];
			System.arraycopy(s, 2, votes, 0, votes.length);
			dataset.add(new Instance(name, party, votes));
		}
	}
	
	public Dataset getDataset(){
		return new Dataset(dataset);
	}
	
}
