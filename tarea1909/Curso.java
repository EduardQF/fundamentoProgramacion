import java.util.ArrayList;
import java.util.Scanner;
public class Curso
{
    public ArrayList<Alumno> alum=new ArrayList<Alumno>();
   
    
    public  void menu(){
        int op=0;
        do{
            System.out.print("\n"+
                             "1.Agregar alumno\n"+
                             "2.Quitar alumno\n"+
                             "3.modificar datos de los alumnos\n"+
                             "4.mostrar alumnos inscritos\n"+
                             "5.buscar alumno en la lista\n"+//rut,apellido,matricula
                             "6.Salir\n"+
                             "op:");
            op=leerNum();
            switch(op){
                case 1:newAlumno();break;
                case 2:deleteAlumno();break;
                case 3:changeAlumno();break;
                case 4:showAlumnos();break;
                case 5:searchAlumno();break;
                case 6:System.out.println("Adios!!!");break;
                default:mensajeError(1);break;
            }
            
        }while(op!=6);
    }
    //agregar alumnos
    public  void newAlumno(){
        System.out.println("ingrese nombre del nuevo alumno");
        String nombre=leerString();
        System.out.println("ingrese apellido del nuevo alumno");
        String apellido=leerString();
        System.out.println("ingrese Rut del nuevo alumno");
        String rut=leerRut();
        int matricula=alum.size()+1;
        alum.add(new Alumno(rut,matricula,nombre,apellido));
        
    }
    //quitar alumnos
    public  void deleteAlumno(){
        System.out.println("ingrese rut del alumno a eliminar");
        String rut=leerRut();
        for(int i=0;i<alum.size();i++){
               if(alum.get(i).getrut().equals(rut)){
                   alum.remove(i);
                }
            }
    }
    //cambiar datos de algun alumno
    public void changeAlumno(){
        int numM,op,posicion=-1;
        System.out.println("ingrese numero de matricula del alumno a modificar datos");
        numM=leerNum();
        for(int i=0;i<alum.size();i++){
            if(alum.get(i).getmatricula()==numM){
                posicion=i;
            }
        }
        
        if(posicion==-1){
            mensajeError(2);
        }else{
            System.out.println(alum.get(posicion).toString()+"\n");
            System.out.println("1.modificar nombre\n"+
                               "2.modificar apellido\n"+
                               "3.modificar rut\n"+
                               "4.modificar numero de matricula");
            op=leerNum();                   
            switch(op){
                case 1:changeNombre(posicion);break;
                case 2:changeApellido(posicion);break;
                case 3:changeRut(posicion);break;
                case 4:changeMatricula(posicion);break;
                default:mensajeError(1);
            }
        }
    }
    
    public void changeNombre(int n){
        System.out.println("ingrese nuevo nombre");
        String nombre=leerString();
        alum.get(n).setnombre(nombre);
    }
    
    public void changeApellido(int n){
        System.out.println("ingrese nuevo Apellido");
        String apellido=leerString();
        alum.get(n).setapellido(apellido);
    }
    
    public void changeRut(int n){
        System.out.println("ingrese nuevo Rut");
        String rut=leerString();
        alum.get(n).setrut(rut);
    }
    
    public void changeMatricula(int n){
        System.out.println("ingrese nuevo Matricula");
        int mat=leerNum();
        alum.get(n).setmatricula(mat);
    }
    //mostrar alumnos
    public void showAlumnos(){
        if(alum.size()==0){
            mensajeError(3);
        }else{
            for(int i=0;i<alum.size();i++){
               mostrarAlumno(i);
            }
        }
    }
    //busqueda alumnos
    public  void searchAlumno(){
        int op;
        System.out.print("1.busqueda por nombre"+
                       "\n2.busqueda por rut"+
                       "\n3.busqueda por numero de matricula"+
                       "\nop:");
        op=leerNum();
        switch(op){
            case 1:searchNom();break;
            case 2:searchRut();break;
            case 3:searchMat();break;
            default:mensajeError(1);
        }
    }
    
    public  void searchNom(){
        System.out.println("ingrese nombre");
        String nom=leerString();
        System.out.println("ingrese apellido");
        String apell=leerString();
        for(int i=0;i<alum.size();i++){
            if(alum.get(i).getnombre().equals(nom) && alum.get(i).getapellido().equals(apell)){
                mostrarAlumno(i);
            }
        }
    }
    
    public  void searchRut(){
        System.out.println("ingrese Rut");
        String rut=leerRut();
        for(int i=0;i<alum.size();i++){
            if(alum.get(i).getrut().equals(rut)){
                mostrarAlumno(i);
            }
        }
    }
    
    public void searchMat(){
         System.out.print("ingrese matricula");
         int matr=leerNum()-1;
         if(matr>alum.size()){
             System.out.print("no existe ese numero de matricula");
         }else{
            mostrarAlumno(matr);
         }
    }
    
    public void mostrarAlumno(int posicion){
        System.out.println("\n"+alum.get(posicion).toString()+"\n");
    }
    //otros metodos
    public void mensajeError(int op){
        switch(op){
            case 1:System.out.println("ingrese una opcion valida");break;
            case 2:System.out.println("el alumno buscado no existe");break;
            case 3:System.out.println("no existen alumnos registrados");break;
            case 4:System.out.println("ingrse solo numeros positivos");break;
            case 5:System.out.println("ingrse rut sin puntos y  con guion");break;
            case 6:System.out.println("ingrse solo letras");break;
        }
    }
    
    private boolean validadores(int op, String palabra){
        switch(op){
            case 1:return palabra.matches("[0-9]*");//validador de numeros
            case 2:return palabra.matches("[0-9]{8,8}-{1,1}[0-9k]{1,1}");//validador de rut
            case 3:return palabra.matches("[a-zA-Z]*");//validador de string
        }
        return false;
    }
    
    public int leerNum(){
        Scanner intro =new Scanner(System.in);
        int num;String leer;
        do{
            leer=intro.nextLine();
            if(!validadores(1,leer) || leer.equals("")){mensajeError(4);}
        }while(!validadores(1,leer) || leer.equals(""));
        num=Integer.parseInt(leer);
        return num;
    }
    
    public String leerRut(){
        Scanner intro =new Scanner(System.in);
        String leer;
        do{
            leer=intro.nextLine();
            if(!validadores(2,leer)){mensajeError(5);}
        }while(!validadores(2,leer));
        return leer;
    }
    
    public String leerString(){
        Scanner intro =new Scanner(System.in);
        String leer;
        do{
            leer=intro.nextLine();
            if(!validadores(3,leer)|| leer.equals("")){mensajeError(6);}
        }while(!validadores(3,leer)|| leer.equals(""));
        return leer;
    }
}
