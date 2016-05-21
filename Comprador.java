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
    private ArrayList <String> imfavoritos;

    
    public Comprador(ArrayList<String> imfavoritos, String email, String nome, String password, String morada, String datanascimento) {
        super(email, nome, password, morada, datanascimento);
        this.imfavoritos = imfavoritos;
    }

    public Comprador(ArrayList<Imovel> listaImoveis) {
        this.imfavoritos = imfavoritos;
    }

    public Comprador(Comprador c){
        super(c);
        this.imfavoritos=c.getImfavoritos();
    }

    public Comprador(){
        super();
        this.imfavoritos= new ArrayList<>();
    }

    public ArrayList<String> getImfavoritos() {
       ArrayList<String> novo= new ArrayList<>();
        for(String s: imfavoritos)
            novo.add(s);
          
        return novo;
    }

    public void setListaImoveis(ArrayList<Imovel> listaImoveis) {
        this.imfavoritos = imfavoritos;
    }
    
    public void addFavorito(String idImovel) {
        imfavoritos.add(idImovel);
        
    }
   
    @Override
    public String toString() {
        return "Comprador{" + "listaImoveis=" + imfavoritos + '}';
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
        if (!Objects.equals(this.imfavoritos, other.imfavoritos)) {
            return false;
        }
        return true;
    }
    
    public Comprador Clone(){
        return new Comprador(this);
    }
}


