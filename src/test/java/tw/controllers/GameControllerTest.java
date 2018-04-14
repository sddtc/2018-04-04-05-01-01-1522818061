package tw.controllers;

import org.junit.Before;
import org.junit.Test;
import tw.commands.InputCommand;
import tw.core.Game;
import tw.views.GameView;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    private GameController gameController;
    private Game game;
    private GameView gameView;
    private InputCommand inputCommand;

    @Before
    public void setUp() throws Exception {
        game = mock(Game.class);
        gameView = mock(GameView.class);
        gameController = mock(GameController.class);
        inputCommand = mock(InputCommand.class);
    }

    @Test
    public void testCheckCoutinueShouldReturnTrue() throws IOException {
        gameController = new GameController(game, gameView);

        when(game.checkCoutinue()).thenReturn(true).thenReturn(false);
        gameController.play(inputCommand);

        verify(game, times(1)).guessHistory();
    }

    @Test
    public void testCheckContinueShouldReturnFalse() throws IOException {
        gameController = new GameController(game, gameView);

        when(game.checkCoutinue()).thenReturn(false);
        gameController.play(inputCommand);

        verify(gameView, times(1)).showGameStatus(game.checkStatus());
    }
}