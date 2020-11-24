package cn.liguohao.example.studentmanger.exception;

/**
 * @Description TODO
 * @Author liguohao
 * @Date 2020/9/29 0:08
 */
public class EmptyElementException extends RuntimeException {
    public EmptyElementException(String message) {
        super(message);
    }
}
