package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import util.SpringUtilities;

public class BuscarDescricaoPanel extends JPanel{
	
	private JLabel buscarDescricaoLabel, nomeTemaL;
	private JTextField nomeTemaT;
	private JButton buscarDescricaoButton;
	private JPanel inicioPanel, meioPanel ,fimPanel;
	
	public BuscarDescricaoPanel() {
		setLayout(new BorderLayout());
		setBackground(Color.white);
		
		buscarDescricaoLabel = new JLabel("BUSCAR DESCRIÇÃO");
		
		nomeTemaL = new JLabel("Nome do Tema:");
		nomeTemaT = new JTextField(10);
		
		buscarDescricaoButton = new JButton("Buscar");
		
		inicioPanel = new JPanel();
		inicioPanel.add(buscarDescricaoLabel);
		
		meioPanel = new JPanel(new SpringLayout());
		meioPanel.add(nomeTemaL);
		meioPanel.add(nomeTemaT);
		SpringUtilities.makeCompactGrid(meioPanel, 
				1, 2, //linha, coluna
				2, 70, //inicialX, inicialY
				3, 100);//finalX, finalY
		
		fimPanel = new JPanel();
		fimPanel.add(buscarDescricaoButton);
		
		add(inicioPanel, BorderLayout.NORTH);
		add(meioPanel, BorderLayout.CENTER);
		add(fimPanel, BorderLayout.SOUTH);
		
	}

	public JLabel getBuscarDescricaoLabel() {
		return buscarDescricaoLabel;
	}

	public JLabel getNomeTemaL() {
		return nomeTemaL;
	}

	public JTextField getNomeTemaT() {
		return nomeTemaT;
	}

	public JButton getBuscarDescricaoButton() {
		return buscarDescricaoButton;
	}

}
