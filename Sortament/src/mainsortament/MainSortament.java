package mainsortament;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import shapes.CornerSymm;
import shapes.CornerUnsymm;
import shapes.Section;
import shapes.Shveller;
import utils.Parser;
import frames.MainFrame;


public class MainSortament {
	
	public final static String pathToNorms = "D:\\java\\Sortament\\resurses\\data\\win-1251\\";
	public final static String pathToIcons= "D:\\java\\Sortament\\resurses\\pic\\icons226x242\\";
	private final static boolean DEBUG = false;
	
	public static Vector<Norm> normsList = new Vector<>();
	public static Set<Section> comparisonList = new TreeSet<>();
	
	public static MainFrame mainFrame;
	

	public static void main(String[] args) {
		
		File path = new File(pathToNorms);
		File[] files = null;
		if (path.exists()) {
			if (path.isDirectory()){
				files = path.listFiles();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Нет доступа к папке c нормами " + pathToNorms, "Запуск программы", JOptionPane.ERROR_MESSAGE);
		}
		
		if (files != null){
			for (int i = 0; i < files.length; i++) {
				try {
					String normName = Parser.readHeadOfFile(files[i]);
					
					//tableHeadsMap.put(files[i].getName(), Parser.readHeadOfTableFile(files[i]));
					List<String> data = Parser.readFile(files[i]);
					Vector<Section> sections = new Vector<>();
					switch (files[i].getName()) {
					case "8509-86.txt":
						//System.out.println("cornerSymmList");
						sections = CornerSymm.makeCornerSymmList(data);
						break;
						
					case "8510-86.txt":
						//System.out.println("cornerSymmList");
						sections= CornerUnsymm.makeCornerUnsymmList(data);
						break;
						
					case "8240-89.txt":
						//System.out.println("cornerSymmList");
						sections= Shveller.makeShvellerList(data);
						break;

					default:
						break;
					}
					normsList.add(new Norm(sections, Parser.readHeadOfTableFile(files[i]), Parser.readHeadOfFile(files[i])));
					
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, files[i].getName() + ": " + e.getMessage(), "Считывание файлов с нормами", JOptionPane.ERROR_MESSAGE);
				} // try-catch
				
			}// for
		} // if (files != null)
		
		for (Norm norm : normsList) {
			if (norm != null) {
				norm.assignNormToSections();
			} 
		}
		System.out.println(normsList);
		
		mainFrame = new MainFrame();
	}

}
