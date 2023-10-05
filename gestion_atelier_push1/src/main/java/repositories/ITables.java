package repositories;

import java.util.ArrayList;

import entities.AbsEntities;


public interface ITables<pro extends AbsEntities>{
   int insert (pro data) ;
   int update (pro data);
   ArrayList<pro>findAll ();
   pro findById (int id);
   int delete (int id);
   int indexOf(int id);
}
