package emergon.service;

import emergon.entity.Salesman;
import emergon.repository.SalesmanRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tzortziskapellas
 */
@Transactional
@Service
public class SalesmanService {
     @Autowired
    SalesmanRepo salesmanRepo;
    
   

    public List<Salesman> getSalesmans() {
        List<Salesman> salesmans = salesmanRepo.findAll();
        return salesmans;
    }

    public void addSalesman(Salesman salesman) {
        salesmanRepo.save(salesman);
    }

    public String deleteSalesman(int id) {
        boolean control;
        try{
              control = salesmanRepo.delete(Salesman.class, id);
        }catch(Exception ex){
            control = false;
        }
      
        String minima;
        if (control) {
            minima = "deleted";
        }
        else{
            minima = "not deleted";
        }
        return minima;
    }

    public Salesman getSalesmanById(int scode) {
        return salesmanRepo.findById(scode);
    }

    public Salesman updateSalesman(Salesman salesman) {//salesman argument contains the new data from the form
        return salesmanRepo.save(salesman);
    }
}
