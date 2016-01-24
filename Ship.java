public class Ship {
	public double rx, ry, radius;
	private double vx, vy, deg, degrad, degchange;
	private String s;
	public static boolean collided;
	public Ship(double rx, double ry, double vx, double vy,  String s, double deg) {
		this.rx = rx;
		this.ry = ry;
		this.vx = vx;
		this.vy = vy;
		this.s = s;
		this.deg = 0;
		this.degrad = Math.toRadians(deg);
		this.radius = 275/2;
		this.degchange = 0;
		this.collided = false;
	}
	public double getRX() {return this.rx;}
	public double getRY() {return this.ry;}
	public double getDEG() {return this.deg;}
	public void show() {
        this.rx = rx + vx;
        this.ry = ry + vy;
        this.deg = this.deg + this.degchange;
        this.degrad = Math.toRadians(deg);
        if(this.collided) { 	
        	rx = Math.random()*2048-1024; ry = Math.random()*2048-1024; vx = 0; vy = 0; degchange = 0; this.collided = false;  
        }
        if (rx > 1125) { this.rx = -(this.rx-101); }
        if (rx < -1125) { this.rx = -(this.rx+101); }
        if (ry > 1125) { this.ry = -(this.ry-101); }
        if (ry < -1125) { this.ry = -(this.ry+101); }
        StdDraw.picture(rx+2250,ry,s,275,275,deg); 
        StdDraw.picture(rx-2250,ry,s,275,275,deg); 
        StdDraw.picture(rx,ry+2250,s,275,275,deg); 
        StdDraw.picture(rx,ry-2250,s,275,275,deg); 
        StdDraw.picture(rx+2250,ry+2250,s,275,275,deg); 
        StdDraw.picture(rx+2250,ry-2250,s,275,275,deg); 
        StdDraw.picture(rx-2250,ry+2250,s,275,275,deg); 
        StdDraw.picture(rx-2250,ry-2250,s,275,275,deg); 
        StdDraw.picture(rx,ry,s, 275, 275,deg);  
	}
	public void acceleration() {
		if(this.vx > 25) { this.vx = 25; }else{ this.vx += Math.cos(degrad); }
		if(this.vx < -25) { this.vx = -25; }else{ this.vx += Math.cos(degrad); }
		if(this.vy > 25) { this.vy = 25; }else{ this.vy += Math.sin(degrad); }
		if(this.vy < -25) { this.vy = -25; }else{ this.vy += Math.sin(degrad); }
	}
	public void deceleration() {
		this.vx -= Math.cos(degrad);
		this.vy -= Math.sin(degrad);
	}
	public void gradualslow() {
		if(Math.abs(this.vx) < 0.1) {
			this.vx = 0;
		}else{
			if(this.vx > 0) {vx -= 0.1;}else{vx += 0.1;}
		}
		if(Math.abs(this.vy) < 0.1) {
			this.vy = 0;
		}else{
			if(this.vy > 0) {vy -= 0.1;}else{vy += 0.1;}
		}
	}
	public void turnleft() {
		if(this.degchange > 5){ this.degchange = 5; return; }
		this.degchange += 0.2;
		//this.degrad += Math.toRadians(10);
	}
	public void turnright() {
		if(this.degchange < -5) { this.degchange = -5; return;}
		this.degchange -= 0.2;
	}
	public void gradualslowdeg() {
		if(this.degchange > 0) {degchange -= 0.01;}else{degchange += 0.01;}
		if(this.degchange > 0) {degchange -= 0.01;}else{degchange += 0.01;}
	}
}