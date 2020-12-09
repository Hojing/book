package cn.liguohao.encrpt;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**RSA加密工具类测试
 * @Author liguohao
 * @Date 2020/12/9
 */
public class RSAEncrptUtilsTest {

    /**
     * 公钥文件
     */
    private File publicKeyFile = new File("R:\\test\\key\\publicKeyFile.pub");
    /**
     * 私钥文件
     */
    private File privateKeyFile = new File("R:\\test\\key\\privatekeyFile.pri");

    /**
     * 源文件
      */
    private File originalFile = new File("R:\\test\\key\\aeskey.key");

    /**
     * 加密后的文件
     */
    private File encrptedFile = new File("R:\\test\\encrypt\\aeskey.key.ikaros");

    /**
     * 解密后的文件
     */
    private File decrptedFile = new File("R:\\test\\decrypted\\aeskey.key");

    /**
     * 生成密钥
     * @throws IOException 文件读写异常
     */
    @Test
    public void generateKeyFile() throws IOException {
        RSAEncrptUtils.generateKeyFile(publicKeyFile,privateKeyFile);
    }

    /**
     * 根据公钥加密
     */
    @Test
    public void encrptFileByPublicKeyFile() throws IOException {
        // 加密
        RSAEncrptUtils.encrptFileByPublicKeyFile(publicKeyFile,originalFile,encrptedFile);
    }

    /**
     * 解密文件
     */
    @Test
    public void decrptFileByPrivateKeyFile() throws IOException {
        // 解密
        RSAEncrptUtils.decrptFileByPrivateKeyFile(privateKeyFile,encrptedFile,decrptedFile);
    }

}
