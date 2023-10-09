package services;

import java.util.ArrayList;


public interface IService<pro> {
      int  add(pro data);
       ArrayList<pro> getAll();
       int update(pro data);
       pro show(int id);
       int remove(int id);
       int[] remove(int[] ids);
}
