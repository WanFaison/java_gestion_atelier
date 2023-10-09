package services;

import java.util.ArrayList;

import entities.Categorie;
import repositories.ITables;
import repositories.list.TableCategories;

public class CategorieServiceImpl implements CategorieService {

    //Couplage fort
    //private TableCategories categoriesRepository=new TableCategories();

    //Couplage faible
    private ITables<Categorie> categorieRepository;

    //injection de dependence via constructeur
    public CategorieServiceImpl(ITables<Categorie> categoriesRepository) {
        this.categorieRepository = categoriesRepository;
    }

    //injection de dependence via setter
    public void setCategorieRepository(ITables<Categorie> categoriesRepository){
        this.categorieRepository = categoriesRepository;
    }

    @Override
    public Categorie get(int id) {
        return categorieRepository.findById(id);
    }

    @Override
    public int add(Categorie categorie) {
       return categorieRepository.insert(categorie);
    }

    @Override
    public ArrayList<Categorie> getAll() {
        return categorieRepository.findAll();
    }

    @Override
    public int update(Categorie categorie) {
         return categorieRepository.update(categorie);
       
    }

    @Override
    public Categorie show(int id) {
        return categorieRepository.findById(id);
    }

    @Override
    public int remove(int id) {
       return categorieRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        int[] idsNotDelete=new int[ids.length];
        int nbre=0;
          for (int id = 0; id < ids.length; id++) {
              if (categorieRepository.delete(ids[id])==0) {
                idsNotDelete[nbre++]= ids[id];
            }
          }
          //create a new array in respect to length of 'idsNotDelete' then transfer numbers
          return idsNotDelete;
    }
    
}
