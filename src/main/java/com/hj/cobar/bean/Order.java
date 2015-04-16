package com.hj.cobar.bean;

import com.alibaba.cobar.client.domain.FragmentPO;

import java.util.Date;

/**
 * <br>==========================
 * <br> 公司：优视科技
 * <br> 开发：fangyuan
 * <br> 版本：1.0
 * <br> 创建时间： 2015/4/15
 * <br>==========================
 */
public class Order extends FragmentPO{

    @Override
    public String toString() {
        return "Order [id=" + id + ", taobaoId=" + taobaoId + ", name=" + name
                + ", updTime=" + updTime + "]";
    }

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;
    /**
     * taobaoId
     */
    private Long taobaoId;
    /**
     * name
     */
    private String name;
    /**
     * upd_time
     */
    private Date updTime;

    /**
     * @return id id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return taobaoId taobaoId
     */
    public Long getTaobaoId() {
        return taobaoId;
    }

    /**
     * @param taobaoId
     *            taobaoId
     */
    public void setTaobaoId(Long taobaoId) {
        this.taobaoId = taobaoId;
    }

    /**
     * @return name name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return updTime upd_time
     */
    public Date getUpdTime() {
        return updTime;
    }

    /**
     * @param updTime
     *            upd_time
     */
    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }
}
