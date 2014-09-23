
public class Predictor {

	private Dataset testset;
	private NaiveBayesModel model;
	
	public Predictor(Dataset testset, NaiveBayesModel model){
		this.testset = testset;
		this.model = model;
	}
	
	public Dataset getPredictiveResults(){
		predictAllTestset();
		return testset;
	}
	
	private void predictAllTestset(){
		for(Instance instance : testset.getDataset()){
			predictClassLabel(instance);
		}
	}
	
	private void predictClassLabel(Instance instance){
		int size = model.getNumOfClassLabel();
		double[] likelihoods = new double[size];
		for(int i=0;i<size;i++){
			likelihoods[i] = (double)1;
		}
		for(int i=0;i<size;i++){
			double[][][] attributes_likelihoods = model.getAttributes_likelihoods();
			for(int j=0;j<attributes_likelihoods.length;j++){
				String votes[] = instance.getVotes();
				if(votes[j].equals("1")){
					if(attributes_likelihoods[j][i][0] != 0){
						likelihoods[i] *= attributes_likelihoods[j][i][0];
						//System.out.println(Math.log(attributes_likelihoods[j][i][0]));
					}
					else{
						System.out.println("error!! P(C) = 0");
					}
				}
				else if(votes[j].equals("-1")){
					if(attributes_likelihoods[j][i][1] != 0){
						likelihoods[i] *= attributes_likelihoods[j][i][1];
						//System.out.println(Math.log(attributes_likelihoods[j][i][1]));
					}
					else{
						System.out.println("error!! P(C) = 0");
					}
				}
				else{
					
				}
			}
			double[] classLabelLikelihoods = model.getClassLabel_likelihoods();
			likelihoods[i] *= classLabelLikelihoods[i];
			//System.out.println(likelihoods[i]);
		}
		double max = likelihoods[0];
		int max_index = 0;
		for(int i=1;i<11;i++){
			if(likelihoods[i] > max){
				max = likelihoods[i];
				max_index = i;
			}
		}
		instance.setPartyByClassLabel(max_index+1);
		//System.out.println("====================");
	}
	
}
