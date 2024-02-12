package comman;

import teacher.entity.Teacher;

public interface MyService {

    public abstract void showMenu();
    public abstract void find(Teacher[]teachers);

    public abstract void delete(Teacher[]teachers);

    public abstract void update(Teacher[]teachers);

    public abstract Teacher[] Initialinew(Teacher[]oldTeachers) ;

    public abstract Teacher[] initialize();
    public abstract Teacher requireAndCreate();

    public abstract void printAll(Teacher[] teachers);
}
