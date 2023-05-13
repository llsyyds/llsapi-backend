package com.llsapi.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.llsapi.project.model.entity.InterfaceInfo;

/**
* @author Administrator
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-04-09 23:07:10
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
