package util;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

/**
 * Here we make all the color and text stuff centralized. Its like a CSS<br>
 * 
 * @author fabiantheblind
 * 
 */
public class Style {

	/**
	 * the PApplet
	 */
	private static PApplet p;

	/**
	 * Color 1
	 */
	public static int ptclCol1;
	/**
	 * Color 2
	 */
	public static int ptclCol2;
	/**
	 * Color 3
	 */
	public static int ptclCol3;

	public static int superSoftWhite;
	
	public static int superSoftGrey;


	public static int activeColor;
	public static int inactiveCol;
	public static int tintingH;

	/**
	 * PDXIII background Stuff
	 */
	public static float tinter;
	/**
	 * PDXIII background Stuff
	 */
	public static boolean tintBack = false;
	/**
	 * PDXIII background Stuff
	 */
	public static float tintMax = 23;
	/**
	 * PDXIII background Stuff
	 */
	public static float tintMin = 0;

	/**
	 * PDXIII background Stuff
	 */
	public static float tintSize = tintMax - tintMin;

	/**
	 * PDXIII background Stuff
	 */
	public static float tintingStep = 0.1f;
	/**
	 * PDXIII background Stuff
	 */
	public static PImage fadingBG;
	/**
	 * If you wan't the Text white
	 */
	public static int textColorWhite;

	/**
	 * if u want it black
	 */
	public static int textColorBlk;

	/**
	 * the color of the clearscreen
	 * 
	 * @see <a
	 *      href="../tmnuelaerm/TmnUELaerm.html#clearScreen()"><code>TMN_UE_Laerm.clearScreen()</code></a>
	 */
	public static int clsColor;

	static int size = 40;
	/**the Size of the path when 9 paths
	 * 
	 */
	public static int[] pathsSize9 = { size, size*2, size*3, size*4, size*5, size*6, size*7, size*8, size*9 };

	static int a = 30;
	static int b = 40;
	/**
	 * the radius around the path when 9 paths
	 */
	public static int[] pathsRadius9 = { a, b, a, a, b, a,a, b, a};
	
	/**
	 * the Size of the path when 3 paths
	 * 
	 */
	public int[] pathsSize3 = { 100, 250, 360};
	 
	 /**
	 * the radius around the path when 3 paths
	 */
	public int[] pathsRadius3 = { 60, 70, 60};
	
	
	/**
	 * to set the PApplet for the whole Class
	 * 
	 * @param _p
	 */
	public static void setPApplet(PApplet _p) {
		p = _p;
	}

	public static PFont MisoBold11;
	public static PFont MisoReg13;
	public static PFont MisoBold18;
	public static PFont MisoBold36;
	public static PFont MisoBold72;

	public static PFont Unibody8;
	/**
	 * Create all colors and stuff
	 */
	public static void create() {
		p.colorMode(PApplet.HSB, 360, 100, 100);

		// colors
		ptclCol1 = p.color(50, 0, 20, 100);
		ptclCol2 = p.color(50, 0, 0, 100);
		ptclCol3 = p.color(50, 0, 0, 100);


		textColorWhite = p.color(255, 0, 100, 100);
		textColorBlk = p.color(255, 0, 0, 100);

		superSoftWhite = p.color(0, 0, 100, 5);
		superSoftGrey = p.color(0, 0, 20, 5);

		activeColor = p.color(0);
		inactiveCol = p.color(0,23);

		tintingH = 290;

		clsColor = p.color(255, 100, 0, 100);

		// PDXIII TUIO Stuff
		// enable on system installed fonts
		p.hint(PApplet.ENABLE_NATIVE_FONTS);
		MisoBold11 = p.createFont("Miso-Bold", 11);
		MisoReg13 = p.createFont("Miso-Regular", 13);
		MisoBold18 = p.createFont("Miso-Bold", 18);
		MisoBold36 = p.createFont("Miso-Bold", 36);
		MisoBold72 = p.createFont("Miso-Bold", 72);
		
		Unibody8 = p.createFont("Unibody8SmallCaps-Regular", 8);

		// PDXIII background Stuff
		fadingBG = p.loadImage("fadingBG.png");
		


		// int[] pathsSize = { 100, 250, 360};//, 230, 250, 270, 340, 360, 380
		// };
		// int[] pathsRadius = { 60, 70, 60};//, 20, 60, 30, 20, 60, 30 };
	}

	public static boolean switchTime(boolean day) {

		if (Style.tinter > Style.tintSize / 2 + Style.tintMin) {
			day = true;
		} else {
			day = false;
		}
		return day;

	}

	public static boolean switchPath(boolean day, boolean switchPath) {

		if (p.frameCount % (Style.tintSize) == 0) {
			switchPath = true;
			return switchPath;
		} else {
			switchPath = false;
			return switchPath;
		}
	}

	public static void theBackground() {

		// if (Style.tinter > Style.tintSize / 2 + Style.tintMin) {
		// DAY = true;
		// switchPath = true;
		// } else {
		// DAY = false;
		// switchPath = true;
		// }

		p.tint(Style.tintingH, 0, 23 + tinter,70);

		p.image(fadingBG, 0, 0);
		if (tinter >= tintMax) {
			tintBack = true;
		}

		if (tinter <= tintMin) {
			tintBack = false;
		}

		if (!tintBack) {
			tinter += tintingStep;
		} else {
			tinter -= tintingStep;
		}

	}

	/**
	 * A Clear Screen Method writes a
	 * {@code processing.core.PApplet.rect(float, float, float, float)} every
	 * Frame
	 * 
	 * @deprecated
	 */
	public static void clearScreen() {
		p.noStroke();
		p.fill(Style.clsColor);
		p.rect(0, 0, p.width, p.height);

	}

	/**
	 * PDXIII background Stuff
	 * 
	 * @param tinter
	 * @deprecated
	 */
	void drawBG(float tinter) {

		// PDXIII background Stuff
		p.tint(tinter, 255, 255, 100);
		p.image(Style.fadingBG, 0, 0);
		tinter += 0.5f;
		if (tinter > 360) {
			tinter = 0;
		}
		// end PDXIII background Stuff

	}
}
