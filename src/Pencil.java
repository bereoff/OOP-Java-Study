
public class Pencil extends InstrumentoEscrita {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String color;
	private String typeOf;

	public Pencil(String typeOf, String brand, double price,  String color) {
		super(brand, price);
		this.color = color;
		this.typeOf = "Pencil";
	}
	public String isType(){
		return this.typeOf;
	}
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String toString() {
		String retorno = "Type: " +this.typeOf + "\n";
		retorno += super.toString();
		retorno += "Pencil color: " + this.color + "\n";
		retorno += "How to scribble? " + this.makeTip()  + "\n";
		return retorno;
	}

	@Override
	public String makeTip() {

		return "Sharpened";
	}
	public void atipr(){
		System.out.println("Sharpening...");
		this.tip =! this.tip;
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
