package Modelo;

public class ModeloCliente {
     
// Se declaran los atributos
    private String nombreUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private long numeroCelular;
    private String clave;
    private String fecha;
    
    // Se crea el contructor
    public ModeloCliente(String nombreUsuario, String nombre, String apellido, String email, long numeroCelular, String clave, String fecha){
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.numeroCelular = numeroCelular;
        this.clave = clave;
        this.fecha = fecha;
    }

    // Se crea el getter del NombreUsuario
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    // Se crea el getter del Nombre
    public String getNombre() {
        return nombre;
    }

    // Se crea el getter del Apellido
    public String getApellido() {
        return apellido;
    }

    // Se crea el getter del Email
    public String getEmail() {
        return email;
    }

    // Se crea el setter del Email
    public void setEmail(String email) {
        this.email = email;
    }

    // Se crea el getter del NumeroCelular
    public long getNumeroCelular() {
        return numeroCelular;
    }

    // Se crea el setter del NumeroCelular
    public void setNumeroCelular(long numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    // Se crea el getter de la Clave
    public String getClave() {
        return clave;
    }

    // Se crea el setter de la Clave
    public void setClave(String clave) {
        this.clave = clave;
    }

    // Se crea el getter de la Fecha
    public String getFecha() {
        return fecha;
    }
    
}
