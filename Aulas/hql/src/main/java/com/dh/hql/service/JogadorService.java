package com.dh.hql.service;

import com.dh.hql.dao.JogadorDAO;
import com.dh.hql.model.Equipe;
import com.dh.hql.model.Jogador;
import com.dh.hql.model.Treinador;
import com.dh.hql.repositories.EquipeRepository;
import com.dh.hql.repositories.JogadorRepository;
import com.dh.hql.repositories.TreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {
    @Autowired
    private JogadorRepository repoJ;

    @Autowired
    private TreinadorRepository repoT;

    @Autowired
    private EquipeRepository repoE;

    public Jogador create(JogadorDAO dao) {
        Treinador treinador = repoT.getById(dao.getIdTreinador());
        Equipe equipe = repoE.getById(dao.getIdEquipe());
        Jogador jogador = new Jogador(
                dao.getNome(),
                dao.getPosicao(),
                dao.getNumero(),
                equipe,
                treinador
        );

        return repoJ.save(jogador);
    }

    public List<Jogador> all() {
        return repoJ.findAll();
    }

    public List<String> filterByTreinador(Integer id) {
        Treinador treinador = repoT.getById(id);
        return repoJ.findAllByTreinador(treinador);
    }
}
