package com.zslin.test;

import com.zslin.app.tools.HttpRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 钟述林 393156105@qq.com on 2016/12/26 8:54.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("zsl")
public class SiteTest {

    @Test
    public void testPost() {
        String url = "http://data.zz.baidu.com/urls?site=www.zslin.com&token=8vuw9dOmN3opAHl3&type=original";
        String [] sites = {"http://www.zslin.com/web/article/detail/5", "http://www.zslin.com/web/article/detail/6"};

        String res = HttpRequest.sendPost(url, sites);
        System.out.println("========="+res);
    }
}
