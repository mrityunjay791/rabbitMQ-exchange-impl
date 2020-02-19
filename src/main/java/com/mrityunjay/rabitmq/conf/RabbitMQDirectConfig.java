package com.mrityunjay.rabitmq.conf;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQDirectConfig {

	@Bean
	Queue marketingQueue() {
		return new Queue("marketingQueue", false);
	}

	@Bean
	Queue financeQueue() {
		return new Queue("financeQueue", false);
	}

	@Bean
	Queue adminQueue() {
		return new Queue("adminQueue", false);
	}
	
	//Direct exchange..

//	@Bean
//	DirectExchange directExchange() {
//		return new DirectExchange("direct-exchange");
//	}
//
//	@Bean
//	Binding marketingBinding(Queue marketingQueue, DirectExchange exchange) {
//		return BindingBuilder.bind(marketingQueue).to(exchange).with("marketing");
//	}
//
//	@Bean
//	Binding financeBinding(Queue financeQueue, DirectExchange exchange) {
//		return BindingBuilder.bind(financeQueue).to(exchange).with("finance");
//	}
//
//	@Bean
//	Binding adminBinding(Queue adminQueue, DirectExchange exchange) {
//		return BindingBuilder.bind(adminQueue).to(exchange).with("admin");
//	}

	
	
	// Fanout exchange...
	
//	@Bean
//	FanoutExchange fanoutExchange() {
//		return new FanoutExchange("fanout-exchange");
//	}
//
//	@Bean
//	Binding marketingBinding(Queue marketingQueue, FanoutExchange exchange) {
//		return BindingBuilder.bind(marketingQueue).to(exchange);
//	}
//
//	@Bean
//	Binding financeBinding(Queue financeQueue, FanoutExchange exchange) {
//		return BindingBuilder.bind(financeQueue).to(exchange);
//	}
//
//	@Bean
//	Binding adminBinding(Queue adminQueue, FanoutExchange exchange) {
//		return BindingBuilder.bind(adminQueue).to(exchange);
//	}

	
	// Topic exchange...
	
//	@Bean
//	TopicExchange topicExchange() {
//		return new TopicExchange("topic-exchange");
//	}
//	
//	@Bean
//	Binding marketingBinding(Queue marketingQueue, TopicExchange topicExchange) {
//		return BindingBuilder.bind(marketingQueue).to(topicExchange).with("queue.marketing");
//	}
//	
//	@Bean
//	Binding financeBinding(Queue financeQueue, TopicExchange topicExchange) {
//		return BindingBuilder.bind(financeQueue).to(topicExchange).with("queue.finance");
//	}
//	
//	@Bean
//	Binding adminBinding(Queue adminQueue, TopicExchange topicExchange) {
//		return BindingBuilder.bind(adminQueue).to(topicExchange).with("queue.admin");
//	}
//	
//	@Bean
//	Binding allBinding(Queue allQueue, TopicExchange topicExchange) {
//		return BindingBuilder.bind(allQueue).to(topicExchange).with("queue.*");
//	}
	
	
	@Bean
	HeadersExchange headerExchange() {
		return new HeadersExchange("header-exchange");
	}

	@Bean
	Binding marketingBinding(Queue marketingQueue, HeadersExchange headerExchange) {
		return BindingBuilder.bind(marketingQueue).to(headerExchange).where("department").matches("marketing");
	}

	@Bean
	Binding financeBinding(Queue financeQueue, HeadersExchange headerExchange) {
		return BindingBuilder.bind(financeQueue).to(headerExchange).where("department").matches("finance");
	}

	@Bean
	Binding adminBinding(Queue adminQueue, HeadersExchange headerExchange) {
		return BindingBuilder.bind(adminQueue).to(headerExchange).where("department").matches("admin");
	}
}