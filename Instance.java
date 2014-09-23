
public class Instance {
	
	private String name;
	private String party;
	private String[] votes;
	private int classLabel;
	
	public static final int Con = 1;
	public static final int Lab = 2;
	public static final int LDem = 3;
	public static final int Ind = 4;
	public static final int DUP = 5;
	public static final int SNP = 6;
	public static final int PC = 7;
	public static final int SDLP = 8;
	public static final int UKIP = 9;
	public static final int UUP = 10;
	public static final int Ind_Lab = 11;
	
	public Instance (String name, String party, String[] votes){
		this.name = name;
		this.votes = votes;
		this.party = party;
		setClassLabel();
	}
	
	private void setClassLabel(){
		if(party.equals("Con")){
			classLabel = Con;
		}
		else if(party.equals("Lab")){
			classLabel = Lab;
		}
		else if(party.equals("LDem")){
			classLabel = LDem;
		}
		else if(party.equals("Ind")){
			classLabel = Ind;
		}
		else if(party.equals("DUP")){
			classLabel = DUP;
		}
		else if(party.equals("SNP")){
			classLabel = SNP;
		}
		else if(party.equals("PC")){
			classLabel = PC;
		}
		else if(party.equals("SDLP")){
			classLabel = SDLP;
		}
		else if(party.equals("UKIP")){
			classLabel = UKIP;
		}
		else if(party.equals("UUP")){
			classLabel = UUP;
		}
		else if(party.equals("Ind Lab")){
			classLabel = Ind_Lab;
		}
		else if(party.equals("")){
			classLabel = 0;
		}
		else {
			classLabel = -1;
			System.out.println("unrecognizable party" + party);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String[] getVotes() {
		return votes;
	}

	public void setVotes(String[] votes) {
		this.votes = votes;
	}
	
	public int getClassLabel(){
		return classLabel;
	}
	
	public void setClassLabel(int class_label){
		if(class_label > 0 && class_label < 12){
			this.classLabel = class_label;
		}
		else{
			System.out.println("Invalid class label" + class_label);
		}
	}
	/*
	public void printDetails(){
		System.out.print(this.name + ",");
		System.out.print(this.party + ",");
		for(int i=0;i<votes.length;i++){
			System.out.print(votes[i]);
		}
		System.out.println();
	}
	*/
	public void setPartyByClassLabel(int class_label){
		if(class_label > 0 && class_label < 12){
			this.classLabel = class_label;
			switch (class_label) {
			case Con:
				setParty("Con");
				break;
			case Lab:
				setParty("Lab");
				break;
			case LDem:
				setParty("LDem");
				break;
			case Ind:
				setParty("Ind");
				break;
			case DUP:
				setParty("DUP");
				break;
			case SNP:
				setParty("SNP");
				break;
			case PC:
				setParty("PC");
				break;
			case SDLP:
				setParty("SDLP");
				break;
			case UKIP:
				setParty("UKIP");
				break;
			case UUP:
				setParty("UUP");
				break;
			case Ind_Lab:
				setParty("Ind_Lab");
				break;
			default:
				break;
			}
		}
	}
	
}
