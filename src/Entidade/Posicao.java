package Entidade;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Posicao {
	
	private int linha;
	private int coluna;
	private boolean bomba;
	private boolean clicado;
	private JButton jButton;
	
	
	
	/*
	 * botoesArray[linha][coluna] = new JButton(linha + "," + coluna);
				botoesArray[linha][coluna].setActionCommand(linha + "," + coluna);
				botoesArray[linha][coluna].setToolTipText(linha + "," + coluna);
	 * 
	 * 
	 */
	public Posicao(int linha, int coluna) {
		super();
		this.linha = linha;
		this.coluna = coluna;
		this.bomba = false;
		this.clicado = false;
		jButton = new JButton(linha + "," + coluna);
	}


	public int getLinha() {
		return linha;
	}


	public void setLinha(int linha) {
		this.linha = linha;
		jButton.setText(linha + "," + coluna);
	}


	public int getColuna() {
		return coluna;
	}


	public void setColuna(int coluna) {
		this.coluna = coluna;
		jButton.setText(linha + "," + coluna);
	}


	public boolean isBomba() {
		return bomba;
	}


	public void setBomba() {
		this.bomba = true;
		Image imagem, imagemMenor = null;
		try {
			imagem = ImageIO.read(getClass().getResource("imagens/bomba.jpg"));
			imagemMenor = imagem.getScaledInstance(25, 20, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			System.out.println("ERRO ao carregar icon!!!");
		}
		
		jButton.setText("B");
		jButton.setIcon(new ImageIcon(imagemMenor));
		jButton.setForeground(Color.BLUE);
		jButton.setBackground(Color.WHITE);
	}


	public boolean isClicado() {
		return clicado;
	}


	public void setClicado(boolean clicado) {
		this.clicado = clicado;
		jButton.setBackground(Color.YELLOW);
	}


	public JButton getjButton() {
		return jButton;
	}


	public void setjButton(JButton jButton) {
		this.jButton = jButton;
	}
	
	
	

}
