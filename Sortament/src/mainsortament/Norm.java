package mainsortament;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import shapes.Section;

public class Norm {
	
	public Vector<Section> sections = new Vector<>(); // ������ ������� ����� �����
	public Vector<String> head = new Vector<>(); // ������ ������������� �������
	public String name; // �������� �����
	
	public Norm(Vector<Section> sections, Vector<String> head, String name) {
		this.sections = sections;
		this.head = head;
		this.name = name;
	}
	
	public void assignNormToSections(){
		if (sections != null ){
			for (Section section : sections) {
				section.norm = this;
			}
		}
	}

	@Override
	public String toString() {
		return name;
	}
	
	
	
	
}
