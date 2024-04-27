package com.learn.springboot_learn_computerstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.learn.springboot_learn_computerstore.entity.District;

@Mapper
public interface DistrictMapper {
    /**
     * 根据父代码号查询区域信息
     * @param parent 父代码号
     * @return 某个父区域下所有的区域列表
     */
    List<District> findByParent(String parent);//查询的结果可能是多个,所以放在集合中
    
    /* 
     * 根据当前code来获取当前省市区的名称
    */
    String findNameByCode(String code);
}
