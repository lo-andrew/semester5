package ca.senecacollege.application.utility;

import ca.senecacollege.application.repositories.ISceneRepository;
import ca.senecacollege.application.repositories.InMemorySceneRepo;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import javafx.stage.Stage;

public class AppModule extends AbstractModule {

    private Stage stage;

    public AppModule(Stage stage) {
        this.stage = stage;
    }

    @Override
    protected void configure() {

        //Bind Stage
        bind(Stage.class).toInstance(stage);

        //Bind repository
        bind(ISceneRepository.class).to(InMemorySceneRepo.class).in(Singleton.class);
    }
}
