/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.BufferedReader;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * @author anezubillaga
 */
public class Calculadora {
    private static File file;
    private List<Geometry> geometries;
    
    //Aquí configuro el fichero desde el que tiene que leer.
    public Calculadora(File file){
        this.file = file;
        geometries = new ArrayList<Geometry>();
        
    }
    
    public void separar() throws FileNotFoundException, IOException{
        String text = new String();
        //Ahora, tengo que coger lo que está en el fichero y copiarlo
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        //Mientras haya lineas para leer
        while ((text = br.readLine()) != null){
            String [] separador = text.split(",");
            if (separador[0].equals("circle"))
            {
                Circle circle = new Circle(parseDouble(separador[1]));
                geometries.add(circle);
            }
            else if (separador[0].equals("rectangle"))
            {
                Rectangle rectangle = new Rectangle(parseDouble(separador[1]), parseDouble(separador[2]));
                geometries.add(rectangle);
            }
            else if (separador[0].equals("triangle"))
            {
                Triangle triangle = new Triangle(parseDouble(separador[1]), parseDouble(separador[2]));
                geometries.add(triangle);
            }
          /*  else
                throw */
        }
    }
    
    public List<Geometry> getLista(){
        return geometries;
    }
    
    public List<Geometry> sortbyArea(){
        Collections.sort(geometries, new Comparator<Geometry>() {
            @Override
            public int compare(Geometry g1, Geometry g2) {
                return Double.compare(g1.calcArea(), g2.calcArea());
            }
        });
        return geometries;
    }
    
    public List<Geometry> sortbyClassName(){
        return geometries = geometries.stream()
                .sorted((g1,g2)->g1.getClass().getSimpleName().compareTo(g2.getClass().getSimpleName()))
                .collect(Collectors.toList());
    }
    
}
