import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import media.Calculador;

public class App {
    
    public static void main(String[] args) throws Exception {
      
        Calculador B1 = new Calculador();
		Calculador B2 = new Calculador();
		
        //MS = (AM * 0,3) + (AC * 0,2) + (AS * 0,5)
		double m_grad = B1.calcular_media(9.5, 4.7, 6.9);
        //MM = (PM * 0,4) + (AS * 0,6)
		double m_pos = B2.calcular_media(7.4, 9.2);

        Icon icone = new ImageIcon("D:/imagens/shitpost/FmStA6uWQAIJfr7.jpeg");
		
		JOptionPane.showMessageDialog(null, "A média do aluno de graduação é " + m_grad + "\nA média do aluno de pós-graduação é " + m_pos, "BOLETIM", JOptionPane.PLAIN_MESSAGE, icone);

    }

}
