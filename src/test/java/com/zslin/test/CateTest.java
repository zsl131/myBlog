package com.zslin.test;

import com.zslin.app.dto.CateDto;
import com.zslin.app.service.IArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by zsl-pc on 2016/10/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("zsl")
public class CateTest {

    @Autowired
    private IArticleService articleService;

    @Test
    public void test() {

        /**
         * SET GLOBAL sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
         SET SESSION sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
         */
        List<CateDto> list = articleService.queryCates();
        System.out.println(list.size());
    }

    @Test
    public void test2() {
        articleService.updateCommentCount(1,-1);
    }

    @Test
    public void test3() {
        System.out.println(articleService.queryReadCount());
    }
}
