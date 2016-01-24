public class Game {

	private Ship a;
	private Rock[] steinar;
	private Bullet[] skot;
	private int fjoldiskota, fjoldisteina;
	private double hradisteina;
	private Ship adal;
	private int byrjunarsteinar;
	private int level;
	private static boolean running;
	private static int lif;
	private static int steinarrender;
	private static int daudirsteinar;
	private static int bulletdelay;
	private static int bulletcounter;
	private static int staerdsteina;
	private static int widthmax = 1024;
	private static int widthmin = -1024;
	private static int heightmax = 1024;
	private static int heightmin = -1024;
	private static double score;
	private static double delay = 0;
	private static UI ui;

	public Game(Ship a, Bullet[] skot, Rock[] steinar, int fjoldiskota, int fjoldisteina, double hradisteina, int steinarrender, int staerdsteina, int byrjunarsteinar, int level, int lif, UI ui) {
		this.adal = a;
		this.skot = skot;
		this.steinar = steinar;
		this.fjoldiskota = fjoldiskota;
		this.fjoldisteina = fjoldisteina;
		this.hradisteina = hradisteina;
		this.steinarrender = steinarrender;
		this.bulletcounter = 0;
		this.bulletdelay = 10;
		this.daudirsteinar = 0;
		this.staerdsteina = staerdsteina;
		this.byrjunarsteinar = byrjunarsteinar;
		this.running = true;
		this.level = level;
		this.ui = ui;
		this.lif = lif;
	}
	public void play() {
		while(running) {
			if(System.nanoTime()-delay > 20000000) {
				delay = System.nanoTime();
				collisioncheck(this.adal,this.skot,this.steinar,this.fjoldisteina);
				keycheck(this.adal,this.skot,this.fjoldiskota);
				render(this.adal,this.skot,this.fjoldiskota,this.steinar);
			}
			if(this.daudirsteinar >= this.fjoldisteina+1-(this.byrjunarsteinar)) { Asteroids.vann = true; this.running = false; score+=500; naestalvl();}
			if(lif < 1) { score = 0; Asteroids.vann = false; this.running = false; ui.byrjunarsteinar--; ui.hradisteina-=2; gameover(); }
		}
	}
	public void naestalvl() {
		Stopwatch bida = new Stopwatch();
		StdDraw.clear();
		StdDraw.picture(0,0,"astpics/winner.jpg",2*widthmax,2*heightmax);
		StdDraw.show();
		while(bida.elapsedTime() < 2) {};
	}
	public void gameover() {
		Stopwatch bida = new Stopwatch();
		StdDraw.clear();
		StdDraw.picture(0,0, ui.gameover , 2*widthmax+500, 2*widthmax+500);
		StdDraw.show();
		while(bida.elapsedTime() < 2) {};
	}
	public void setjasteina(Rock[] bsteinar) {
		for(int i = 0; i < this.byrjunarsteinar; i++){
			switch(i) {
				case 0: bsteinar[i] = new Rock(widthmax/4, heightmax/4, this.hradisteina, this.hradisteina, ui.steinnm,0.0,this.staerdsteina);
						break;
				case 1: bsteinar[i] = new Rock(-widthmax/4, -heightmax/4, -this.hradisteina, -this.hradisteina, ui.steinnm ,0.0,this.staerdsteina);
						break;
				case 2: bsteinar[i] = new Rock(widthmax/4, -heightmax/4, this.hradisteina, -this.hradisteina, ui.steinnm ,0.0,this.staerdsteina);
						break;
				case 3: bsteinar[i] = new Rock(-widthmax/4, heightmax/4, -this.hradisteina, this.hradisteina, ui.steinnm ,0.0,this.staerdsteina);
						break;
				case 4: bsteinar[i] = new Rock(widthmax/2, heightmax/2, this.hradisteina, this.hradisteina, ui.steinnm ,0.0,this.staerdsteina);
						break;
				case 5: bsteinar[i] = new Rock(-widthmax/2, heightmax/2, -this.hradisteina, -this.hradisteina, ui.steinnm ,0.0,this.staerdsteina);
						break;
				case 6: bsteinar[i] = new Rock(-widthmax/2, -heightmax/2, this.hradisteina, -this.hradisteina, ui.steinnm ,0.0,this.staerdsteina);
						break;
				case 7: bsteinar[i] = new Rock(-widthmax/2, -heightmax/2, -this.hradisteina, this.hradisteina, ui.steinnm ,0.0,this.staerdsteina);
						break;
			}
		}
	}
	public static void keycheck(Ship adal, Bullet[] skot, int fjoldiskota) {
		if(StdDraw.isKeyPressed(Character.codePointAt("W", 0))) { adal.acceleration(); }
		if(StdDraw.isKeyPressed(Character.codePointAt("A", 0))) { adal.turnleft(); }
		if(StdDraw.isKeyPressed(Character.codePointAt("D", 0))) { adal.turnright(); }
		if(StdDraw.isKeyPressed(Character.codePointAt("S", 0))) { adal.deceleration(); }
		if(!(StdDraw.isKeyPressed(Character.codePointAt("S", 0)) || StdDraw.isKeyPressed(Character.codePointAt("W", 0)))) {
			adal.gradualslow();
		}
		if(!(StdDraw.isKeyPressed(Character.codePointAt("A", 0)) || StdDraw.isKeyPressed(Character.codePointAt("D", 0)))) {
			adal.gradualslowdeg();
		}
		if(/*StdDraw.mousePressed()*/StdDraw.isKeyPressed(32)||StdDraw.isKeyPressed(Character.codePointAt("E", 0))) {
			if(bulletcounter > bulletdelay) {
				for(int i = 0; i < fjoldiskota; i++) {
					if(skot[i].dispersed() || skot[i].collided) {
						skot[i] = new Bullet(ui.skotm , adal);
						StdAudio.play("astsounds/fire.wav");
						bulletcounter = 0;
						break;
					}
				}
			}
		}
		if(StdDraw.isKeyPressed(27)){ running = false; Asteroids.vann = false; ui.byrjunarsteinar--; ui.hradisteina-=2;}
	}
	public static void render(Ship adal, Bullet[] skot, int fjoldiskota, Rock[] steinar) {
		StdDraw.clear();
		StdDraw.picture(0,0, ui.backg , 2*widthmax+500, 2*widthmax+500);
		for(int i = 0; i < fjoldiskota; i++) {
			skot[i].show();
			
		}
		for(int i = 0; i <= steinarrender; i++) {
			if(!(steinar[i].collided)) { steinar[i].show(); }
			
		}
		adal.show();
		StdDraw.text(-775, 1050, "The score is :" + score);
		StdDraw.text(500, 1050, "fjoldi lifa :" + lif);
		bulletcounter++;
		StdDraw.show(5);
	}
	public static void collisioncheck(Ship adal, Bullet[] b, Rock[] c, int fjoldisteina) {
		for(int i = 0; i <= steinarrender; i++) {
			if(c[i].collides(adal)) {
				adal.collided = true; 
				lif-=1; 
				score-=150; 
			}
			for(int j = 0; j < b.length; j++) {
				if(c[i].collides(b[j])) {
					if(steinarrender < fjoldisteina-1 && (c[i].staerdsteins > 1)) { 
						b[j].collided = true;
						c[i].collided = true;
						daudirsteinar++;
						//System.out.println(c[i].staerdsteins);
						steinarrender ++; 
						//System.out.println(steinarrender);
						c[steinarrender] = new Rock(c[i].rx, c[i].ry, c[i].vx, -c[i].vy, c[i].s, 0, c[i].staerdsteins-1);
						steinarrender ++; 
						c[steinarrender] = new Rock(c[i].rx, c[i].ry, -c[i].vx, c[i].vy, c[i].s, 0, c[i].staerdsteins-1);
						score += (10 - c[i].staerdsteins)*4;
						StdAudio.play("astsounds/explo.wav");
					}else{
						b[j].collided = true;
						c[i].collided = true;
						daudirsteinar++;
						score += 50;
						StdAudio.play("astsounds/explo.wav");
					}
				}
			}
		}
	}
}
