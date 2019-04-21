package q.w;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import q.w.accTopic.AccountRepository;

@Slf4j
@Component
public class CLIOne implements CommandLineRunner {


    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    AccountRepository accountRepository;


    /**
     *
     * @param st - экземпляр класса Студент.
     * @param subj - экземпляр класса Предмет.
     *             Метод добавляет в бд связь между студентом и предметом
     *
     */
    public void addStudentsToCourse(Student st, Subject subj) {
        Subject tempSubject = subj;
        if (st != null && subj != null) {
            if (st.getId() != 0) {
                System.out.println(st.getId());
                System.out.println(st.getId() == 0);
                st = studentRepository.findDistinctById(st.getId());
            } else {
                System.out.println("1st " + st);
                if (st.getName() != null){
                    st = studentRepository.findDistinctByName(st.getName());
                }
                System.out.println(st);
            }

            if (subj.getId() != 0){
                subj = subjectRepository.findDistinctById(subj.getId());
            }else{
                if (subj.getSubjectName() != null)
                    tempSubject  = subjectRepository.findDistinctBySubjectName(subj.getSubjectName());
            }
            if (tempSubject != null){
                subj = tempSubject;
            }
            st.getSubjects().add(subj);
            subj.getStudents().add(st);
            studentRepository.save(st);

            log.info("saved");
        }




    }


    @Override
    public void run(String... args) throws Exception {

        Student john = new Student("John", 19);
        Student phill = new Student("Phill", 18);
        Student anna = new Student("Anna", 19);
        Subject math = new Subject("Math");
        Subject sports = new Subject("sports");
        Subject languages = new Subject("languages");
        Subject oratory = new Subject("Speaking skills");


      //  addStudentsToCourse(john, languages);

/*
        сначала сохранить
        studentRepository.save(john);

        subjectRepository.save(math);
        subjectRepository.save(sports);

        потом привязать друг к другу
        addStudentsToCourse(john, math);
        addStudentsToCourse(john, sports);
*/

      /* сначала отвязать их таким образом


      Subject subj = subjectRepository.findDistinctById(3);
        Student st = studentRepository.findDistinctById(3);
        st.setSubjects(null);
       subj.setStudents(null);
       studentRepository.save(st);
       subjectRepository.save(subj);*/

      //потом удалить
     //  subjectRepository.delete(subj);


    }


}
