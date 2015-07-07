package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;


public class Parser {
	
	// метод для чтения из файла характеристик профилей
	// первая строка - название норматива
	public static List<String> readFile(File file) throws FileNotFoundException {
		List<String> result = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(file));
		try {
			while (reader.ready()) {
				result.add(replaceComasToPoints(reader.readLine()));
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Parser", JOptionPane.ERROR_MESSAGE);
		}
		return result;		
	} // readFile
	
	private static String replaceComasToPoints(String strWithComas) {
		return strWithComas.replace(',', '.');		
	}

	public static String readHeadOfFile(File file) throws FileNotFoundException {
		String result = null;
		BufferedReader reader = new BufferedReader(new FileReader(file));
		try {
			result = (reader.readLine());
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Parser", JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Parser", JOptionPane.ERROR_MESSAGE);
			}
		}
		return result;		
	} // readFile
	
	public static Vector<String> readHeadOfTableFile(File file) throws FileNotFoundException {
		Vector<String> result = new Vector<>();
		BufferedReader reader = new BufferedReader(new FileReader(file));
		try {
			reader.readLine();
			String[] tmp = (reader.readLine()).trim().split("\t");
			if (tmp != null ){
				for (int i = 0; i < tmp.length; i++) {
					result.add(tmp[i]);
				}
			}
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Parser", JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Parser", JOptionPane.ERROR_MESSAGE);
			}
		}
		return result;		
	} // readFile
	
	public static Vector<String> convertListObjToVectorStr(Vector list) {
		Vector<String> result = new Vector<>();
		for (int i = 0; i < list.size(); i++) {
			result.add(list.get(i).toString());
		}
		return result;
	}
	

	/*public static void main(String[] args) {
		System.out.println(replaceComasToPoints("20	3	0,89	1,13	3,5	1,2	0,40	0,28	0,59	0,63	0,75	0,17	0,20	0,39	0,23	0,60"));
	}*/

}
