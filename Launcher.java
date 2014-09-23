
public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dataset training_set = new Reader("trainingset.txt").getDataset();
		Dataset test_set = new Reader("testset.txt").getDataset();
		Classifier c = new Classifier(training_set);
		NaiveBayesModel model = c.getModel();
		Predictor p = new Predictor(test_set, model);
		Dataset results = p.getPredictiveResults();
		new Outputfile(results);
		//Dataset d = new Reader("gapData.txt").getDataset();
		//new Populater(d, model);
	}

}
