package q.w;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    Subject findDistinctBySubjectName(String name);
    Subject findDistinctById(int id);
    List<Subject> findAll();
}


