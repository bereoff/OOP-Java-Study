

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

	private ArrayList<WriteTool> materials;

	public Main() {
		this.materials = new ArrayList<WriteTool>();
	}

	public String[] leValues(String[] dataIn) {
		String[] dataOut = new String[dataIn.length];

		for (int i = 0; i < dataIn.length; i++)
			dataOut[i] = JOptionPane.showInputDialog("Enter " + dataIn[i] + ": ");

		return dataOut;
	}

	public Pen lePen() {

		String[] values = new String[2];
		String[] valName = { "Brand", "Price", "Tip Diameter", "Ink Color" };
		values = leValues(valName);

		double price = this.returnDouble(values[1]);
		double tipDiameter = this.returnDouble(values[2]);

		Pen pen = new Pen(values[0], price, tipDiameter, values[3]);
		return pen;
	}

	public MechanicalPencil leMechanicalPencil() {

		String[] values = new String[4];
		String[] valName = { "Brand", "Price", "Grafite" };
		values = leValues(valName);

		double price = this.returnDouble(values[1]);
		double lead = this.returnDouble(values[2]);

		MechanicalPencil mechanicalPencil = new MechanicalPencil( values[0], price, lead);
		return mechanicalPencil;
	}

	public Pencil lePencil() {

		String[] values = new String[4];

		String[] valName = { "Brand", "Price", "Cor" };
		values = leValues(valName);
		String typeOf = "Pencil";
		double price = this.returnDouble(values[1]);


		Pencil pencil = new Pencil(typeOf, values[0], price, values[2]);
		return pencil;
	}

	private boolean validInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public int intReturn(String input) {

		while (this.validInt(input)) {
			input = JOptionPane.showInputDialog(null,
					"Error\n\nEnter an integer from the provided options.");
		}
		return Integer.parseInt(input);
	}

	private boolean doubleValido(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public double returnDouble(String input) {

		while (this.doubleValido(input)) {
			input = JOptionPane.showInputDialog(null, "Incorrect value\n\nEnter a decimal number.");
		}
		return Double.parseDouble(input);
	}

	private boolean booleanValido(String s) {
		try {
			Boolean.parseBoolean(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public boolean retornaBoolean(String input) {

		while (this.booleanValido(input)) {
			input = JOptionPane.showInputDialog(null, "Incorrect value\n\nEnter a decimal number.");
		}
		return Boolean.parseBoolean(input);
	}

	public void materialSave(ArrayList<WriteTool> materials) {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream("schollSupplies.json"));
			for (int i = 0; i < materials.size(); i++)
				outputStream.writeObject(materials.get(i));
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Unable to create the file.");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (outputStream = null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	@SuppressWarnings("finally")
	public ArrayList<WriteTool> recoverMaterials() {
		ArrayList<WriteTool> materialsTemp = new ArrayList<WriteTool>();

		ObjectInputStream inputStream = null;

		try {
			inputStream = new ObjectInputStream(new FileInputStream("schollSupplies.json"));
			Object obj = null;
			while ((obj = inputStream.readObject()) = null) {
				if (obj instanceof WriteTool) {
					materialsTemp.add((WriteTool) obj);
				}
			}
		} catch (EOFException ex) {
			System.out.println("EOF.");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "File does not exist.");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (inputStream = null) {
					inputStream.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
			return materialsTemp;
		}
	}

	public void schollSuppliesMenu() {

		String menu = "";
		String input;
		int opt1, opt2;

		do {
			menu = "School Supplies Control\n" + "Options:\n" + "1. Register material\n" + 
			"2. Display Materials\n" + "3. Save Materials\n" + "4. Clear Materials\n" + "5. Recover Materials\n" + "9. Exit";
			input = JOptionPane.showInputDialog(menu + "\n\n");
			opt1 = this.intReturn(input);

			switch (opt1) {
			case 1:// Entrada de data
				menu = "School Supplies Entry\n" + "Options:\n" + "1. Pen\n" + "2. Mechanical Pencil\n" + "3. Pencil";

				input = JOptionPane.showInputDialog(menu + "\n\n");
				opt2 = this.intReturn(input);

				switch (opt2) {
				case 1:
					materials.add(lePen());
					break;
				case 2:
					materials.add(leMechanicalPencil());
					break;
				case 3:
					materials.add(lePencil());
					break;
				default:
					JOptionPane.showMessageDialog(null, "School supplies for registration were not selected.");
				}

				break;
			case 2: // Show information
				if (materials.size() == 0) {
					JOptionPane.showMessageDialog(null, "First, register the school supplies.");
					break;
				}
				String data = "";
				for (int i = 0; i < materials.size(); i++) {
					data += materials.get(i).toString() + "---------------\n";
				}
				JOptionPane.showMessageDialog(null, data);
				break;
			case 3: // Saving data
				if (materials.size() == 0) {
					JOptionPane.showMessageDialog(null, "First, register the school supplies.");
					break;
				}
				materialSave(materials);
				JOptionPane.showMessageDialog(null, "Materials successfully saved");
				break;
			case 4: // Clean data
				if (materials.size() == 0) {
					JOptionPane.showMessageDialog(null, "First, register the school supplies.");
					break;
				}
				materials.clear();
				JOptionPane.showMessageDialog(null, "Data erased.");
				break;
			case 5: // Data recovering
				materials = recoverMaterials();
				if (materials.size() == 0) {
					JOptionPane.showMessageDialog(null, "There are no materials to display.");
					break;
				}
				JOptionPane.showMessageDialog(null, "Materials successfully recovered.");
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Program completed.");
				break;
			}
		} while (opt1 = 9);
	}

	public static void main(String[] args) {

		Main material = new Main();
		material.schollSuppliesMenu();

	}

}
