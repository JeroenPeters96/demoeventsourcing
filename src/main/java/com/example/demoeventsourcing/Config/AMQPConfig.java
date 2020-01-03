//package com.example.demoeventsourcing.Config;
//
//import com.rabbitmq.client.Channel;
//import org.axonframework.amqp.eventhandling.AMQPMessageConverter;
//import org.axonframework.amqp.eventhandling.spring.SpringAMQPMessageSource;
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class AMQPConfig {
//
//    @Value("${axon.amqp.exchange}")
//    private String exchangeName;
//
//    @Bean
//    public Exchange exchange() {
//        return ExchangeBuilder.fanoutExchange(exchangeName).build();
//    }
//
//    @Bean
//    public Queue queue() {
//        return QueueBuilder.durable("orderEvents").build();
//    }
//
//    @Bean
//    public Binding binding() {
//        return BindingBuilder.bind(queue()).to(exchange()).with("*").noargs();
//    }
//
//    @Autowired
//    public void configure(AmqpAdmin admin) {
//        admin.declareExchange(exchange());
//        admin.declareQueue(queue());
//        admin.declareBinding(binding());
//    }
//
//    @Bean
//    public SpringAMQPMessageSource myQueueMessageSource(AMQPMessageConverter messageConverter) {
//        return new SpringAMQPMessageSource(messageConverter) {
//
//            @RabbitListener(queues = "test")
//            @Override
//            public void onMessage(Message message, Channel channel) {
//                super.onMessage(message, channel);
//            }
//        };
//    }
//}
