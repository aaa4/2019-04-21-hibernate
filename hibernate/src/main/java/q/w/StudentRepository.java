package q.w;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    Student findDistinctById(int id);
    Student findDistinctByName(String name);
    List<Student> findAll();


}
