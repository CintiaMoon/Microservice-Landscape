package com.cargain.micro.landscape.user.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import com.cargain.micro.landscape.user.model.UserLog;

@RepositoryRestResource // Spring automatically creates REST representations from the UserLog JPA
                        // Entity class
// ie.
// 1.) curl curl http://localhost:8060/userLogs/search/by-name?content=Initial_Log
// 2.) curl http://localhost:8060/userLogs/15
public interface UserLogRepository extends JpaRepository<UserLog, Integer> {

  @RestResource(path = "by-name")
  Collection<UserLog> findByContent(@Param("content") String content);
}
