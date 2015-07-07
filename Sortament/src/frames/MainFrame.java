package frames;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import shapes.Section;
import utils.Parser;
import mainsortament.MainSortament;
import mainsortament.Norm;

public class MainFrame extends JFrame{
	
	//private boolean isStart = true;
	
	JButton butStandartSec;
	JButton butCompositeSec;
	JButton butUserSec;
	JButton butToComparison;
	JButton butClearComparison;
	JButton butExit;
	
	JScrollPane tableScrollPane;
	JPanel headPanel;
	JPanel headButtonPanel;
	JPanel centerPanel;
	JPanel iconPanel;
	JPanel bottomPanel;
	
	JComboBox<String> normsComboBox;
	JComboBox<String> nameOfSecComboBox;
	JLabel iconLabel;
	ImageIcon startIcon = new ImageIcon(MainSortament.pathToIcons + "sortament.jpg");
	JCheckBox addToComparisonCheckBox;
	
	JTable secFeaturesTable;
	
	private int selectedNormIndex = -1;
	private int selectedSectionIndex= -1;
	protected final Vector selectedTableHead = new Vector<>(Arrays.asList("Имя характеристики", "Значение"));
	
	public MainFrame() throws HeadlessException {
		
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // получить разрешение экрана
		
		setTitle("Сортамент");
		setSize(800, 500); 
		setResizable(false);
		setLocation((screenSize.width-getWidth() )/2, (screenSize.height-getHeight())/2); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);  
		setLayout(new FlowLayout());
		
		
		
		butStandartSec = new JButton("Стандартные сечения");
		butCompositeSec= new JButton("Составные сечения");
		butUserSec = new JButton("Пользовательские сечения");		
		
		headButtonPanel = new JPanel(new GridLayout(0, 3));
		headButtonPanel.setPreferredSize(new Dimension(getWidth()-30, 30));
		headButtonPanel.add(butStandartSec);
		headButtonPanel.add(butCompositeSec);
		headButtonPanel.add(butUserSec);
		
		normsComboBox = new JComboBox<>(Parser.convertListObjToVectorStr(MainSortament.normsList));
		normsComboBox.setPreferredSize(new Dimension(getWidth()-30, 30));
		normsComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedNormIndex = normsComboBox.getSelectedIndex();
				selectedSectionIndex = 0;
				
				addToComparisonCheckBox.setEnabled(true);
				iconLabel.setIcon(MainSortament.normsList.get(selectedNormIndex).sections.get(0).icon);		
				//iconLabel.setSize(339, 363);
				Vector<Section> selectedNorm = MainSortament.normsList.get(selectedNormIndex).sections;
				Vector<String> namesOfSelectedSections = Section.makeVectorOfSectionsNames(selectedNorm);
				nameOfSecComboBox.removeAllItems();
				for (String string : namesOfSelectedSections) {
					nameOfSecComboBox.addItem(string);
				}
				nameOfSecComboBox.setEnabled(true);
				//nameOfSecComboBox.repaint();
				DefaultTableModel tableModel = new DefaultTableModel(selectedNorm.get(0).makeVectorOfFields(), selectedTableHead);
				secFeaturesTable.setModel(tableModel);
				secFeaturesTable.repaint();
				//tableScrollPane.revalidate();
				addToComparisonCheckBox.setSelected(false);
			}
		});
		
		headPanel = new JPanel();
		headPanel.setPreferredSize(new Dimension(getWidth()-30, 80));
		headPanel.add(headButtonPanel, BorderLayout.NORTH);
		headPanel.add(normsComboBox, BorderLayout.SOUTH);
		
		iconLabel = new JLabel(startIcon);		
		//iconLabel.setPreferredSize(new Dimension(startIcon.getIconWidth(), startIcon.getIconHeight()));
		
		addToComparisonCheckBox = new JCheckBox("Добавить к сравнению");
		//addToComparisonCheckBox.setPreferredSize(new Dimension(iconLabel.getWidth(), 20));;
		addToComparisonCheckBox.setEnabled(false);
		addToComparisonCheckBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainSortament.comparisonList.add(MainSortament.normsList.get(selectedNormIndex).sections.get(selectedSectionIndex));
				System.out.println(MainSortament.comparisonList);
				
			}
		});
		
		nameOfSecComboBox = new JComboBox<>();
		nameOfSecComboBox.setEnabled(false);
		nameOfSecComboBox.addActionListener(new ActionListener() {			

			@Override
			public void actionPerformed(ActionEvent e) {
				selectedSectionIndex = nameOfSecComboBox.getSelectedIndex();
				//System.out.println(selectedSectionIndex);
				Vector<Section> selectedNorm = MainSortament.normsList.get(selectedNormIndex).sections;
				Section selectedSection = selectedNorm.get(0);
				/*if (selectedSectionIndex != -1) {
					selectedSection = selectedNorm.get(selectedSectionIndex);
				} */
				DefaultTableModel tableModel = new DefaultTableModel(selectedSection.makeVectorOfFields(), selectedTableHead);
				secFeaturesTable.setModel(tableModel);
				secFeaturesTable.repaint();
				addToComparisonCheckBox.setSelected(false);
			}
		});
		
		iconPanel = new JPanel();		
		iconPanel.setPreferredSize(new Dimension(startIcon.getIconWidth(), startIcon.getIconHeight()+100));
		iconPanel.add(iconLabel, BorderLayout.NORTH);
		iconPanel.add(addToComparisonCheckBox, BorderLayout.CENTER);	
		iconPanel.add(nameOfSecComboBox, BorderLayout.SOUTH);	
		
		secFeaturesTable = new JTable();
		tableScrollPane = new JScrollPane(secFeaturesTable);
		
		centerPanel = new JPanel(new GridLayout(0, 2));
		centerPanel.setPreferredSize(new Dimension(getWidth()-30, getHeight() - 200));
		centerPanel.add(iconPanel);
		centerPanel.add(tableScrollPane);
		
		butToComparison = new JButton("Перейти к сравнению");
		butToComparison.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ComparisonFrame(screenSize);
				addToComparisonCheckBox.setSelected(false);
			}
		});
		
		butClearComparison = new JButton("Очистить сравнение");	
		butClearComparison.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainSortament.comparisonList.clear();
				addToComparisonCheckBox.setSelected(false);
			}
		});
		butExit = new JButton("Выход");

		bottomPanel = new JPanel(new GridLayout(0,3));
		bottomPanel.setPreferredSize(new Dimension(getWidth()-30, 30));
		bottomPanel.add(butToComparison);
		bottomPanel.add(butClearComparison);
		bottomPanel.add(butExit);

		add(headPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	
	

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
