
public class Mechanical Pencil extends WriteTool {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double lead;
	private String typeOf;

	public Mechanical Pencil(String brand, double price, double lead) {
		super(brand, price);
		this.lead = lead;
		this.typeOf = "Mechanical Pencil";
	}

	public double getLead() {
		return lead;
	}

	public void setLead(double lead) {
		this.lead = lead;
	}

	public String toString() {
		String response = "Type: " +this.typeOf + "\n";
		response += super.toString();
		response += "Lead diameter: " + this.lead + "\n";
		response += "How to scribble? " + this.makeTip() + "\n";
		return response;
	}

	@Override
	public String makeTip() {

		return "Exposing the lead";
	}
	public void leadButton(){
		System.out.println("Sharpening...");
		this.tip =! this.tip;
	}

	// @Override
	// public boolean scribbling() {
	// if (this.isTip() == true) {
	// return "Scribbling" != null;
	// } else {
	// return "Exponha a tip para rabiscar" != null;
	// }

}
