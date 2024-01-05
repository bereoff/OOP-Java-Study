

import java.io.Serializable;

public abstract class WriteTool implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String brand;
	private double price;
	protected boolean tip;

	public WriteTool(String brand, double price) {
		this.brand = brand;
		this.price = price;
		this.tip = true;
	}

	public String toString() {
		String retorno = "";
		retorno += "Brand: " + this.brand + "\n";
		retorno += "Price: R$ " + this.price + "\n";
		retorno += "Tip: " +  (this.isPonta()?"exposed":"not exposed") +"\n";
		return retorno;
	}

	public abstract String makeTip();

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isTip() {
		return tip;
	}

	public void setTip(boolean tip) {
		this.tip = tip;
	}

}