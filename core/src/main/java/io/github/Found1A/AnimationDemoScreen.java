package io.github.Found1A;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class AnimationDemoScreen implements Screen {

    enum playerState {IDLE, RUNNING, JUMPING}

    private SpriteBatch batch;
    private OrthographicCamera camera;

    private Texture playerSheet, enemySheet, coinSheet;

    private Animation<TextureRegion> idleAnim, jumpAnim, runAnim;

    private Animation<TextureRegion> slimeAnim, coinAnim;

    private float stateTime = 0f;
    private playerState state = playerState.IDLE;
    private boolean facingRight = true;
    private float playerX = 100f, playerY = 100f;

    @Override
    public void show() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 640, 480);

        playerSheet = new Texture("player.png");
        TextureRegion[][] pGrid = TextureRegion.split(playerSheet, 64, 64);

        idleAnim = new Animation<>(0.2f, pGrid[0]);
        runAnim = new Animation<>(0.1f, pGrid[1]);
        jumpAnim = new Animation<>(0.15f, pGrid[2]);
    }

    @Override
    public void render(float delta) {
        stateTime += delta;

        TextureRegion playerFrame = idleAnim.getKeyFrame(stateTime, true);
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.15f, 1f);
        Gdx.gl.glClearColor(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        batch.draw(playerFrame, playerX, playerY);

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
