package services;

import java.util.ArrayList;

import entities.ArticleConfection;
import repositories.ITables;
import repositories.list.TableArticleConfections;

public class ArticleConfectionServiceImpl implements ArticleConfectionService {

    //couplage faible
    private ITables<ArticleConfection> articleConfectionRepository;

    //injection de dependance via le constructeur
    public ArticleConfectionServiceImpl(ITables<ArticleConfection> articleConfectionRepository) {
        this.articleConfectionRepository = articleConfectionRepository;
        
    }

    // injection de dependance via le setter
    public void setArticleConfectionRepository(ITables<ArticleConfection> articleConfectionRepository) {
        this.articleConfectionRepository= articleConfectionRepository;
    }

    @Override
    public ArticleConfection get(int id) {
        return articleConfectionRepository.findById(id);
    }

    @Override
    public int add(ArticleConfection data) {
        return articleConfectionRepository.insert(data);
    }

    @Override
    public ArrayList<ArticleConfection> getAll() {
        return articleConfectionRepository.findAll();
    }

    @Override
    public int update(ArticleConfection data) {
        return articleConfectionRepository.update(data);
    }

    @Override
    public ArticleConfection show(int id) {
        return articleConfectionRepository.findById(id);
    }

    @Override
    public int remove(int id) {
        return articleConfectionRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        int[] idsNotDelete=new int[ids.length];
        int nbre=0;
          for (int id = 0; id < ids.length; id++) {
              if (articleConfectionRepository.delete(ids[id])==0) {
                idsNotDelete[nbre++]= ids[id];
            }
          }
          //create a new array in respect to length of 'idsNotDelete' then transfer numbers
          return idsNotDelete;
    }
    
}
