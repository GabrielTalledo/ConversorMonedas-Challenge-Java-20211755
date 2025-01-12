package Modelos;


public class Moneda {
    // Atributos:

    private String codigo;
    private String nombre;

    // Constructores:

    public Moneda(String codigo,String nombre){
        this.codigo = codigo;
        this.nombre = nombre;
    }

    // Métodos:

    public String obtenerMonedaStr(){
        return codigo+" - "+nombre;
    }

    // Getters y Setters:

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
