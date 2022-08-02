package uz.namangan.developer.rms.service;


import java.util.List;
import java.util.Optional;

public interface iBaseService<T> {

    public T save(T obj);


    public List<T> findAll();

    public void delete(int id);

    public T update(T obj);

    public Optional<T> find(int id);

    public boolean find(String obj);

    public Optional<T> find(T obj);
}
