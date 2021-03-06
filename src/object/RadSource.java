package object;
import java.util.ArrayList;

import core.*;
public class RadSource extends OptObj{
	
	private double lambda;
	private double deltaLambda;
	private double ampl;
	private double phaseAtZero;
	private double kz,kr,kq;
	private double sz,sr,sq;
	private double polionAng;
//	private boolean polion = false;
	
//	public RadSourse() {
//		
//	}
	
	public void emit(ArrayList<Ray> rays, Settings S){
		Ray one = new Ray(cg.getZ(),cg.getR(),0.2);
		one.setLambda(lambda);
		rays.add(one);
		if(S.isDebug())System.out.println("Ray #"+(rays.size()-1)+ " emitted");
	}
	
	
	public void setLengthWave(double lengthWave){
		lambda = lengthWave;
	}
	public double getLengthWave(){
		return lambda;
	}
	public void setDeltaLengthWave(double deltaLengthWave){
		deltaLambda = deltaLengthWave;
	}
	public double getDeltaLengthWave(){
		return deltaLambda;
	}
	public void setAmplitude(double amplitude){
		ampl = amplitude;
	}
	public double getAmplitude(){
		return ampl;
	}
	public void setPhaseAtOrigin(double phaseAtOrigin){
		phaseAtZero = phaseAtOrigin;
	}
	public double getPhase(){
		return phaseAtZero;
	}
	public void setKz(double waveVectorW){
		kz = waveVectorW;
	}
	public double getKz(){
		return kz;
	}
	public void setKr(double waveVectorH){
		kr = waveVectorH;
	}
	public double getKr(){
		return kr;
	}
	public void setKq(double waveVectorA){
		kq = waveVectorA;
	}
	public double getKq(){
		return kq;
	}
	public void setSz(double poyntingVectorW){
		sz = poyntingVectorW;
	}
	public double getSz(){
		return sz;
	}
	public void setSr(double poyntingVectorH){
		sr = poyntingVectorH;
	}
	public double getSr(){
		return sr;
	}
	public void setSq(double poyntingVectorA){
		sq = poyntingVectorA;
	}
	public double getSq(){
		return sq;
	}
	public void setPolarAngle(double polarizationAngle){
		polionAng = polarizationAngle;
	}
	public double getPolarAngle(){
		return polionAng;
	}
	
	
}
