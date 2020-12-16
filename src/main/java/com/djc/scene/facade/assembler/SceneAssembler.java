package com.djc.scene.facade.assembler;

import com.djc.scene.domain.IOSCert;
import com.djc.scene.domain.User;
import com.djc.scene.dto.IOSCertDto;
import com.djc.scene.dto.UserDto;

public class SceneAssembler {

    public static IOSCert toIOSCert(IOSCertDto iosCertDto){
        IOSCert iosCert = new IOSCert();
        String certEnv = iosCertDto.getCertEnv();
        String certDate = iosCertDto.getCertDate();
        String certPassword = iosCertDto.getCertPassword();

        iosCert.setCertEnv(certEnv);
        iosCert.setCertDate(certDate);
        iosCert.setCertPassword(certPassword);
        return iosCert;
    }

    public static IOSCertDto toIOSCertDto(IOSCert iosCert){
        IOSCertDto iosCertDto = new IOSCertDto();
        String certEnv = iosCert.getCertEnv();

        String certDate = iosCert.getCertDate();
        String certPassword = iosCert.getCertPassword();

        iosCertDto.setCertEnv(certEnv);
        iosCertDto.setCertPassword(certPassword);
        iosCertDto.setCertDate(certDate);
        return iosCertDto;
    }

    public static User toUser(UserDto userDto) {
        User user = new User();
        Integer id = userDto.getId();
        String realName = userDto.getRealName();
        String userName = userDto.getUserName();
        String passWord = userDto.getPassWord();
        user.setId(id);
        user.setRealName(realName);
        user.setUserName(userName);
        user.setPassWord(passWord);
        return user;
    }

    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        Integer id = user.getId();
        String realName = user.getRealName();
        String userName = user.getUserName();
        String passWord = user.getPassWord();
        userDto.setId(id);
        userDto.setRealName(realName);
        userDto.setUserName(userName);
        userDto.setPassWord(passWord);
        return userDto;
    }
}
