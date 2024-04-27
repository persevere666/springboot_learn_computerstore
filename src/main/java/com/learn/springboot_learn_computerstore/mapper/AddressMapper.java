package com.learn.springboot_learn_computerstore.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.learn.springboot_learn_computerstore.entity.Address;

@Mapper
public interface AddressMapper {
    //
     /**
     * 插入用户的收货地址数据
     * @param address 收货地址数据
     * @return 受影响的行数
     */
    Integer insert (Address address);

    /**
     * 根据用户的uid统计收货地址数量
     * @param uid 用户的uid
     * @return 当前用户的收货地址总数
     */
    Integer countByUid(Integer uid);

    /**
    * 根据用户的uid查询用户的收货地址数据
    * @param uid 用户uid
    * @return 收货地址数据
    */
    List<Address> findByUid(Integer uid);

    /**
    * 根据aid查询收货地址数据
    * @param aid 收货地址aid
    * @return 收货地址数据,如果没有找到则返回null值
    */
    Address findByAid(Integer aid);

    /**
    * 根据用户uid修改用户的收货地址统一设置为非默认
    * @param uid 用户uid
    * @return 受影响的行数
    */
    Integer updateNonDefault(Integer uid);


    Integer updateDefaultByAid(
        @Param("aid") Integer aid,
        @Param("modifiedUser") String modifiedUser,
        @Param("modifiedTime") Date modifiedTime);

    /**
     * 根据收货地址id删除收货地址数据
     * @param aid 收货地址的id
     * @return 受影响的行数
     */
    Integer deleteByAid(Integer aid);

    /**
     * 根据用户uid查询用户最后一次被修改的收货地址数据
     * @param uid 用户id
     * @return 收货地址数据
     */
    Address findLastModified(Integer uid);

    /**
     * Description : 根据地址aid查询某条数据
     * @date 2022/7/15
     * @param aid 地址的aid
     * @return top.year21.computerstore.entity.Address
     **/
    Address queryUserAddressByAid(Integer aid);
    
    /**
     * Description : 根据aid修改用户信息
     * @date 2024/04/25
     * @param address 更新的用户地址信息
     * @return int
     **/
    int updateUserAddressByAid(Address address);    
}
