package TestProjektStudent.gui;

import TestProjektStudent.controller.Controller;
import javafx.application.Application;
import TestProjektStudent.storage.Storage;

public class App {

	public static void main(String[] args) {
		Storage storage = new Storage();
		Controller.setStorage(storage);
		Controller.initStorage();

		Application.launch(StartVindue.class);
	}
}
