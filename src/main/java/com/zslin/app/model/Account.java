package com.zslin.app.model;

import javax.persistence.*;

/**
 * Created by 钟述林 393156105@qq.com on 2017/5/12 23:11.
 */
@Entity
@Table(name = "t_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    private String password;

    @Column(name = "real_name")
    private String realName;
}
