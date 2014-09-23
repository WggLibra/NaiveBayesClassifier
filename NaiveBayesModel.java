
public class NaiveBayesModel {

	private double[][][] attributes_likelihoods;
	private double[] classLabel_likelihoods;
	private int numOfClassLabel;
	
	public NaiveBayesModel(double[][][] attributes_likelihoods,double[] classLabel_likelihoods,int numOfClassLabel){
		this.attributes_likelihoods = attributes_likelihoods;
		this.classLabel_likelihoods = classLabel_likelihoods;
		this.numOfClassLabel = numOfClassLabel;
		//printModel();
	}
	
	public void printModel(){
		for(int i=0;i<numOfClassLabel;i++){
			System.out.println("Class " + (i+1) + " : P(C) = " + classLabel_likelihoods[i]);
			for(int j=0;j<attributes_likelihoods.length;j++){
				System.out.println("attribute vote" + j);
				System.out.println("P(Y)=" + attributes_likelihoods[j][i][0]);
				System.out.println("P(N)=" + attributes_likelihoods[j][i][1]);
			}
		}
	}
	
	public int getNumOfClassLabel() {
		return numOfClassLabel;
	}

	public double[][][] getAttributes_likelihoods() {
		return attributes_likelihoods;
	}

	public double[] getClassLabel_likelihoods() {
		return classLabel_likelihoods;
	}
	
}
