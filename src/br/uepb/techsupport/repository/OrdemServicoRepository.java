package br.uepb.techsupport.repository;

import br.uepb.techsupport.model.OrdemServico;
import br.uepb.techsupport.model.enums.StatusOS;
import java.util.*;

public class OrdemServicoRepository {
    private List<OrdemServico> ordens = new ArrayList<>();

    public void adicionar(OrdemServico os) {
        ordens.add(os);
    }

    public List<OrdemServico> listarPendentes() {
        return ordens.stream()
                .filter(os -> os.getStatus() == StatusOS.PENDENTE)
                .toList();
    }

    public List<OrdemServico> listarTodas() {
        return ordens;
    }
}