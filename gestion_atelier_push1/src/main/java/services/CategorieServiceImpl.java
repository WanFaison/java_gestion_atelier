package services;

import java.util.ArrayList;

import entities.Categorie;
import repositories.ITables;
import repositories.list.TableCategories;

public class CategorieServiceImpl implements CategorieService {

    //Couplage fort
    private TableCategories categoriesRepository=new TableCategories();

    //Couplage faible
    //private ITables<Categorie> catRep;

    // public CategorieServiceImpl(ITables<Categorie> catRep) {
    //     this.catRep = catRep;
    // }

    @Override
    public int add(Categorie categorie) {
       return categoriesRepository.insert(categorie);
    }

    @Override
    public ArrayList<Categorie> getAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public int update(Categorie categorie) {
         return categoriesRepository.update(categorie);
       
    }

    @Override
    public Categorie show(int id) {
        return categoriesRepository.findById(id);
    }

    @Override
    public int remove(int id) {
       return categoriesRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        int[] idsNotDelete=new int[ids.length];
        int nbre=0;
          for (int id = 0; id < ids.length; id++) {
              if (categoriesRepository.delete(ids[id])==0) {
                idsNotDelete[nbre++]= ids[id];
            }
          }
          //create a new array in respect to length of 'idsNotDelete' then transfer numbers
          return idsNotDelete;
    }
    
}
