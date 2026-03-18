package br.uepb.techsupport.model;

import br.uepb.techsupport.model.enums.NivelTecnico;

public class Tecnico {
    private int id;
    private String nome;
    private NivelTecnico nivel;
    private boolean ocupado;

    public Tecnico(int id, String nome, NivelTecnico nivel) {
        this.id = id;
        this.nome = nome;
        this.nivel = nivel;
        this.ocupado = false;
    }

    public boolean isDisponivel() {
        return !ocupado;
    }

    public void ocupar() { ocupado = true; }

    public void liberar() { ocupado = false; }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public NivelTecnico getNivel() { return nivel; }
}