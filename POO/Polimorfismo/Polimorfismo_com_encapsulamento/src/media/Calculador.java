package media;

public class Calculador {

    public double calcular_media(double AM, double AC, double AS) {
		
		double media = AM * 0.3 + AC * 0.2 + AS * 0.5;
		return media;
        
    }
	
public double calcular_media(double PM, double AS) {
		
		double media = PM * 0.4 + AS * 0.6;
		return media;

    }
    
}
