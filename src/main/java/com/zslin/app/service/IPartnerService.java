package com.zslin.app.service;

import com.zslin.app.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 钟述林 393156105@qq.com on 2016/10/20 14:32.
 */
public interface IPartnerService extends JpaRepository<Partner, Integer>, JpaSpecificationExecutor<Partner> {

    /** 通过用户名获取对象 */
    Partner findByUsername(String username);

    /** 通过用户Id获取对象 */
    Partner findByUserId(Integer userId);

    @Query("SELECT MAX(p.orderNo) FROM Partner p")
    Integer findMaxOrderNo();

    @Query("UPDATE Partner p SET p.orderNo=?1 WHERE p.id=?2")
    @Modifying
    @Transactional
    void updateOrderNo(Integer orderNo, Integer id);
}
