
public class Pipe {
	private double x, y, width, height;
	private double xTop, yTop, widthTop, heightTop;
	private boolean score;
	
	//Default constructor
	public Pipe(double x) {
		this.x = x;
		this.width = .1;
		do {
			this.y = Math.random();
		} while(this.y > .7 || this.y < .1);
		this.height = .01;
		
		this.xTop = x;
		this.widthTop = this.width;
		this.heightTop = 0.01;
		this.yTop = this.y + .3;
		
		this.score = false;
	}
	
	public void setScore (boolean value) {
		this.score = value;
	}
	public boolean getScore() {
		return this.score;
	}
	
	public double getX() {
		return this.x;
	}
	public double getXTop() {
		return this.xTop;
	}
	
	public double getY() {
		return this.y;
	}
	public double getYTop() {
		return this.yTop;
	}
	
	public double getHeight() {
		return this.height;
	}
	public double getHeightTop() {
		return this.heightTop;
	}
	
	public double getWidth() {
		return this.width;
	}
	public double getWidthTop() {
		return this.widthTop;
	}
	
	//Draws top and bottom pipes
	public void draw() {
		//Bottom pipe
		StdDraw.setPenColor(0, 128, 0);
		StdDraw.filledRectangle(this.x, this.y, this.width, this.height);
		double pos = this.y;
		//Fills out the rest of the pipe down
		do {
			StdDraw.filledRectangle(this.x, pos, this.width, this.height);
			pos -= this.height;
		} while (pos > 0 - this.height);
		
		//Top pipe
		StdDraw.filledRectangle(this.xTop, this.yTop, this.widthTop, this.heightTop);
		pos = this.yTop;
		//Fills out the rest of the pipe up
		do {
			StdDraw.filledRectangle(this.x, pos, this.width, this.height);
			pos += this.heightTop;
		} while (pos < 1.2);
	}
	
	//Moves pipes across screen
	public void pipeScroll(double scroll) {
		this.x -= scroll;
		this.xTop -= scroll;
		
		if ((this.x + this.width) < -.3) {
			reset();
		}
	}
	
	//Resets pipe if it goes off screen to give illusion of infinity
	public void reset() {
		this.x = 1.1;
		this.xTop = 1.1;
		do {
			this.y = Math.random();
		} while(this.y > .7 || this.y < .1);
		this.yTop = this.y + .3;
		
		setScore(false);
	}
}
