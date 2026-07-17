package ca.senecacollege.application.workshop4and5.di;

import ca.senecacollege.application.workshop4and5.data.EmployeeRepository;
import ca.senecacollege.application.workshop4and5.data.ProjectRepository;
import ca.senecacollege.application.workshop4and5.services.AuthenticationService;
import ca.senecacollege.application.workshop4and5.services.ResourceService;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Central wiring for the application's object graph. Kept in one place so
 * repositories/services stay plain, framework-agnostic classes - none of
 * them import Guice themselves; only this module (and the @Inject
 * constructors it can see) knows about the DI framework.
 * <p>
 * Everything here is bound as a Singleton: there should be exactly one
 * ProjectRepository/EmployeeRepository backing the whole app (they hold the
 * "seeded" in-memory data), and the services that depend on them can safely
 * be shared too since they hold no per-request state.
 */
public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ProjectRepository.class).in(Singleton.class);
        bind(EmployeeRepository.class).in(Singleton.class);
        bind(AuthenticationService.class).in(Singleton.class);
        bind(ResourceService.class).in(Singleton.class);
    }
}
