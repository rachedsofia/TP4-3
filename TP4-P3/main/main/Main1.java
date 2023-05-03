package main;

import javax.swing.SwingUtilities;

public class Main1 {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new Main1().start();
				} catch (Exception e) {
					// log exception...
					System.out.println(e);
				}
			}
		});
	}

	private void start() {
		new RadioCompetition();
	}
}
