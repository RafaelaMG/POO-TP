package poo;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Consulta
{
    private GregorianCalendar data;

    
    public Consulta(){
        data = new GregorianCalendar();
       

    }
    
    public Consulta(GregorianCalendar data){
        this.data = data;
        

    }
    
    public Consulta(Consulta c){
        this.data = c.getData();
       

    }
    
    public GregorianCalendar getData(){
        return data;
    }
    
   


    public Consulta clone(){
        return new Consulta(this);
    }
    
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(o == null || o.getClass() != this.getClass()){
            return false;
        }
        Consulta c = (Consulta) o;
        return data.equals(c.getData());
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Data: " + data + "\n");
       
        return s.toString();
    }
    

}
    