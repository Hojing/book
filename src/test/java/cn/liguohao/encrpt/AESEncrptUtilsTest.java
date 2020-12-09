package cn.liguohao.encrpt;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**AESEncrpts工具类测试
 * @Author liguohao
 * @Date 2020/12/8
 */
public class AESEncrptUtilsTest {

    /**
     * 密钥文件
     */
    private File KEY_FILE = new File("R:\\test\\key\\aeskey.key");

    /**
     * 源文件目录
     */
    private String ORIGINAL_FILE_DIRTORY = "R:\\test\\original";

    /**
     * 加密文件目录
     */
    private String ENCRPTED_FILE_DIRTORY = "R:\\test\\encrypted";

    /**
     * 加密后文件后缀名 文件完整名.ikaros 如 蜀道难.txt.ikaros
     */
    private String ENCRPTED_FILE_SUFFIX = ".ikaros";

    /**
     * 解密文件目录
     */
    private String DECRPTED_FILE_DIRTORY = "R:\\test\\decrypted";

    /**
     * 测试用文本文件完整名称
     */
    private String TXT_FILE_NAME = "蜀道难.txt";

    /**
     * 测试用图片文件完整名称
     */
    private String IMG_FILE_NAME = "万民堂.jpg";

    /**
     * 测试用视频文件完整名称
     */
    private String VIDEO_FILE_NAME = "Happy Sugar Life 01 砂糖少女以爱为食.mp4";




    /**
     * 生成密钥文件测试
     */
    @Test
    public void generateKeyFile() throws IOException {
        AESEncrptUtils.generateKeyFile(256,KEY_FILE);
    }


    /**
     * 加密文件
     * @param fileName 完整文件名
     * @throws IOException 文件IO操作异常
     */
    private void encrptFile(String fileName) throws IOException {
        long start = System.currentTimeMillis();
        // 构建源文件
        File originalFile = new File(ORIGINAL_FILE_DIRTORY + "\\" +fileName);
        // 构建加密文件
        File encrptedFile = new File(ENCRPTED_FILE_DIRTORY + "\\" + fileName + ENCRPTED_FILE_SUFFIX);
        // 加密文件
        AESEncrptUtils.encrptFile(KEY_FILE,originalFile,encrptedFile);
        long end = System.currentTimeMillis();
        System.out.println("加密大小为"+originalFile.length()+"KB的文件耗时 ==> "+(end-start) +"ms");
    }


    /**
     * 加密文件测试
     * @throws IOException 文件IO操作异常
     * @see #encrptFile(String)
     */
    @Test
    public void encrptFileTest() throws IOException {
        // 加密文本文件
        encrptFile(TXT_FILE_NAME);
        // 加密图片文件
        encrptFile(IMG_FILE_NAME);
        // 加密视频文件
        encrptFile(VIDEO_FILE_NAME);
    }

    /**
     * 根据完整文件名解密文件
     * @param fileName 完整文件名
     * @throws IOException 文件IO操作异常
     */
    private void decryptFile(String fileName) throws IOException{
        long start = System.currentTimeMillis();
        // 构建加密文件
        File encrptedFile = new File(ENCRPTED_FILE_DIRTORY + "\\" + fileName + ENCRPTED_FILE_SUFFIX);

        // 构建解密后文件
        File decrptedFile = new File(DECRPTED_FILE_DIRTORY + "\\" + fileName);

        // 解密文件
        AESEncrptUtils.decryptFile(KEY_FILE,encrptedFile,decrptedFile);
        
        long end = System.currentTimeMillis();
        System.out.println("解密大小为"+encrptedFile.length()+"KB的文件耗时 ==> "+(end-start) +"ms");
    }

    /**
     * 解密文件测试
     * @throws IOException
     * @see #decryptFile(String) 
     */
    @Test
    public void decryptFileTest() throws IOException{
        //解密文本文件
        decryptFile(TXT_FILE_NAME);
        //解密图片文件
        decryptFile(IMG_FILE_NAME);
        // 解密视频文件
        decryptFile(VIDEO_FILE_NAME);
    }

}
