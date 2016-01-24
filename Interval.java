public class Interval
{
	private final double left;
	private final double right;
	//N: x = Interval(a,b)
	//F: a og b eru rauntölur
	//E: x er interval a bilinu a og b
	public Interval(double left, double right) {
		this.left = left;
		this.right = right;
    }
    //N: x = a.getleft()
    //F: a er interval
    //E: x er vinstri endi intervalsins 
    public double getleft() { return left;}
    //N: x = a.getright()
    //F: a er interval
    //E: x er hægri endi intervalsins
    public double getright() { return right;}
    //N: x = a.contains(tala)
    //F: a er interval, tala er rauntala
    //E: x = hvort tala sé í a
	public boolean contains(double x) {
		return x >= left && x <= right;
	}
	//N: x = a.intersects(b)
    //F: a og b eru interval
    //E: x = hvort intervölin skerist
	public boolean intersects(Interval b) {
		return (this.left<b.right && b.left < this.right);
	}
	//N: s = a.toString() 
    //F: a er interval
    //E: s er strengur sem segir mörk intervalsins 
	public String toString() {
		return "thetta er fra " + this.left + " til " + this.right;
	}

	public static void main (String[]args) {
		Interval a = new Interval(3,1);
		Interval b = new Interval(11,4);
		double x = Double.parseDouble(args[0]);
		System.out.println(a.contains(x));
		System.out.println(a.intersects(b));
		System.out.println(a.toString());
	}
}