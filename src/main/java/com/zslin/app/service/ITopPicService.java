package com.zslin.app.service;

import com.zslin.app.model.TopPic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by 钟述林 393156105@qq.com on 2016/11/11 15:26.
 */
public interface ITopPicService extends JpaRepository<TopPic, Integer>, JpaSpecificationExecutor<TopPic> {
}
