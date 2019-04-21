package q.w.accTopic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends CrudRepository<Acc, Integer> {
}
