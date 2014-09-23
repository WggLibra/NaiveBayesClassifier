

public class Classifier {

	private int[][][] details;
	private int[] valuesInClass;
	private int numOfInstances;
	
	private Dataset trainingset;
	
	public Classifier(Dataset dataset){
		trainingset = dataset;
	}
	
	private void naiveBayes(Dataset dataset){
		for(Instance instance : dataset.getDataset()){
			String[] votes = instance.getVotes();
			
			switch (instance.getClassLabel()) {
			case Instance.Con:
				valuesInClass[Instance.Con-1]++;
				for(int i=0;i<votes.length;i++){
					if(votes[i].equals("1")){
						details[i][Instance.Con-1][0]++;
					}
					else if(votes[i].equals("-1")){
						details[i][Instance.Con-1][1]++;
					}
					else{
						
					}
				}
				break;
			
			case Instance.Lab:
				valuesInClass[Instance.Lab-1]++;
				for(int i=0;i<votes.length;i++){
					if(votes[i].equals("1")){
						details[i][Instance.Lab-1][0]++;
					}
					else if(votes[i].equals("-1")){
						details[i][Instance.Lab-1][1]++;
					}
					else{
						
					}
				}
				break;

			case Instance.LDem:
				valuesInClass[Instance.LDem-1]++;
				for(int i=0;i<votes.length;i++){
					if(votes[i].equals("1")){
						details[i][Instance.LDem-1][0]++;
					}
					else if(votes[i].equals("-1")){
						details[i][Instance.LDem-1][1]++;
					}
					else{
						
					}
				}
				break;
				
			case Instance.Ind:
				valuesInClass[Instance.Ind-1]++;
				for(int i=0;i<votes.length;i++){
					if(votes[i].equals("1")){
						details[i][Instance.Ind-1][0]++;
					}
					else if(votes[i].equals("-1")){
						details[i][Instance.Ind-1][1]++;
					}
					else{
						
					}
				}
				break;
				
			case Instance.DUP:
				valuesInClass[Instance.DUP-1]++;
				for(int i=0;i<votes.length;i++){
					if(votes[i].equals("1")){
						details[i][Instance.DUP-1][0]++;
					}
					else if(votes[i].equals("-1")){
						details[i][Instance.DUP-1][1]++;
					}
					else{
						
					}
				}
				break;
				
			case Instance.SNP:
				valuesInClass[Instance.SNP-1]++;
				for(int i=0;i<votes.length;i++){
					if(votes[i].equals("1")){
						details[i][Instance.SNP-1][0]++;
					}
					else if(votes[i].equals("-1")){
						details[i][Instance.SNP-1][1]++;
					}
					else{
						
					}
				}
				break;
				
			case Instance.PC:
				valuesInClass[Instance.PC-1]++;
				for(int i=0;i<votes.length;i++){
					if(votes[i].equals("1")){
						details[i][Instance.PC-1][0]++;
					}
					else if(votes[i].equals("-1")){
						details[i][Instance.PC-1][1]++;
					}
					else{
						
					}
				}
				break;
				
			case Instance.SDLP:
				valuesInClass[Instance.SDLP-1]++;
				for(int i=0;i<votes.length;i++){
					if(votes[i].equals("1")){
						details[i][Instance.SDLP-1][0]++;
					}
					else if(votes[i].equals("-1")){
						details[i][Instance.SDLP-1][1]++;
					}
					else{
						
					}
				}
				break;
				
			case Instance.UKIP:
				valuesInClass[Instance.UKIP-1]++;
				for(int i=0;i<votes.length;i++){
					if(votes[i].equals("1")){
						details[i][Instance.UKIP-1][0]++;
					}
					else if(votes[i].equals("-1")){
						details[i][Instance.UKIP-1][1]++;
					}
					else{
						
					}
				}
				break;
				
			case Instance.UUP:
				valuesInClass[Instance.UUP-1]++;
				for(int i=0;i<votes.length;i++){
					if(votes[i].equals("1")){
						details[i][Instance.UUP-1][0]++;
					}
					else if(votes[i].equals("-1")){
						details[i][Instance.UUP-1][1]++;
					}
					else{
						
					}
				}
				break;
				
			case Instance.Ind_Lab:
				valuesInClass[Instance.Ind_Lab-1]++;
				for(int i=0;i<votes.length;i++){
					if(votes[i].equals("1")){
						details[i][Instance.Ind_Lab-1][0]++;
					}
					else if(votes[i].equals("-1")){
						details[i][Instance.Ind_Lab-1][1]++;
					}
					else{
						
					}
				}
				break;
				
			default:
				System.out.println("Invalid class label");
				break;
			}
		}
	}
	
	private void laplaceCorrection(){
		for(int i=0;i<1288;i++){
			for(int j=0;j<11;j++){
				for(int k=0;k<2;k++){
					details[i][j][k]++;
				}
			}
		}
		for(int i=0;i<valuesInClass.length;i++){
			valuesInClass[i]++;
		}
	}
	
	private NaiveBayesModel generateModel(){
		double[][][] attributes_likelihoods = new double[1288][11][2];
		double[] classLabel_likelihoods = new double[11];
		for(int i=0;i<1288;i++){
			for(int j=0;j<11;j++){
				for(int k=0;k<2;k++){
					int sum = 0;
					sum = details[i][j][0] + details[i][j][1];
					double likelihood;
					likelihood = (double)(details[i][j][k])/(double)(sum);
					attributes_likelihoods[i][j][k] = likelihood;
				}
			}
		}
		for(int i=0;i<classLabel_likelihoods.length;i++){
			double likelihood = 0;
			likelihood = (double)(valuesInClass[i])/(double)(numOfInstances+11);
			classLabel_likelihoods[i] = likelihood;
		}
		NaiveBayesModel nbm = new NaiveBayesModel(attributes_likelihoods, classLabel_likelihoods,11);
		return nbm;
	}
	
	public NaiveBayesModel getModel(){
		numOfInstances = trainingset.getDataset().size();
		details = new int[1288][11][2];
		valuesInClass = new int[11];
		naiveBayes(trainingset);
		laplaceCorrection();
		NaiveBayesModel model = generateModel();
		return model;
	}
	
	public int[][][] getDetails() {
		return details;
	}

	public void setDetails(int[][][] details) {
		this.details = details;
	}

	public int[] getValuesInClass() {
		return valuesInClass;
	}

	public void setValuesInClass(int[] valuesInClass) {
		this.valuesInClass = valuesInClass;
	}

	public int getNumOfInstances() {
		return numOfInstances;
	}

	public void setNumOfInstances(int numOfInstances) {
		this.numOfInstances = numOfInstances;
	}
	
}
