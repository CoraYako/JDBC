package estancias.entidades;

public final class Comentario {

    private Integer idComentario;
    private Casa idCasa;
    private String comentario;

    public Comentario(Integer idComentario, Casa idCasa, String comentario) {
        this.idComentario = idComentario;
        this.idCasa = idCasa;
        this.comentario = comentario;
    }

    public Comentario() {
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Casa getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(Casa idCasa) {
        this.idCasa = idCasa;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Comentario{" + "idComentario=" + idComentario + ", idCasa=" + idCasa + ", comentario=" + comentario + '}';
    }

}
