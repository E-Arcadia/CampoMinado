import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaPrincipal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 8245159786346318363L;
	JButton botoesArray[][] = null;

	public TelaPrincipal(int tamanhoMatriz) {
		super("Campo Minado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		add(inicializaBotoes(tamanhoMatriz));
		
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
	}

	

	private JPanel inicializaBotoes(int tamanho) {
		JPanel painel = new JPanel(new GridLayout(tamanho, tamanho));
		botoesArray = new JButton[tamanho][tamanho];
		for (int linha = 0; linha < tamanho; linha++) {
			for (int coluna = 0; coluna < tamanho; coluna++) {
				botoesArray[linha][coluna] = new JButton(linha + "," + coluna);
				botoesArray[linha][coluna].setActionCommand(linha +","+ coluna);
				botoesArray[linha][coluna].setToolTipText(linha +","+ coluna);
				botoesArray[linha][coluna].addActionListener(this);
				painel.add(botoesArray[linha][coluna]);
			}
		}
		return painel;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String posicaoBotaoClicado = e.getActionCommand();
		String[] posicao = posicaoBotaoClicado.split(",");
		int linhaOriginal = Integer.parseInt(posicao[0]);
		int colunaOriginal = Integer.parseInt(posicao[1]);
				
//		-L-C | -L | -L+C
//		-C   |  O | +C
//		+L-C | +L | +L+C	
		
		(botoesArray[linhaOriginal-1][colunaOriginal-1]).setBackground(Color.green);
		(botoesArray[linhaOriginal-1][colunaOriginal]).setBackground(Color.green);
		(botoesArray[linhaOriginal-1][colunaOriginal+1]).setBackground(Color.green);
		(botoesArray[linhaOriginal][colunaOriginal-1]).setBackground(Color.green);
		(botoesArray[linhaOriginal][colunaOriginal+1]).setBackground(Color.green);
		(botoesArray[linhaOriginal+1][colunaOriginal-1]).setBackground(Color.green);
		(botoesArray[linhaOriginal+1][colunaOriginal]).setBackground(Color.green);
		(botoesArray[linhaOriginal+1][colunaOriginal+1]).setBackground(Color.green);
		
		JButton botaoClicado = (JButton) e.getSource();
		botaoClicado.setBackground(Color.YELLOW);
		
	}
}