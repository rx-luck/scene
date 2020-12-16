package com.djc.scene.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CertResolver {

    /**
     * 解析ios证书
     * @param inputStream 上传的文件流
     * @param password ios证书密码
     * @return
     * @throws KeyStoreException
     * @throws CertificateException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static String resolveCert(InputStream inputStream,String password) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
            KeyStore ks = KeyStore.getInstance("PKCS12");
            ks.load(inputStream, password.toCharArray());
            String alias = ks.aliases().nextElement();
            X509Certificate certificate = (X509Certificate) ks.getCertificate(alias);
            Date beginDate = certificate.getNotBefore();
            Date endDate = certificate.getNotAfter();
            String beginTime = toDateString(beginDate);
            String endTime = toDateString(endDate);
            return beginTime+"-"+endTime;
    }

    /**
     *
     * @param date 传入的时间对象
     * @return 返回当前时间对象的
     */
    private static String toDateString(Date date){
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
