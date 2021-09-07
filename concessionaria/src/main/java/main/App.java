package main;

import dao.ConcessionariaDAO;
import dao.VeiculoDAO;
import domain.Acessorio;
import domain.Concessionaria;
import domain.Endereco;
import domain.Veiculo;
import enums.AcessorioEnum;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        ConcessionariaDAO concessionariaDAO = new ConcessionariaDAO();
        Concessionaria concessionaria =
                Concessionaria.builder().endereco(
                Endereco.builder().rua("Joao Pessoa")
                        .cidade("Cajazeiras")
                        .numero("123")
                        .bairro("Centro")
                        .uf("PB").build())
                        .nome("Fafic Veiculos")
                        .telefone("35311234").build();
       // concessionariaDAO.saveOrUpdate(concessionaria);

      /*  Acessorio gps = Acessorio.builder()
                .acessorioEnum(AcessorioEnum.GPS).build();
        Acessorio ar = Acessorio.builder()
                .acessorioEnum(AcessorioEnum.AR_CONDICIONADO).build();
        Acessorio ve = Acessorio.builder()
                .acessorioEnum(AcessorioEnum.VIDRO_ELETRICO).build();
                 acessorioDAO.saveOrUpdate(gps);
        acessorioDAO.saveOrUpdate(ar);
        acessorioDAO.saveOrUpdate(ve);*/

        AcessorioDAO acessorioDAO = new AcessorioDAO();

        List<Acessorio> acessorios = new ArrayList<>();
        acessorios.add(acessorioDAO.findById(Acessorio.class, 1L));
        acessorios.add(acessorioDAO.findById(Acessorio.class, 2L));
        acessorios.add(acessorioDAO.findById(Acessorio.class, 3L));

        Veiculo bmw = Veiculo.builder()
                .anoFabricacao("2020")
                .marca("BMW")
                .modelo("Z3")
                .acessorios(acessorios).build();

        Veiculo mercedez = Veiculo.builder()
                .anoFabricacao("2021")
                .marca("Mercedez-Benz")
                .modelo("560R")
                .acessorios(acessorios).build();

        VeiculoDAO veiculoDAO = new VeiculoDAO();
        //veiculoDAO.saveOrUpdate(mercedez);
        //veiculoDAO.saveOrUpdate(bmw);
        Query query = concessionariaDAO.getEm().createNamedQuery("findByName");
        query.setParameter("nome", "Fafic Veiculos");
        concessionaria = (Concessionaria) query.getSingleResult();
       // concessionaria.setVeiculos(concessionariaDAO.getEm().createNamedQuery("veiculosFindAll").getResultList());
        System.out.println(concessionaria);
        //concessionariaDAO.saveOrUpdate(concessionaria);
        Query q2 = concessionariaDAO.getEm().createNamedQuery("accessoriosByVeiculo");
        q2.setParameter("modelo", "560R");
        System.out.println("Mercedez" + q2.getResultList().toString());
    }
}
