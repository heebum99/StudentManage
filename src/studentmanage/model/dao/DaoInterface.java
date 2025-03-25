package studentmanage.model.dao;

import studentmanage.common.SearchInterface;
import studentmanage.model.vo.Job;

import java.util.List;

public interface DaoInterface {
    boolean save(Job job);

    List<? extends Job> search(SearchInterface search);

    boolean findEqualJob(Job job);

    boolean update(Job existJob, Job updateJob);

    boolean delete(int id);
}

