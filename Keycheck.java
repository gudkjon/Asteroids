public class Keycheck {
	public static void keycheck(Ship adal, Bullet[] skot, int fjoldiskota) {
		if(StdDraw.isKeyPressed(Character.codePointAt("W", 0))) { System.out.print("W"); }
		if(StdDraw.isKeyPressed(Character.codePointAt("A", 0))) { adal.turnleft("A"); }
		if(StdDraw.isKeyPressed(Character.codePointAt("D", 0))) { adal.turnright("D"); }
		if(StdDraw.isKeyPressed(Character.codePointAt("S", 0))) { adal.deceleration("S"); }
	}
	public static void main (String[]args) {
		while(true) {
			keycheck();
		}
	}
}