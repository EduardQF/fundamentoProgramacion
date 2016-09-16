
/**
 * Write a description of class Alumno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alumno
{
    // instance variables
    private int matricula;
    private String rut;
    private String nombre;
    private String apellido;

    //  Constructors
    public Alumno()
    {
        rut="";
        matricula=0;
        nombre="";
        apellido="";
    }
    
    public Alumno(String run,int matr,String nom,String ape){
        this.rut=run;
        this.matricula=matr;
        this.nombre=nom;
        this.apellido=ape;
    }
    //getters
    public String getrut(){
        return this.rut;
    }
    
    public int getmatricula(){
        return this.matricula;
    }
    
    public String getnombre(){
        return this.nombre;
    }
    
    public String getapellido(){
        return this.apellido;
    }
    //setters
    public void setrut(String run){
        this.rut =run;
    }
    
    public void setmatricula (int matr){
        this.matricula=matr;
    }
    
    public void setnombre (String nom){
        this.nombre=nom;
    }
    
    public void setapellido (String apell){
        this.apellido=apell;
    }
    //toString
    public String toString(){
        String mensaje="nombre: "+nombre+ 
                       "\napellido: "+apellido+
                       "\nrut: "+rut+
                       "\nnumero matricula: "+matricula;
         return mensaje;
    }
}
