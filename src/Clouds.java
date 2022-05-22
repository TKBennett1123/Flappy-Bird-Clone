
public class Clouds {
	private double x, y;
	
	public Clouds(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw() {
		StdDraw.setPenColor(255, 255, 255);
		StdDraw.filledEllipse(this.x, this.y, 0.05, .01);
		StdDraw.filledEllipse(this.x, this.y, 0.045, .015);
		StdDraw.filledEllipse(this.x, this.y, 0.03, .02);
	}
}
