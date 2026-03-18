package br.uepb.techsupport.model;

import br.uepb.techsupport.model.enums.*;
import java.time.LocalDateTime;

public class OrdemServico {
    private int id;
    private String descricao;
    private Prioridade prioridade;
    private int tempoEstimado;
    private LocalDateTime dataCriacao;
    private StatusOS status;

    public OrdemServico(int id, String descricao, Prioridade prioridade, int tempoEstimado) {
        this.id = id;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.tempoEstimado = tempoEstimado;
        this.dataCriacao = LocalDateTime.now();
        this.status = StatusOS.PENDENTE;
    }

    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public Prioridade getPrioridade() { return prioridade; }
    public int getTempoEstimado() { return tempoEstimado; }
    public StatusOS getStatus() { return status; }

    public void setStatus(StatusOS status) { this.status = status; }
}