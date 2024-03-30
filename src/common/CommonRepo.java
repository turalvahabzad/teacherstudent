package common;

import java.util.List;

public interface CommonRepo<T>{

    public List<T>getList() ;
    public void update(T obj);
    public void delete(T obj);

    public void insert(T obj);

    public T findById(int id);

    public List<T>getList(String name, String surname);
}
