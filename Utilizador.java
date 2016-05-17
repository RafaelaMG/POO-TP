package poo;

import java.io.Serializable;



public abstract class Utilizador implements Serializable
{
    private String email;
    private String nome;
    private String password;
    private String morada;
    private String datanascimento;
    private String comprar;
    private String vender;

    
    
    
    public Utilizador(String email, String nome, String password, String morada, String datanascimento, String comprador, String vendedor) {
        this.email = email;
        this.nome = nome;
        this.password = password;
        this.morada = morada;
        this.datanascimento = datanascimento;
        this.comprar=comprador;
        this.vender=vender;
    }

    
    public Utilizador (Utilizador u){
        this.email=u.getEmail();
        this.nome=u.getNome();
        this.password=u.getPassword();
        this.morada=u.getMorada();
        this.datanascimento=u.getDatanascimento();
        this.comprar=u.getComprar();
        this.vender=u.getVender();
    }
    
    public Utilizador(){
        this.email=new String();
        this.nome= new String();
        this.password=new String();
        this.morada=new String();
        this.datanascimento= new String();
        this.comprar=new String();
        this.vender=new String();
        
    }

    public String getComprar() {
        return comprar;
    }

    public void setComprar(String comprar) {
        this.comprar = comprar;
    }

    public String getVender() {
        return vender;
    }

    public void setVender(String vender) {
        this.vender = vender;
    }
    
    
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }
   


public String toString(){
    StringBuilder s = new StringBuilder();
    
    s.append("Email: " + this.getEmail() + "\n");
    s.append("Nome: " + this.getNome() + "\n");
    s.append("Password: " + this.getPassword() + "\n");
    s.append("Morada: " + this.getMorada() + "\n");
    s.append("Data de Nascimento: " + this.getDatanascimento() + "\n");
    s.append("Comprado:" + this.getComprar() + "\n");
    s.append("vender" + this.getVender() + "\n");
    
    return s.toString();
}


public boolean equals(Object o){
    if(this==o)
        return true;
    
    if((o==null)|| this.getClass() != o.getClass())
        return false;
    
    else{
        Utilizador u=(Utilizador) o;
        return (this.email.equals(u.getEmail()) && this.nome.equals((u.getNome())) && this.password.equals(u.getPassword()) && this.morada.equals(u.getMorada()) && this.datanascimento.equals(u.getDatanascimento()) && this.comprar.equals(u.getComprar()) && this.vender.equals(u.getVender()));
    }
    
}



public Utilizador Clone(){
    return new Utilizador(this) {};
}

}
