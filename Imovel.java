/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public abstract class Imovel implements Serializable
{
    private String rua;
    private String idImovel;
    private String estado;
    private String tipo;
    private int idP;
    private int precoP; //preço pedido pelo proprietário 
    private int precoM; // preço mínimo que não deve ser visível ao utilizador.
    private List<Consulta> consultas;
    

   
    
    public Imovel(List<Consulta> consultas, String rua, String idImovel, String estado, String tipo,int idP, int precoP, int precoM) {
       this.consultas=consultas;
        this.rua = rua;
        this.estado=estado;
        this.precoP = precoP;
        this.precoM = precoM;
        this.idImovel=idImovel;
        this.idP = idP;
        this.tipo = tipo;
        
    }


    public Imovel(Imovel i){
       
        this.rua=i.getRua();
        this.estado=i.getEstado();
        this.precoP=i.getPrecoP();
        this.precoM=i.getPrecoM();
        this.idImovel=i.getIdImovel();
        this.tipo = i.getTipo();
        this.idP = i.getIdP();
        this.consultas=i.getConsulta();
        
        
        
    }


    public Imovel(){
      
        this.rua=new String();
        this.precoP=0;
        this.precoM=0;
        this.idImovel=new String();
        this.estado=new String();
        this.tipo = new String();
        this.idP = 0;
        
    }

    
    public List<Consulta> getConsulta() {
        List<Consulta> cons = new ArrayList<Consulta>();

        for (Consulta c : consultas) {
            
                    cons.add(c.clone());
                }
                return cons;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
        
        
    
   
     public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }
    
     public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(String idImovel) {
        this.idImovel = idImovel;
    }

    public String getEstado(){
        return estado;
    }
    
    public void setEstado(String Estado){
        this.estado=estado;
    }
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getPrecoP() {
        return precoP;
    }

    public void setPrecoP(int precoP) {
        this.precoP = precoP;
    }

    public int getPrecoM() {
        return precoM;
    }

    public void setPrecoM(int precoM) {
        this.precoM = precoM;
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Rua: " + this.getRua() + "\n");
        s.append("Id do imóvel: " + this.getIdImovel() + "\n");
        s.append("Id do Proprietário: " + this.getIdP() + "\n");
        s.append("Estado do imóvel " + this.getEstado() + "\n");
        s.append("Tipo: " + this.getTipo() + "\n");
        s.append("Valor pretendido: " + this.precoP + "\n");
        s.append("Valor mínimo " + this.precoM + "\n");
        s.append("Consultas:" + this.consultas + "\n");
        return s.toString();
    }

    public boolean equals(Object o){
    if(this==o)
        return true;
    
    if((o==null)|| this.getClass() != o.getClass())
        return false;
    
    else{
        Imovel i=(Imovel) o;
        return (this.rua.equals(i.getRua()) && this.idImovel.equals(i.getIdImovel()) && this.estado.equals(i.getEstado()) && this.idP==(i.getIdP())
                && this.precoM == i.getPrecoM() && this.precoP == i.getPrecoP() && this.tipo.equals(i.getTipo()) && this.consultas.equals(i.getConsulta()));
    }
    }
    
    public Imovel Clone(){
        return new Imovel(this) {};
    }

}

