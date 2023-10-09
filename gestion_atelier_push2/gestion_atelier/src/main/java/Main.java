import java.util.Scanner;

import entities.ArticleConfection;
import entities.Categorie;
import repositories.ITables;
import repositories.list.TableArticleConfections;
import repositories.list.TableCategories;
import services.ArticleConfectionService;
import services.ArticleConfectionServiceImpl;
import services.CategorieService;
import services.CategorieServiceImpl;

public class Main {
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
         ITables<Categorie> repository=new TableCategories();
         ITables<ArticleConfection> rep=new TableArticleConfections();
         CategorieService categorieServiceImpl=new CategorieServiceImpl(repository);
         ArticleConfectionService articleConfectionServiceImpl=new ArticleConfectionServiceImpl(rep);
         
        int choix;
        int choix2;
       
        do {
            effacer();
            System.out.println("-------MENU GENERAL-------");
            System.out.println("1----Categorie Services");
            System.out.println("2----ArticleConfection Services");
            System.out.println("3----Quitter");
            System.out.print("Choisir: ");
            choix=scanner.nextInt();
            scanner.nextLine();
            switch(choix){
                case 1:
                    
                    do {
                        effacer();
                        System.out.println("-------MENU CATEGORIE-------");
                        System.out.println("1---- Ajouter categorie");
                        System.out.println("2----Lister les categories");
                        System.out.println("3----Modifier une categorie");
                        System.out.println("4----Editer une categorie");
                        System.out.println("5----Supprime les categories");
                        System.out.println("6----Quitter");
                        System.out.print("Choisir: ");
                        choix2=scanner.nextInt();
                        scanner.nextLine();
                        switch(choix2){
                            case 1:
                                effacer();
                                System.out.println("Entrer le libelle :");
                                Categorie categorie=new Categorie(scanner.nextLine());
                                categorieServiceImpl.add(categorie);
                                break;
                            case 2:
                                System.out.println("Liste categorie");
                                categorieServiceImpl.getAll().forEach(System.out::println);
                                pause();
                                break;
                            case 3:
                                effacer();
                                categorieServiceImpl.getAll().forEach(System.out::println);
                                System.out.println("Entrer l'id de la categorie a modifier :");
                                int idToUpdate = scanner.nextInt();
                                scanner.nextLine();
                                Categorie categorieUpdate= categorieServiceImpl.show(idToUpdate);
                                if(categorieUpdate !=null){
                                    System.out.println("Entrez un nouveau libelle:");
                                    String newLiblelle = scanner.nextLine();
                                    categorieUpdate.setLibelle(newLiblelle);
                                    categorieServiceImpl.update(categorieUpdate);
                                    System.out.println("La categorie a été modifié.");        
                                }else{
                                    System.out.println("echec");
                                }
                                break;
                            case 4:
                                System.out.println(" editer Une categorie");
                                categorieServiceImpl.getAll().forEach(System.out::println);
                                System.out.println("Entrer l'id du categorie a editer");
                                //int id=scanner.nextInt();
                                //System.out.println(categorieServiceImpl.get(id));
                                break;   
                            case 5:
                                effacer();
                                categorieServiceImpl.getAll().forEach(System.out::println);
                                System.out.println("Entrer l'id de la categorie a supprimer: ");
                                int idToDelete = scanner.nextInt();
                                scanner.nextLine();
                                Categorie categorieToDelete = categorieServiceImpl.show(idToDelete);
                                if (categorieToDelete != null) {
                                    //categorieServiceImpl.de(categorieToDelete.getId());
                                    System.out.println("La categorie a été supprimée.");
                                } else {
                                    System.out.println("echec");
                                }
                                break;   
                            default:
                            break;
                        }   
                    } while (choix2!=6);

                case 2:
                    effacer();
                    do {
                        effacer();
                        System.out.println("-------MENU ARTICLECONFECTION-------");
                        System.out.println("1---- Ajouter Articleconfection");
                        System.out.println("2---- Lister les articles confection");
                        System.out.println("3---- Modifier article de confection");
                        System.out.println("4---- Editer article de confection");
                        System.out.println("5---- supprimer article de confection");
                        System.out.println("6---- Quitter");
                        System.out.print("Choisir: ");
                        choix2=scanner.nextInt();
                        scanner.nextLine();
                        
                        switch (choix2) {
                            case 1:
                                int qte;
                                double pri;
                                System.out.println("Ajouter Un article de confection");
                                System.out.println("Entrer le libelle :");
                                String libelle=scanner.nextLine();
                                System.out.println("Entrer le prix :");
                                pri=scanner.nextDouble();
                                System.out.println("Entrer la quantite :");
                                qte=scanner.nextInt();
                                ArticleConfection article = new ArticleConfection(libelle,pri,qte);
                                System.out.println("afficher les categories");
                                categorieServiceImpl.getAll().forEach(System.out::println);
                                System.out.println("Entrer l'id de la categorie de l'article :");
                                article.setCategorie(categorieServiceImpl.get(scanner.nextInt()));
                                articleConfectionServiceImpl.add(article);
                                break;

                            case 2:
                                System.out.println("afficher les  articles");
                                articleConfectionServiceImpl.getAll().forEach(System.out::println);
                                pause();
                                break;
                            case 3:
                                int id;
                                System.out.println("Vous allez modifier Un article");
                                articleConfectionServiceImpl.getAll().forEach(System.out::println);
                                System.out.println("Entrer l'id du categorie a modifier");
                                id=scanner.nextInt();
                                scanner.nextLine();
                                article=articleConfectionServiceImpl.get(id);
                                do {
                                        System.out.println("1-Modifier Libelle ");
                                        System.out.println("2-Modifier Prix ");
                                        System.out.println("3-Modifier Quantite ");
                                        System.out.println("Choisir:");
                                        choix=scanner.nextInt();
                                        scanner.nextLine();

                                    switch (choix) {
                                    case 1:
                                        System.out.println("1-Entrer le nouveau Libelle");
                                        article.setLibelle( scanner.nextLine());
                                        break;
                                    case 2:
                                        System.out.println("2-Entrer le nouveau prix");
                                        article.setPrix(scanner.nextDouble());
                                        break;
                                    case 3:
                                        System.out.println("3-Entrer la nouvelle quantite");
                                        article.setQte( scanner.nextInt());
                                        break;
                                }
                                } while (choix!=3);
                                
                                articleConfectionServiceImpl.update(article);
                                break;
                            case 4:
                                effacer();
                                System.out.println("editter Un article");
                                articleConfectionServiceImpl.getAll().forEach(System.out::println);
                                System.out.println("Entrer l'id de l'article a editer");
                                id=scanner.nextInt();
                                System.out.println(articleConfectionServiceImpl.get(id));
                                break;

                            case 5:
                               
                            default:
                                break;
                        }
                    } while (choix2!=6);

                    
                
                
            }
        } while (choix!=3);
        
    }
    

    public static void effacer(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    static void pause(){
        int millis = 3000;

        try {
            Thread.sleep(millis);
        } catch (InterruptedException ie) {
            // ...
        }
    } 
}
       