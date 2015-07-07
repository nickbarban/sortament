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

	
	float b; // ����� � ��
	float t; // ������� ����� � ��	
	float rbig; // ������ ������� � ��
	float rsmall; // ������ ����� � ��
	float jx0; // ������ ������� ������ ��� �0 � ��4
	float ix0; // ������ ������� ������ ��� �0 � ��	
	float jy0; // ������ ������� ������ ��� y0 � ��4
	float wy0; // ������ ������������� ����� ��� y0 � ��3
	float iy0; // ������ ������� ������ ��� y0 � ��
	float jxy; // ������ ������������� ������ ��� xy � ��4
	float z0; // ����� ������� � ��
	
	public CornerSymm(float b, float t, float p, float f, float rbig, float rsmall, float jx, float wx, float ix, 
			float jx0, float ix0, float jy0, float wy0, float iy0, float jxy, float z0) {
		super(b + "x" + t,  // ��� �������
				p, // ����� � ��/�.�.
				f, // ������� � ��2
				jx, // ������ ������� ������ ��� � � ��4
				wx, // ������ ������������� ������ ��� � � ��3
				ix, // ������ ������� ������ ��� � � ��
				jx, // jy ������ ������� ������ ��� y � ��4 ����� jx ��� �������������� ������
				wx, // wy ��������� ������������� ������ ��� y � ��3 ����� wx ��� �������������� ������
				ix, // iy ������ ������� ������ ��� y � �� ����� ix ��� �������������� ������
				new ImageIcon(MainSortament.pathToIcons + "8509-86.jpg"));
		
		this.b = b; // ����� � ��
		this.t = t; // ������� ����� � ��	
		this.rbig = rbig; // ������ ������� � ��
		this.rsmall = rsmall; // ������ ����� � ��
		this.jx0 = jx0; // ������ ������� ������ ��� �0 � ��4
		this.ix0 = ix0; // ������ ������� ������ ��� �0 � ��	
		this.jy0 = jy0; // ������ ������� ������ ��� y0 � ��4
		this.wy0 = wy0; // ������ ������������� ����� ��� y0 � ��3
		this.iy0 = iy0; // ������ ������� ������ ��� y0 � ��
		this.jxy = jxy; // ������ ������������� ������ ��� xy � ��4
		this.z0 = z0; // ����� ������� � ��
		
	} // constructor
	
	public static Vector<Section> makeCornerSymmList(List<String> data) {
		Vector<Section> corners = new Vector<>();
		for (int i = 2; i < data.size(); i++) {
			String[] tmp = data.get(i).trim().split("\t");
			try {
				System.out.println(Arrays.toString(tmp));
				corners.add(new CornerSymm(Float.parseFloat(tmp[0]), 	// ����� � ��
										Float.parseFloat(tmp[1]), 	// ������� ����� � ��	
										Float.parseFloat(tmp[2]), 	// ����� � ��/�.�.
										Float.parseFloat(tmp[3]), 	// ������� � ��2
										Float.parseFloat(tmp[4]), 	// ������ ������� � ��
										Float.parseFloat(tmp[5]), 	// ������ ����� � ��
										Float.parseFloat(tmp[6]), 	// ������ ������� ������ ��� � � ��4
										Float.parseFloat(tmp[7]), 	// ������ ������������� ������ ��� � � ��3
										Float.parseFloat(tmp[8]), 	// ������ ������� ������ ��� � � ��
										Float.parseFloat(tmp[9]), 	// ������ ������� ������ ��� �0 � ��4
										Float.parseFloat(tmp[10]), 	// ������ ������� ������ ��� �0 � ��		
										Float.parseFloat(tmp[11]), 	// ������ ������� ������ ��� y0 � ��4
										Float.parseFloat(tmp[12]), 	// ������ ������������� ����� ��� y0 � ��3
										Float.parseFloat(tmp[13]), 	// ������ ������� ������ ��� y0 � ��
										Float.parseFloat(tmp[14]), 	// ������ ������������� ������ ��� xy � ��4
										Float.parseFloat(tmp[15])));// ����� ������� � ��
			} catch (NumberFormatException e) {
				System.out.println("NumberFormatException " + i);
				JOptionPane.showMessageDialog(null, i + ": " + e.getMessage(), "������ �������������", JOptionPane.ERROR_MESSAGE);
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
		tmp.add("���");
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
