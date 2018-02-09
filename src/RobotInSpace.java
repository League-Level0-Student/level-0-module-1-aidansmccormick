
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class RobotInSpace implements KeyEventDispatcher {

	static RobotInSpace rob = new RobotInSpace();

	/*
	 * Make the Robot move around the screen when the arrow keys are pressed...
	 * 
	 * 1. IMPORTANT: For this recipe, use rob.microMove(distance) to move your Robot
	 * and rob.setAngle(angle) to change the direction of your Robot.
	 * 
	 */

	private void moveRobot(int keyPressed) {
		// 2. Print out the keyPressed variable and write down the numbers for each
		// arrow key

		System.out.println(keyPressed);

		int lArrow = 1;
		int rArrow = 2;
		int uArrow = 3;
		int dArrow = 4;

		// 3. If the up arrow is pressed, move the Robot up the screen.

		// 4. If the down arrow is pressed, move the Robot down.

		// 5. If the left arrow is pressed, make the Robot go left.

		// 6. If right is pressed, move the Robot right.

		// 7. Run your program and move the Robot to RD-2D for a surprise!
	}

	private void checkIfR2D2Found() throws Exception {
		int robotLocationX = rob.getX();
		int robotLocationY = rob.getY();

		if (robotLocationX <= 7300 && robotLocationX >= 720 && robotLocationY >= 150 && robotLocationY <= 160)
			playEureka();
	}

	public static void main(String[] args) {
		rob = new RobotInSpace();
		rob.controlTheRobot();

		rob.setAngle(90);

		rob.microMove(100);

	}

	private void controlTheRobot() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
		rob.setWindowImage("planet.jpg");
		rob.penUp();
		rob.setSpeed(10);
	}

	public boolean dispatchKeyEvent(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_PRESSED) {
			moveRobot(e.getKeyCode());
			try {
				checkIfR2D2Found();
			} catch (Exception exception) {
			}
		}
		return false;
	}

	public void playEureka() {
		System.out.println("EUREKA!");
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/r2d2-eureka.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
