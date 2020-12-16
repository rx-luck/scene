package com.djc.scene.validator;

import com.djc.scene.dto.UserDto;
import com.djc.scene.dto.IOSCertDto;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;

@Component
public class SceneValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        if(clazz.equals(UserDto.class)){
            return true;
        }else if(clazz.equals(IOSCertDto.class)){
            return true;
        }
        return false;
    }

    @Override
    public void validate(Object obj, Errors errors) {
        if(obj instanceof UserDto){
            String passWord = ((UserDto) obj).getPassWord();
            String realName = ((UserDto) obj).getRealName();
            String userName = ((UserDto) obj).getUserName();
            if(!StringUtils.hasText(passWord)){
                errors.rejectValue("passWord",null,"密码不能为空");
            }
            if(!StringUtils.hasText(realName)){
                errors.rejectValue("realName",null,"真实姓名不能为空");
            }
            if(!StringUtils.hasText(userName)){
                errors.rejectValue("userName",null,"姓名不能为空");
            }
        }
    }
}
