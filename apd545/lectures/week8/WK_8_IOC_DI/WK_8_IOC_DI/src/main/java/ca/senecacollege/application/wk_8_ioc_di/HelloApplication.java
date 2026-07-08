package ca.senecacollege.application.wk_8_ioc_di;

import ca.senecacollege.application.controllers.MainController;
import ca.senecacollege.application.controllers.ViewOneController;
import ca.senecacollege.application.controllers.ViewThreeController;
import ca.senecacollege.application.controllers.ViewTwoController;
import ca.senecacollege.application.repositories.ISceneRepository;
import ca.senecacollege.application.utility.AppModule;
import ca.senecacollege.application.utility.SceneName;
import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Create Guice Injector
        Injector injector = Guice.createInjector(new AppModule(stage));

        //Get the ISceneRepository from Guice
        ISceneRepository sceneRepository = injector.getInstance(ISceneRepository.class);

        //Loading main view
        FXMLLoader mainLoader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml"));
        mainLoader.setControllerFactory(injector::getInstance);

        Scene scene = new Scene(mainLoader.load());
        MainController mainController = mainLoader.getController();
        sceneRepository.addScene(SceneName.MAIN, scene);

        //Saving Scene 1
        FXMLLoader oneLoader = new FXMLLoader(HelloApplication.class.getResource("view-one.fxml"));
        oneLoader.setControllerFactory(injector::getInstance);

        Scene oneScene = new Scene(oneLoader.load());
        ViewOneController viewOneController = oneLoader.getController();
        sceneRepository.addScene(SceneName.SCENE1, oneScene);

        //Saving Scene 2
        FXMLLoader twoLoader = new FXMLLoader(HelloApplication.class.getResource("view-two.fxml"));
        twoLoader.setControllerFactory(injector::getInstance);

        Scene twoScene = new Scene(twoLoader.load());
        ViewTwoController viewTwoController = twoLoader.getController();
        sceneRepository.addScene(SceneName.SCENE2, twoScene);

        //Saving Scene 3
        FXMLLoader threeLoader = new FXMLLoader(HelloApplication.class.getResource("view-three.fxml"));
        threeLoader.setControllerFactory(injector::getInstance);

        Scene threeScene = new Scene(threeLoader.load());
        ViewThreeController viewthreeController = threeLoader.getController();
        sceneRepository.addScene(SceneName.SCENE3, threeScene);

        stage.setTitle("Multi-Scene Demo with Guice -- IoC");
        stage.setScene(scene);
        stage.show();
    }
}
