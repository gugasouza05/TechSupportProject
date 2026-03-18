package br.uepb.techsupport.service;

import br.uepb.techsupport.model.*;
import br.uepb.techsupport.model.enums.*;
import br.uepb.techsupport.exception.BusinessRuleException;
import br.uepb.techsupport.strategy.PrioritizationStrategy;

import java.util.*;

public class FilaService {

    private PrioritizationStrategy strategy;
 
    public FilaService(PrioritizationStrategy strategy) {
        this.strategy = strategy;
    }

    public void executarEscalonamento(List<OrdemServico> ordens, List<Tecnico> tecnicos)
            throws BusinessRuleException {

        List<OrdemServico> ordenadas = strategy.ordenar(ordens);

        for (OrdemServico os : ordenadas) {
            for (Tecnico t : tecnicos) {
                if (t.isDisponivel() && regraCompetencia(t, os)) {
                    t.ocupar();
                    os.setStatus(StatusOS.EM_ATENDIMENTO);
                    break;
                }
            }
        }
    }

    private boolean regraCompetencia(Tecnico tecnico, OrdemServico os) {
        return !(tecnico.getNivel() == NivelTecnico.JUNIOR &&
                 os.getPrioridade() == Prioridade.ALTA);
    }
}