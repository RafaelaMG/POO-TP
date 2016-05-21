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

    
    public Comprador(ArrayList<String> imfavoritos, String email, String nome, String password, String morada, String datanascimento, int id) {
        super(email, nome, password, morada, datanascimento, id);
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
   
   public boolean equals(Object o){
    if(this==o)
        return true;
    
    if((o==null)|| this.getClass() != o.getClass())
        return false;
    
    else{
        Comprador i=(Comprador) o;
        return (this.imfavoritos.equals(i.getImfavoritos()));
    }
    }
   
   
   public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Favoritos: " + this.getImfavoritos() + "\n");
        
        return s.toString();
    }

    public Comprador Clone(){
        return new Comprador(this);
    }
}


