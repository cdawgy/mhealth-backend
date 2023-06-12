package main.java.com.mhealth.cosmoservice.repositories;

import main.java.com.mhealth.cosmoservice.models.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildRepository extends JpaRepository<Child, Long> {
    List<Child> findByParentIdIs(int parentId);
}
