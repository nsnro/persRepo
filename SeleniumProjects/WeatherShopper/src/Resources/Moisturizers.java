package Resources;

import java.util.ArrayList;
import java.util.List;

public class Moisturizers extends Products{
    public static List<Moisturizers> objects = new ArrayList<>();

    public Moisturizers(String Mname, int Mprice)
    {
        name = Mname;
        price = Mprice;
        objects.add(this);
    }

    public static void printAllObjects()
    {
        for (Moisturizers object : objects)
        {
            System.out.println(object);
        }
    }

    @Override
    public String toString()
    {
        return "ProductName: " + name + "; Product Price: " + price;
    }

    public static void resetObjectList()
    {
        objects.clear();
    }

}
