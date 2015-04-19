package core;


public class Settings {
	//Jetot klass hranit tekushhie nastrojki
	boolean waveOptics;//Ispol'zovat' volnovuju optiku
	boolean dispersion;//Ispol'zovat' n=n(lambda);
	
	public void toDefault(){
		waveOptics=false;
		dispersion=true;
	}
}