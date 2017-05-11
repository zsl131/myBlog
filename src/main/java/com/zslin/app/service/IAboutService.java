package com.zslin.app.service;

import com.zslin.app.model.About;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zsl-pc on 2016/10/8.
 */
public interface IAboutService extends JpaRepository<About, Integer> {

}
