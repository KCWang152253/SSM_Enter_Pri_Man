package com.itheima.ssm.service;

import com.itheima.ssm.domain.SysLog;

import java.util.List;

/**
 * @Author panghl
 * @Date 2020/11/9 21:50
 * @Version 1.0
 * @Description TODO
 **/
public interface ISysLogService {

    public void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll() throws Exception;
}
