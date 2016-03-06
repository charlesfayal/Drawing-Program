package drawing;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.lang.Math;



public class Cube extends Object3D implements Shape{

	private Point _p;
	private Line fltop,dlright,flbottom,flleft;
	private Line lineBackTop,lineBackRight,lineBackBottom,lineBackLeft;
	private Line lineTopRight,lineTopLeft, lineBottomRight, lineBottomLeft;
	private LocalPoint pFRT,pFLT,pFRB,pFLB,pBRT,pBLT,pBRB,pBLB;


	private double _size, r;
	/*private double _swivel;
	private double _roll;
	private double _pitch;*/
		/**
		 * 
		 * @param x
		 * @param y
		 * @param size
		 * @param swivel
		 * @param roll
		 * @param pitch
		 */
		public Cube(int x, int y, int size, double swivel,double roll, double pitch){
			this(new Point(x,y), size,swivel,roll,pitch);
		}
		public Cube(Point p,int size, double swivel,double roll,double pitch){
			_swivel = swivel * (Math.PI)/180;
			_roll = roll * (Math.PI)/180;
			_p = p;
			x =  _p.getX();
			y =  _p.getY();
			z = 0;
		
			_size = size;
			r = _size*Math.sqrt(2) /2;

			
			pFRT = new LocalPoint(x,y,z, r, r, r);
			_localPoints.add(pFRT); 	//0
			pFLT = new LocalPoint(x,y,z,-r, r, r);
			_localPoints.add(pFLT);		//1
			pFRB = new LocalPoint(x,y,z, r,-r, r);
			_localPoints.add(pFRB);		//2
			pFLB = new LocalPoint(x,y,z,-r,-r, r);
			_localPoints.add(pFLB);		//3
			pBRT = new LocalPoint(x,y,z, r, r,-r);
			_localPoints.add(pBRT);		//4
			pBLT = new LocalPoint(x,y,z,-r, r,-r);
			_localPoints.add(pBLT);		//5
			pBRB = new LocalPoint(x,y,z, r,-r,-r);
			_localPoints.add(pBRB);		//6
			pBLB = new LocalPoint(x,y,z,-r,-r,-r);
			_localPoints.add(pBLB);		//7
			
			swivelPoints(swivel);
			pitchPoints(pitch);
			rollPoints(roll);
			
			
		}
		public void resetLines(){
			
			fltop = new Line(_localPoints.get(0),_localPoints.get(1));
			_lines.add(fltop);
			dlright = new Line(_localPoints.get(0),_localPoints.get(2));
			_lines.add(dlright);
			flbottom = new Line(_localPoints.get(2),_localPoints.get(3));
			_lines.add(flbottom);
			flleft = new Line(_localPoints.get(3),_localPoints.get(1));
			_lines.add(flleft);
			
			lineBackTop = new Line(_localPoints.get(4),_localPoints.get(5));
			_lines.add(lineBackTop);
			lineBackRight = new Line(_localPoints.get(4),_localPoints.get(6));
			_lines.add(lineBackRight);
			lineBackBottom= new Line(_localPoints.get(6),_localPoints.get(7));
			_lines.add(lineBackBottom);
			lineBackLeft = new Line(_localPoints.get(7),_localPoints.get(5));
			_lines.add(lineBackLeft);
			
			lineTopRight = new Line(_localPoints.get(0), _localPoints.get(4));
			_lines.add(lineTopRight);
			lineTopLeft = new Line(_localPoints.get(1),_localPoints.get(5));
			_lines.add(lineTopLeft);
			lineBottomRight = new Line(_localPoints.get(2),_localPoints.get(6));
			_lines.add(lineBottomRight);
			lineBottomLeft = new Line(_localPoints.get(3),_localPoints.get(7));
			_lines.add(lineBottomLeft);
		}

		@Override
		public void paint(Graphics g) {
			resetLines();
			for(Line l : _lines){
				l.paint(g);
			}
			
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
