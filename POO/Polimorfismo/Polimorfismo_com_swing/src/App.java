import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) throws Exception {

        /*
		   ERROR_MESSAGE
		   INFORMATION_MESSAGE
		   WARNING_MESSAGE
		   QUESTION_MESSAGE
		   PLAIN_MESSAGE
		*/

		JOptionPane.showMessageDialog(null, "Olá. \n Esse é um exemplo de método polimórfico");
		
		JOptionPane.showMessageDialog(null, "Olá \n Esse é um exemplo de método polimórfico", "Informações Gerais", JOptionPane.ERROR_MESSAGE);

		ImageIcon icone = new ImageIcon("C:/Users/Davi Campolina/Pictures/shitpost/FmStA6uWQAIJfr7.jpeg");
		
	    JOptionPane.showMessageDialog(null, "Olá \n Esse é um exemplo de método polimórfico", "Informações Gerais", JOptionPane.ERROR_MESSAGE, icone);

		
    }

}
