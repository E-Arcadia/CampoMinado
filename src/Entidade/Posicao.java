package entidade;

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
	private Image imagemMenor = null;
	
	
	
	public Posicao(int linha, int coluna) {
		super();
		this.linha = linha;
		this.coluna = coluna;
		this.bomba = false;
		this.clicado = false;
		jButton = new JButton(linha + "," + coluna);
		jButton.setActionCommand(linha + "," + coluna);
		jButton.setToolTipText(linha + "," + coluna);
	}


	public int getLinha() {
		return linha;
	}


	public int getColuna() {
		return coluna;
	}

	public boolean isBomba() {
		return bomba;
	}


	public void setBomba() {
		this.bomba = true;
		this.carregaIcon();
		jButton.setIcon(new ImageIcon(imagemMenor));
		jButton.setText("");
		//jButton.setText("B");
		jButton.setForeground(Color.BLUE);
		jButton.setBackground(Color.WHITE);
	}


	private void carregaIcon() {
		Image imagem = null;
		try {
			imagem = ImageIO.read(getClass().getResource("../imagens/bomba.jpg"));
			imagemMenor = imagem.getScaledInstance(25, 20, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			System.out.println("ERRO ao carregar icon!!!");
		}
	}


	public boolean isClicado() {
		return clicado;
	}


	public void setClicado() {
		this.clicado = true;
		jButton.setBackground(Color.YELLOW);
	}


	public JButton getjButton() {
		return jButton;
	}
}
