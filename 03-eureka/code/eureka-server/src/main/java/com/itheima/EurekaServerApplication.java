package com.itheima;

/**
 * @author XUAN
 * @date 2020/11/4 - 21:31
 * @references
 * @purpose
 * @errors
 *   * java.lang.TypeNotPresentException: Type javax.xml.bind.JAXBContext not present
 *       [Type javax.xml.bind.JAXBContext not present](https://blog.csdn.net/weixin_44388193/article/details/88839883)
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//声明当前应用为eureka服务
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {
    // http://127.0.0.1:10086
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class);
    }
}
