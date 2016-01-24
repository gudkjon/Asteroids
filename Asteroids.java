import java.awt.Font;
import java.awt.Color;

public class Asteroids{
	private static double widthmax = 1024;
	private static double heightmax = 1024;
	private static double widthmin = -widthmax;
	private static double heightmin = -heightmax;
	private static int steinarrender = 0;
	public static boolean vann = false;
	
	public static void main(String[] args) {
		
		StdDraw.setXscale(widthmin,widthmax);
		StdDraw.setYscale(heightmin,heightmax);
		StdDraw.filledRectangle( 0, 0, 1500, 1500 );
		StdDraw.setFont(new Font("Arial", Font.PLAIN, 20));
		StdDraw.setPenColor(new Color(0,0,200));
		StdDraw.text(0,100, "Asteroids");
		StdDraw.text(0,-100, "the role playing game");
		Stopwatch byrjunarskjar = new Stopwatch();
		while(byrjunarskjar.elapsedTime() < 2) {}
		UI ui = new UI();
		while(true) {
			ui.play();
			Ship a = new Ship(0, 0, 0, 0, ui.skipm,0);
			while(vann) {
				ui.byrjunarsteinar++;
				ui.hradisteina+=2;
				steinarrender = ui.byrjunarsteinar-1;
				int fjoldisteina = ui.byrjunarsteinar * (int) Math.pow(2,ui.staerdsteina) - 1;
				Bullet[] skot = new Bullet[ui.fjoldiskota];
				for(int i = 0; i < ui.fjoldiskota; i++) {
					skot[i] = new Bullet("byrja", a);
				}
				Rock[] steinar = new Rock[fjoldisteina];
				Game lvl1 = new Game( a, skot, steinar, ui.fjoldiskota, fjoldisteina, ui.hradisteina, steinarrender, ui.staerdsteina, ui.byrjunarsteinar, 1, ui.lif, ui);
				lvl1.setjasteina(steinar);
				lvl1.play();
			}
		}
	}
} 
		//while(true) {System.out.println("i gangi");} 
		//vinstri 37   
		//upp 38
		//hægri 39 niður 40
		//space32
		//StdDraw.clear();
		//StdDraw.picture( 0 , 0 ,"astpics/loser.jpg", widthmax*2, heightmax*2);
	    /*Game game = new Game(...);
	    game.initialize(...); // kannski?
	    game.play(); // spilar leik
	*/
