package com.djc.scene.facade;

import com.djc.scene.domain.IOSCert;
import com.djc.scene.domain.User;
import com.djc.scene.dto.IOSCertDto;
import com.djc.scene.dto.UserDto;
import com.djc.scene.facade.assembler.SceneAssembler;
import com.djc.scene.service.SceneService;
import com.djc.scene.utils.Base64Utils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@Component
public class SceneFacade {
    @Resource
    private SceneService sceneService;

    public String saveConfig(MultipartFile file, IOSCertDto iosCertDto) {
        IOSCert iosCert = SceneAssembler.toIOSCert(iosCertDto);
        String intervalDate = sceneService.resolveIOSCert(file, iosCert);
        try {
            iosCert.setCert(Base64Utils.toBase64(file.getBytes()));
            save(iosCert);
            return intervalDate;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return intervalDate;
    }

    public void save(IOSCert iosCert) {
        sceneService.saveConfig(iosCert);
    }

    public User obtainUser(String mobileNumber) {
        return sceneService.obtainUser(mobileNumber);
    }

    public void saveUser(UserDto userDto) {
        User user = SceneAssembler.toUser(userDto);
        sceneService.saveUser(user);
    }
}
