package br.uepb.techsupport.strategy;

import br.uepb.techsupport.model.OrdemServico;
import java.util.*;

public class PrioridadeStrategy implements PrioritizationStrategy {
    @Override
    public List<OrdemServico> ordenar(List<OrdemServico> ordens) {
        return ordens.stream()
                .sorted(Comparator.comparing(OrdemServico::getPrioridade).reversed())
                .toList();
    }
}