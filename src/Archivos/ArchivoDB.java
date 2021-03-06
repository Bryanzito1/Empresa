/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.File;
import Modelo.Empresa;
import Modelo.*;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author Estudiante
 */
public class ArchivoDB {
    
    public void guardarInformacion(Empresa e) throws FileNotFoundException{
        
       File archivo = new File("empresa.txt"); 
       PrintStream salida = new PrintStream(archivo);
      
       for(Trabajador t : e.getTrabajadores()) {
                if(t instanceof Consultor){
                    Consultor c = (Consultor)t;
                    salida.print("C, " + c.getId() + ", " + c.getLabor() +",");
                    
                  } else if(t instanceof Administrador){
                      
                    Administrador a = (Administrador)t;
                    salida.print("A, " + a.getId() + ", " + a.getName() + ", " + a.getSalarioM() + ",");
                    
                } else if(t instanceof LiderProyecto){
                    
                    LiderProyecto l = (LiderProyecto)t;
                    salida.print("L, " + l.getId() + ", " + l.getName() + ", " + l.getSalarioM() + ", " + l.getLenguaje() + ", ");
                    salida.print(l.getProgramadores().size() + ", ");
                    for (Programador p : l.getProgramadores()) {
                        salida.print(p.getId()+ ",");
                    }
                } else if ( t instanceof Programador){
                    
                    Programador p = (Programador)t;
                    salida.print("P, " + p.getId() + ", " + p.getName() + ", " + p.getSalarioM() + ", ");
                }
            }
        
       
       salida.close();
    }
    
    public Empresa cargarinformacion(){
        File archivo = new File("empresa.txt");
        String tipo="";
        try{
            Scanner lectura = new Scanner(archivo);
            lectura.useDelimiter(",");
            while(lectura.hasNext()){
                tipo = lectura.next();
                if(tipo.equals("C")){
                   System.out.println("ID " + lectura.nextInt());
                   System.out.println("Labor: " + lectura.next()); 
                }else if(tipo.equals("A")){
                   System.out.println("ID " + lectura.nextInt());
                   System.out.println("Nombre: " + lectura.next()); 
                   System.out.println("Salario: " + lectura.nextDouble());
                }
             }
        
        
        lectura.close();
        }catch(FileNotFoundException ex){
            Logger.getLogger(ArchivoDB.class.getName());
                    
        }
    }
}
