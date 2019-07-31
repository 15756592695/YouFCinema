package com.woniu.rabbit;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 张鸿杰
 * Date：2019-05-04
 * Time:22:56
 */
public class MyMessagePostProcessor  implements MessagePostProcessor {
    private final Long ttl; // 毫秒
    public MyMessagePostProcessor(Long ttl) {
        this.ttl = ttl;
        
    }
    @Override
    public Message postProcessMessage(Message message) throws AmqpException {
        message.getMessageProperties()
                .setExpiration(ttl.toString()); // 设置per-message的失效时间
        return message;
    }
}
