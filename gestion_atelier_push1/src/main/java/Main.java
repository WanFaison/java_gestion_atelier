import java.util.Scanner;

import entities.ArticleConfection;
import entities.Categorie;
import repositories.ITables;
import repositories.list.TableCategories;
import services.ArticleConfectionServiceImpl;
import services.CategorieServiceImpl;

public class Main {
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        //Repo: 
            //ITables<Categorie> repository = new TableCategories();
         CategorieServiceImpl categorieServiceImpl=new CategorieServiceImpl();
         ArticleConfectionServiceImpl articleConfectionServiceImpl = new ArticleConfectionServiceImpl();
        int choix;
        do {
            
            System.out.println("-------MENU GENERAL-------");
            System.out.println("1----Ajouter categorie");
            System.out.println("2----Lister les categories");
            System.out.println("3----Modifier une categories");
            System.out.println("4----Supprimer categories");
            System.out.println("5----Supprimer plusieurs categories");
            System.out.println("6----Ajouter article");
            System.out.println("7----Lister les articles");
            System.out.println("8----Modifier une articles");
            System.out.println("9----Supprimer articles");
            System.out.println("10----Supprimer plusieurs articles");
            System.out.println("11----Quitter");
            choix=scanner.nextInt();
            scanner.nextLine();
            switch(choix){
                case 1:
                    System.out.println("Entrer le libelle :");
                    Categorie categorie=new Categorie(scanner.nextLine());
                    categorieServiceImpl.add(categorie);
                    break;

                case 2:
                    categorieServiceImpl.getAll().forEach(System.out::println);
                    break;
                
                case 3:
                    scanner.nextLine();
                    categorieServiceImpl.getAll().forEach(System.out::println);
                    System.out.println("choisir selon l'id: ");
                    Categorie modCat = categorieServiceImpl.show(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("entrer nouveau libelle: ");
                    modCat.setLibelle(scanner.nextLine());
                    break;
                case 4:
                    scanner.nextLine();
                    categorieServiceImpl.getAll().forEach(System.out::println);
                    System.out.println("choisir selon l'id: ");
                    Categorie delCat = categorieServiceImpl.show(scanner.nextInt());
                    if(delCat != null){
                        categorieServiceImpl.remove(delCat.getId()); 
                    }else{
                        System.out.println("not found");
                    }
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("nbre a selectionner: ");
                    choix = scanner.nextInt();
                    int[] selectedNumbers = new int[choix];
                
                    for (int i = 0; i < choix; i++) {
                        System.out.print("Enter number " + (i + 1) + ": ");
                        selectedNumbers[i] = scanner.nextInt();
                    }

                    categorieServiceImpl.remove(selectedNumbers);
                    break;
                case 6:
                    System.out.println("Entrer le libelle :");
                    ArticleConfection articleConfection=new ArticleConfection(scanner.nextLine());
                    scanner.nextLine();
                    System.out.println("entrer prix: ");
                    articleConfection.setPrix(scanner.nextInt());
                    System.out.println("entrer qte: ");
                    articleConfection.setQte(scanner.nextInt());
                    articleConfectionServiceImpl.add(articleConfection);
                    break;
                case 7:
                    articleConfectionServiceImpl.getAll().forEach(System.out::println);
                    break;
                case 8:
                    scanner.nextLine();
                    articleConfectionServiceImpl.getAll().forEach(System.out::println);
                    System.out.println("choisir selon l'id: ");
                    ArticleConfection modArt = articleConfectionServiceImpl.show(scanner.nextInt());
                    System.out.println("modifier? 1.libelle 2.prix 3.qte: ");
                    switch (scanner.nextInt()) {
                        case 1:
                            System.out.println("entrer nouveau libelle: ");
                            modArt.setLibelle(scanner.nextLine());
                            break;
                        case 2:
                            scanner.nextLine();
                            System.out.println("entrer nouveau prix: ");
                            modArt.setPrix(scanner.nextInt());
                            break;
                        case 3:
                            scanner.nextLine();
                            System.out.println("entrer nouveau qte: ");
                            modArt.setQte(scanner.nextInt());
                            break;
                    
                        default:
                            break;
                    }
                    break;
                case 9:
                    scanner.nextLine();
                    articleConfectionServiceImpl.getAll().forEach(System.out::println);
                    System.out.println("choisir selon l'id: ");
                    ArticleConfection delArt = articleConfectionServiceImpl.show(scanner.nextInt());
                    if(delArt != null){
                        articleConfectionServiceImpl.remove(delArt.getId()); 
                    }else{
                        System.out.println("not found");
                    }
                    break;
                case 10:
                    scanner.nextLine();
                    System.out.println("nbre a selectionner: ");
                    choix = scanner.nextInt();
                    int[] selectNumbers = new int[choix];
                
                    for (int i = 0; i < choix; i++) {
                        System.out.print("Enter number " + (i + 1) + ": ");
                        selectNumbers[i] = scanner.nextInt();
                    }

                    articleConfectionServiceImpl.remove(selectNumbers);
                    break;
                    
                default:
                    System.exit(3);
                break;

            }
        } while (choix!=11);
        
    }

    public static void effacer(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    } 
}
       