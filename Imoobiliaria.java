/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Imoobiliaria implements Serializable {

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
    
    public String getImoveis2(){
        String res = new String();
        for(Imovel a: this.imoveis){
            res=a.getIdImovel();
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

        Imoobiliaria te = (Imoobiliaria) ois.readObject();

        ois.close();
        return te;
    }

    public void log(String f, boolean ap) throws IOException {
        FileWriter fw = new FileWriter(f, ap);
        fw.write("\n----------- LOG - LOG - LOG - LOG - LOG ----------------\n");
        fw.write(this.toString());
        fw.write("\n----------- LOG - LOG - LOG - LOG - LOG ----------------\n");
        fw.flush();
        fw.close();
    }

    public static Imoobiliaria initApp() {
        Imoobiliaria imo;
        try {
            imo = Imoobiliaria.leObj("estado.tabemp");
        } catch (IOException e) {
            imo = new Imoobiliaria();
            System.out.println("Não existem dados gravados|\nErro de leitura.");
        } catch (ClassNotFoundException e) {
            imo = new Imoobiliaria();
            System.out.println("Não é possível ler os dados!\nFicheiro com formato desconhecido.");
        } catch (ClassCastException e) {
            imo = new Imoobiliaria();
            System.out.println("Não é possível ler os dados!\nErro de formato.");
        }
        return imo;
    }

    public void fechaSessao() {
        String fich = new String();
        try {
            gravaObj(fich);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean registo(String email) {
        return (this.utilizadores.containsKey(email));
    }

    public void registarUtilizador(Utilizador utilizador) throws UtilizadorExistenteException {
        if (this.utilizadores.containsKey(utilizador.getEmail())) {
            throw new UtilizadorExistenteException("Este email já existe");
        } else {
            this.utilizadores.put(utilizador.getEmail(), utilizador.Clone());
        }
    }

    public void addUtilizadores(Set<Utilizador> user) {
        Utilizador e = new Utilizador() {
        };
        for (Iterator<Utilizador> it = user.iterator(); it.hasNext();) {
            e = it.next();
            try {
                registarUtilizador(e.Clone());
            } catch (UtilizadorExistenteException ex) {
                System.out.println(ex.getMessage());;

            }
        }
    }

    public boolean auxLogin(String email, String password) {
        return (this.utilizadores.containsKey(email) && this.utilizadores.get(email).getPassword().equals(password));
    }

    public void iniciaSessao(String email, String password) throws SemAutorizacaoException {
        if (auxLogin(email, password)) {
            System.out.println("Login com sucesso");
        } else {
            throw new SemAutorizacaoException("Dados incorrectos");
        }
    }

    
    public void registaImovel(Imovel im) throws ImovelExisteException, SemAutorizacaoException {
          Utilizador u= new Utilizador() {};         
       if(this.utilizadores.containsKey(u.getId()!=1))
           throw new SemAutorizacaoException("Não tem autorização para adicionar imóveis!");
           
       else if(this.imoveis.contains(im)){
            throw new ImovelExisteException("Este imóvel já existe!");
        }
           this.imoveis.add(im.Clone());
    }
    
   public boolean elmImovel(Imovel nome){
       return this.imoveis.remove(nome);
   }
   
  

    public void setEstado(String idImovel, String estado) throws ImovelInexistenteException, SemAutorizacaoException, EstadoInvalidoException {
       
     /*   if(!this.imoveis.contains(idImovel))
          throw new ImovelInexistenteException("O Id de Imóvel não existe!");
      else if(estado!="Vendido" && estado != "Em venda" && estado!="Reservado"){
          throw new EstadoInvalidoException("Estado não é válido!");
      }*/
      for(Imovel i: imoveis)
          if(i.getIdImovel().equals(idImovel)){
              System.out.println("cena");
              new Imovel(i) {
}.setEstado(estado);
    }
    }

     public List<Imovel> getImovel(String classe, int preco) {
        List<Imovel> imo = new ArrayList<Imovel>();
        
        for(Imovel i: imoveis){
            while(i.getPrecoP()<=preco){
                if(i.getTipo().equals(classe))
                    imo.add(i);
            }
        }
         return imo;
    }

   /* public List<Habitavel> getHabitaveis(int preco) {
        List<Habitavel> hab = new ArrayList<Habitavel>();
            Imovel e = new Habitavel() 
      
        for(Imovel i: imoveis)
            while(i.getPrecoP()<=preco){
                if(i.)
                    hab.add();
            
            }
        return hab;
    }*/

    public Map<Imovel, Vendedor> getMapeamentoImoveis() {
        Map<Imovel, Vendedor> mapImo = new HashMap<Imovel, Vendedor>();
        Vendedor v = new Vendedor();
        for (Imovel i: imoveis){
           for(Utilizador u : utilizadores.values()){
                if(i.getIdP()==u.getId())
                    v = (Vendedor) u.Clone();
                    mapImo.put(i, v);
           }
       }
    return mapImo;
    }

}
