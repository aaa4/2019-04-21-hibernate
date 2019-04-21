package q.w.accTopic;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "topic")
@RequiredArgsConstructor
@NoArgsConstructor
public class Topic {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    int id;

    @Column(name = "topic_title")
    @NonNull String title;

    @Column(name = "topic_content")
    @NonNull String content;

    @ManyToOne
    @JoinColumn(name = "topic_acc_id")
    Acc account;

    @Override
    public String toString() {
        String idx="";
        if (account != null)
            idx += account.getId();
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", accountIdx=" + idx+
                '}';
    }
}
