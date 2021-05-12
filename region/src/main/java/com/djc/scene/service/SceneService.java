package com.djc.scene.service;

import com.djc.scene.dao.UserMapper;
import com.djc.scene.domain.IOSCert;
import com.djc.scene.domain.User;
import com.djc.scene.utils.CertResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

@Service
public class SceneService {

    private static final Logger log = LoggerFactory.getLogger(SceneService.class);

    @Resource
    private UserMapper userMapper;
    private static IOSCert iosCert = null;

    public String resolveIOSCert(MultipartFile file, IOSCert iosCert) {
        try {
            return CertResolver.resolveCert(file.getInputStream(),iosCert.getCertPassword());
        } catch (IOException | KeyStoreException | CertificateException | NoSuchAlgorithmException e) {
            log.error("Certificate resolve failed:",e);
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void saveConfig(IOSCert iosCert){
        SceneService.iosCert = iosCert;
    }

    public IOSCert obtain(){
        return SceneService.iosCert;
    }

    public User obtainUser(String mobileNumber) {
        return userMapper.query(mobileNumber);
    }

    public void saveUser(User user) {
        String mobileNumber = user.getMobileNumber();
        User oldUser = userMapper.query(mobileNumber);
        if(oldUser != null){
            throw new IllegalArgumentException("该账号已被注册");
        }
        userMapper.save(user);
    }
}
