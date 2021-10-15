package com.genspark.app.partRest.Service;

import com.genspark.app.partRest.Entity.Part;

import java.util.List;

public interface PartService {
    List<Part> findAll();
    Object findById(int partId);
    void saveOrUpdate(Part thePart);
    void deleteById(int partId);
}
