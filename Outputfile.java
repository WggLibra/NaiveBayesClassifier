import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class Outputfile {

	public Outputfile(Dataset dataset){
		try {
			output(dataset);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void output(Dataset dataset) throws IOException{
		File file = new File("output.txt");
		file.createNewFile();
		FileWriter fw = new FileWriter(file);
		for(Instance instance : dataset.getDataset()){
			fw.write(instance.getName());
			fw.write(",");
			fw.write(instance.getParty());
			fw.write(",");
			String[] votes = instance.getVotes();
			for(int i=0;i<votes.length-1;i++){
				fw.write(votes[i]);
				fw.write(",");
			}
			fw.write(votes[votes.length-1]);
			fw.write("\n");
		}
		fw.flush();
		fw.close();
	}
	
}
