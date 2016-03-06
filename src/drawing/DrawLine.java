package drawing;

import java.awt.Point;
import java.awt.event.MouseEvent;

public class DrawLine {
	
	static int x1,x2,y1,y2;
	static boolean newLine = true;
	
	public static Line drawLine(Point p){
		if(_drawing){
		 x1 = p.x;
		 y1 = p.y;
		 if( newLine == true ){
			 x2 = x1;
			 y2 = y1;
			 newLine = false;
		 }
		 x1 = p.x;
		 y1 = p.y;
		 Line l = new Line(x1, y1 , x2 , y2);
		 x2 =x1;
		 y2= y1;
		 return l;
		}
		return null;


		
	}
	
	public static boolean _drawing = false;
	public static void startLine(MouseEvent mouseEvent) {
		_drawing = true;
		newLine = true;
	}
	public static void endLine(MouseEvent mouseEvent) {
		_drawing = false;;
	}
}
