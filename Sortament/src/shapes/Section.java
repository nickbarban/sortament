package shapes;


import java.util.Vector;

import javax.swing.ImageIcon;

import mainsortament.Norm;

public class Section implements Comparable<Section>{
	
	String name; // ��� �������
	float p; // ����� � ��/�.�.
	float f; // ������� � ��2
	float jx; // ������ ������� ������ ��� � � ��4
	float wx; // ������ ������������� ������ ��� � � ��3
	float ix; // ������ ������� ������ ��� � � ��
	float jy; // ������ ������� ������ ��� y � ��4
	float wy; // ������ ������������� ������ ��� y � ��3
	float iy; // ������ ������� ������ ��� y � ��
	public ImageIcon icon; // ������ � ������������ �������
	public Norm norm; // ����� ��������� 
	
	public Section(String name, float p, float f, float jx, float wx, float ix, float jy,
			float wy, float iy, ImageIcon icon) {
		
		this.name = name;
		this.p = p;
		this.f = f;
		this.jx = jx;
		this.wx = wx;
		this.ix = ix;
		this.jy = jy;
		this.wy = wy;
		this.iy = iy;
		this.icon = icon;
	} // constructor
	
	

	/*public void setNorm(Norm norm) {
		this.norm = norm;
	}*/



	@Override
	public String toString() {
		return norm.name.split(" ")[0] + " " + name;
	}


	public static Vector<String> makeVectorOfSectionsNames(Vector<Section> sections) {
		Vector<String> result = new Vector<>();
		for (int i = 0; i < sections.size(); i++) {
			result.add(sections.get(i).name);
		}
		return result;
	}
	



	public Vector<Vector> makeVectorOfFields() {
		Vector<Vector> result = new Vector<>();
		Vector<String> tmp = new Vector<>();
		tmp.add("���");
		tmp.add(name + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(0));
		tmp.add(p + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(1));
		tmp.add(f + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(2));
		tmp.add(jx + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(3));
		tmp.add(wx + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(4));
		tmp.add(ix + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(5));
		tmp.add(jy + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(6));
		tmp.add(wy + "");
		result.add(tmp);
		tmp = new Vector<>(2);
		tmp.add(norm.head.get(7));
		tmp.add(iy + "");
		System.out.println(result);
		return result;
	}

	
	public Vector<String> getFieldsForComparison(){
		Vector<String> result = new Vector<>();
		result.add(name + "");
		result.add(p + "");
		result.add(f + "");
		result.add(jx + "");
		result.add(wx + "");
		result.add(ix + "");
		result.add(jy + "");
		result.add(wy + "");
		result.add(iy + "");
		return result;		
	}


	@Override
	public int compareTo(Section o) {
		//System.out.println(this.p + "||" + o.p);
		return (int) (this.p*1000 - o.p*1000);
	}



	
	
	

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
