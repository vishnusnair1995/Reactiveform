package com.form.Reactive.repository;

import com.form.Reactive.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
public interface ItemRepository extends JpaRepository<Item,Integer> {

}
