package frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import mainsortament.MainSortament;
import shapes.Section;

public class ComparisonFrame extends JFrame{
	
	Vector<Vector<String>> data = new Vector<>();
	Vector<String> head = new Vector<>(Arrays.asList("№", "P(кг/м.п.)", "F(см2)", "Jx(см4)", "Wx(см3)", "ix(см)", "Jy(см4)", "Wy(см3)", "iy(см)"));
	JTable table = null;
	JScrollPane scrollPane;
	
	JButton exitButton;

	public ComparisonFrame(Dimension screenSize) throws HeadlessException {
		super();
		
		setTitle("Сравнение профилей по характеристикам");
		setSize(800, 500); 
		setResizable(false);
		setLocation((screenSize.width-getWidth() )/2, (screenSize.height-getHeight())/2); 
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);  
		setLayout(new BorderLayout());
		setAlwaysOnTop(true);
		MainSortament.mainFrame.setEnabled(false);
		
		for (Section section : new Vector<>(MainSortament.comparisonList)) {
			data.add(section.getFieldsForComparison());
		}
		
		table = new JTable(data, head);
		
		scrollPane = new JScrollPane(table);
		
		add(scrollPane, BorderLayout.NORTH);
		
		exitButton = new JButton("Выход из сравнения");
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				MainSortament.mainFrame.setEnabled(true);
			}
		});
		
		add(exitButton, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
