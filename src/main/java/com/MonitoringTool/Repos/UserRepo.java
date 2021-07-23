package com.MonitoringTool.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.MonitoringTool.MvpModel.User;
public interface UserRepo extends JpaRepository<User, Long>{

}
