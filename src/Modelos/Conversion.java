package Modelos;

import java.text.DecimalFormat;

public class Conversion {

    // Atributos:

    private Double valor;
    private Double valorConvertido;
    private Moneda monedaBase;
    private Moneda monedaConversion;
    private DecimalFormat dfPretty = new DecimalFormat("###,###.##");

    // Constructores:

    public Conversion(Double valor, Double valorConvertido, Moneda monedaBase, Moneda monedaConversion) {
        this.valor = valor;
        this.valorConvertido = valorConvertido;
        this.monedaBase = monedaBase;
        this.monedaConversion = monedaConversion;
    }

    // Métodos:

    public String obtenerConversionStr(){
        return "Valor base: "+dfPretty.format(valor)+" ["+monedaBase.obtenerMonedaStr()+"]  |-*-|  Valor convertido: "+dfPretty.format(valorConvertido)+" ["+monedaConversion.obtenerMonedaStr()+"]";
    }

    // Getters y Setters:

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValorConvertido() {
        return valorConvertido;
    }

    public void setValorConvertido(Double valorConvertido) {
        this.valorConvertido = valorConvertido;
    }

    public Moneda getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(Moneda monedaBase) {
        this.monedaBase = monedaBase;
    }

    public Moneda getMonedaConversion() {
        return monedaConversion;
    }

    public void setMonedaConversion(Moneda monedaConversion) {
        this.monedaConversion = monedaConversion;
    }
}
