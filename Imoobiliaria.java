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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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
            Logger.getLogger(Imoobiliaria.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean validaVendedor(Utilizador u, String cena) {
        return (this.utilizadores.get(u.getVender()).equals(cena));
    }

    public void registaImovel(Imovel im) throws ImovelExisteException, SemAutorizacaoException {
       /*Utilizador v=new Utilizador() {};
       String vend="Vendedor";
        if(!validaVendedor(v, vend))
            throw new SemAutorizacaoException("Não tem autorização para registar um imóvel!");
       
        if(this.imoveis.contains(im)){
            throw new ImovelExisteException("Este imóvel já existe!");
        }*/
           this.imoveis.add(im.Clone());
    }
    

    /*public void setEstado(String idImovel, String estado) throws ImovelInexistenteException, SemAutorizacaoException, EstadoInvalidoException {
        Imovel im = new Imovel() {
        };
        Vendedor v = new Vendedor();
        if (validaVendedor(v) == true) {
            if (this.imoveis.contains(idImovel)) {
                im.setEstadoI(estado);
            } else if (estado.equals("")) {
                throw new EstadoInvalidoException("Estado inválido");
            } else {
                throw new ImovelInexistenteException("Este id de imóvel não existe");
            }
        } else {
            throw new SemAutorizacaoException("Vendedor inválido");
        }

    }*/

    public boolean verificaComprador(Utilizador u, String cena) {
        return (this.utilizadores.get(u.getComprar()).equals(cena));
    }

}
