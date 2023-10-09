package repositories;

import java.util.ArrayList;

public interface IRepository<pro> {
     pro insert(pro data);
     pro update(pro data);
     ArrayList<pro> findAll();
     pro findById(int id);
     pro delete(int id) ;
     pro indexOf(int id);
}
