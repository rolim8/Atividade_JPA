package dao;

import domain.Concessionaria;

import java.util.List;

public class ConcessionariaDAO extends GenericDAOImpl<Concessionaria> {

    @Override
    public void saveOrUpdate(Concessionaria entity) {
        super.saveOrUpdate(entity);
    }

    @Override
    public void delete(Concessionaria entity) {
        super.delete(entity);
    }

    @Override
    public Concessionaria findById(Class<Concessionaria> clazz, Long id) {
        return super.findById(clazz, id);
    }

    @Override
    public List<Concessionaria> findAll(String namedQuery) {
        return super.findAll(namedQuery);
    }
}
