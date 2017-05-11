package com.zslin.basic.auth.iservice;

import com.zslin.basic.auth.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by zsl-pc on 2016/9/1.
 */
public interface IUserRoleService extends JpaRepository<UserRole, Integer> {

    @Query("SELECT ur.rid FROM UserRole ur WHERE ur.uid=:userId")
    public List<Integer> queryRoleIds(@Param("userId") Integer userId);

    public UserRole findByUidAndRid(Integer uid, Integer rid);
}
