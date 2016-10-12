package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controle.Jogo;

public class TelaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 8245159786346318363L;
	private Jogo jogo;

	public TelaPrincipal() {
		super("Campo Minado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		jogo = new Jogo(this);
		this.defineTamanhoDaMatriz();
		add(jogo.getPainelDeBotoes());

		setVisible(true);
		pack();
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		jogo.botaoClicado((JButton) e.getSource());
	}

	private void defineTamanhoDaMatriz() {
		// Definir o tamanho da matriz
		boolean repete;
		do {
			String valorInformado = JOptionPane.showInputDialog("Informe a quantidade de elementos: ");

			int tamanhoSolicitado = 0;
			try {
				tamanhoSolicitado = Integer.parseInt(valorInformado);
				repete = false;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Valor inválido");
				repete = true;
			}

			int tamanhoMatriz = jogo.defineTamanhoMatriz(tamanhoSolicitado);
			if (tamanhoMatriz < 0) {
				JOptionPane.showMessageDialog(null, "Valor muito grande.");
				repete = true;
			}
		} while (repete);
	}

}
