/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Demo
 */
public class Consulta extends Imovel {
    private ArrayList<Imovel> consultas;
    private int numConsultas;

    public Consulta(ArrayList<Imovel> consultas,int numConsultas, String rua, String idImovel, String estado, String tipo, int idP, int precoP, int precoM) {
        super(rua, idImovel, estado, tipo, idP, precoP, precoM);
        this.consultas = consultas;
        this.numConsultas=numConsultas;
    }

   
    
    public Consulta(Consulta c){
        super(c);
        this.consultas=c.getConsultas();
        this.numConsultas=c.getNumConsultas();
    }

    public int getNumConsultas() {
        return numConsultas;
    }

    public void setNumConsultas(int numConsultas) {
        this.numConsultas = numConsultas;
    }
    
    
    public ArrayList<Imovel> getConsultas() {
        ArrayList<Imovel> res = new ArrayList<>();
        for (Imovel a : this.consultas) {
            res.add(a.Clone());
        }
        return res;
    }
    
    public void setConsultas(ArrayList<Imovel> consultas){
        this.consultas=consultas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consulta other = (Consulta) obj;
        if (this.numConsultas != other.numConsultas) {
            return false;
        }
        if (!Objects.equals(this.consultas, other.consultas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consulta{" + "consultas=" + consultas + ", numConsultas=" + numConsultas + '}';
    }

  
    
    public Consulta Clone(){
        return new Consulta(this);
    }
    
}
