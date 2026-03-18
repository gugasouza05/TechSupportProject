package br.uepb.techsupport.repository;

import br.uepb.techsupport.model.Tecnico;
import java.util.*;

public class TecnicoRepository {
    private List<Tecnico> tecnicos = new ArrayList<>();

    public void adicionar(Tecnico tecnico) {
        tecnicos.add(tecnico);
    }

    public List<Tecnico> listarTodos() {
        return tecnicos;
    }
}