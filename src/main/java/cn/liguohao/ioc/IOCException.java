package cn.liguohao.ioc;

/**IOC容器异常
 * @author <a href="mailto:liguohao_cn@qq.com">liguohao_cn@qq.com</a>
 * @since 2021/1/31
 */
public class IOCException extends Exception{
    public IOCException() {
        super();
    }

    public IOCException(String message) {
        super(message);
    }

    public IOCException(String message, Throwable cause) {
        super(message, cause);
    }

    public IOCException(Throwable cause) {
        super(cause);
    }

    public IOCException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
