import java.awt.event.KeyEvent;

public class Bird {
	private double x, y, radius;
	private int jumpCoolDown, score;
	
	//Default constructor
	public Bird() {
		this.x = .25;
		this.y = .5;
		this.radius = .02;
		this.score = 0;
	}
	
	//Returns the player scoree
	public double getScore() {
		return this.score;
	}
	
	//Draws the circle to represent the bird on screen
	public void draw() {
		StdDraw.setPenColor(250, 250, 50);
		StdDraw.filledCircle(this.x, this.y, this.radius);
	}
	
	public boolean update(Pipe[] pipes) {
		//Checks for jump with a cooldown to prevent flying
		if (jumpCoolDown >= 3) {
			if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
	            this.y += .05;
	            jumpCoolDown = 0;
	        } else {
	        	//Fall
				this.y -= .01;
	        }
		} else {
			jumpCoolDown += 1;
		}
		
		//Hits floor
		if (this.y <= 0) {
			return true;
		}
		
		//Checks if score is earned
		for (Pipe p : pipes) {
			if (this.x > (p.getX() + p.getWidth()) && p.getScore() == false) {
				this.score += 1;
				p.setScore(true);
			}
		}
		
		//Checks for pipe collision
		for (Pipe p : pipes) {
			//Collision with bottom pipe
			if (((this.y + this.radius) < (p.getY() + p.getHeight())) &&
					((this.x + this.radius)>= (p.getX() - p.getWidth())) &&
					((this.x + this.radius)<= (p.getX() + p.getWidth()))) {
				return true;
			}
			
			//Collision with bottom pipe
			if (((this.y + this.radius)> (p.getYTop() + p.getHeightTop())) &&
					((this.x + this.radius)>= (p.getXTop() - p.getWidthTop())) &&
					((this.x + this.radius)<= (p.getXTop() + p.getWidthTop()))) {
				return true;
			}
		}
		
		//default case if no collisions
		return false;
		
	}
}
