public class Rock {
	public double rx, ry, vx, vy, radius;
	public int staerdsteins;
	private double deg, scaleX, scaleY;
	public String s;
	public boolean collided;
	public Rock(double rx, double ry, double vx, double vy, String s, double deg, int staerdsteins) {
		this.rx = rx;
		this.ry = ry;
		this.vx = vx;
		this.vy = vy;
		this.s = s;
		this.deg = deg;
		this.scaleX = Math.pow(2,staerdsteins-1)*50;
		this.scaleY = Math.pow(2,staerdsteins-1)*50;
		this.radius = scaleX/2;
		this.collided = false;
		this.staerdsteins = staerdsteins;
	}
	public void show() {
		if(Math.random() < 0.5) { vx+=1; }else{ vx-=1; }
		if(Math.random() < 0.5) { vy+=1; }else{ vy-=1; }
		this.rx += this.vx;
        this.ry = this.ry + this.vy;
		if (rx > 1125) { this.rx = -(this.rx-101); }
        if (rx < -1125) { this.rx = -(this.rx+101); }
        if (ry > 1125) { this.ry = -(this.ry-101); }
        if (ry < -1125) { this.ry = -(this.ry+101); }
        this.deg += 5;
        StdDraw.picture(rx,ry,s,scaleX,scaleY,deg);
	}
	public boolean collides(Ship that) {
		if(this.collided) { return false; }
		double c = Math.sqrt(Math.pow(Math.abs(this.rx-that.rx),2)+Math.pow(Math.abs(this.ry-that.ry),2));
		return c < (this.radius+that.radius);
	}
	public boolean collides(Bullet that) {
		if(this.collided || that.collided) { return false; }
		double c = Math.sqrt(Math.pow(Math.abs(this.rx-that.rx),2)+Math.pow(Math.abs(this.ry-that.ry),2));
		return c < (this.radius+that.radius);
	}
}