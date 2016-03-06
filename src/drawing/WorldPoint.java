package drawing;


public class WorldPoint {
	public double _wx,_wy,_wz; //world coordinates 

	/**
	 * 
	 * @param wx coord x
	 * @param wy corrd y
	 * @param wz corrd z
	 */
	
	public WorldPoint(int x,int y, int z){
		_wx = x;
		_wy = y;
		_wz = z;
	}
	public WorldPoint(double x,double y, double z){
		_wx = x;
		_wy = y;
		_wz = z;
	}

	public WorldPoint() {
	}
	public double getX(){
		return _wx;
	}
	public double getY(){
		return _wy;
	}
	public double getZ(){
		return _wz;
	}
	public LocalPoint turnIntoLocalPoint(double refX,double refY,double refZ){
		double relX =  (_wx-refX);
		double relY = (_wy-refX);
		double relZ =  (_wz-refZ);
		return new LocalPoint(refX,refY,refZ,relX,relY,relZ);
		
	}
	public String toString(){
		return "World coordinates: x " + _wx + " y " + _wy + " z " + _wz;
	}
}
