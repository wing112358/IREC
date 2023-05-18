package org.irecapi.entity;

import java.io.Serializable;

/**
 * 内容en表(ContentEn)实体类
 *
 * @author makejava
 * @since 2022-07-20 15:02:08
 */
public class ContentEn implements Serializable {
    private static final long serialVersionUID = -27671948084847340L;
    /**
     * 主键id
     */
    private Long id;
    /**
     * 内容
     */
    private String content;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

