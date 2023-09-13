import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.net.URL;
import java.io.FileOutputStream;

public class App {

    public static void main(String[] args) throws Exception {

        URL url = new URL("https://media.istockphoto.com/id/177122214/pt/foto/selo-de.jpg?s=612x612&w=0&k=20&c=-9Lwici4jU3M1HtNnsDjALxtn-P6xtlaI6iqOWzZ9JU=");

        url.openStream().transferTo(new FileOutputStream("foca.jpeg"));

		Icon i = new ImageIcon("foca.jpeg");
		
	    JOptionPane.showMessageDialog(null, "Olá \n Ai está a foquinha fofinha!", "foca fofa", JOptionPane.PLAIN_MESSAGE, i);



    }

}
