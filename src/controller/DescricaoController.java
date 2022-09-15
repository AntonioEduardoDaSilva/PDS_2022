package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import model.BaseDeDados;
import model.Tema;
import model.TipoErro;
import view.Mensagem;
import view.TelaMenu;

public class DescricaoController implements ActionListener{


	private FormularioHandler formularioHandler;
	private TelaMenu telaMenu;

	public DescricaoController(TelaMenu telaMenu) {
		this.formularioHandler = new FormularioHandler();
		this.telaMenu = telaMenu;

		control();
	}

	private void control() {
		telaMenu.getDescricaoPanel().getButtonPanel().getCadastrarButton().addActionListener(this);
		telaMenu.getBuscarDescricaoPanel().getBuscarDescricaoButton().addActionListener(this);
		telaMenu.getDescricaoPanel().getButtonPanel().getRemoverButton().addActionListener(this);
		telaMenu.getDescricaoPanel().getButtonPanel().getAtualizarButton().addActionListener(this);
		telaMenu.getDescricaoPanel().getNomeTemaT().addCaretListener(formularioHandler);
		telaMenu.getDescricaoPanel().getInfoArea().addCaretListener(formularioHandler);
	}
	private class FormularioHandler implements FocusListener, CaretListener{

		@Override
		public void caretUpdate(CaretEvent e) {
			if( !(telaMenu.getDescricaoPanel().getNomeTemaT().getText().length()!=0
					&& telaMenu.getDescricaoPanel().getInfoArea().getText().length()!=0)) {
				telaMenu.getDescricaoPanel().getButtonPanel().getCadastrarButton().setEnabled(false);
			}else {
				telaMenu.getDescricaoPanel().getButtonPanel().getCadastrarButton().setEnabled(true);
			}
		}

		@Override
		public void focusGained(FocusEvent e) {}

		@Override
		public void focusLost(FocusEvent e) {}

	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==telaMenu.getDescricaoPanel().getButtonPanel().getCadastrarButton()) {
			if((BaseDeDados.buscarTema(telaMenu.getDescricaoPanel().getNomeTemaT().getText().toUpperCase()))!=null) {
				(BaseDeDados.buscarTema(telaMenu.getDescricaoPanel().getNomeTemaT().getText().toUpperCase())).setDescricao(telaMenu.getDescricaoPanel().getInfoArea().getText());;

				Mensagem.exibirMensagem("Descrição cadastrada com sucesso.");
				telaMenu.getDescricaoPanel().getNomeTemaT().setText("");
				telaMenu.getDescricaoPanel().getInfoArea().setText("");

			}else {
				Mensagem.exibirMensagem(TipoErro.NAO_EXISTE_TEMA);
			}

		}
		if(e.getSource()==telaMenu.getBuscarDescricaoPanel().getBuscarDescricaoButton()) {

			if((BaseDeDados.buscarTema(telaMenu.getBuscarDescricaoPanel().getNomeTemaT().getText().toUpperCase()))!=null) {
				telaMenu.getDescricaoPanel().getNomeTemaT().setText(BaseDeDados.buscarTema(telaMenu.getBuscarDescricaoPanel().getNomeTemaT().getText().toUpperCase()).getNome());
				telaMenu.getDescricaoPanel().getInfoArea().setText(BaseDeDados.buscarTema(telaMenu.getBuscarDescricaoPanel().getNomeTemaT().getText().toUpperCase()).getDescricao());

				telaMenu.getBuscarDescricaoPanel().setVisible(false);
				telaMenu.getDescricaoPanel().getButtonPanel().getAtualizarButton().setVisible(true);
				telaMenu.getDescricaoPanel().getButtonPanel().getRemoverButton().setVisible(true);
				telaMenu.getDescricaoPanel().getButtonPanel().getCadastrarButton().setVisible(false);
				telaMenu.getDescricaoPanel().setVisible(true);
			}else {
				Mensagem.exibirMensagem(TipoErro.NAO_EXISTE_TEMA);
			}
		}
		if(e.getSource()==telaMenu.getDescricaoPanel().getButtonPanel().getRemoverButton()) {
			(BaseDeDados.buscarTema(telaMenu.getBuscarDescricaoPanel().getNomeTemaT().getText().toUpperCase())).setDescricao("");
			Mensagem.exibirMensagem("Descricao removida com sucesso.");
			telaMenu.getDescricaoPanel().setVisible(false);
		}
		if(e.getSource()==telaMenu.getDescricaoPanel().getButtonPanel().getAtualizarButton()) {
			if((BaseDeDados.buscarTema(telaMenu.getDescricaoPanel().getNomeTemaT().getText().toUpperCase()))!=null) {
				(BaseDeDados.buscarTema(telaMenu.getDescricaoPanel().getNomeTemaT().getText().toUpperCase())).setDescricao(telaMenu.getDescricaoPanel().getInfoArea().getText());;

				Mensagem.exibirMensagem("Descrição atualizada com sucesso.");
				telaMenu.getDescricaoPanel().getNomeTemaT().setText("");
				telaMenu.getDescricaoPanel().getInfoArea().setText("");
				telaMenu.getDescricaoPanel().setVisible(false);

			}else {
				Mensagem.exibirMensagem(TipoErro.NAO_EXISTE_TEMA);
			}
		}
	}

}
