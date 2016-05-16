/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Imoobiliaria {

    private HashMap<String, Utilizador> utilizadores;
    private ArrayList<Imovel> imoveis;
    private HashMap<String, Vendedor> vendedores;

    public HashMap<String, Utilizador> getUtilizadores() {
        HashMap<String, Utilizador> user = new HashMap<>();
        for (Utilizador u : this.utilizadores.values()) {
            user.put(u.getEmail(), u.Clone());
        }
        return user;
    }

    public void setUtilizadores(HashMap<String, Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }

    public ArrayList<Imovel> getImoveis() {
        ArrayList<Imovel> res = new ArrayList<>();
        for (Imovel a : this.imoveis) {
            res.add(a.Clone());
        }
        return res;
    }

    public void setImoveis(ArrayList<Imovel> imoveis) {
        this.imoveis = imoveis;
    }

    public HashMap<String, Vendedor> getVendedores() {
        HashMap<String, Vendedor> v = new HashMap<>();
        for (Vendedor vend : this.vendedores.values()) {
            v.put(vend.getEmail(), vend.Clone());
        }
        return v;
    }

    public void setVendedores(HashMap<String, Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public Imoobiliaria(HashMap<String, Utilizador> utilizadores, ArrayList<Imovel> imoveis, HashMap<String, Vendedor> vendedores) {
        this.utilizadores = utilizadores;
        this.imoveis = imoveis;
        this.vendedores = vendedores;
    }

    public Imoobiliaria(Imoobiliaria m) {
        this.utilizadores = m.getUtilizadores();
        this.imoveis = m.getImoveis();
        this.vendedores = m.getVendedores();
    }

    public Imoobiliaria() {
        this.utilizadores = new HashMap<>();
        this.imoveis = new ArrayList<>();
        this.vendedores = new HashMap<>();
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Utilizador: " + this.getUtilizadores() + "\n");
        s.append("Imóvel: " + this.getImoveis() + "\n");
        s.append("Vendedor: " + this.getVendedores() + "\n");
        return s.toString();
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
        final Imoobiliaria other = (Imoobiliaria) obj;
        if (!Objects.equals(this.utilizadores, other.utilizadores)) {
            return false;
        }
        if (!Objects.equals(this.imoveis, other.imoveis)) {
            return false;
        }
        if (!Objects.equals(this.vendedores, other.vendedores)) {
            return false;
        }
        return true;
    }

    public Imoobiliaria Clone() {
        return new Imoobiliaria(this);
    }
    
   public void gravaObj(String fich) throws IOException { 
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fich)); 
        oos.writeObject(this); 
        
        oos.flush(); 
        oos.close(); 
    } 
   
   public static Imoobiliaria leObj(String fich) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fich));
      
        Imoobiliaria te= (Imoobiliaria) ois.readObject();
        
        ois.close();
        return te;
    }
   
   public static Imoobiliaria initApp (){
       String fich= new String(); 
       Imoobiliaria te = null;
        try {
            te = Imoobiliaria.leObj(fich);
        } catch (IOException ex) {
            Logger.getLogger(Imoobiliaria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Imoobiliaria.class.getName()).log(Level.SEVERE, null, ex);
        }
       return te;
    
       
   }
   
   public void fechaSessao (){
       String fich=new String();
        try {
            gravaObj(fich);
        } catch (IOException ex) {
            Logger.getLogger(Imoobiliaria.class.getName()).log(Level.SEVERE, null, ex);
        }
   }


    public void registarUtilizador(Utilizador utilizador) throws UtilizadorExistenteException {
        this.utilizadores.put(utilizador.getEmail(), utilizador.Clone());
        if (this.utilizadores.containsKey(utilizador.getEmail())) {
            throw new UtilizadorExistenteException("Este email já está registado");
        }

    }

    public void iniciaSessao(String email, String password) throws SemAutorizacaoException {
        if ((this.utilizadores.containsKey(email)) && (this.utilizadores.get(email).getPassword().equals(password))); else {
            throw new SemAutorizacaoException("Dados incorrectos");
        }

    }
    
    public boolean validaVendedor(Vendedor v){
        Utilizador u= new Utilizador() {};
        return (this.utilizadores.containsKey(v.getEmail()) && (this.utilizadores.get(v.getEmail()).equals(u.getPassword())));
    }

    public void registaImovel(Imovel im) throws ImovelExisteException, SemAutorizacaoException {
        Vendedor v = new Vendedor();
        Utilizador u = new Utilizador() {}; {
        };
        if (this.utilizadores.containsKey(v.getEmail()) && (this.utilizadores.get(v.getEmail()).equals(u.getPassword())) && (!this.imoveis.contains(im.getIdImovel()))) {
            imoveis.add(im.Clone());
        } else if (this.utilizadores.containsKey(v.getEmail()) && (this.utilizadores.get(v.getEmail()).equals(u.getPassword())) && (this.imoveis.contains(im.getIdImovel()))) {
            throw new ImovelExisteException("Este id de imóvel já foi registado");
        } else {
            throw new SemAutorizacaoException("Não tem autorização para registar imóveis");
        }

    }
    
   public void setEstado ( String idImovel , String estado )throws ImovelInexistenteException ,SemAutorizacaoException ,EstadoInvalidoException{
       Imovel im = new Imovel() {};
       Vendedor v= new Vendedor();
       if(validaVendedor(v)==true){
           if(this.imoveis.contains(idImovel))
               im.setEstadoI(estado);
           else if(estado.equals("")){
               throw new EstadoInvalidoException("Estado inválido");
           }
           else{
               throw new ImovelInexistenteException("Este id de imóvel não existe");
           }
       }
       else{
           throw new SemAutorizacaoException("Vendedor inválido");
       }
       
       
   }


}
