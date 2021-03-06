package com.mygdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.factory.StageFactory;
import com.mygdx.manager.SoundManager;
import com.mygdx.state.Assets;

public class MenuScreen implements Screen {
	private Stage stage;

	private static Music music;

	public MenuScreen() {

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();

	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		//stageManager.setStage("Hello");
		setMusic(Assets.mainMusic);
		getMusic().setVolume(Assets.musicVolume);
		SoundManager.getInstance().playMusic(getMusic());
		stage = new Stage();
		Assets.loadSize(stage);
		stage = StageFactory.getInstance().makeStage("main");

		Gdx.input.setInputProcessor(stage);

	}

	@Override
	public void hide() {

		stage.dispose();

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	public static Music getMusic() {
		return music;
	}

	public static void setMusic(Music music) {
		MenuScreen.music = music;
	}

}
