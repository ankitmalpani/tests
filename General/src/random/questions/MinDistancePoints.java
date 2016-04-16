package random.questions;

import java.util.ArrayList;
import java.util.List;

public class MinDistancePoints {
	
	
	public static void findClosestPairOfPoints(Point [] points){
		int currMin = Integer.MAX_VALUE;
		int totalMin = Integer.MAX_VALUE;
		List<Point> closest = new ArrayList<Point>(2);
		for(int i = 0 ; i < points.length-1 ; i++){
			currMin = Math.min(currMin,Point.distance(points[i], points[i+1]));
			if(totalMin < currMin){
				totalMin = currMin	;
				closest.add(points[i]);
				closest.add(points[i+1]);
			}
			
		}
	}
	
	
	
	public static class Point{
		int x;
		int y;
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		
		public static int distance(Point x, Point y){
			return 1;
		}
	}

}
