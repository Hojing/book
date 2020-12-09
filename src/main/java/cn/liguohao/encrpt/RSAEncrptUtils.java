package cn.liguohao.encrpt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**RSA加密工具类
 * @Author liguohao
 * @Date 2020/12/9
 */
public class RSAEncrptUtils {

    /**
     * 密钥算法
     */
    private static final String KEY_ALGORITHM = "RSA";

    /**
     * 生成密钥对
     * @param keySize 生成尺寸
     */
    public static KeyPair generateKey(int keySize){
        try {
            // 获取Key生成器
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);

            // 初始化Key生成器
            keyPairGenerator.initialize(keySize);

            // 生成密钥对
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成密钥对文件
     * @param keySize 密钥尺寸
     * @param publicKeyFile 公钥文件
     * @param privateKeyFile 私钥文件
     * @throws IOException 文件读写异常
     * @see #generateKey(int)
     */
    public static void generateKeyFile(int keySize, File publicKeyFile, File privateKeyFile) throws IOException {
        // 父目录不存在创建
        if(!publicKeyFile.getParentFile().exists()) publicKeyFile.getParentFile().mkdirs();
        if(!privateKeyFile.getParentFile().exists()) privateKeyFile.getParentFile().mkdirs();

        // 生成密钥对
        KeyPair keyPair = generateKey(keySize);

        // 写入到文件中
        FileOutputStream publicKeyFileOutputStream = new FileOutputStream(publicKeyFile);
        FileOutputStream privateKeyFileOutputStream = new FileOutputStream(privateKeyFile);
        publicKeyFileOutputStream.write(keyPair.getPublic().getEncoded());
        privateKeyFileOutputStream.write(keyPair.getPrivate().getEncoded());

        // 释放流
        publicKeyFileOutputStream.close();
        privateKeyFileOutputStream.close();
    }

}
