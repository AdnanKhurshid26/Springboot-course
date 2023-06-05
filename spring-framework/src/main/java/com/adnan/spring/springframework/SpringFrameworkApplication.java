package com.adnan.spring.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.adnan.spring.springframework.game.GameRunner;


@SpringBootApplication
public class SpringFrameworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(SpringFrameworkApplication.class, args);

		//MarioGame,GameRunner
		GameRunner runner = context.getBean(GameRunner.class);
		
//		MarioGame game = new MarioGame();
		//SuperContraGame game = new SuperContraGame();
//		GameRunner runner = new GameRunner(game);
		
		runner.runGame();
	}

}
