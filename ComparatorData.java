package poo;


import java.util.Comparator;
import java.io.Serializable;
import java.util.GregorianCalendar;

public class ComparatorData implements Comparator<Consulta>, Serializable
{
    public int compare(Consulta c1, Consulta c2){
        GregorianCalendar a1 = c1.getData();
        GregorianCalendar a2 = c2.getData();
        return a1.compareTo(a2);
    }
}