package services;



import entities.ArticleConfection;


public interface ArticleConfectionService extends IService<ArticleConfection>  {

    ArticleConfection get(int id);
   
}
