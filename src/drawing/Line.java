package drawing;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class Line extends Object3D implements Shape {
	private int _x1, _x2,_z1 = 0, _y1, _y2, _z2 = 0;
	private WorldPoint referencePoint = new WorldPoint(600,400,0); // hard coded ref point
	private Color[] _colors = {Color.BLACK, Color.RED, Color.BLUE, Color.GRAY};
	private Color _color = _colors[0];
	
	public Line(int x1, int y1 , int x2, int y2){
		_x1 = x1;
		_y1 = y1;
		_x2 = x2;
		_y2 = y2;
		this.createLocalPointsFrom_Coord();
		
	}
	public Line(int x1, int y1, int z1 , int x2, int y2, int z2){
		_x1 = x1;
		_y1 = y1;
		_x2 = x2;
		_y2 = y2;
		_z1 = z1;
		_z2 = z2;
		this.createLocalPointsFrom_Coord();
	}
	public Line(Point p1, Point p2){
		_x1 = (int) p1.getX();
		_y1 = (int) p1.getY();
		_x2 = (int) p2.getX();
		_y2 = (int) p2.getY();
		this.createLocalPointsFrom_Coord();
	}
	public Line(WorldPoint p1, WorldPoint p2){
		_x1 = (int) p1.getX();
		_y1 = (int) p1.getY();
		_z1 = (int) p1.getZ();
		_x2 = (int) p2.getX();
		_y2 = (int) p2.getY();
		_z2 = (int) p2.getZ();
		this.createLocalPointsFrom_Coord();


	}
	public Line(LocalPoint p1, LocalPoint p2){
		_localPoints.add(p1);
		_localPoints.add(p2);
	}
	public void createLocalPointsFrom_Coord(){
		WorldPoint w1 = new WorldPoint(_x1,_y1,_z1);
		WorldPoint w2 = new WorldPoint(_x2,_y2,_z2);
		_localPoints.add(new LocalPoint(referencePoint,w1));
		_localPoints.add(new LocalPoint(referencePoint,w2));
	}
	@Override
	public void paint(Graphics g) {
		if(_localPoints.size() > 1){
			_x1 = (int) _localPoints.get(0).getX();
			_y1 = (int) _localPoints.get(0).getY();
			_x2 = (int) _localPoints.get(1).getX();
			_y2 = (int) _localPoints.get(1).getY();
			g.setColor(_color);
			g.drawLine(_x1, _y1, _x2, _y2); // need to change to world points
		}
	}
	int colorIndex = 1; 
	@Override
	public void mousePressed(MouseEvent mev) {
		System.out.println( mev.getButton());
		if(mev.getButton() == 3){
			this.changeColor();
			}
	}
	public void changeColor(){
		_color = _colors[colorIndex];
		colorIndex++; 
		if(colorIndex >= _colors.length){
			colorIndex = 0;
		}
	}
	@Override
	public boolean contains(Point p) {
		return false;
	}

}
