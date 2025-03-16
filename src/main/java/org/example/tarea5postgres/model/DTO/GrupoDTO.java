package org.example.tarea5postgres.model.DTO;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class GrupoDTO {

    private Integer grupoID;
    private String nome;
    private String xenero;
    private LocalDate dataFormacion;

    public GrupoDTO(Integer grupoID, String nome, String xenero, LocalDate dataFormacion) {
        this.grupoID = grupoID;
        this.nome = nome;
        this.xenero = xenero;
        this.dataFormacion = dataFormacion;
    }

    public GrupoDTO() {

    }

    public Integer getGrupoID() {
        return grupoID;
    }

    public void setGrupoID(Integer grupoID) {
        this.grupoID = grupoID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getXenero() {
        return xenero;
    }

    public void setXenero(String xenero) {
        this.xenero = xenero;
    }

    public LocalDate getDataFormacion() {
        return dataFormacion;
    }

    public void setDataFormacion(LocalDate dataFormacion) {
        this.dataFormacion = dataFormacion;
    }
}
