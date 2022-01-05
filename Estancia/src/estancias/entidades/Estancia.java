package estancias.entidades;

import java.sql.Date;

public final class Estancia {

    private Integer idEstancia;
    private Cliente idCliente;
    private Casa idCasa;
    private String nombreHuesped;
    private Date fechaDesde;
    private Date fechaHasta;

    public Estancia(Integer idEstancia, Cliente idCliente, Casa idCasa, String nombreHuesped, Date fechaDesde, Date fechaHasta) {
        this.idEstancia = idEstancia;
        this.idCliente = idCliente;
        this.idCasa = idCasa;
        this.nombreHuesped = nombreHuesped;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public Estancia() {
    }

    public Integer getIdEstancia() {
        return idEstancia;
    }

    public void setIdEstancia(Integer idEstancia) {
        this.idEstancia = idEstancia;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Casa getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(Casa idCasa) {
        this.idCasa = idCasa;
    }

    public String getNombreHuesped() {
        return nombreHuesped;
    }

    public void setNombreHuesped(String nombreHuesped) {
        this.nombreHuesped = nombreHuesped;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    @Override
    public String toString() {
        return "Estancia{" + "idEstancia=" + idEstancia + ", idCliente=" + idCliente + ", idCasa=" + idCasa + ", nombreHuesped=" + nombreHuesped + ", fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta + '}';
    }

}
