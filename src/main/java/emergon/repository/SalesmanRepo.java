package emergon.repository;

import emergon.entity.Family;
import emergon.entity.Salesman;
import emergon.entity.Salesman;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class SalesmanRepo extends HibernateUtil<Salesman> implements CrudRepo<Salesman>{

    @Override
    public Salesman save(Salesman s) {
        return super.save(s);
    }

    @Override
    public void delete(int id) {
        super.delete(Salesman.class, id);
    }

    @Override
    public Salesman findById(int id) {
        return super.find(Salesman.class, id);
    }

    @Override
    public List<Salesman> findAll() {
        return super.findAll("Salesman.findAll");
    }
    
    public List<Family> findBySalesman(int id){
        Salesman s = super.find(Salesman.class, id);
        List<Family> family = s.getFamilyList();
        return family;
    }
}
