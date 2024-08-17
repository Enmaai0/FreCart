package icu.hao.haomall.model.pojo;

import java.util.Date;

public class Category {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hao_mall_category.id
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hao_mall_category.name
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hao_mall_category.type
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hao_mall_category.parent_id
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    private Integer parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hao_mall_category.order_num
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    private Integer orderNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hao_mall_category.create_time
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column hao_mall_category.update_time
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hao_mall_category.id
     *
     * @return the value of hao_mall_category.id
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hao_mall_category.id
     *
     * @param id the value for hao_mall_category.id
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hao_mall_category.name
     *
     * @return the value of hao_mall_category.name
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hao_mall_category.name
     *
     * @param name the value for hao_mall_category.name
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hao_mall_category.type
     *
     * @return the value of hao_mall_category.type
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hao_mall_category.type
     *
     * @param type the value for hao_mall_category.type
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hao_mall_category.parent_id
     *
     * @return the value of hao_mall_category.parent_id
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hao_mall_category.parent_id
     *
     * @param parentId the value for hao_mall_category.parent_id
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hao_mall_category.order_num
     *
     * @return the value of hao_mall_category.order_num
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hao_mall_category.order_num
     *
     * @param orderNum the value for hao_mall_category.order_num
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hao_mall_category.create_time
     *
     * @return the value of hao_mall_category.create_time
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hao_mall_category.create_time
     *
     * @param createTime the value for hao_mall_category.create_time
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column hao_mall_category.update_time
     *
     * @return the value of hao_mall_category.update_time
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column hao_mall_category.update_time
     *
     * @param updateTime the value for hao_mall_category.update_time
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}