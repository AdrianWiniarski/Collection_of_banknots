import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Zadanie extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton author, dodBank,usunBank, usunWsz ;//JButton deklaracja przyciskow
	private Picture myPanel;
	private final String AUTHOR="Imiê i nazwisko:\n"+
			"Adrian W.\n"+"kierunek:\n"+
			"Informatyka\n"+"Numer indeksu:\n"+
			"";
	private JMenu menu;
	private JMenuItem closeItem, authorItem;
	private JMenuBar menuBar;
	private HashSet<Banknot> banknoty= new HashSet<Banknot>(0);
	private JTextField value, currency;
	private JLabel valueLabel, currencyLabel;
	private JTextArea podglad;
	
	public Zadanie() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super("Adrian W.");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 300);
		author = new JButton("Autor");
		myPanel = new Picture();
		this.add(myPanel);
		myPanel.add(author);
		author.addActionListener(this);
		
		menuBar = new JMenuBar();
		menu = new JMenu();
		menu.setText("Menu");
		menuBar.add(menu);
		closeItem = new JMenuItem();
		closeItem.setText("Zamknij");
		menu.add(closeItem);
		//this.add(menuBar);
		this.setJMenuBar(menuBar);
		authorItem= new JMenuItem();
		authorItem.setText("Autor");
		menu.add(authorItem);
		closeItem.addActionListener(this);
		authorItem.addActionListener(this);
		
		myPanel.addKeyListener(myPanel);
		myPanel.setFocusable(true);
		valueLabel= new JLabel("wartosc");
		currencyLabel = new JLabel("waluta");
		value = new JTextField();
		//this.setSize(100, 10);
		value.setPreferredSize(new Dimension(80, 30));
		currency = new JTextField();
		currency.setPreferredSize(new Dimension(80, 30));
		//value.setSize();
		//value.setMinimumSize(new Dimension(100, 40));
		myPanel.add(valueLabel);
		myPanel.add(value);
		myPanel.add(currencyLabel);
		myPanel.add(currency);
		dodBank = new JButton("dodaj");
		usunBank = new JButton("usun");
		usunWsz = new JButton("usun wszystkie");
		dodBank.addActionListener(this);
		usunBank.addActionListener(this);
		usunWsz.addActionListener(this);
		myPanel.add(dodBank);
		myPanel.add(usunBank);
		myPanel.add(usunWsz);
		podglad= new JTextArea();
		podglad.setPreferredSize(new Dimension(200, 150));
		myPanel.add(podglad);
		

		
		
		
		
		
		this.setVisible(true);
		
	}

	public Zadanie(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	public Zadanie(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public Zadanie(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source=e.getSource();
		
		if(source==author){
			JOptionPane.showMessageDialog(null, AUTHOR);
		}
		if(source==authorItem){
			JOptionPane.showMessageDialog(null, AUTHOR);
		}
		if(source==closeItem) {
		//this.dispose();
		System.exit(0);
		}
		if(source==dodBank)
		{
			Banknot b = new Banknot(Integer.parseInt(value.getText()),currency.getText());
			banknoty.add(b);
			podglad.setText(banknoty.stream() .map( Object::toString )
		            .collect( Collectors.joining( ";\n") ));
		}
		if(source==usunBank)
		{
			Banknot b = new Banknot(Integer.parseInt(value.getText()),currency.getText());
			banknoty.remove(b);
			podglad.setText(banknoty.toString());
		}
		if(source==usunWsz)
		{
			banknoty.clear();
			podglad.setText(banknoty.toString());
		}
		
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Zadanie();
	}

}
