package es.fplumara.dam1.talleres.dto;

public class ActualizarTallerDTO {
    private String titulo;
    private String descripcion;
    private String estadoInscripcion;
    private String url;
    private String lugar;

    public ActualizarTallerDTO(String titulo, String descripcion, String estadoInscripcion, String url, String lugar, int cupo) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estadoInscripcion = estadoInscripcion;
        this.url = url;
        this.lugar = lugar;
        this.cupo = cupo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstadoInscripcion() {
        return estadoInscripcion;
    }

    public void setEstadoInscripcion(String estadoInscripcion) {
        this.estadoInscripcion = estadoInscripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    private int cupo;
}
