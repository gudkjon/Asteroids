import java.awt.Font;
import java.awt.Color;

public class UI {
	private static double widthmax = 1024;
	private static double heightmax = 1024;
	private static double widthmin = -widthmax;
	private static double heightmin = -heightmax;
	private static Color text = new Color(0,100,200);
	private static Color dft = new Color(255,255,255);
	public static String backg,skipm,skotm,steinnm,gameover;
	private double Y;
	private double X;
	private boolean running;
	private Stopwatch klikkcounter, passauppastop;
	private static Interval vinstrivinstri = new Interval(-642,-542);
	private static Interval haegrivinstri = new Interval(382,482);
	private static Interval vinstrihaegri = new Interval(-482,-382);
	private static Interval haegrihaegri = new Interval(542,642);
	private static Interval uppi = new Interval(770,870);
	private static Interval midja = new Interval(220,320);
	private static Interval nidri = new Interval(-330,-230);
	public int byrjunarsteinar, fjoldiskota, staerdsteina;
	public int hradisteina;// lif;
	public static int lif = 4;
	public static int utlit = 1;
	public UI() {
		this.running = true;
		this.byrjunarsteinar = 1;
		this.fjoldiskota = 5;
		this.hradisteina = 5;
		this.staerdsteina = 3; 
		this.lif = lif;
		this.klikkcounter = new Stopwatch();
		this.passauppastop = new Stopwatch();
	}
	public static void look() {
		switch(utlit) {
			case 1: backg = "astpics/space.jpg"; skipm = "astpics/ship.png"; skotm = "astpics/sidebullet.gif"; steinnm = "astpics/rock.png"; gameover = "astpics/gameover.png";
			break;
			case 2: backg = "astpics/wildWest.jpg"; skipm = "astpics/cowboy.png"; skotm = "astpics/cowbullet.png"; steinnm = "astpics/tumbleweed.png"; gameover = "astpics/desert.jpg";
			break;
			case 3: backg = "astpics/MarioBack.png"; skipm = "astpics/Mario.gif"; skotm = "astpics/Fire.gif"; steinnm = "astpics/Goom.gif"; gameover = "astpics/marioGameOver.jpg";
			break;
			case 4: backg = "astpics/breakingBad.jpg"; skipm = "astpics/walter.png"; skotm = "astpics/bulleta.gif"; steinnm = "astpics/HankBoy.png"; gameover = "astpics/BreakingOver.jpg";
		}
	}


	public void render() {
		StdDraw.clear();
		setC();
		StdDraw.setFont(new Font("Arial", Font.PLAIN, 20));

		StdDraw.picture(0,0,"astpics/uibg.jpg", 2*widthmax+500, 2*widthmax+500);
		StdDraw.setPenColor();
		StdDraw.filledRectangle( 0, -1000, 500, 55 );//space til ad byrja
		StdDraw.filledRectangle( 512, 855, 400, 110 );//byrjunarsteinar
		StdDraw.filledRectangle( 512, 305, 400, 110 );//hradi
		StdDraw.filledRectangle( 512, -245, 400, 110 );//lif
		StdDraw.filledRectangle( -512, 855, 400, 110 );//utlit
		StdDraw.filledRectangle( -512, 305, 400, 110 );//skothylki
		StdDraw.filledRectangle( -512, -245, 400, 110 );//staerd byrjunarsteina
		StdDraw.filledRectangle( 0,-800,500,55);
		setC();

		StdDraw.text(0,-1000, "Yttu a space til ad byrja");
		StdDraw.text(0, -800,"Yttu a C til ad sja controls");

		StdDraw.text(-512, 900, "veldu utlit");
		StdDraw.picture(-592,820,"astpics/arrowleft.png",100,100);
		StdDraw.text(-512,810,String.valueOf(utlit));
		StdDraw.picture(-432,820,"astpics/arrowright.png",100,100);

		StdDraw.text(512, 900, "veldu fjolda steina");
		StdDraw.picture(432,820,"astpics/arrowleft.png",100,100);
		StdDraw.text(512,810,String.valueOf(byrjunarsteinar+1));
		StdDraw.picture(592,820,"astpics/arrowright.png",100,100);
		
		StdDraw.text(512,350, "veldu hrada steina" );
		StdDraw.picture(432,270,"astpics/arrowleft.png",100,100);
		StdDraw.text(512,260,String.valueOf(hradisteina+2));
		StdDraw.picture(592,270,"astpics/arrowright.png",100,100);
		
		StdDraw.text(-512,350, "staerd skothylkis" );
		StdDraw.picture(-592,270,"astpics/arrowleft.png",100,100);
		StdDraw.text(-512,260,String.valueOf(fjoldiskota));
		StdDraw.picture(-432,270,"astpics/arrowright.png",100,100);
		
		StdDraw.text(-512,-200, "veldu staerd steina");
		StdDraw.picture(-592,-280,"astpics/arrowleft.png",100,100);
		StdDraw.text(-512,-290,String.valueOf(staerdsteina));
		StdDraw.picture(-432,-280,"astpics/arrowright.png",100,100);

		StdDraw.text(512,-200, "veldu fjolda lifa");
		StdDraw.picture(432,-280,"astpics/arrowleft.png",100,100);
		StdDraw.text(512,-290,String.valueOf(lif));
		StdDraw.picture(592,-280,"astpics/arrowright.png",100,100);		
		
		setCD();
		StdDraw.show(10);
	}
	public void staerdminus() { if(staerdsteina == 1) {return;} staerdsteina--; }
	public void staerdplus() { if(staerdsteina == 5) {return;} staerdsteina++; }
	public void skotminus() { if( fjoldiskota == 1) {return;} fjoldiskota--; }
	public void skotplus() { fjoldiskota++; }
	public void steinarminus() { if( byrjunarsteinar == 0) {return;} byrjunarsteinar--; }
	public void steinarplus() { if( byrjunarsteinar == 7) {return;} byrjunarsteinar++; }
	public void lifminus() { if( lif == 1) {return;} lif--; }
	public void lifplus() { lif++; }
	public void utlitminus() { if( utlit == 1) {return;} utlit--; }
	public void utlitplus() { if( utlit == 4) {return;} utlit++; }
	public void hradiminus() { if( hradisteina == -1) {return;} hradisteina--; }
	public void hradiplus() { hradisteina++; }

