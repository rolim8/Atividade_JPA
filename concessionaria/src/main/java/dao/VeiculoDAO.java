package dao;

import domain.Veiculo;

import java.util.List;

public class VeiculoDAO extends GenericDAOImpl<Veiculo>{

    @Override
    public void saveOrUpdate(Veiculo entity) {
        super.saveOrUpdate(entity);
    }

    @Override
    public void delete(Veiculo entity) {
        super.delete(entity);
    }

    @Override
    public Veiculo findById(Class<Veiculo> clazz, Long id) {
        return super.findById(clazz, id);
    }

    @Override
    public List<Veiculo> findAll(String namedQuery) {
        return super.findAll(namedQuery);
    }
}
