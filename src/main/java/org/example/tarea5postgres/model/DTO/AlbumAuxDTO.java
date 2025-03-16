package org.example.tarea5postgres.model.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumAuxDTO {
    //atributos de clase
    private Integer id;
    private Integer grupoID;
    private String titulo;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataLanzamento;
    private BigDecimal puntuacion;

    /**
     * Constructor de la clase
     *
     * @param id             el id del album
     * @param grupoID        el ID del grupo
     * @param titulo         el titulo del album
     * @param dataLanzamento el año de lanzamiento del album
     * @param puntuacion     la puntuacion de album
     */
    public AlbumAuxDTO(Integer id, Integer grupoID, String titulo, LocalDate dataLanzamento, BigDecimal puntuacion) {
        this.id = id;
        this.grupoID = grupoID;
        this.titulo = titulo;
        this.dataLanzamento = dataLanzamento;
        this.puntuacion = puntuacion;
    }

    //getter y setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

