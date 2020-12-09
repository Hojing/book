package cn.liguohao.encrpt;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**RSA加密工具类测试
 * @Author liguohao
 * @Date 2020/12/9
 */
public class RSAEncrptUtilsTest {

    @Test
    public void generateKeyFile() throws IOException {
        File publicKeyFile = new File("R:\\test\\key\\publicKeyFile.pub");
        File privateKeyFile = new File("R:\\test\\key\\privatekeyFile.pri");
        RSAEncrptUtils.generateKeyFile(publicKeyFile,privateKeyFile);
    }

}
