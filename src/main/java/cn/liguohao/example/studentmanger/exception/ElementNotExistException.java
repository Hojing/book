package cn.liguohao.example.studentmanger.exception;

/**
 * @Description TODO 对象不存在异常
 * @Author liguohao
 * @Date 2020/9/29 0:13
 */
public class ElementNotExistException extends RuntimeException {
    public ElementNotExistException(String message) {
        super(message);
    }
}
