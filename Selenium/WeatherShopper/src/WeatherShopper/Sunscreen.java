package WeatherShopper;

import java.util.ArrayList;
import java.util.List;

public class Sunscreen extends Products {
	public static List<Sunscreen> objects = new ArrayList<>();
	
	public Sunscreen(String Mname, int Mprice)
	{
		name = Mname;
		price = Mprice;
		objects.add(this);
	}
	
	public static void printAllObjects()
	{
		for (Sunscreen object : objects)
		{
			System.out.println(object);
		}
	}
	
	@Override
	public String toString()
	{
		return "ProductName: " + name + "; Product Price: " + price;
	}
}
