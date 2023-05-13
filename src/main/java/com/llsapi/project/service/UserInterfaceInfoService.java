package com.llsapi.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.llsapi.project.model.entity.UserInterfaceInfo;

/**
* @author Administrator
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2023-04-28 15:12:33
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    void validInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    boolean invokeCount(long interfaceInfoId, long userId);
}
