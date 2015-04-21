package gui;
import java.awt.*;

import core.*;

import java.util.*;

import object.*;
public class DrawingFrame extends Frame {
	int xMax=800;
	int yMax=600;
	double scale=3;//Во столько раз объекты в int больше, чем в double
	OSys OS;
	Settings S;
	ArrayList<Ray> rays;
	  public DrawingFrame(OSys os, ArrayList<Ray> rays, Settings S) {
          super("Rays");
          setSize(xMax, yMax);
          setVisible(true);
          this.OS=os;
          this.S=S;
          this.rays=rays;
	  }
	public void paint(Graphics G){
		S.setX0(xMax/2);
		S.setY0(yMax/2);
		G.setColor(Color.lightGray);
		G.fillRect(0, 0, xMax, yMax);
		G.setColor(Color.GREEN);
		G.drawLine(0, S.getY0(), xMax, S.getY0());
		for(int i=0;i<OS.getDOE().size();i++)pnt(G,OS.getDOE().get(i),S);
		for(int i=0;i<rays.size();i++)pnt(G,rays.get(i),S);
		
	}
	void pnt(Graphics G, OptObj O, Settings S){
		if(O.getClass()==Ray.class){
			Ray R=(Ray)O;
			G.setColor(getRayColor(R.getLambda()));
			if(S.isBones()==true){
				double lenray=scale*Math.sqrt((R.getZs()-R.getZe())*(R.getZs()-R.getZe())+(R.getRs()-R.getRe())*(R.getRs()-R.getRe()));
				double speed=50;//length per second
				int stepsps=10;
				int all=(int)(lenray/(speed/stepsps));
				double lastX=(int)(R.getZs()*scale)+S.getX0();
				double lastY=-(int)(R.getRs()*scale)+S.getY0();
				for(int i=0; i<all;i++){
					double nextX=lastX+(Math.cos(R.getPhi())*lenray/all);
					double nextY=lastY-(Math.sin(R.getPhi())*lenray/all);
					G.drawLine((int)lastX, (int)lastY, (int)nextX, (int)nextY);
					lastX=nextX;
					lastY=nextY;					
					try {
						Thread.sleep(1000/stepsps-1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
					}
				}
				
			}else{
			G.drawLine(S.getX0()+(int)(R.getZs()*scale), S.getY0()-(int)(R.getRs()*scale), S.getX0()+(int)(R.getZe()*scale), S.getY0()-(int)(R.getRe()*scale));}			
		}
		if(O.getClass()==CircleHole.class){
			G.setColor(Color.DARK_GRAY);
			CircleHole ch=(CircleHole)O;
			G.drawLine((int)(ch.getZ()*scale)+S.getX0(), (int)(ch.getRadius()*scale)+S.getY0(),(int)(ch.getZ()*scale)+S.getX0(),yMax);
			G.drawLine((int)(ch.getZ()*scale)+S.getX0(), -(int)(ch.getRadius()*scale)+S.getY0(),(int)(ch.getZ()*scale)+S.getX0(),0);
		}
		if(O.getClass()==FlatLens.class){	
			int x=S.getX0()+(int)(O.getZ()*scale);
			int r=(int)(((FlatLens) O).getRadius()*scale);
			G.setColor(Color.DARK_GRAY);
			if(((FlatLens)O).getF()>0){
				G.drawLine(x, S.getY0()+r, x, S.getY0()-r);
				G.drawLine(x-7, S.getY0()-r+7, x, S.getY0()-r);
				G.drawLine(x+7, S.getY0()-r+7, x, S.getY0()-r);
				G.drawLine(x-7, S.getY0()+r-7, x, S.getY0()+r);
				G.drawLine(x+7, S.getY0()+r-7, x, S.getY0()+r);
			}else{	
			G.drawLine(x, S.getY0()+r, x, S.getY0()-r);
			G.drawLine(x-7, S.getY0()-r-7, x, S.getY0()-r);
			G.drawLine(x+7, S.getY0()-r-7, x, S.getY0()-r);
			G.drawLine(x-7, S.getY0()+r+7, x, S.getY0()+r);
			G.drawLine(x+7, S.getY0()+r+7, x, S.getY0()+r);
		}
		}
	}
	Color getRayColor(double lambda){
		return Color.red;	
	}
}
