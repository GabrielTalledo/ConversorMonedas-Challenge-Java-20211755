package Herramientas;

import Modelos.Moneda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MonedaTool {

    public static List<Moneda> obtenerListaMonedas(){
        List<Moneda> listaMonedas = new ArrayList<>();
        HashMap<String,String> listaMonedasCompleta = new HashMap<String, String>()
        {{
            put("USD","Dólar americano");
            put("ARS","Peso argentino");
            put("VEZ","Bolívar venezolano");
            put("BRL","Real brasileño");
            put("CLP","Peso chileno");
            put("COP","Peso colombiano");
            put("PEN","Sol peruano");
            put("EUR","Euro");
            put("JPY","Yen japonés");
        }};
        listaMonedasCompleta.keySet().forEach(k -> listaMonedas.add(new Moneda(k,listaMonedasCompleta.get(k))));
        return listaMonedas;
    }

    public static String obtenerListaMonedasStr(List<Moneda> listaMonedas){
        String listaMonedasStr = "";
        for(int i = 1; i <= listaMonedas.size(); i++){
            listaMonedasStr += ((char) ('a' + (i-1 % 26))) + ") " + listaMonedas.get(i-1).obtenerMonedaStr() + (i<listaMonedas.size()?"\n":"");
        }
        return listaMonedasStr;
    }

    public static Moneda obtenerMonedaPorCodigoListaMonedas(String codigo, List<Moneda> listaMonedas){
        for(int i = 1; i <= listaMonedas.size(); i++){
            if(listaMonedas.get(i-1).getCodigo().toLowerCase().contains(codigo.toLowerCase())){
                return listaMonedas.get(i-1);
            }
        }
        return null;
    }

}
