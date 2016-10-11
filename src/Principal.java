import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		boolean repete;
		int tamanhoMatriz = 0;
		do {
			String elementos = JOptionPane.showInputDialog("Informe a quantidade de elementos: ");

			int valor = 0;
			try {
				valor = Integer.parseInt(elementos);
				repete = false;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Valor inválido");
				repete = true;
			}

			tamanhoMatriz =  (int) Math.round(Math.sqrt(valor));
			System.out.println(tamanhoMatriz);
			if(tamanhoMatriz >= 20){
				JOptionPane.showMessageDialog(null, "Valor muito grande.");
				repete = true;
			}
		} while (repete);
		 new TelaPrincipal(tamanhoMatriz);

		System.out.println("Sistema encerrou!!!");
	}

}
