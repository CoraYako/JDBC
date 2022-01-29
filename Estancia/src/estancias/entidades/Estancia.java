package estancias.entidades;

import java.sql.Date;

public final class Estancia {

    private Integer idEstancia;
    private Cliente cliente;
    private Casa casa;
    private String nombreHuesped;
    private Date fechaDesde;
    private Date fechaHasta;

    public Estancia(Integer idEstancia, Cliente cliente, Casa casa, String nombreHuesped, Date fechaDesde, Date fechaHasta) {
        this.idEstancia = idEstancia;
        this.cliente = cliente;
        this.casa = casa;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
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
        return "Estancia {" + "idEstancia: " + idEstancia + ", \ncliente: " + cliente + ", \ncasa: " + casa + ", nombreHuesped: " + nombreHuesped + ", fechaDesde: " + fechaDesde + ", fechaHasta: " + fechaHasta + '}';
    }

}
