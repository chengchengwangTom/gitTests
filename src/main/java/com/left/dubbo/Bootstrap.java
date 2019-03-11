package com.left.dubbo;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Protocol;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 *    @author : orange
 *    @e-mail : 495314527@qq.com
 *    @time   : 2019/2/26 21:50
 *    @desc   :
 *    @version: 1.0
 * </pre>
 */
public class Bootstrap {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-client.xml");
        LeftHello leftHello = (LeftHello)context.getBean("leftHello");
        System.out.println(leftHello.sayHello("cc"));

        ExtensionLoader<Protocol> extensionLoader = ExtensionLoader.getExtensionLoader(Protocol.class);
        Protocol adaptiveExtension = extensionLoader.getAdaptiveExtension();

        Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class)
                .getExtension("myProtocol");

        System.out.println(protocol.getDefaultPort());



    }
}
