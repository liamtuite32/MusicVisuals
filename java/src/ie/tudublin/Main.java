package ie.tudublin;

import c21394693.longWalkHome;
import c21415142.Cesar_2;
import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;
import ie.tudublin.Sketch_Select;

public class Main {
	public static int visual_to_run = -1; // -1 just means nothing has been selected
	public static String[] arg = { "MAIN" };


	public void startUI() {
		String[] a = { "MAIN" };
		processing.core.PApplet.runSketch(a, new MyVisual());
	}

	public void RotatingAudioBands() {
		String[] a = { "MAIN" };
		processing.core.PApplet.runSketch(a, new RotatingAudioBands());
	}

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Start");
		Thread option_menu = new Thread(new show_option_menu());
		option_menu.start();
		option_menu.join();

		System.out.println("End");

		switch (visual_to_run) {
			case 0: // Stephens Long walk home
				System.out.println("Doing " + visual_to_run);
				longWalkHome game = new longWalkHome();
				break;

			case 1: // Stephens 2nd thing
				System.out.println("Doing " + visual_to_run);
				longWalkHome game_2 = new longWalkHome();
				break;

			case 2: // Césars First visual
				System.out.println("Doing " + visual_to_run);
				processing.core.PApplet.runSketch(arg, new Cesar_2());
				break;
				
			case 3: // César's second visual
				System.out.println("Doing " + visual_to_run);
				processing.core.PApplet.runSketch(arg, new Cesar_2());
				break;

			default:
				System.out.println("Doing " + visual_to_run);
				System.out.println("ERROR in switch");
				break;
		}

	}
}

class show_option_menu implements Runnable {
	public void run() {
		Sketch_Select option_menu = new Sketch_Select();
		
		processing.core.PApplet.runSketch(Main.arg, option_menu);

		while (true) {
			Main.visual_to_run = option_menu.return_choice();

			if (Main.visual_to_run < 0 || Main.visual_to_run > 7) {
				// user hasn't chosen anything
				System.out.println("Reading " + Main.visual_to_run);
				continue;
			}

			else {
				// Something has been chosen
				option_menu.noLoop();
				option_menu.getSurface().setVisible(false);
				option_menu.getSurface().stopThread();
				break;
			}
		}
	}
}