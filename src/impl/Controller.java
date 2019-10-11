package impl;

import java.io.IOException;

import bot_interface.Action;
import bot_interface.BotBase;
import bot_interface.GameState;

public class Controller extends BotBase {

	private int x = 0;
	public Action process(GameState gamestate) {
		gamestate.log(String.format("%.2f ", this.getPosy()) + this.getVely());
		x++;
		if (x == 5) {
			x++;
			return new Action(1, 0, 0, 0);
		} else if (x == 50) {
			x++;
			return new Action(-1, 0, 0, 0);
		} else return new Action(0, 0, 0, 0);
//		if ((int) this.getPosy() > 0 && this.getVely() >= -9) return new Action(1, 0, 0, 0);
//		if ((int) this.getPosy() < 0 && this.getVely() <= 9) return new Action(-1, 0, 0, 0);
//		return new Action(0, 0, 0, 0);
	}

	public static void main(String[] args) throws IOException {
		GameState game = new GameState(new Controller());
		game.connect();
	}
}
