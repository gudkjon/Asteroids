public abstract class Shape {
    // Notkun: p = s.getCenter()
    // Fyrir:  ekkert
    // Eftir:  p er miðjan á s
    public abstract Point2D getCenter();

    // Notkun: r = s.getBoundingBox()
    // Fyrir:  ekkert
    // Eftir:  r er minnsti ferhyrningur sem passar utan um s
    public abstract Rectangle getBoundingBox();

    // Notkun: c = s.intersects(o)
    // Fyrir:  ekkert
    // Eftir:  c er true of s og o skarast
    public abstract boolean intersects(Shape o);

    // Notkun: s.scale(f)
    // Fyrir:  f > 0
    // Eftir:  s er f-sinnum stærra og miðjan er óbreytt
    public abstract void scale(double f);
}