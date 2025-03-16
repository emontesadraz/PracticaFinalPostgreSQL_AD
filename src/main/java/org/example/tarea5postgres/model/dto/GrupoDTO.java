package org.example.tarea5postgres.model.dto;

import java.time.LocalDate;

public class GrupoDTO {

    // atributos de la clase
    private String nome;
    private String xenero;
    private LocalDate dataFormacion;

    /**
     * Constructor de la clase
     * @param nome el nombre del grupo
     * @param xenero el genero del grupo
     * @param dataFormacion la fecha de formacion del grupo
     */
    public GrupoDTO(String nome, String xenero, LocalDate dataFormacion) {
        this.nome = nome;
        this.xenero = xenero;
        this.dataFormacion = dataFormacion;
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
