package q.w.accTopic;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "acc")
@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Acc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "acc_id")
    int id;


    @NonNull @Column(name = "acc_user_name")
    String userName;

    @OneToMany
    Set<Topic> topics;

    public void addTopic(Topic t){
        if (topics == null)
            topics = new HashSet<>();
        topics.add(t);
        t.setAccount(this);
    }




}
