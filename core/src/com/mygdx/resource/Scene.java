package com.mygdx.resource;

/*
 * Scene클래스는 GameScreen에서 벗어나 EventScreen에서 대화(이벤트)할 때 사용함. 
 */

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class Scene {
	// 신 진행 관련 변수
	int num;	// load한 Event(예 Prologue)의 scene 갯수
	public boolean isEnd;
	
	// 스크립트, 케릭터 레이아웃 관리 테이블
	Table table;
	
	// 스크립트
	Scripts scriptloader;
	Label script;
	String text;
	
	// 케릭터
	Characters characloader;
	Texture charactexture;
	Image character;
	
	// 배경
	Backgrounds bgloader;
	Texture bgtexture;
	SpriteBatch batch;

	String scene;
	
	// batch는 이미지 출력을 위해, table은 이미지와 텍스트 레이아웃을 위해
	public Scene(Table table, SpriteBatch batch) {
		isEnd = false;
		
		this.batch = batch;
		
		scriptloader = new Scripts(1);
		bgloader = new Backgrounds(1);
		characloader = new Characters(1);
		
		this.table = table;
	}
	
	// scene은 Prologue-scene-1과 같은 형식(Prologue와 숫자 바뀜)
	public void load(String scene) {
		this.scene = scene;
		
		// 신 갯수, 첫번째(Prologue)만 받아옴
		num = characloader.getNum(scene.split("-")[0]);
		
		// 배경 불러옴
		bgtexture = bgloader.BackgroundGetter(scene);
		
		// 텍스트 파싱
		text = scriptloader.ScriptGetter(scene);
		script = new Label(text, Assets.skin);
		//String str = "Prologue"+"-"+"scene"+"-"+"1";
		
		// 케릭터 불러옴
		charactexture = characloader.ImageGetter(scene);
		character = new Image(charactexture);
	}
	
	// 처음 시작
	public void start() {
		table.bottom();	// table 전체를 화면 아래로 쪽으로
		table.add(character);
		table.add(script);
	}

	// 신(scene)을 넘기기 위한 함수
	public void next() {
		// 이전 scene을 지움.
		clear(); 
		
		// table 전체를 화면 아래로 쪽으로
		table.bottom();
		
		String[] temp = scene.split("-");
		int now = Integer.parseInt(temp[2]);	// next를 호출하는 상황은 첫 화면에서 +1된 상황이므로
		
		System.out.println("1. "+now+" "+num);
		// 다음 신으로------------------------------
		if(isNext(now))
			now++;
		else 
			isEnd = true;
		String scenenum = String.valueOf(now);
		scene = temp[0]+"-"+temp[1]+"-"+scenenum;
		// ----------------------------------------
		System.out.println("2. "+now+" "+num);
		
		load(scene);
		
		table.add(character);
		table.add(script);
	}
	
	public boolean isNext(int i) {
		if(i<num)
			return true;
		else if(i==num)
			return false;
		else 
			return false;
	}

	// 배경 그림
	public void show() {
		batch.draw(bgtexture, 0, 0);
	}
	
	public void clear() {
		table.clear();
	}

}