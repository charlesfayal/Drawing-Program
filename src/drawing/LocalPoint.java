package drawing;

import java.awt.Point;

public class LocalPoint extends WorldPoint{
	public double _relX, _relY, _relZ; // points relative to the refernce point
	public double _refX,_refY,_refZ;	//reference locaiton
	/**
	 * 
	 * @param refX coord x
	 * @param refY coord y
	 * @param refZ corrd z
	 * @param relX  relative to coord x
	 * @param relY relative to coord y
	 * @param relZ relative to coord z
	 * wx,wy,wz = coord plus local
	 */
	
	public LocalPoint(double refX, double refY, double refZ, double relX,double relY, double relZ){
		super();
		_refX=refX;
		_refY=refY;
		_refZ=refZ;
		_relX=relX;
		_relY=relY;
		_relZ=relZ;
	
		_wx=_relX+refX;
		_wy=_relY+refY;
		_wz=_relZ+refZ;
	}

	public LocalPoint(int refX, int refY, int refZ, int relX,int relY, int relZ){
		this((double) refX, (double) refY, (double) refZ, (double) relX,(double) relY, (double) relZ);
		
	}
	/**
	 *@param refPoint is a world point the object local points is ref around
	 *@param currentPoint is the worldPoint the object is currently at
	 */
	public LocalPoint(WorldPoint refPoint, WorldPoint currentPoint){
		this(refPoint.getX(),refPoint.getY(),refPoint.getZ(), currentPoint.getX()-refPoint.getX(),currentPoint.getY()-refPoint.getY(),currentPoint.getZ()-refPoint.getZ());
	
	}

	public void reset(Point p){
		_refX = p.getX();
		_refY = p.getY();
		resetX();
		resetY();
		
	}
	public void resetX(){
		_wx = _relX+_refX;
	}
	public void resetY(){
		_wy = _relY+_refY;
	}
	public void resetZ(){
		_wz = _relZ+_refZ;
	}

	public String toString(){
		return "World coordinates x " + _wx + " y " + _wy + " z " + _wz;
	}
}
