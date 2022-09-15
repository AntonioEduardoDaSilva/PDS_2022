package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import util.SpringUtilities;

public class DescricaoPanel extends JPanel{
	
    private JTextArea infoArea;
    private ButtonPanel buttonPanel;
    private JLabel titulo, nomeTema, vazio;
    private JTextField nomeTemaT;
    private JPanel mainPanel;
	
	public DescricaoPanel() {
		
		setSize(300 , 300);
		setLayout(new BorderLayout());
		
		titulo = new JLabel("Descricao de Tema:");
		vazio = new JLabel();
		
		nomeTema = new JLabel("Nome do tema:");
		nomeTemaT = new JTextField(10);
		
		buttonPanel = new ButtonPanel();
		buttonPanel.getCadastrarButton().setEnabled(false);
		
		mainPanel= new JPanel(new SpringLayout());
		
		mainPanel.add(nomeTema);
		mainPanel.add(nomeTemaT);
		mainPanel.add(titulo);
		mainPanel.add(vazio);
		
		SpringUtilities.makeCompactGrid(mainPanel,2,2,4,4,4,4);

		infoArea= new JTextArea(12,10); 
		JScrollPane scroll = new JScrollPane(infoArea); 
		add(mainPanel, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER); 
		add(buttonPanel, BorderLayout.SOUTH);
	}

	public JTextArea getInfoArea() {
		return infoArea;
	}

	public ButtonPanel getButtonPanel() {
		return buttonPanel;
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public JLabel getNomeTema() {
		return nomeTema;
	}

	public JLabel getVazio() {
		return vazio;
	}

	public JTextField getNomeTemaT() {
		return nomeTemaT;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

}
