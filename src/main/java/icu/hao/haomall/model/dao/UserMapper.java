package icu.hao.haomall.model.dao;

import icu.hao.haomall.model.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hao_mall_user
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hao_mall_user
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    int insert(User row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hao_mall_user
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    int insertSelective(User row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hao_mall_user
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hao_mall_user
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    int updateByPrimaryKeySelective(User row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hao_mall_user
     *
     * @mbg.generated Tue May 21 01:26:00 AEST 2024
     */
    int updateByPrimaryKey(User row);

    User selectByName(String userName);

    User selectByLogin(@Param("username") String userName, @Param("password") String password);
}