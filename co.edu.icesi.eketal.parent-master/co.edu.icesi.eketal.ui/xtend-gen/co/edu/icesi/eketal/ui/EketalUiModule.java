/**
 * generated by Xtext 2.10.0
 */
package co.edu.icesi.eketal.ui;

import co.edu.icesi.eketal.ui.AbstractEketalUiModule;
import co.edu.icesi.eketal.ui.wizard.MavenProjectCreator;
import com.google.inject.Binder;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.builder.nature.NatureAddingEditorCallback;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback;
import org.eclipse.xtext.ui.wizard.IProjectCreator;

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class EketalUiModule extends AbstractEketalUiModule {
  @Override
  public void configure(final Binder binder) {
    super.configure(binder);
  }
  
  @Override
  public Class<? extends IProjectCreator> bindIProjectCreator() {
    return MavenProjectCreator.class;
  }
  
  @Override
  public Class<? extends IXtextEditorCallback> bindIXtextEditorCallback() {
    return NatureAddingEditorCallback.class;
  }
  
  public EketalUiModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
}
