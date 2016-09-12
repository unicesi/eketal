/**
 * generated by Xtext 2.9.2
 */
package co.edu.icesi.eketal;

import co.edu.icesi.eketal.AbstractEketalRuntimeModule;
import co.edu.icesi.eketal.outputconfiguration.EketalOutputConfigurationProvider;
import co.edu.icesi.eketal.outputconfiguration.OutputConfigurationAwaredGenerator;
import co.edu.icesi.eketal.scoping.EketalScopeProvider;
import com.google.inject.Binder;
import com.google.inject.Singleton;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.linking.LinkingScopeProviderBinding;
import org.eclipse.xtext.scoping.IScopeProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
@SuppressWarnings("all")
public class EketalRuntimeModule extends AbstractEketalRuntimeModule {
  @Override
  public void configureLinkingIScopeProvider(final Binder binder) {
    AnnotatedBindingBuilder<IScopeProvider> _bind = binder.<IScopeProvider>bind(IScopeProvider.class);
    LinkedBindingBuilder<IScopeProvider> _annotatedWith = _bind.annotatedWith(LinkingScopeProviderBinding.class);
    _annotatedWith.to(EketalScopeProvider.class);
  }
  
  @Override
  public void configure(final Binder binder) {
    super.configure(binder);
    AnnotatedBindingBuilder<IOutputConfigurationProvider> _bind = binder.<IOutputConfigurationProvider>bind(IOutputConfigurationProvider.class);
    ScopedBindingBuilder _to = _bind.to(EketalOutputConfigurationProvider.class);
    _to.in(Singleton.class);
  }
  
  @Override
  public Class<? extends IGenerator> bindIGenerator() {
    return OutputConfigurationAwaredGenerator.class;
  }
  
  @Override
  public Class<? extends IScopeProvider> bindIScopeProvider() {
    return EketalScopeProvider.class;
  }
}
