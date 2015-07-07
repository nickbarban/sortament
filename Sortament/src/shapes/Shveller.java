package shapes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import mainsortament.MainSortament;

public class Shveller extends Section{
	
	//№	h	b	s	t	R	r	F	P	Jx	Wx	ix	Sx	Jy	Wy	iy	Z0
	float h; // стенка в мм
	float b; // полка в мм
	float s; // толщина стенки в мм	
	float t; // толщина полки в мм	
	float rbig; // радиус большой в мм
	float rsmall; // радиус малый в мм
	float sx; // статический момент вокруг оси х в см3
	float z0; // центр тяжести в см
	
	
	public Shveller(String name, float h, float b, float s, float t, float rbig, float rsmall, float f, float p, 
			float jx, float wx, float ix, float sx, float jy, float wy, float iy, float z0) {
		super(name,  // имя профиля
				p, 		// масса в кг/м.п.
				f, 		// площадь в см2
				jx, 	// момент инерции вокруг оси х в см4
				wx, 	// момент сопротивления вокруг оси х в см3
				ix, 	// радиус инерции вокруг оси х в см
				jy, 	// момент инерции вокруг оси y в см4
				wy, 	// момент сопротивления вокруг оси y в см3
				iy, 	// радиус инерции вокруг оси y в см
				new ImageIcon(MainSortament.pathToIcons + "8240-89.jpg"));
		this.h = h; 
		this.b = b;
		this.s = s;
		this.t = t;
		this.rbig = rbig;
		this.rsmall = rsmall;
		this.sx = sx;
		this.z0 = z0;		
	}


	public static Vector<Section> makeShvellerList(List<String> data) {
		Vector<Section> corners = new Vector<>();
		for (int i = 2; i < data.size(); i++) {
			String[] tmp = data.get(i).trim().split("\t");
			try {
				System.out.println(Arrays.toString(tmp));
				corners.add(new Shveller(tmp[0],						// имя профиля
										Float.parseFloat(tmp[1]), 	// стенка в мм
										Float.parseFloat(tmp[2]), 	// полка в мм
										Float.parseFloat(tmp[3]), 	// толщина стенки в мм	
										Float.parseFloat(tmp[4]), 	// толщина полки в мм	
										Float.parseFloat(tmp[5]), 	// радиус большой в мм
										Float.parseFloat(tmp[6]), 	// радиус малый в мм
										Float.parseFloat(tmp[7]), 	// площадь в см2
										Float.parseFloat(tmp[8]), 	// масса в кг/м.п.
										Float.parseFloat(tmp[9]), 	// момент инерции вокруг оси х в см3
										Float.parseFloat(tmp[10]), 	// момент сопротивления вокруг оси х в см3
										Float.parseFloat(tmp[11]), 	// радиус инерции вокруг оси х в см
										Float.parseFloat(tmp[12]), 	// статический момент оси х в см
										Float.parseFloat(tmp[13]), 	// момент инерции вокруг оси y в см4
										Float.parseFloat(tmp[14]), 	// момент сопротивления вокруг оси y в см3	
										Float.parseFloat(tmp[15]), 	// радиус инерции вокруг оси y в см
										Float.parseFloat(tmp[16])));// tg(alpha) - тангенс угла наклона оси u
							} catch (NumberFormatException e) {
				//System.out.println("NumberFormatException " + i);
				JOptionPane.showMessageDialog(null, i + ": " + e.getMessage(), "Швеллеры с уклоном полок", JOptionPane.ERROR_MESSAGE);
				break;
			}
		} // for		
		return corners;
	}
	
	
	
	public Vector<Vector> makeVectorOfFields() {
		Vector<Vector> result = new Vector<>();
		Vector<String> tmp = new Vector<>();
		tmp.add(norm.head.get(0));
		tmp.add(name + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(1));
		tmp.add(h + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(2));
		tmp.add(b+ "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(3));
		tmp.add(s + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(4));
		tmp.add(t + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(5));
		tmp.add(rbig + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(6));
		tmp.add(rsmall+ "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(7));
		tmp.add(f + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(8));
		tmp.add(p + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(9));
		tmp.add(jx + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(10));
		tmp.add(wx + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(11));
		tmp.add(ix + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(12));
		tmp.add(sx + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(13));
		tmp.add(jy + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(14));
		tmp.add(wy + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(15));
		tmp.add(iy + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(16));
		tmp.add(z0 + "");
		result.add(tmp);
		//System.out.println(result);
		return result;
	}


	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
