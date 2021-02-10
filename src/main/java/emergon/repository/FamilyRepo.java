/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.repository;

import emergon.entity.Family;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tzortziskapellas
 */
@Repository
public class FamilyRepo extends HibernateUtil<Family> implements CrudRepo<Family>{

    @Override
    public Family save(Family e) {
        return super.save(e);
    }

    @Override
    public void delete(int id) {
        super.delete(Family.class, id);
    }

    @Override
    public Family findById(int id) {
        return super.find(Family.class, id);
    }

    @Override
    public List<Family> findAll() {
        return super.findAll("Family.findAll");
    }
    
}
