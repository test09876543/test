package test;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CountDigitsDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void store(CountDigitsEntity entity){
        entityManager.persist(entity);
    }

    @SuppressWarnings("unchecked")
    public List<CountDigitsEntity> getAll() {
        return entityManager.createQuery("from CountDigitsEntity").getResultList();
    }
}
