package core;


public class Settings {
	//Jetot klass hranit tekushhie nastrojki
	boolean waveOptics;//Ispol'zovat' volnovuju optiku
	boolean dispersion;//Ispol'zovat' n=n(lambda);
	boolean typeEverything;
	boolean bones=false;
	public boolean isBones() {
		return bones;
	}
	public void setBones(boolean bones) {
		this.bones = bones;
	}
	int x0,y0;//в этой точке экрана находится 0,0
	public int getX0() {
		return x0;
	}
	public void setX0(int x0) {
		this.x0 = x0;
	}
	public int getY0() {
		return y0;
	}
	public void setY0(int y0) {
		this.y0 = y0;
	}
	public void toDefault(){
		waveOptics=false;
		dispersion=true;
		typeEverything=false;
	}
	public boolean isWaveOptics() {
		return waveOptics;
	}
	public void setWaveOptics(boolean waveOptics) {
		this.waveOptics = waveOptics;
	}
	public boolean isDispersion() {
		return dispersion;
	}
	public void setDispersion(boolean dispersion) {
		this.dispersion = dispersion;
	}
	public boolean isDebug() {
		return typeEverything;
	}
	public void Debug(boolean typeEverything) {
		this.typeEverything = typeEverything;
	}
}