	public static void setC() {
		StdDraw.setPenColor(text);
	}
	public static void setCD() {
		StdDraw.setPenColor(dft);
	}
	public void play() {
		this.running = true;
		this.passauppastop = new Stopwatch();
		render();
		look();
		while(running) {
			keycheck();
		}
	}
	/*
			Stopwatch byrja2 = new Stopwatch();
			lnFactorial(N);
			double timi2 = byrja2.elapsedTime();
			*/
	public void controls() {
		StdDraw.clear();
		StdDraw.setPenColor();
		StdDraw.filledRectangle( 0, 0, 1200, 1200 );
		setC();
		StdDraw.text(0,600,"W er afram");
		StdDraw.text(0,300,"A og D sja um beygjur");
		StdDraw.text(0,000,"S bakkar");
		StdDraw.text(0,-300,"Space eda E skytur");
		StdDraw.text(0,-600,"esc er back");
		StdDraw.show();
		boolean control = true;
		while(control) {
			if(StdDraw.isKeyPressed(27)){ control = false; } // sleep(20ms)}
			System.out.println(control);
			//Thread.sleep((long)20.0); fékk ekki til að virka, kom upp must be caught or declared to be thrown
		}
		render();
	}
	public void keycheck() {
		if(this.passauppastop.elapsedTime() > 1) { if(StdDraw.isKeyPressed(32)) { Asteroids.vann = true; running = false; } }	
		if(StdDraw.isKeyPressed(Character.codePointAt("C", 0))) {controls();}	
		if(klikkcounter.elapsedTime() > 0.2) {
			if(StdDraw.mousePressed()) {
				Y = StdDraw.mouseY();
				X = StdDraw.mouseX();
				klikkcounter = new Stopwatch();
				System.out.println("X: "+X+" Y: "+Y);
				if(uppi.contains(Y)){
					if(X < 0) {	
						if(vinstrivinstri.contains(X)) { 
							utlitminus(); render(); look();
						}else if(vinstrihaegri.contains(X)) {
							utlitplus(); render(); look();
						}
					}else{
						if(haegrihaegri.contains(X)) {
							steinarplus(); render();
						}else if(haegrivinstri.contains(X)){
							steinarminus(); render();
						}
					}	
				}else if(midja.contains(Y)) {
					if(X < 0) {
						if(vinstrivinstri.contains(X)) {
							skotminus(); render();
						}else if(vinstrihaegri.contains(X)) {
							skotplus(); render();
						}
					}else{
						if(haegrihaegri.contains(X)) {
							hradiplus(); render();
						}else if(haegrivinstri.contains(X)) {
							hradiminus(); render();
						}
					}
				}else if(nidri.contains(Y)) {
					if(X < 0) {
						if(vinstrivinstri.contains(X)) {
							staerdminus(); render();
						}else if(vinstrihaegri.contains(X)) {
							staerdplus(); render();
						}		
					}else{
						if(haegrihaegri.contains(X)) {
							lifplus(); render();
						}else if(haegrivinstri.contains(X)) {
							lifminus(); render();
						}
					}

				}
			}
		}
		//StdDraw.mouseX()
		//StdDraw.mouseY()
		//StdDraw.mousePressed() 
	}
}