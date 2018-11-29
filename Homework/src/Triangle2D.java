import java.util.*;
import java.math.*;
public class Triangle2D
{
	private MyPoint p1, p2, p3;
	private double l1, l2, l3;

	public MyPoint getP1()
	{
		return p1;
	}

	public void setP1(MyPoint p1)
	{
		this.p1 = p1;
	}

	public MyPoint getP2()
	{
		return p2;
	}

	public void setP2(MyPoint p2)
	{
		this.p2 = p2;
	}

	public MyPoint getP3()
	{
		return p3;
	}

	public void setP3(MyPoint p3)
	{
		this.p3 = p3;
	}

	public Triangle2D()
	{
		p1(0, 0);
		p2(1, 1);
		p3(2, 5);
		l3 = Math.pow(Math.pow(p1x - p2x, 2) + Math.pow(p1y - p2y, 2), 0.5);
		l2 = Math.pow(Math.pow(p1x - p3x, 2) + Math.pow(p1y - p3y, 2), 0.5);
		l1 = Math.pow(Math.pow(p3x - p2x, 2) + Math.pow(p3y - p2y, 2), 0.5);
	}

	public Triangle2D(double p1x, double p1y, double p2x, double p2y, double p3x, double p3y)
	{
		p1(p1x, p1y);
		p2(p2x, p2y);
		p3(p3x, p3y);
		l3 = Math.pow(Math.pow(p1x - p2x, 2) + Math.pow(p1y - p2y, 2), 0.5);
		l2 = Math.pow(Math.pow(p1x - p3x, 2) + Math.pow(p1y - p3y, 2), 0.5);
		l1 = Math.pow(Math.pow(p3x - p2x, 2) + Math.pow(p3y - p2y, 2), 0.5);
	}

	public double getPerimeter()
	{
		return l1 + l2 + l3;
	}

	public double getArea()
	{
		return Math.pow(this.getPerimeter() * (this.getPerimeter() - l1) * (this.getPerimeter() - l2)
				* (this.getPerimeter() - l3), 0.5);
	}
	
	public boolean contains(MyPoint p)
	{
		double px = p.getx();
		double py = p.gety();
		boolean b1 = 
	}
}
