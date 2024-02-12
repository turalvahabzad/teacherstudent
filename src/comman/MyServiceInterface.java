package comman;

import teacher.entity.Teacher;

public interface MyServiceInterface {

  //  public abstract void showMenu();
  void find(Teacher[]teachers);

  void delete(Teacher[]teachers);

     default void update(Teacher[] teachers){
         System.out.println("Hello");

     }

   Teacher[] Initialinew(Teacher[]oldTeachers) ;

     Teacher[] initialize();
     Teacher requireAndCreate();

    void printAll(Teacher[] teachers);
}
