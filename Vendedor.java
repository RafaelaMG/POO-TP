/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vendedor extends Utilizador
{
    private HashMap<String, Imovel> imoveisVenda; //Disponível ou Não disponível para venda.
    private ArrayList<Imovel> imoveisVendidos; // Histórico de vendas

    
    
    
    public HashMap<String, Imovel> getImoveisDisponiveis() {
        HashMap<String, Imovel> i = new HashMap<>();
        for (Imovel im : this.imoveisVenda.values()) {
            i.put(im.getRua(), im.Clone());
        }
        return i;
    }
    
  public ArrayList<Imovel> getImoveisVendidos() {
        ArrayList<Imovel> res = new ArrayList<>();
        for (Imovel a : this.imoveisVendidos) {
            res.add(a.Clone());
        }
        return res;
    }

    public void setImoveisVenda(HashMap<String, Imovel> imoveisVenda) {
        this.imoveisVenda = imoveisVenda;
    }

    public void setImoveisVendidos(ArrayList<Imovel> imoveisVendidos) {
        this.imoveisVendidos = imoveisVendidos;
    }
  
  
    public Vendedor(HashMap<String, Imovel> imoveisVenda, ArrayList<Imovel> imoveisVendidos, String email, String nome, String password, String morada, String datanascimento, int id) {
        super(email, nome, password, morada, datanascimento,id);
        this.imoveisVenda = imoveisVenda;
        this.imoveisVendidos = imoveisVendidos;
    }

    
    public Vendedor(Vendedor v){
        super(v);
        this.imoveisVenda=v.getImoveisDisponiveis();
        this.imoveisVendidos=v.getImoveisVendidos();
    }
    
    public Vendedor(){
        super();
        this.imoveisVenda=new HashMap<>();
        this.imoveisVendidos= new ArrayList<>();
    }

 public boolean equals(Object o){
    if(this==o)
        return true;
    
    if((o==null)|| this.getClass() != o.getClass())
        return false;
    
    else{
        Vendedor i=(Vendedor) o;
        return (this.imoveisVenda.equals(i.getImoveisDisponiveis())&& this.imoveisVendidos.equals(i.getImoveisVendidos()));
    }
    }

   
     public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Imoveis Disponíveis: " + this.getImoveisDisponiveis() + "\n");
        s.append("Imoveis Vendidos: " + this.getImoveisVendidos() + "\n");
        
       
        return s.toString();
    }


    
    
    public Vendedor Clone(){
        return new Vendedor(this);
    }
}
