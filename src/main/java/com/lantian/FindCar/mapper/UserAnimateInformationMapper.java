package com.lantian.FindCar.mapper;

import com.lantian.FindCar.dao.UserAnimateInformation;
import com.lantian.FindCar.dao.UserAnimateInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAnimateInformationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_animate_information
     *
     * @mbggenerated
     */
    int countByExample(UserAnimateInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_animate_information
     *
     * @mbggenerated
     */
    int deleteByExample(UserAnimateInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_animate_information
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_animate_information
     *
     * @mbggenerated
     */
    int insert(UserAnimateInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_animate_information
     *
     * @mbggenerated
     */
    int insertSelective(UserAnimateInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_animate_information
     *
     * @mbggenerated
     */
    List<UserAnimateInformation> selectByExample(UserAnimateInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_animate_information
     *
     * @mbggenerated
     */
    UserAnimateInformation selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_animate_information
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") UserAnimateInformation record, @Param("example") UserAnimateInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_animate_information
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") UserAnimateInformation record, @Param("example") UserAnimateInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_animate_information
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UserAnimateInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_animate_information
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserAnimateInformation record);
}