package q.w;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private int id;
    @NonNull
    @Column(name = "subject_name")
    private String subjectName;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH,
           /*{
                    CascadeType.MERGE,
            }*/
            mappedBy = "subjects"
    )
   /* @JoinTable( name = "subjects_students",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )*/
    private Set<Student> students = new HashSet<>();


    public void addStudent(Student student) {
        if (students == null)
            students = new HashSet<>();
        students.add(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return id == subject.id &&
                Objects.equals(subjectName, subject.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectName);
    }
}
