package br.uepb.techsupport.strategy;

import br.uepb.techsupport.model.OrdemServico;
import java.util.List;

public interface PrioritizationStrategy {
    List<OrdemServico> ordenar(List<OrdemServico> ordens);
}