package shapes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import mainsortament.MainSortament;


public class CornerSymm extends Section{

	
	float b; // полка в мм
	float t; // толщина полки в мм	
	float rbig; // радиус большой в мм
	float rsmall; // радиус малый в мм
	float jx0; // момент инерции вокруг оси х0 в см4
	float ix0; // радиус инерции вокруг оси х0 в см	
	float jy0; // момент инерции вокруг оси y0 в см4
	float wy0; // момент сопротивления вкруг оси y0 в см3
	float iy0; // радиус инерции вокруг оси y0 в см
	float jxy; // момент сопротивления вокруг оси xy в см4
	float z0; // центр тяжести в см
	
	public CornerSymm(float b, float t, float p, float f, float rbig, float rsmall, float jx, float wx, float ix, 
			float jx0, float ix0, float jy0, float wy0, float iy0, float jxy, float z0) {
		super(b + "x" + t,  // имя профиля
				p, // масса в кг/м.п.
				f, // площадь в см2
				jx, // момент инерции вокруг оси х в см4
				wx, // момент сопротивления вокруг оси х в см3
				ix, // радиус инерции вокруг оси х в см
				jx, // jy момент инерции вокруг оси y в см4 равен jx для равнополочного уголка
				wx, // wy расчетное сопротивление вокруг оси y в см3 равно wx для равнополочного уголка
				ix, // iy радиус инерции вокруг оси y в см равен ix для равнополочного уголка
				new ImageIcon(MainSortament.pathToIcons + "8509-86.jpg"));
		
		this.b = b; // полка в мм
		this.t = t; // толщина полки в мм	
		this.rbig = rbig; // радиус большой в мм
		this.rsmall = rsmall; // радиус малый в мм
		this.jx0 = jx0; // момент инерции вокруг оси х0 в см4
		this.ix0 = ix0; // радиус инерции вокруг оси х0 в см	
		this.jy0 = jy0; // момент инерции вокруг оси y0 в см4
		this.wy0 = wy0; // момент сопротивления вкруг оси y0 в см3
		this.iy0 = iy0; // радиус инерции вокруг оси y0 в см
		this.jxy = jxy; // момент сопротивления вокруг оси xy в см4
		this.z0 = z0; // центр тяжести в см
		
	} // constructor
	
	public static Vector<Section> makeCornerSymmList(List<String> data) {
		Vector<Section> corners = new Vector<>();
		for (int i = 2; i < data.size(); i++) {
			String[] tmp = data.get(i).trim().split("\t");
			try {
				System.out.println(Arrays.toString(tmp));
				corners.add(new CornerSymm(Float.parseFloat(tmp[0]), 	// полка в мм
										Float.parseFloat(tmp[1]), 	// толщина полки в мм	
										Float.parseFloat(tmp[2]), 	// масса в кг/м.п.
										Float.parseFloat(tmp[3]), 	// площадь в см2
										Float.parseFloat(tmp[4]), 	// радиус большой в мм
										Float.parseFloat(tmp[5]), 	// радиус малый в мм
										Float.parseFloat(tmp[6]), 	// момент инерции вокруг оси х в см4
										Float.parseFloat(tmp[7]), 	// момент сопротивления вокруг оси х в см3
										Float.parseFloat(tmp[8]), 	// радиус инерции вокруг оси х в см
										Float.parseFloat(tmp[9]), 	// момент инерции вокруг оси х0 в см4
										Float.parseFloat(tmp[10]), 	// радиус инерции вокруг оси х0 в см		
										Float.parseFloat(tmp[11]), 	// момент инерции вокруг оси y0 в см4
										Float.parseFloat(tmp[12]), 	// момент сопротивления вкруг оси y0 в см3
										Float.parseFloat(tmp[13]), 	// радиус инерции вокруг оси y0 в см
										Float.parseFloat(tmp[14]), 	// момент сопротивления вокруг оси xy в см4
										Float.parseFloat(tmp[15])));// центр тяжести в см
			} catch (NumberFormatException e) {
				System.out.println("NumberFormatException " + i);
				JOptionPane.showMessageDialog(null, i + ": " + e.getMessage(), "Уголки равнополочные", JOptionPane.ERROR_MESSAGE);
				break;
			}
		} // for		
		return corners;
	} // makeCornerSymmList()

	
	/*float b, float t, float p, float f, float rbig, float rsmall, float jx, float wx, float ix, 
	float jx0, float ix0, float jy0, float wy0, float iy0, float jxy, float z0*/
	public Vector<Vector> makeVectorOfFields() {
		Vector<Vector> result = new Vector<>();
		Vector<String> tmp = new Vector<>();
		tmp.add("Имя");
		tmp.add(name + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(0));
		tmp.add(b + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(1));
		tmp.add(t + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(2));
		tmp.add(p + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(3));
		tmp.add(f + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(4));
		tmp.add(rbig + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(5));
		tmp.add(rsmall + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(6));
		tmp.add(jx + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(7));
		tmp.add(wx + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(8));
		tmp.add(ix + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(9));
		tmp.add(jx0 + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(10));
		tmp.add(ix0 + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(11));
		tmp.add(jy0 + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(12));
		tmp.add(wy0 + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(13));
		tmp.add(iy0 + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(14));
		tmp.add(jxy + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(15));
		tmp.add(z0 + "");
		result.add(tmp);
		//System.out.println(result);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
