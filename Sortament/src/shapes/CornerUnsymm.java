package shapes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import mainsortament.MainSortament;

public class CornerUnsymm extends Section{
	
	
	float bbig; // ������� ����� � ��
	float bsmall; // ����� ����� � ��
	float t; // ������� ����� � ��	
	float rbig; // ������ ������� � ��
	float rsmall; // ������ ����� � ��
	float ju; // ������ ������� ������ ��� u � ��4
	float wu; // ������ ������������� ����� ��� u � ��3
	float iu; // ������ ������� ������ ��� u � ��
	float x0; // ���������� �� ����� �� ��� y � ��
	float y0; // ���������� �� ����� �� ��� x � ��
	float jxy; // ������ ������������� ������ ��� xy � ��4
	float tanA; // tg(alpha) - ������� ���� ������� ��� u
	
	
	public CornerUnsymm(String name, float bbig, float bsmall, float t, float p, float f, float rbig, float rsmall, 
			float jx, float wx, float ix, float jy, float wy, float iy, float ju, float wu, float iu, float x0, float y0,
			float jxy, float tanA) {
		super(name,  // ��� �������
				p, 		// ����� � ��/�.�.
				f, 		// ������� � ��2
				jx, 	// ������ ������� ������ ��� � � ��4
				wx, 	// ������ ������������� ������ ��� � � ��3
				ix, 	// ������ ������� ������ ��� � � ��
				jy, 	// ������ ������� ������ ��� y � ��4
				wy, 	// ������ ������������� ������ ��� y � ��3
				iy, 	// ������ ������� ������ ��� y � ��
				new ImageIcon(MainSortament.pathToIcons + "8510-86.jpg"));
		this.bbig = bbig; 
		this.bsmall = bsmall;
		this.t = t;
		this.rbig = rbig;
		this.rsmall = rsmall;
		this.ju = ju;
		this.wu = wu;
		this.iu = iu;
		this.x0 = x0;
		this.y0 = y0;
		this.jxy = jxy;
		this.tanA = tanA;
		
	}


	public static Vector<Section> makeCornerUnsymmList(List<String> data) {
		Vector<Section> corners = new Vector<>();
		for (int i = 2; i < data.size(); i++) {
			String[] tmp = data.get(i).trim().split("\t");
			try {
				System.out.println(Arrays.toString(tmp));
				corners.add(new CornerUnsymm(tmp[0],						// ��� �������
										Float.parseFloat(tmp[1]), 	// ������� ����� � ��
										Float.parseFloat(tmp[2]), 	// ����� ����� � ��
										Float.parseFloat(tmp[3]), 	// ������� ����� � ��	
										Float.parseFloat(tmp[4]), 	// ����� � ��/�.�.
										Float.parseFloat(tmp[5]), 	// ������� � ��2
										Float.parseFloat(tmp[6]), 	// ������ ������� � ��
										Float.parseFloat(tmp[7]), 	// ������ ����� � ��
										Float.parseFloat(tmp[8]), 	// ������ ������� ������ ��� � � ��4
										Float.parseFloat(tmp[9]), 	// ������ ������������� ������ ��� � � ��3
										Float.parseFloat(tmp[10]), 	// ������ ������� ������ ��� � � ��
										Float.parseFloat(tmp[11]), 	// ������ ������� ������ ��� y � ��4
										Float.parseFloat(tmp[12]), 	// ������ ������������� ������ ��� y � ��3	
										Float.parseFloat(tmp[13]), 	// ������ ������� ������ ��� y � ��
										Float.parseFloat(tmp[14]), 	// ������ ������� ������ ��� u � ��4
										Float.parseFloat(tmp[15]), 	// ������ ������������� ����� ��� u � ��3
										Float.parseFloat(tmp[16]), 	// ������ ������� ������ ��� u � ��
										Float.parseFloat(tmp[17]), 	// ���������� �� ����� �� ��� y � ��
										Float.parseFloat(tmp[18]), 	// ���������� �� ����� �� ��� x � ��
										Float.parseFloat(tmp[19]), 	// ������ ������������� ������ ��� xy � ��4
										Float.parseFloat(tmp[20])));// tg(alpha) - ������� ���� ������� ��� u
							} catch (NumberFormatException e) {
				System.out.println("NumberFormatException " + i);
				JOptionPane.showMessageDialog(null, e.getMessage(), "������ ���������������", JOptionPane.ERROR_MESSAGE);
				break;
			}
		} // for		
		return corners;
	}
	
	/*String name, float bbig, float bsmall, float t, float p, float f, float rbig, float rsmall, 
	float jx, float wx, float ix, float jy, float wy, float iy, float ju, float wu, float iu, float x0, float y0,
	float jxy, float tanA*/
	public Vector<Vector> makeVectorOfFields() {
		Vector<Vector> result = new Vector<>();
		Vector<String> tmp = new Vector<>();
		tmp.add(norm.head.get(0));
		tmp.add(name + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(1));
		tmp.add(bbig + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(2));
		tmp.add(bsmall + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(3));
		tmp.add(t + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(4));
		tmp.add(p + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(5));
		tmp.add(f + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(6));
		tmp.add(rbig + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(7));
		tmp.add(rsmall + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(8));
		tmp.add(jx + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(9));
		tmp.add(wx + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(10));
		tmp.add(ix + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(11));
		tmp.add(jy + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(12));
		tmp.add(wy + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(13));
		tmp.add(iy + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(14));
		tmp.add(ju + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(15));
		tmp.add(wu + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(16));
		tmp.add(iu + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(17));
		tmp.add(x0 + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(18));
		tmp.add(y0 + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(19));
		tmp.add(jxy + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(20));
		tmp.add(tanA + "");
		result.add(tmp);
		//System.out.println(result);
		return result;
	}

	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
