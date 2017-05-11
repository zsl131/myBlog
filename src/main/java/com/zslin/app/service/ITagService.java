package com.zslin.app.service;

import com.zslin.app.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by zsl-pc on 2016/9/27.
 */
public interface ITagService extends JpaRepository<Tag, Integer>, JpaSpecificationExecutor<Tag> {

    public Tag findByName(String name);
}
