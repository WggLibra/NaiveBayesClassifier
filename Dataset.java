import java.util.List;

public class Dataset {

	private List<Instance> dataset;
	
	public Dataset(List<Instance> dataset){
		this.dataset = dataset;
	}

	public List<Instance> getDataset() {
		return dataset;
	}

	public void setDataset(List<Instance> dataset) {
		this.dataset = dataset;
	}
	
	public void printDetails(){
		for(int i=0;i<dataset.size();i++){
			//System.out.println(count + ". party=" + i.getParty());
			System.out.print((i+1) + ". " + dataset.get(i).getName() + ", " + dataset.get(i).getParty() + ", ");
			for(int j=0;j<dataset.get(i).getVotes().length;j++){
				String[] votes = dataset.get(i).getVotes();
				System.out.print(votes[j] + ", ");
			}
			System.out.println();
		}
	}
	
}
