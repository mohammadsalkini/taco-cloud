package com.mohammadalsalkini.tacocloud.data;

import com.mohammadalsalkini.tacocloud.model.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {

}
