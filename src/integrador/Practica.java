package integrador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Practica {

    
//    La función recibirá un numero x y deberá determinar si es capicúa o no. 
//    Este deberá devolver verdadero(true) si es capicúa y falso(false) si no lo es. 
//    Además deberemos contemplar los siguientes escenarios: 
//    Contemplar que el numero que llega puede ser negativo. 
//    Contemplar que el numero que llega puede ser de un digito, si es así debe devolver true. 
//    Contemplar que el numero que llega puede ser null, si es así debe devolver false.
//    @param num
//    @return esPalindromo
     
    public Boolean numeroCapicua(Integer num) {
        int numeroAlRevez=0,resto,numero=0;
        boolean esCapicua;
        
        if (num==null){
            return false;
        }
        
        if (num<0){
            numero=num;
            while (num < 0) {
                resto = num % 10;
                numeroAlRevez = numeroAlRevez * 10 + resto;
                num /= 10;
            }
        }else{
            if (num>0){
                numero=num;
                while (num > 0) {
                    resto = num % 10;
                    numeroAlRevez = numeroAlRevez * 10 + resto;
                    num /= 10;
                }
            }else{
                
            }
        }
        
        esCapicua = numeroAlRevez==numero;
        
        return esCapicua;
    }

    
//    Estamos en caramelolandia, donde estan los peores ladrones de dulces. 
//    Una vez al mes, se sienta una n cantidad de presos en ronda, contemplando 
//    al preso que inicia la ronda, como el preso 0. 
//    A los presos se les da una m cantidad de caramelos, estos caramelos se repartirán de uno en uno a cada preso, 
//    contemplando que se comenzaran a repartir los caramelos desde el primer preso (inicio). 
//    Se repartirán los caramelos hasta que no queden más y el ultimo caramelo en repartirse estará podrido, 
//    determinar a que preso, según su posición en la ronda le tocara el caramelo podrido.
//     @param inicio
//     @param cantidadCaramelos
//     @param cantidadLadrones
//     @return ladronQueLeTocoElCarameloPodrido
     
    public int prisioneroDulce(int inicio, int cantidadCaramelos, int cantidadLadrones) {
        int repartirCaramelos=1,contador=inicio;
        
        int[] ladrones=new int[cantidadLadrones];
        
        if (cantidadLadrones==1){
            // Retorna 0 porque es la unica posicion que existe
            return 0;
        }
        
        for (int i=0;i<cantidadCaramelos-1;i++){
            if (contador==ladrones.length){
                contador=0;
            }
            
            ladrones[contador]=ladrones[contador]+repartirCaramelos;
            
            contador++;
        }
        
        return contador;
    }

//    En un universo paralelo, donde los habitantes son medias, existe un crucero de medias donde se sube una lista de medias. 
//    Esta lista de tripulantes del crucero es una Collection de letras. 
//    Lo que se deberá hacer, es filtrar la lista de medias que se suben al crucero y 
//    retornar una lista que contenga los grupos de medias que si tenían pares. 
//    Esta lista final de medias pares se mostraran ordenadas de menor a mayor.
//    A continuación un ejemplo: 
//    List de medias que llegan : A,B,A,B,C,A,F,Z,C,H. A,B y C tiene pares, mientras que F,Z y H no. 
//    Entonces la List que se debería retornar sería: A,B,C.
//   @param pasajeros
//   @return mediasAmigas
    
    public List<String> mediasAmigas(List<String> pasajeros) {
        int contador=0;
        
        HashSet<String> nuevoSet=new HashSet<>();
        
        List<String> nuevaLista=new ArrayList<>();
        
        if(pasajeros == null){
            return new ArrayList();
        }
        
        for (String pasajero : pasajeros) {
            
            for (String pasajero1 : pasajeros) {
                if(pasajero.equals(pasajero1)){
                    contador++;
                }
            }
            
            if (contador>1){
                nuevoSet.add(pasajero);
            }
            contador=0;
        }
        
        nuevaLista.addAll(nuevoSet);
        
        Collections.sort(nuevaLista);
        
        return nuevaLista;
    }
}
