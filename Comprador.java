/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.util.ArrayList;
import java.util.Objects;

public class Comprador extends Utilizador
{
    private ArrayList <Imovel> listaImoveis;

    
    public Comprador(ArrayList<Imovel> listaImoveis, String email, String nome, String password, String morada, String datanascimento, int id, ArrayList<Imovel> reg) {
        super(email, nome, password, morada, datanascimento, id, reg);
        this.listaImoveis = listaImoveis;
    }

    public Comprador(ArrayList<Imovel> listaImoveis) {
        this.listaImoveis = listaImoveis;
    }

    public Comprador(Comprador c){
        super(c);
        this.listaImoveis=c.getListaImoveis();
    }

    public Comprador(){
        super();
        this.listaImoveis= new ArrayList<>();
    }

    public ArrayList<Imovel> getListaImoveis() {
        return listaImoveis;
    }

    public void setListaImoveis(ArrayList<Imovel> listaImoveis) {
        this.listaImoveis = listaImoveis;
    }
   
    @Override
    public String toString() {
        return "Comprador{" + "listaImoveis=" + listaImoveis + '}';
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
        final Comprador other = (Comprador) obj;
        if (!Objects.equals(this.listaImoveis, other.listaImoveis)) {
            return false;
        }
        return true;
    }
    
    public Comprador Clone(){
        return new Comprador(this);
    }
}


