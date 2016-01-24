public class Rectangle extends Shape
{       //Tilviksbreytur
        private double x,y,width,height;
        //N: r = Rectangle(x, y, w, h)
        //F: x,y eru hnit í hnitakerfi, og width og height er >0
        //E: r er kassi sem byrjar í x,y og fer út um w til hægri og h upp 
        public Rectangle (double x, double y, double w, double h)
        {
                this.x = x;
                this.y = y;
                this.width = w;
                this.height = h;
        }
 
        //N: z = a.getCenter()
        //F: a er tvívíður ferhyrningur
        //E: z er af gerð Point2D(x,y) þar sem x og y eru hnit miðjupunkts a
        public Point2D getCenter()
        {
                return new Point2D(this.x+this.width/2, this.y+this.height/2);
        }
 
        //N: c = a.contains(b)
        //F: a og b eru tvívíðir ferhyrningar
        //E: c er true ef a inniheldur b annars er það false
        public boolean contains(Rectangle b)
        {
                Interval int1 = new Interval(x, x+width);
                Interval int2 = new Interval(y, y+height);
                double a = b.x, c = b.y, d = b.x+b.width, e = b.y+b.height;
                if(int1.contains(a) && int2.contains(c) && int1.contains(d) && int2.contains(e))
                {
                        return true;
                }else{
                        return false;
                }
        }
 
        //N: c = a.intersects(b)
        //F: a og b eru tvívíðir ferhyrningar
        //E: c er true ef a og b hafa línur sem skerast annars false
        public boolean rectIntersects(Rectangle b)
        {
                Interval int1 = new Interval(x, x+width);
                Interval int2 = new Interval(y, y+height);
                Interval int3 = new Interval(b.x, b.x+b.width);
                Interval int4 = new Interval(b.y, b.y+b.height);
                if(int1.intersects(int3) && int2.intersects(int4) && (this.contains(b) == false)){return true;}
                else {return false;}
        }
 
        //N: b = a.intersects(s)
        //F: a er Ferhyrningur, s er einhver erfingi af data type Shape
        //E: b er true ef a og boundingbox af s skerast á einhverjum punkti annars false
        public boolean intersects(Shape that)
        {
                Rectangle box = that.getBoundingBox();
                return this.rectIntersects(box);
        }
 
        //N: b = a.getBoundingBox()
        //F: a er ferhyrningur
        //E: b er minnsti ferhyrningur sem passar utan um a
        public Rectangle getBoundingBox()
        {
                return new Rectangle(this.x, this.y, this.width, this.height);
        }
 
        //N: a.scale(x)
        //F: a er ferhyrningur, x er double
        //E: a er x-sinnum stærra en með sama byrjunarpunkt
        public void scale(double s)
        {
                width *= s;
                height *= s;
        }
 
        //N: b = a.getWidth()
        //F: a er ferhyrningur
        //E: b er breiddin á ferhyrning a
        public double getWidth()
        {
                return width;
        }
 
        //N: b = a.getHeight()
        //F: a er ferhyrningur
        //E: b er hæðin á ferhyrning a
        public double getHeight()
        {
                return height;
        }
 
        //N: a.setWidth(x)
        //F: a er ferhyrningur
        //E: breiddin á a er orðin x
        public void setWidth(double set)
        {
                width = set;
        }
 
        //N: a.setHeight(x)
        //F: a er ferhyrningur
        //E: hæðin á a er orðin x
        public void setHeight(double set)
        {
                height = set;
        }
}