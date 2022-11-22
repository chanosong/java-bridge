package bridge;

public class GameController {
    private BridgeGame bridgeGame;
    private InputView inputView;
    private OutputView outputView;

    GameController() {
        inputView = new InputView();
        outputView = new OutputView();

    }

    private void simulate() {
        while (!bridgeGame.isOver()) {
            if (!bridgeGame.canMove(inputView.readMoving())) {
                break;
            }
            outputView.printMap(bridgeGame.bridgeMap.getBridgeMap());
        }
        outputView.printMap(bridgeGame.bridgeMap.getBridgeMap());
    }

    private void ending() {
        outputView.printResult(bridgeGame.bridgeMap.getBridgeMap(), bridgeGame.isOver(), bridgeGame.getCursor());
    }

    public void run() {
        bridgeGame = new BridgeGame(inputView.readBridgeSize());
        while (true) {
            simulate();
            if (inputView.readGameCommand().equals("Q")) {
                break;
            }
            bridgeGame.retry();
        }
        ending();
    }
}
