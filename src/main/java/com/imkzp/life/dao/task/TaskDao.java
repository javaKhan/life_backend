package com.imkzp.life.dao.task;

import com.imkzp.life.bean.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends JpaRepository<Task,String> {
}
