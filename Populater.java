
public class Populater {

	private Dataset dataset;
	private NaiveBayesModel model;
	
	public Populater(Dataset dataset,NaiveBayesModel model){
		this.dataset = dataset;
		this.model = model;
		populateValues();
		new Outputfile(dataset);
		//dataset.printDetails();
	}
	
	private void populateValues(){
		for(Instance instance : dataset.getDataset()){
			String[] votes = instance.getVotes();
			for(int i=0;i<votes.length;i++){
				if(votes[i].equals("NaN")){
					double[][][] attributes_likelihoods = model.getAttributes_likelihoods();
					double likelihood_Y = attributes_likelihoods[i][instance.getClassLabel()-1][0];
					double likelihood_N = attributes_likelihoods[i][instance.getClassLabel()-1][1];
					if(likelihood_Y > likelihood_N){
						votes[i] = "1";
					}
					else{
						votes[i] = "-1";
					}
				}
			}
		}
	}
	
}
