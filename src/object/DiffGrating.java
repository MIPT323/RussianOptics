package object;

public class DiffGrating extends DOE{
	
	private double b;//periud reshotki
	private double d;//shyrina zheli
	private int nameN;
	

//	public DiffGrating() {
//		
//	}
	
	public void setPeriod(double period){
		b = period;
	}
	public double getPeriod(){
		return b;
	}
	public void setWidth(double w){
		d=w;
	}
	public double getWidth(){
		return d;
	}
	public void setQuanTouches(int n){
		nameN = n;
	}
	public int getQuanTouches(){
		return nameN;
	}

}
