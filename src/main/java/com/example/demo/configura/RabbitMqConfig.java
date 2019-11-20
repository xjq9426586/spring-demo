package com.example.demo.configura;
 
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
@Configuration
public class RabbitMqConfig {
    /**
     * 创建三个队列   一个fanoutexchange路由器（交换机），将三个队列分别绑定到交换机上去
     * @return
     */
    @Bean(name = "Amessage")
    public Queue AMessage(){
        return new Queue("fanout.A");
    }

    @Bean(name = "Bmessage")
    public Queue BMessage(){
        return new Queue("fanout.B");
    }

    @Bean(name = "Cmessage")
    public Queue CMessage(){
        return new Queue("fanout.C");
    }

    // 创建交换机 FanoutExchange
    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchangeA(@Qualifier("Amessage")Queue aqueue,FanoutExchange exchange){
        return BindingBuilder.bind(aqueue).to(exchange);
    }

    @Bean
    Binding bindingExchangeB(@Qualifier("Bmessage")Queue bqueue,FanoutExchange exchange){
        return BindingBuilder.bind(bqueue).to(exchange);
    }

    @Bean
    Binding bindingExchangeC(@Qualifier("Cmessage")Queue cqueue, FanoutExchange exchange){
        return BindingBuilder.bind(cqueue).to(exchange);
    }

}
