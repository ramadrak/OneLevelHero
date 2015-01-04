package com.mygdx.game;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class OLHWithSpring {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				OLHWithSpring.class);

		OneLevelHero oneLevelHero = context.getBean(OneLevelHero.class);

		oneLevelHero.create();
	}
}
