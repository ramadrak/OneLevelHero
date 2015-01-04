package com.mygdx.game.desktop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.OneLevelHero;

@Configuration
@ComponentScan
public class SpringDesktopLauncher {

	@Bean
	public LwjglApplication lwjglApplicationConfiguration() {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		// 나중에 수정 요망
		config.title = "One Level Hero";
		config.width = 1280;

		config.height = 720;
		return new LwjglApplication(new OneLevelHero(), config);
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				SpringDesktopLauncher.class);

		LwjglApplication app = context.getBean(LwjglApplication.class);

	}
}
