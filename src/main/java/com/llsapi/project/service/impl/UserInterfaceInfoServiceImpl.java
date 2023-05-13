package com.llsapi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.llsapi.project.common.ErrorCode;
import com.llsapi.project.exception.BusinessException;
import com.llsapi.project.mapper.UserInterfaceInfoMapper;
import com.llsapi.project.model.entity.UserInterfaceInfo;
import com.llsapi.project.service.UserInterfaceInfoService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
* @createDate 2023-04-28 15:12:33
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {

    @Override
    public void validInterfaceInfo(UserInterfaceInfo UserInterfaceInfo, boolean add) {
        if (UserInterfaceInfo == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Long userId = UserInterfaceInfo.getUserId();
        Long interfaceInfoId = UserInterfaceInfo.getInterfaceInfoId();
        Integer leftNum = UserInterfaceInfo.getLeftNum();

        if (add){
            if (userId < 0 || interfaceInfoId < 0){
                throw  new BusinessException(ErrorCode.PARAMS_ERROR,"接口或者用户不存在");
            }
        }

        if (leftNum < 0){
            throw  new BusinessException(ErrorCode.PARAMS_ERROR,"剩余次数不能小于0");
        }

    }

    //调用次数
    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        if (interfaceInfoId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interfaceInfoId", interfaceInfoId);
        updateWrapper.eq("userId", userId);
        updateWrapper.gt("leftNum", 0);
        updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
        return this.update(updateWrapper);
    }
}




