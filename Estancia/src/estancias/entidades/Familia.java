package estancias.entidades;

public final class Familia {

    private Integer idFamilia;
    private String nombre;
    private Integer edadMinima;
    private Integer edadMaxima;
    private Integer numHijos;
    private String email;
    private Casa idCasaFamilia;

    public Familia(Integer idFamilia, String nombre, Integer edadMinima, Integer edadMaxima, Integer numHijos, String email, Casa idCasaFamilia) {
        this.idFamilia = idFamilia;
        this.nombre = nombre;
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
        this.numHijos = numHijos;
        this.email = email;
        this.idCasaFamilia = idCasaFamilia;
    }

    public Familia() {
    }

    public Integer getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(Integer idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(Integer edadMinima) {
        this.edadMinima = edadMinima;
    }

    public Integer getEdadMaxima() {
        return edadMaxima;
    }

    public void setEdadMaxima(Integer edadMaxima) {
        this.edadMaxima = edadMaxima;
    }

    public Integer getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(Integer numHijos) {
        this.numHijos = numHijos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Casa getIdCasaFamilia() {
        return idCasaFamilia;
    }

    public void setIdCasaFamilia(Casa idCasaFamilia) {
        this.idCasaFamilia = idCasaFamilia;
    }

    @Override
    public String toString() {
        return "Familia{" + "idFamilia=" + idFamilia + ", nombre=" + nombre + ", edadMinima=" + edadMinima + ", edadMaxima=" + edadMaxima + ", numHijos=" + numHijos + ", email=" + email + ", idCasaFamilia=" + idCasaFamilia + '}';
    }

}
