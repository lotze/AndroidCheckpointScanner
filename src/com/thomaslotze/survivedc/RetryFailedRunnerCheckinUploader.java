package com.thomaslotze.survivedc;

public class RetryFailedRunnerCheckinUploader implements Runnable {
	SelectCheckpoint mainApp;
	
	public RetryFailedRunnerCheckinUploader(SelectCheckpoint mainApp) {
		super();
		this.mainApp = mainApp;
	}

	@Override
	public void run() {
		while(true) {
			if (mainApp.hasWaitingRunners()) {
				mainApp.uploadWaitingRunners();
			}
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
			}
		}
	}

}
