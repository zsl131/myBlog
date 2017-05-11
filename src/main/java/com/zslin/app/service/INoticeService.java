package com.zslin.app.service;

import com.zslin.app.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zsl-pc on 2016/9/27.
 */
public interface INoticeService extends JpaRepository<Notice, Integer>, JpaSpecificationExecutor<Notice> {

    @Query("SELECT MAX(n.orderNo) FROM Notice n ")
    public Integer queryMaxOrderNo();

    @Modifying
    @Transactional
    @Query("update Notice n set n.orderNo=?2 WHERE n.id=?1")
    public void updateOrderNo(Integer id, Integer orderNo);
}
