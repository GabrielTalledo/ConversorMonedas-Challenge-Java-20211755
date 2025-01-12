package Herramientas;

import Modelos.Conversion;
import Modelos.Moneda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalTool {

    // Atributos:

    Scanner sc = new Scanner(System.in);
    List<Moneda> listaMonedas = MonedaTool.obtenerListaMonedas();
    List<Conversion> listaConversiones = new ArrayList<>();
    String API_KEY = "5daa9344b3f10cf01e542810";
    String API_URL = "https://v6.exchangerate-api.com/v6/"+API_KEY+"/latest/";

    // Métodos:

    public void mostrarMenu() throws IOException, InterruptedException {
        String listaMonedasStr = MonedaTool.obtenerListaMonedasStr(listaMonedas);
        String inicioStr =
                """
                *********************************************************
                Sea bienvenido/a al Conversor de Monedas :)
                
                - Para realizar una conversión introduzca '1'.
                  Luego, ingrese los códigos de moneda y el valor que desea convertir considerando las siguientes
                  monedas disponibles:
                
                """ +
                listaMonedasStr + "\n" +
                """
                
                - Para listar las conversiones realizadas introduzca '2'.
                - Para salir introduzca '0'.
                
                *********************************************************""";

        String opcionStr;
        String codigoMoneda1Str;
        Moneda moneda1;
        String codigoMoneda2Str;
        Moneda moneda2;
        String valorStr;
        Double valor;
        Double valorConvertido;
        Double conversionRate;
        String urlCompleta;

        while (true){
            System.out.println(inicioStr);
            opcionStr = sc.nextLine();

            if(opcionStr.equals("1")){
                while(true){
                    System.out.println("Introduzca el código de moneda base:");
                    codigoMoneda1Str = sc.nextLine();
                    moneda1 = MonedaTool.obtenerMonedaPorCodigoListaMonedas(codigoMoneda1Str,listaMonedas);
                    if(moneda1!=null){
                        break;
                    }else{
                        System.out.println("Código de moneda no encontrado/inválido!\n");
                    }
                }
                while(true){
                    System.out.println("Introduzca el código de moneda convertir:");
                    codigoMoneda2Str = sc.nextLine();
                    moneda2 = MonedaTool.obtenerMonedaPorCodigoListaMonedas(codigoMoneda2Str,listaMonedas);
                    if(moneda2!=null){
                        break;
                    }else{
                        System.out.println("Código de moneda no encontrado/inválido!\n");
                    }
                }
                while(true){
                    System.out.println("Introduzca el valor a convertir:");
                    valorStr = sc.nextLine();
                    try{
                        valor = Double.parseDouble(valorStr);
                        urlCompleta = API_URL + codigoMoneda1Str.toUpperCase();
                        conversionRate = ApiTool.obtenerConversionRate(urlCompleta, codigoMoneda2Str.toUpperCase());
                        valorConvertido = valor*conversionRate;
                        Conversion conversion = new Conversion(valor,valorConvertido,moneda1,moneda2);
                        listaConversiones.add(conversion);
                        System.out.println("Se realizó la siguiente conversión: ");
                        System.out.println("-> "+conversion.obtenerConversionStr()+"\n");
                        break;
                    }catch (NumberFormatException e){
                        System.out.println("Introduzca un valor numérico válido!\n");
                    }
                }
            }else{
                if(opcionStr.equals("2")){
                    if(listaConversiones != null && !listaConversiones.isEmpty()){
                        System.out.println("Conversiones realizadas:");
                        listaConversiones.forEach(conversion -> {
                            System.out.println((listaConversiones.indexOf(conversion)+1)+") "+conversion.obtenerConversionStr());
                        });
                    }else{
                        System.out.println("No se han realizado conversiones aún!\n");
                    }
                } else if (opcionStr.equals("0")) {
                    System.out.println("Cerrando programa...\n");
                    break;
                }
            }


        }
    }


}
