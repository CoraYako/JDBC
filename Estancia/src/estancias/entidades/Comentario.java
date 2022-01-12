package estancias.entidades;

public final class Comentario {

    private Integer idComentario;
    private Casa casa;
    private String comentario;

    public Comentario(Integer idComentario, Casa casa, String comentario) {
        this.idComentario = idComentario;
        this.casa = casa;
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

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Comentario{" + "idComentario=" + idComentario + ", casa=" + casa + ", comentario=" + comentario + '}';
    }

}
