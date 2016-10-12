package controle;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entidade.Posicao;

public class Jogo {

	private Posicao mPosicaoArray[][] = null;
	private int mTamanhoMatriz = 0;
	private JPanel painelDeBotoes = null;
	private ActionListener actionListener;

	public Jogo(ActionListener actionListener) {
		this.actionListener = actionListener;
	}

	/*
	 * Retorna o tamanho para a matriz Retorna negativo se o valor muito grande
	 */
	public int defineTamanhoMatriz(int tamanhoSolicitado) {
		mTamanhoMatriz = (int) Math.round(Math.sqrt(tamanhoSolicitado));
		System.out.println(mTamanhoMatriz);
		if (mTamanhoMatriz >= 20)
			return -1;
		this.criaAsPosicoes();
		this.implantaBombas();
		return mTamanhoMatriz;
	}

	private JPanel criaAsPosicoes() {
		painelDeBotoes = new JPanel(new GridLayout(mTamanhoMatriz, mTamanhoMatriz));
		mPosicaoArray = new Posicao[mTamanhoMatriz][mTamanhoMatriz];
		for (int linha = 0; linha < this.mTamanhoMatriz; linha++) {
			for (int coluna = 0; coluna < this.mTamanhoMatriz; coluna++) {
				mPosicaoArray[linha][coluna] = new Posicao(linha, coluna);
				painelDeBotoes.add(mPosicaoArray[linha][coluna].getjButton());
				mPosicaoArray[linha][coluna].getjButton().addActionListener(actionListener);
			}
		}
		return painelDeBotoes;
	}

	private void implantaBombas() {
		int quantidadeBombas = (int) (Math.round((mTamanhoMatriz * mTamanhoMatriz) / 10)) * 2;
		System.out.println(mTamanhoMatriz + " " + mTamanhoMatriz * mTamanhoMatriz + " " + quantidadeBombas);
		boolean repete = true;
		Random geradorDefinePosicaoDaBomba = new Random();
		do {
			int linha = geradorDefinePosicaoDaBomba.nextInt(mTamanhoMatriz);
			int coluna = geradorDefinePosicaoDaBomba.nextInt(mTamanhoMatriz);

			if (!mPosicaoArray[linha][coluna].isBomba()) {
				mPosicaoArray[linha][coluna].setBomba();
				if (--quantidadeBombas == 0)
					repete = false;
			}
		} while (repete);
	}

	public void botaoClicado(JButton jButton) {
//		String posicaoBotaoClicado = jButton.getActionCommand();
//		String[] posicao = posicaoBotaoClicado.split(",");
//		int linhaOriginal = Integer.parseInt(posicao[0]);
//		int colunaOriginal = Integer.parseInt(posicao[1]);
//		mPosicaoArray[linhaOriginal][colunaOriginal].setClicado();
		
		Posicao posicao = pegaPosicaoBotaoClicado(jButton);
		int linhaOriginal = posicao.getLinha();
		int colunaOriginal = posicao.getColuna();
		posicao.setClicado();
		
		// -L-C | -L | -L+C
		//   -C |  O |   +C
		// +L-C | +L | +L+C

		//TODO tratar os cliques nas colunas e linhas das bordas
		
		(mPosicaoArray[linhaOriginal - 1][colunaOriginal - 1]).getjButton().setBackground(Color.green);
		(mPosicaoArray[linhaOriginal - 1][colunaOriginal]).getjButton().setBackground(Color.green);
		(mPosicaoArray[linhaOriginal - 1][colunaOriginal + 1]).getjButton().setBackground(Color.green);
		(mPosicaoArray[linhaOriginal][colunaOriginal - 1]).getjButton().setBackground(Color.green);
		(mPosicaoArray[linhaOriginal][colunaOriginal + 1]).getjButton().setBackground(Color.green);
		(mPosicaoArray[linhaOriginal + 1][colunaOriginal - 1]).getjButton().setBackground(Color.green);
		(mPosicaoArray[linhaOriginal + 1][colunaOriginal]).getjButton().setBackground(Color.green);
		(mPosicaoArray[linhaOriginal + 1][colunaOriginal + 1]).getjButton().setBackground(Color.green);

	}

	private Posicao pegaPosicaoBotaoClicado(JButton jButton) {
		for (int linha = 0; linha < this.mTamanhoMatriz; linha++)
			for (int coluna = 0; coluna < this.mTamanhoMatriz; coluna++)
				if (mPosicaoArray[linha][coluna].getjButton().equals(jButton)) {
					return mPosicaoArray[linha][coluna];
				}
		return null;
	}

	public JPanel getPainelDeBotoes() {
		return painelDeBotoes;
	}
}
