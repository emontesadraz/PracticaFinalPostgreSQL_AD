package org.example.tarea5postgres.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumDTO {

    private Integer grupoID;
    private String titulo;
    private LocalDate dataLanzamento;
    private BigDecimal puntuacion;

    /**
     * Constructor de la clase
     * @param grupoID
     * @param titulo
     * @param dataLanzamento
     * @param puntuacion
     */
    public AlbumDTO(Integer grupoID, String titulo, LocalDate dataLanzamento, BigDecimal puntuacion) {
        this.grupoID = grupoID;
        this.titulo = titulo;
        this.dataLanzamento = dataLanzamento;
        this.puntuacion = puntuacion;
    }

    public Integer getGrupoID() {
        return grupoID;
    }

    public void setGrupoID(Integer grupoID) {
        this.grupoID = grupoID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataLanzamento() {
        return dataLanzamento;
    }

    public void setDataLanzamento(LocalDate dataLanzamento) {
        this.dataLanzamento = dataLanzamento;
    }

    public BigDecimal getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(BigDecimal puntuacion) {
        this.puntuacion = puntuacion;
    }
}
