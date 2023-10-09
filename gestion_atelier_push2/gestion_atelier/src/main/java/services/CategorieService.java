package services;

import entities.Categorie;

public interface CategorieService extends IService<Categorie> {

    Categorie get(int nextInt);
    
}
