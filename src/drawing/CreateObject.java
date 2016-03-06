package drawing;

import java.awt.Point;
import java.util.ArrayList;

import view.DrawingPanel;

public class CreateObject{
	private static WorldPoint _referencePoint;
	private static ArrayList<WorldPoint> _worldPoint = new ArrayList<WorldPoint>();
	private static ArrayList<LocalPoint> _localPoint = new ArrayList<LocalPoint>();
	
	public static ArrayList<Line> _lines = new ArrayList<Line>();
	public static ArrayList<Dot> _dots = new ArrayList<Dot>();
	
	public static void addPoint(Point p){
		double x = p.getX();
		double y = p.getY();
		double z = 0;
		
		_dots.add(new Dot(x,y,z));
		_worldPoint.add(new WorldPoint(x,y,z));
	}
	private static boolean _firstCircle = true; 
	private static WorldPoint P1;
	private static WorldPoint P2;
	private static int firstCircleIndex = -1;
	public static void addLine(Point P){
	 for(int i = 0 ; i < _dots.size(); i++){
		if( _dots.get(i).contains(P) ){
			if(_firstCircle ){
				_dots.get(i).turnGreen();
				P1 = _dots.get(i).getWorldPoint();
				firstCircleIndex = i;
				_firstCircle = false; 
				
				
			} else{
				P2 = _dots.get(i).getWorldPoint();
				_lines.add(new Line(P1, P2));
				_dots.get(firstCircleIndex).turnBlack();
				_firstCircle = true; 

			}
		}

	 }
	 
	}

	public static Object3D doneCreating(double refX,double refY,double refZ){
		for(WorldPoint p : _worldPoint){
			LocalPoint lp = p.turnIntoLocalPoint(refX, refY, refZ);
			_localPoint.add(lp);
		}
		_worldPoint.clear();
		choosenCenterMass = false;
		return new Object3D( refX, refY, refZ, _localPoint);
	}
	
	private static boolean choosenCenterMass = false;
	
	public static void chooseCenterMass(Point p) {
		_referencePoint = new WorldPoint(p.getX(),p.getY(),0);
		if(choosenCenterMass){
			_dots.remove(_dots.size()-1);
		}
		_dots.add(new Dot(p.getX(),p.getY(),0));
		choosenCenterMass = true;
		
		}
}
