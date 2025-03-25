package studentmanage.common;

import studentmanage.model.vo.Job;

@FunctionalInterface
public interface SearchInterface {
    boolean find(Job job);
}
