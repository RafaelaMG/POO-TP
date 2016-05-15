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
  
  
    public Vendedor(HashMap<String, Imovel> imoveisVenda, ArrayList<Imovel> imoveisVendidos, String email, String nome, String password, String morada, String datanascimento) {
        super(email, nome, password, morada, datanascimento);
        this.imoveisVenda = imoveisVenda;
        this.imoveisVendidos = imoveisVendidos;
    }

    public Vendedor(HashMap<String, Imovel> imoveisVenda, ArrayList<Imovel> imoveisVendidos, Utilizador u) {
        super(u);
        this.imoveisVenda = imoveisVenda;
        this.imoveisVendidos = imoveisVendidos;
    }
    
    public Vendedor(Vendedor v){
        this.imoveisVenda=v.getImoveisDisponiveis();
        this.imoveisVendidos=v.getImoveisVendidos();
    }
    
    public Vendedor(){
        this.imoveisVenda=new HashMap<>();
        this.imoveisVendidos= new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Vendedor{" + "imoveisVenda=" + imoveisVenda + ", imoveisVendidos=" + imoveisVendidos + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Vendedor other = (Vendedor) obj;
        if (!Objects.equals(this.imoveisVenda, other.imoveisVenda)) {
            return false;
        }
        if (!Objects.equals(this.imoveisVendidos, other.imoveisVendidos)) {
            return false;
        }
        return true;
    }
    
    public Vendedor Clone(){
        return new Vendedor(this);
    }
}
