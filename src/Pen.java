import java.util.Scanner;

public class Pen extends InstrumentoEscrita {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double tipDiameter;
	private String inkColor;


	public Pen(String brand, double price, double tipDiameter, String inkColor) {
		super(brand, price);
		this.tipDiameter = tipDiameter;
		this.inkColor = inkColor;

	}

	public double getTipDiameter() {
		return this.tipDiameter;
	}

	public void setTipDiameter(double tipDiameter) {
		this.tipDiameter = tipDiameter;
	}

	public String getInkColor() {
		return this.inkColor;
	}

	public void setInkColor(String inkColor) {
		this.inkColor = inkColor;
	}

	public String toString() {
		String response = "Type : Pen" + "\n";
		response += super.toString();
		response += "The tip diameter is:  " + this.tipDiameter + "\n";
		response += "The pen ink color is: " + this.inkColor + "\n";
		response += "How to scribble? " + this.makeTip() + "\n";
		return response;
	}

	@Override
	public String makeTip() {

		//
		return "Exposing the tip...";
	}


	// @Override
	// public boolean scribbling() {
	// if (this.isTip() == true) {
	// return "Scribbling" != null;
	// } else {
	// return "Exposing the tip to scribble" != null;
	// }
	// }

}
