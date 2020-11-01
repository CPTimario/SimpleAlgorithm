import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class SimpleAlgorithm {
	private final static String SORT = "Sorting";
	private final static String STACK = "Stacks";
	private final static String QUEUE = "Queues";
	private final static int extraWindowWidth = 100;

	private boolean repeat = true;

	public static void main(String[] args) {
		start();
	}

	private static void start() {
		setUILookAndFeel();
		displayInitialMessage();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				displayMenu();
			}
		});
	}

	private static void displayInitialMessage() {
		StringBuilder message = new StringBuilder();
		message.append("Case Study in Data Structure\n\n\n");
		message.append("Presented by:\n\nCHRISTOPHER P. TIMARIO\n");
		message.append("CEIT-03-401P\nMH/1:30pm-3:00pm");
		JOptionPane.showMessageDialog(null, message, "Case Study", JOptionPane.INFORMATION_MESSAGE);
	}

	private static void setUILookAndFeel() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			UIManager.put("swing.boldMetal", Boolean.FALSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void displayMenu() {
		JFrame frame = new JFrame("Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SimpleAlgorithm card = new SimpleAlgorithm();
		card.addComponentToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

	public void addComponentToPane(Container pane) {
		JTabbedPane tabbedPane = new JTabbedPane();
		JPanel sortTab = getSortTab();
		JPanel stackTab = getStackTab();
		JPanel queueTab = getQueueTab();
		tabbedPane.addTab(SORT, sortTab);
		tabbedPane.addTab(STACK, stackTab);
		tabbedPane.addTab(QUEUE, queueTab);
		pane.add(tabbedPane, BorderLayout.CENTER);
	}

	public static void executeAlgorithm(String className) {
		try {
			Class<?> classToExecute = Class.forName("algorithms." + className);
			Method mainMethod = classToExecute.getDeclaredMethod("main", String[].class);
			mainMethod.invoke(null, new Object[] { new String[] {} });
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private JPanel getSortTab() {
		JPanel sortPanel = getDefaultJPanel();
		Box layout = new Box(BoxLayout.Y_AXIS);
		JButton bubble = new JButton("Bubble Sort");
		JButton select = new JButton("Selection Sort");
		JButton insert = new JButton("Insertion Sort");
		bubble.addActionListener(getActionListener("BubbleSort"));
		select.addActionListener(getActionListener("SelectionSort"));
		insert.addActionListener(getActionListener("InsertionSort"));
		layout.add(bubble);
		layout.add(select);
		layout.add(insert);
		sortPanel.add(layout);
		return sortPanel;
	}

	private JPanel getStackTab() {
		JPanel stackPanel = getDefaultJPanel();
		Box layout = new Box(BoxLayout.Y_AXIS);
		JButton basicStack = new JButton("Basic Stack");
		basicStack.addActionListener(getActionListener("Stacks"));
		layout.add(basicStack);
		stackPanel.add(layout);
		return stackPanel;
	}

	private JPanel getQueueTab() {
		JPanel stackPanel = getDefaultJPanel();
		Box layout = new Box(BoxLayout.Y_AXIS);
		JButton basicQueue = new JButton("Basic Queue");
		basicQueue.addActionListener(getActionListener("Queues"));
		layout.add(basicQueue);
		stackPanel.add(layout);
		return stackPanel;
	}

	private JPanel getDefaultJPanel() {
		return new JPanel() {
			private static final long serialVersionUID = 1L;

			public Dimension getPreferredSize() {
				Dimension size = super.getPreferredSize();
				size.width += extraWindowWidth;
				return size;
			}
		};
	}

	private ActionListener getActionListener(String className) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				repeat = false;
				do {
					SimpleAlgorithm.executeAlgorithm(className);
					prompt();
				} while (repeat);
			}
		};
	}

	private void prompt() {
		String[] options = { "Home", "Repeat", "Exit" };
		int choice = JOptionPane.showOptionDialog(null, "Continue?", "Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, null);
		switch (choice) {
			case 0:
				repeat = false;
				break;
			case 1:
				repeat = true;
				break;
			case 2:
			default:
				repeat = false;
				JOptionPane.showMessageDialog(null, "Program Terminated!", "Prompt", JOptionPane.WARNING_MESSAGE);
				System.exit(0);
				break;
		}
	}
}