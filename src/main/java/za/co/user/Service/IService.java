package za.co.user.Service;

public interface IService<T, ID>{

    T save(T t);
    T update (T t);
    T getById(ID id);
    void deleteById (ID id);

}
