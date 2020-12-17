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
        String userName = userDto.getUserName();
        String passWord = userDto.getPassWord();
        String mobileNumber = userDto.getMobileNumber();
        user.setUserName(userName);
        user.setPassWord(passWord);
        user.setMobileNumber(mobileNumber);
        return user;
    }

    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        String userName = user.getUserName();
        String passWord = user.getPassWord();
        String mobileNumber = user.getMobileNumber();
        userDto.setUserName(userName);
        userDto.setPassWord(passWord);
        userDto.setMobileNumber(mobileNumber);
        return userDto;
    }
}
