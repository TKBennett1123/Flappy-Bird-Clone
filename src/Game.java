// The main method for the Pac-Man project
// CMS 170, Spring 2019

public class Game {
	
	public static void main(String[] args) {
		Bird flappy = new Bird();
		Pipe pipe1 = new Pipe(1.1);
		Pipe pipe2 = new Pipe(1.6);
		Pipe pipe3 = new Pipe(2.1);
		
		Clouds cloud1 = new Clouds(.5, .75);
		Clouds cloud2 = new Clouds(.8, .8);
		Clouds cloud3 = new Clouds(.15, .55);
		Clouds cloud4 = new Clouds(.7, .65);
		Clouds cloud5 = new Clouds(.2, .9);
		Clouds cloud6 = new Clouds(.4, .6);
		Clouds cloud7 = new Clouds(.65, .85);
		
		Pipe[] pipes = {pipe1, pipe2, pipe3};
		Clouds[] clouds = {cloud1, cloud2, cloud3, cloud4, cloud5, cloud6, cloud7};
		
		boolean playing = true;
		while (playing) {
			
			//Draws background
			StdDraw.clear(StdDraw.BOOK_LIGHT_BLUE);
			
			//Draw clouds
			for (Clouds c : clouds) {
				c.draw();
			}
			
			//Draw sun
			StdDraw.setPenColor(249, 215, 28);
			StdDraw.filledCircle(.95, .95, 0.2);
			
			//Draw Flappy Bird
			flappy.draw();
			
			//Draw Pipes
			for (Pipe p : pipes) {
				p.draw();
			}
			
			//Draw Ground
			StdDraw.setPenColor(139, 69, 19);
			StdDraw.filledRectangle(.5, -0.2, 0.75, .2);
			
			//Draw score
			StdDraw.setPenColor(0, 0, 0);
			StdDraw.text(.5, 1.0, "" + flappy.getScore());
			
			//Scroll the pipes at the given speed
			for (Pipe p : pipes) {
				p.pipeScroll(0.01);
			}
			
			//Checks if Flappy Bird hit floor and collisions
			if (flappy.update(pipes) == true) {
				playing = false;
			}
			
			//Displays death message
			if (playing == false) {
				StdDraw.setPenColor(0, 0, 0);
				StdDraw.text(.5, .5, "Game Over. Final Score: " + flappy.getScore());
			}
			//Shows on screen
			StdDraw.show(20);
		}
		
		
		
	}

}
