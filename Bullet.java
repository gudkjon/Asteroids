public class Bullet {
	public double rx, ry, radius;
	private double vx, vy, deg, startx, starty, distancex, distancey;
	private int vegalengd;
	private String s;
	public boolean collided;
	public Bullet(String s, Ship a) {
		if(s.equals("byrja")) {
			
			this.collided = true;
		}else{
			this.rx = a.getRX();
			this.ry = a.getRY();
			this.distancex = this.rx;
			this.distancey = this.ry;
			this.s = s;
			this.deg = a.getDEG();
			this.vx = 40*Math.cos(Math.toRadians(deg));
			this.vy = 40*Math.sin(Math.toRadians(deg));
			this.vegalengd = 0;
			this.startx = rx;
			this.starty = ry;
			this.radius = 50;
			this.collided = false;
		}
	}
	public void show() {
		if(vegalengd > 70) {return;}
		//if(this.s.equals("byrja")) { return ;}
		if(this.collided) { return; }
		this.rx = this.rx + this.vx;
        this.ry = this.ry + this.vy;
		if (rx > 1125) { this.rx = -(this.rx-101); }
        if (rx < -1125) { this.rx = -(this.rx+101); }
        if (ry > 1125) { this.ry = -(this.ry-101); }
        if (ry < -1125) { this.ry = -(this.ry+101); }
        this.vegalengd++;
    	StdDraw.picture(this.rx,this.ry,s, 100, 100, deg);
		}
	public boolean dispersed() { return (vegalengd > 70);
	}
}	

