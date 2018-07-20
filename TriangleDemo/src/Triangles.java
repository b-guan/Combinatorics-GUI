import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;

public class Triangles extends JFrame {
	//number of triangles formed
	static double number_of_triangles = 0;

	//number of nodes
	static int n;
	
	//percent, chance of forming a connection
	double p;

	//expected number of triangles formed
	double expected;

	private JPanel contentPane;
	private JTextField nodes_field;
	private JTextField probability_field;
	private JTextField expected_field;
	private JTextField actual_field;
	private JTextField difference_field;

	private JButton btnStart = new JButton("Start");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Triangles frame = new Triangles();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * Create the frame.
	 */
	public Triangles() {
		this.setTitle("Triangles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 269, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
						.addGap(22))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 428, Short.MAX_VALUE)
						.addGap(14))
				);

		nodes_field = new JTextField();
		nodes_field.setColumns(10);

		probability_field = new JTextField();
		probability_field.setColumns(10);
		probability_field.setText("Integers only");

		JLabel NumberOfNodes = new JLabel("Number of Nodes");

		JLabel Probability = new JLabel("Probability");

		JLabel lblExpectedNumberOt = new JLabel("Expected Number ot Triangles");

		JLabel lblActualNumberOt = new JLabel("Actual Number ot Triangles");

		JLabel lblDifference = new JLabel("Difference");

		JLabel lblSsssss = new JLabel("");

		expected_field = new JTextField();
		expected_field.setBackground(Color.WHITE);
		expected_field.setColumns(10);
		expected_field.setEditable(false);

		actual_field = new JTextField();
		actual_field.setBackground(Color.WHITE);
		actual_field.setColumns(10);
		actual_field.setEditable(false);

		difference_field = new JTextField();
		difference_field.setBackground(Color.WHITE);
		difference_field.setColumns(10);
		difference_field.setEditable(false);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(11)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(NumberOfNodes, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
										.addGap(9))
								.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(nodes_field, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
										.addGap(59))
								.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(Probability, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
										.addGap(50))
								.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(probability_field, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
										.addGap(56))
								.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(btnStart, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
										.addGap(24)))
						.addGap(31))
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblExpectedNumberOt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblDifference, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
						.addContainerGap())
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblActualNumberOt, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
						.addContainerGap())
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblSsssss, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
						.addGap(107))
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(expected_field, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
						.addGap(88))
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(actual_field, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
						.addGap(88))
				.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(difference_field, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
						.addGap(88))
				);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(32)
						.addComponent(NumberOfNodes, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
						.addGap(13)
						.addComponent(nodes_field, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addGap(13)
						.addComponent(Probability, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
						.addGap(11)
						.addComponent(probability_field, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(btnStart, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
						.addGap(37)
						.addComponent(lblExpectedNumberOt, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblSsssss)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(expected_field, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addGap(16)
						.addComponent(lblActualNumberOt, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(actual_field, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addGap(2)
						.addComponent(lblDifference, GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(difference_field)
						.addGap(39))
				);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);


		thehandler handler = new thehandler();
		btnStart.addActionListener(handler);


	}

	private class thehandler implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == btnStart) {
				p = (Double.parseDouble(probability_field.getText())/100.0);
				n = Integer.parseInt(nodes_field.getText());
				expected = (Math.pow(p, 3) * ((n*(n-1)*(n-2))/6));
				expected = Math.round(expected);
				expected_field.setText("" + expected);

				JFrame demo = new JFrame("Triangles");
				drawing triangles = new drawing();
				demo.getContentPane().add(triangles);
				demo.setSize(550, 550);
				demo.setVisible(true);
			}
		}
	}
	
	
	public class drawing extends JPanel{

		public void paintComponent(Graphics g) {
			number_of_triangles=0;
			super.paintComponent(g);
			this.setBackground(Color.white);
			g.setColor(Color.BLACK);
			HashMap<Integer, Integer[]> map = new HashMap<>();
			Random rand = new Random();
			int randX = 0;
			int randY = 0;
			
			//Nodes are represented by numbers 0..n-1, where n is the number of nodes
			//For each node, draws a circle at a randomly generated coordinate
			//Each node is then set as the key to a hashmap.
			//The value corresponding to each key is an Integer[]{x+3, y+3},
			//where x+3 and y+3 are the coordinates to the center of the node's circle
			for(int i=0; i<n; i++) {
				randX = rand.nextInt(400);
				randY = rand.nextInt(400);
				g.fillOval(randX,randY, 9,9);
				Integer[] value = {randX+3, randY+3};
				map.put(i, value);
			}
			
			//nodes is an ArrayList that will contain Integers 0..n-1. Each Integer is a distinct node
			ArrayList<Integer> nodes = new ArrayList(Triangles.n);
			
			/*connections is an ArrayList containing n ArrayLists. 
			 * each nested ArrayList, with index i, will contain the second element of each ArrayList in edges 
			 * that contain i as the first element
			 * (see edges line 274)
			 * example(using the edges example): [[3,4,5], [2,5], [], [5], [], []]
			 * */
			ArrayList<ArrayList<Integer>> connections = new ArrayList<ArrayList<Integer>>();
			for (int i =0; i<n; i++) {
				nodes.add(i,i);
				connections.add(new ArrayList<Integer>());
			}
			
			/*edges is an ArrayList that will keep track of each randomly formed edge formed, as a nested ArrayList
			 * Each nested ArrayList contains the two nodes that are connected with each other
			 * the ArrayLists are listed consecutively, according to the first element in each nested ArrayList
			 * nested ArrayLists with the same first element are also listed in increasing order,
			 * according to the second element in each nested ArrayList
			 * example: [[0,3], [0,4], [0,5], [1,2], [1,5], [3,5]]
			 * */
			ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
			int current;
			int factor;
			ArrayList<Integer> new_edge;
			for(int i=0; i< nodes.size()-1; i++) {
				current = i;
				ArrayList<Integer> next = new ArrayList<Integer>(nodes.subList(i+1, nodes.size()));
				for (Object a: next) {
					factor = rand.nextInt(101);
					if (factor<= p*100) {
						new_edge = new ArrayList<Integer>();
						new_edge.add(current);
						new_edge.add((Integer)a);
						edges.add(new_edge);
					}
				}
			}
			
			// see connections on line 262
			int index;
			for (ArrayList<Integer> b: edges) {
				index = b.get(0);
				connections.get(index).add(b.get(1));
			}
			
			/*Iterates through each list in connections. Within each list, checks if the
			 *each possible pair of nodes is actually an edge contained within the edge list
			 *If it is, then increase number_of_triangles by 1
			 * */
			Integer current_number;
			ArrayList<Integer> connecting_edge;
			for (int i1 =0; i1< connections.size(); i1++) {
				ArrayList<Integer> list = connections.get(i1);
				for (int p = 0; p< list.size(); p++) {
					current_number = list.get(p);
					ArrayList<Integer> check = new ArrayList<Integer>(list.subList(list.indexOf(current_number),  list.size()));
					for (Integer e: check) {
						connecting_edge = new ArrayList<Integer>();
						connecting_edge.add(current_number);
						connecting_edge.add(e);	
						if(edges.contains(connecting_edge)) {
							number_of_triangles+=1;
						}
					}
				}
			}
			for (int draw = 0; draw < edges.size(); draw++) {
				g.drawLine(map.get(edges.get(draw).get(0))[0], map.get(edges.get(draw).get(0))[1], map.get(edges.get(draw).get(1))[0], map.get(edges.get(draw).get(1))[1]);
			}
//			System.out.println("number of triangles: " + number_of_triangles);
//			System.out.println("connections: " + connections);
//			System.out.println("edges: " + edges);
			actual_field.setText("" + number_of_triangles);
			difference_field.setText("" + (number_of_triangles - (expected)));
		}
	}
}
