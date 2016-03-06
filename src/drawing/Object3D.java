package drawing;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Object3D implements Shape{
	/***
	 * Contains _LocalPoints ArrayList
	 * Contains _lines ArrayList
	 */

		protected Point _p;
	

		protected ArrayList<LocalPoint> _localPoints = new ArrayList<LocalPoint>();
		protected ArrayList<Line> _lines = new ArrayList<Line>();
		protected double x,y,z;
		protected double _swivel;
		protected double _roll;
		protected double _pitch;
			/**
			 * 
			 * @param x
			 * @param y
			 * @param size
			 * @param swivel
			 * @param roll
			 * @param pitch
			 */
			public Object3D(){
				
			}
			public Object3D(Point p){
				x =  _p.getX();
				y =  _p.getY();
				z = 0;
						
			}
			public Object3D(double refX,double refY,double refZ,ArrayList<LocalPoint> localPoints ){
				_localPoints = localPoints;
				x = refX;
				y = refY;
				z = refZ;
			}
			public Object3D(int x, int y, double swivel,double roll, double pitch){
				this(new Point(x,y) ,swivel,roll,pitch);
			}
			public Object3D(Point p, double swivel,double roll,double pitch){
				this(p);
				_swivel = toRads(swivel);
				_roll = toRads(roll);
				_p = p;
			}
			public Object3D(ArrayList<LocalPoint> points3D){
				_localPoints = points3D;
	
			}
			
			public void translate(int dx,int dy){
				_p.x += dx;
				_p.y += dy;
				for(int i=0; i<_localPoints.size();i++){
					_localPoints.get(i).reset(_p); // could have issues here
				}
			}
			
			public LocalPoint swivel(LocalPoint p, double swivelDeg){
				double swivelAngle = toRads(swivelDeg);
				double r =r(p._relX,p._relZ);
				double currentAngle = angle(p._relX,p._relZ);
				p._relX = r*cos(currentAngle + swivelAngle);
				p.resetX();
				p._relZ = r*sin(currentAngle + swivelAngle);
				p.resetZ();
				return p;
			}
			public void swivelPoints(double swivelDeg){
				for(int i = 0; i < _localPoints.size(); i++){
					_localPoints.set(i, swivel(_localPoints.get(i), swivelDeg));
				}
			}
			public LocalPoint pitch(LocalPoint p,double pitchDeg){
				double pitchAngle = toRads(pitchDeg);
				double r =r(p._relY,p._relZ);
				double currentAngle = angle(p._relY,p._relZ);
				p._relY = r*cos(currentAngle + pitchAngle);
				p.resetY();
				p._relZ = r*sin(currentAngle + pitchAngle);
				p.resetZ();
				return p;
			}
			public void pitchPoints(double pitchDeg){
				for(int i = 0; i < _localPoints.size(); i++){
					_localPoints.set(i, pitch(_localPoints.get(i), pitchDeg));
				}
			}
			public LocalPoint roll(LocalPoint p,double rollDeg){
				double rollAngle = toRads(rollDeg);
				double r = r(p._relX,p._relY);
				double currentAngle = angle(p._relX,p._relY);
				p._relX = r*cos(currentAngle + rollAngle);
				p.resetX();
				p._relY = r*sin(currentAngle + rollAngle);
				p.resetY();
			
				return p;
				
			}
			public void rollPoints(double rollDeg){
				for(int i = 0; i < _localPoints.size(); i++){
					_localPoints.set(i, roll(_localPoints.get(i), rollDeg));
				}
			}
			
			public double angle(double a, double b){
				return Math.atan2(b, a);
			}
			
			@Override
			public void paint(Graphics g) {
			
				
			}
			public double toRads(double degree){
				return (degree*Math.PI/180);
			}
			public double sin(double angle){
				return Math.sin(angle);
			}
			public double cos(double angle){
				return Math.cos(angle);
			}
			public double r(double a,double b){
				return Math.sqrt(a*a+b*b);
			}
			@Override
			public void mousePressed(MouseEvent mev) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean contains(Point p) {
				// TODO Auto-generated method stub
				return false;
			}
			

	}