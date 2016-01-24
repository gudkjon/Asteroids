 public class Circle extends Shape
{       //Tilviksbreytur
    private double x;
    private double y;
    private double radius;
    //N: c = Circle(x, y, r)
    //F: x,y eru hnit í hnitakerfi, og r er >0
    //E: c er hringur með miðju í x,y og radíus r 
    public Circle(double x, double y, double r)
    {
        this.x = x;
        this.y = y;
        this.radius = r;
    }

    //N: z = a.getCenter()
    //F: a er hringur, z er Point2D
    //E: x og y hnit í z eru miðjupunktur a
    public Point2D getCenter()
    {
        return new Point2D(x, y);
    }

    //N: c = a.intersects(b)
    //F: ekkert
    //E: c er true ef minnstu ferhyrningar í kringur a og b skerast
    public boolean intersects(Shape that)
    {
        Rectangle box = this.getBoundingBox();
        Rectangle box2 = that.getBoundingBox();
        return box.rectIntersects(box2);
    }

    //N: x = a.getBoundingBox()
    //F: a er hringur
    //D: x er minnsti ferhyrningur sem passar utanum a
    public Rectangle getBoundingBox()
    {
        return new Rectangle(this.x-radius, this.y-radius, radius*2, radius*2);
    }

    //N: a.scale(x)
    //F: a er hringur, x er double
    //E: a er x-sinnum stærra og miðjan óbreytt
    public void scale(double s)
    {
        radius *= s;
    }

    //N: r = a.getRadius()
    //F: a er hringur
    //E: r er radíus hringsins a
    public double getRadius()
    {
        return radius;
    }
}