package com.zslin.test;

import com.zslin.app.tools.HtmlRegexpTools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zsl-pc on 2016/9/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class NormalTest {

    @Test
    public void test1() {
        String str = "&lt;p&gt;adgasdf&lt;/p&gt;\n" +
                "&lt;div class=\"editormd-toc-menu\"&gt;&lt;div class=\"markdown-toc editormd-markdown-toc\"&gt;[TOCM]&lt;/div&gt;&lt;/div&gt;&lt;br/&gt;&lt;h1 id=\"h1-asdfadsf\"&gt;&lt;a name=\"asdfadsf\" class=\"reference-link\"&gt;&lt;/a&gt;&lt;span class=\"header-link octicon octicon-link\"&gt;&lt;/span&gt;asdfadsf&lt;/h1&gt;&lt;h2 id=\"h2-asdfasg\"&gt;&lt;a name=\"asdfasg\" class=\"reference-link\"&gt;&lt;/a&gt;&lt;span class=\"header-link octicon octicon-link\"&gt;&lt;/span&gt;asdfasg&lt;/h2&gt;&lt;h3 id=\"h3-asdfadfagasdf\"&gt;&lt;a name=\"asdfadfagasdf\" class=\"reference-link\"&gt;&lt;/a&gt;&lt;span class=\"header-link octicon octicon-link\"&gt;&lt;/span&gt;asdfadfagasdf&lt;/h3&gt;&lt;h1 id=\"h1-aaaa\"&gt;&lt;a name=\"aaaa\" class=\"reference-link\"&gt;&lt;/a&gt;&lt;span class=\"header-link octicon octicon-link\"&gt;&lt;/span&gt;aaaa&lt;/h1&gt;&lt;h2 id=\"h2-bbb\"&gt;&lt;a name=\"bbb\" class=\"reference-link\"&gt;&lt;/a&gt;&lt;span class=\"header-link octicon octicon-link\"&gt;&lt;/span&gt;bbb&lt;/h2&gt;";
        String res = HtmlRegexpTools.filterHtml(str);
        System.out.println(str);
    }

    @Test
    public void test2() {
        String str = "这里是头\\n二级目录第二个一级目录第二个的二级目录";
        System.out.println(str.replace("[TOCM]", ""));
    }
}
