package q.w;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "students")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int id;
    @NonNull
    @Column(name = "student_name")
    @EqualsAndHashCode.Include
    private String name;
    @NonNull
    @Column(name = "student_age")
    private int age;


    @ManyToMany(fetch = FetchType.EAGER,
           cascade = CascadeType.REMOVE
           /* cascade = {
                    CascadeType.MERGE,
                    CascadeType.PERSIST
            }*/)
    @JoinTable(
            name = "subjects_students",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    Set<Subject> subjects = new HashSet<>();

    @Override
    public String toString() {
        String instructorId = "";

        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +

                '}';
    }
}
