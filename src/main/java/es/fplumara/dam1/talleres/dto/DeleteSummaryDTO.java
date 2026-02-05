package es.fplumara.dam1.talleres.dto;

public class DeleteSummaryDTO {

    private Integer idsIncripcionesBorradas;
    public DeleteSummaryDTO (Integer idsIncripcionesBorradas) {
        this.idsIncripcionesBorradas = idsIncripcionesBorradas;
    }

    public Integer getIdInscripcionesBorradas() {
        return idsIncripcionesBorradas;
    }

    public  void setIdBorradas(Integer idsIncripcionesBorradas) {
        this.idsIncripcionesBorradas = idsIncripcionesBorradas;
    }

}
