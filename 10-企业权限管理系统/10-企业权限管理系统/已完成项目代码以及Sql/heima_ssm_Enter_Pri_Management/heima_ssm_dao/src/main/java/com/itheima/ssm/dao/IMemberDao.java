package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author panghl
 * @Date 2020/10/27 21:48
 * @Version 1.0
 * @Description TODO
 **/
@Repository
public interface IMemberDao {
    @Select("select * from member where id = #{id}")
    Member findById(String id) throws Exception;
}
