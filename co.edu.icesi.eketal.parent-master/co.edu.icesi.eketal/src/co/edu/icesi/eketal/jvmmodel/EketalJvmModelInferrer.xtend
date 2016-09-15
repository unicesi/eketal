/*
 * generated by Xtext 2.9.2
 */
package co.edu.icesi.eketal.jvmmodel

import co.edu.icesi.eketal.eketal.Model
import com.google.inject.Inject
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import java.util.TreeMap
import java.util.Set
import org.eclipse.xtext.common.types.JvmVisibility
import co.edu.icesi.eketal.eketal.Group
import org.eclipse.xtext.common.types.JvmField
import java.util.HashSet
import co.edu.icesi.eketal.eketal.StateType
import co.edu.icesi.ketal.core.State
import co.edu.icesi.ketal.core.Event
import java.util.Map
import java.util.HashMap
import co.edu.icesi.ketal.core.Automaton
import co.edu.icesi.ketal.core.Transition
import co.edu.icesi.ketal.core.DefaultEqualsExpression
import java.util.TreeSet
import org.eclipse.xtext.naming.IQualifiedNameProvider
import co.edu.icesi.eketal.outputconfiguration.OutputConfigurationAdapter
import co.edu.icesi.ketal.core.NamedEvent
import org.eclipse.xtext.generator.IFileSystemAccess
import co.edu.icesi.eketal.eketal.EventClass
import co.edu.icesi.ketal.distribution.BrokerMessageHandler
import co.edu.icesi.ketal.distribution.ReceiverMessageHandler
import co.edu.icesi.ketal.distribution.EventBroker
import co.edu.icesi.ketal.distribution.transports.jgroups.JGroupsEventBroker
import co.edu.icesi.ketal.distribution.KetalMessageHandler
import java.util.Vector
import java.util.Hashtable
import co.edu.icesi.ketal.core.Expression

/**
 * <p>Infers a JVM model from the source model.</p> 
 *
 * <p>The JVM model should contain all elements that would appear in the Java code 
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>     
 */
class EketalJvmModelInferrer extends AbstractModelInferrer {

    /**
     * convenience API to build and initialize JVM types and their members.
     */
	@Inject extension JvmTypesBuilder

	@Inject extension IQualifiedNameProvider
		
	public static String groupClassName = "GroupsControl"
	public static String handlerClassName = "EventHandler"
		
	/**
	 * The dispatch method {@code infer} is called for each instance of the
	 * given element's type that is contained in a resource.
	 * 
	 * @param element
	 *            the model to create one or more
	 *            {@link org.eclipse.xtext.common.types.JvmDeclaredType declared
	 *            types} from.
	 * @param acceptor
	 *            each created
	 *            {@link org.eclipse.xtext.common.types.JvmDeclaredType type}
	 *            without a container should be passed to the acceptor in order
	 *            get attached to the current resource. The acceptor's
	 *            {@link IJvmDeclaredTypeAcceptor#accept(org.eclipse.xtext.common.types.JvmDeclaredType)
	 *            accept(..)} method takes the constructed empty type for the
	 *            pre-indexing phase. This one is further initialized in the
	 *            indexing phase using the closure you pass to the returned
	 *            {@link org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor.IPostIndexingInitializing#initializeLater(org.eclipse.xtext.xbase.lib.Procedures.Procedure1)
	 *            initializeLater(..)}.
	 * @param isPreIndexingPhase
	 *            whether the method is called in a pre-indexing phase, i.e.
	 *            when the global index is not yet fully updated. You must not
	 *            rely on linking using the index if isPreIndexingPhase is
	 *            <code>true</code>.
	 */
	def dispatch void infer(Model element, IJvmDeclaredTypeAcceptor acceptor, boolean isPreIndexingPhase) {
		// Here you explain how your model is mapped to Java elements, by writing the actual translation code.
//		println("Inferring model for " + element.name)
		
		val implementation = element.toClass(element.fullyQualifiedName)
		
		if(implementation==null)
			return;
		
		var eventClass = element.typeDeclaration
		var eventClassGenerate = eventClass.toClass(eventClass.fullyQualifiedName)
		
//		eventClassGenerate.eAdapters.add(new OutputConfigurationAdapter(EketalOutputConfigurationProvider::ASPECTJ_OUTPUT))
		eventClassGenerate.eAdapters.add(new OutputConfigurationAdapter(IFileSystemAccess.DEFAULT_OUTPUT))

		acceptor.accept(eventClassGenerate)[
			println("línea 97 Inferrer")
		]
		
		/*
		 * Creates the class that handles the control in the jgroups
		 */
		val handlerClass = element.typeDeclaration;
		createHandlerClass(acceptor, handlerClass)
		
		/*
		 * Creates a class that contains the groups declared
		 */
		val groupsClass = element.typeDeclaration
		createGroupClass(acceptor, groupsClass)
		
		/*
		 * Navigates for the declarations looking for automatons
		 */
		var declarations = element.typeDeclaration.declarations
		for(declaracion:declarations){
			switch(declaracion){
				co.edu.icesi.eketal.eketal.Automaton:{//Debe ir con la ruta para el que compilador entienda que no es el objeto automáta de la libreria ketal, sino el elmento automata de la definicion del lenguaje (es decir, la producción)
					/*
					 * Creates the class with the singleton nature
					 */
					acceptor.accept(declaracion.toClass("co.edu.icesi.eketal.automaton."+declaracion.name.toFirstUpper)) [
					 	//superTypes+=entity.superType.cloneWithProxies
//					 	superTypes+=typeRef(Automaton)
						members+=declaracion.toField("instance", typeRef(Automaton))[static = true]
						members+=declaracion.toField("estados", typeRef(Map, typeRef(String), typeRef(State)))[
							static = true
							visibility = JvmVisibility::PUBLIC
							initializer = '''new «typeRef(HashMap)»<String, «typeRef(State)»>()'''
						]
						
						members+=declaracion.toMethod("getInstance", typeRef(Automaton))[
							static = true
							body = '''
							if(instance==null)
								new «declaracion.name.toFirstUpper»();
							return instance;
							'''
						]
						members+=declaracion.toConstructor[
							visibility = JvmVisibility::PRIVATE
							body = '''
							initialize();
							'''
						]
						/*
						 * Creates the main method
						 */
						members += AutomatonInit(declaracion as co.edu.icesi.eketal.eketal.Automaton)
					]	
				}
//				EvDecl:{
//					acceptor.accept(declaracion.toClass("co.edu.icesi.eketal.multicast."+declaracion.name.toFirstUpper)) [
//						members+=declaracion.toField("brokerMessageHandler", typeRef(BrokerMessageHandler))[
//							static = true
//							initializer = '''new «typeRef(ReceiverMessageHandler)»()'''
//						]
//						members+=declaracion.toField("eventBroker", typeRef(EventBroker))[
//							static = true
//							initializer = '''new «typeRef(JGroupsEventBroker)»("", brokerMessageHandler)'''
//						]
//						
//						//TODO en este es el mulsticasSync o el Async?
//						members+=declaracion.toMethod("multicast", typeRef(void))[
//							parameters+=declaracion.toParameter("evento", Event.typeRef)
//							static = true
//							body='''
//								eventBroker.multicastSync(evento, null);
//							'''
//						]
//						
//						members+=declaracion.toField("ketalMessageHandler", typeRef(BrokerMessageHandler))[
//							static = true
//							initializer = '''new «typeRef(KetalMessageHandler)»()'''
//						]
//						members+=declaracion.toField("eventBrokerHandler", typeRef(EventBroker))[
//							static = true
//							initializer = '''new «typeRef(JGroupsEventBroker)»("", ketalMessageHandler)'''
//						]
//						members+=declaracion.toMethod("getEvents", typeRef(Vector))[
//							parameters+=declaracion.toParameter("evento", Event.typeRef)
//							static = true
//							body='''
//								return ((((«typeRef(KetalMessageHandler)») ketalMessageHandler).getVectorEvents()));
//							'''
//						]
//					]
//				}
			}
		}
		
	}
	
	/*
	 * Also adds the Singleton nature
	 */
	def createHandlerClass(IJvmDeclaredTypeAcceptor acceptor, EventClass eventDefinitionClass) {
		acceptor.accept(eventDefinitionClass.toClass("co.edu.icesi.eketal.handlercontrol."+handlerClassName)) [
			//Implementación de la simulación Singleton
			members+=eventDefinitionClass.toField("instance", typeRef(it))[
				static = true
				initializer = '''new «co.edu.icesi.eketal.jvmmodel.EketalJvmModelInferrer.handlerClassName»()'''
			]
			
			members+=eventDefinitionClass.toField("brokerMessageHandler", typeRef(BrokerMessageHandler))[
				static = true
			]
			members+=eventDefinitionClass.toField("eventBroker", typeRef(EventBroker))[
				static = true
			]
			
			members+=eventDefinitionClass.toConstructor[
				visibility = JvmVisibility.PRIVATE
				body = 
				'''
				brokerMessageHandler = new «typeRef(ReceiverMessageHandler)»();
				eventBroker = new «typeRef(JGroupsEventBroker)»("Eketal", brokerMessageHandler);
				'''
			]
			
			members+=eventDefinitionClass.toMethod("getInstance", typeRef(it))[
				static = true
				body = '''
				if(instance==null)
					instance = new «co.edu.icesi.eketal.jvmmodel.EketalJvmModelInferrer.handlerClassName»();
				return instance;
				'''
			]
			//Aquí termina la definición sintética del Sigleton
			
			//TODO en este es el mulsticasSync o el Async?
			members+=eventDefinitionClass.toMethod("multicast", typeRef(void))[
				parameters+=eventDefinitionClass.toParameter("evento", Event.typeRef)
				parameters+=eventDefinitionClass.toParameter("map", Map.typeRef)
				static = false
				body='''
					eventBroker.multicast(evento, map);
				'''
			]
			//TODO Síncrono
			members+=eventDefinitionClass.toField("ketalMessageHandler", typeRef(BrokerMessageHandler))[
				static = true
				initializer = '''new «typeRef(KetalMessageHandler)»()'''
			]
			members+=eventDefinitionClass.toField("eventBrokerHandler", typeRef(EventBroker))[
				static = true
				initializer = '''new «typeRef(JGroupsEventBroker)»("Eketal", ketalMessageHandler)'''
			]
			members+=eventDefinitionClass
			.toMethod("multicastSync", typeRef(void))[
				parameters+=eventDefinitionClass.toParameter("evento", Event.typeRef)
				parameters+=eventDefinitionClass.toParameter("map", Map.typeRef)
				static = false
				body='''
					eventBrokerHandler.multicastSync(evento, map);
				'''
			]
			members+=eventDefinitionClass.toMethod("getEvents", typeRef(Vector))[
				parameters+=eventDefinitionClass.toParameter("evento", Event.typeRef)
				static = true
				body='''
					return ((((«typeRef(KetalMessageHandler)») ketalMessageHandler).getVectorEvents()));
				'''
			]		
			
		]
	}
	
	def createGroupClass(IJvmDeclaredTypeAcceptor acceptor, EventClass claseGrupos) {
		acceptor.accept(claseGrupos.toClass("co.edu.icesi.eketal.groupsimpl."+groupClassName)) [
//			annotations+=annotationRef(Singleton)
			members+=claseGrupos.toField("grupos", typeRef(Set))[
				static = true
				initializer = '''new «typeRef(TreeSet)»<«typeRef(String)»>()'''
			]
			
			members+=claseGrupos.toConstructor[
				body='''agregarGrupos();'''
			]
			members+=claseGrupos.toMethod("addGroup", typeRef(Boolean))[
				parameters+=claseGrupos.toParameter("nuevoGrupo", String.typeRef)
				static = true
				body='''
					return grupos.add(nuevoGrupo);
				'''
			]
			
			members+=claseGrupos.toMethod("removeGroup", typeRef(Boolean))[
				parameters+=claseGrupos.toParameter("grupoEliminar", String.typeRef)
				static = true
				body='''
					return grupos.remove(grupoEliminar);
				'''
			]
			
			members+=claseGrupos.toMethod("agregarGrupos", typeRef(void))[
				body='''
				«FOR grupo:claseGrupos.declarations»
					«IF grupo instanceof Group»
						«var grupoTemp = grupo as Group»
						addGroup("«grupoTemp.name»");
					«ENDIF»
				«ENDFOR»
				'''
			]
			
			//TODO realizar el llamado para ver
			members+=claseGrupos.toMethod("on", typeRef(boolean))[
				parameters+=claseGrupos.toParameter("grupo", typeRef(String))
				static = true
				body='''
					return true;
				'''
			]
			
			members+=claseGrupos.toMethod("host", typeRef(boolean))[
				parameters+=claseGrupos.toParameter("nombreGrupo", typeRef(String))
				static = true
				body='''
					if(grupos==null){
						return false;
					}
					return grupos.contains(nombreGrupo);
				'''
			]
		]
	}
	
	def AutomatonInit(co.edu.icesi.eketal.eketal.Automaton declaracion) {
		val method = declaracion.toMethod("initialize", typeRef(void))[
		visibility = JvmVisibility::PRIVATE
		body = '''
		//Relación evento caracter
		«typeRef(Map)»<String, Character> mapping = new «typeRef(TreeMap)»<String, Character>();
		//Estado inicial
		«typeRef(State)» inicial = null;
		//lista de estados finales
		«typeRef(Set)»<«typeRef(State)»> estadosFinales = new «typeRef(HashSet)»();
		
		//conjunto de transiciones
		«typeRef(HashSet)»<«typeRef(Transition)»> transitionSet = new «typeRef(HashSet)»();
		//map de expresiones con caracteres
		«typeRef(Hashtable)»<«typeRef(Expression)», «typeRef(Character)»> expressions = new «typeRef(Hashtable)»();
		
		int consecutivo = 65;
		Character caracter = (char)consecutivo;
		String nombreEvento = "";
		String estadoLlegada = "";
		
		«FOR step : declaracion.steps»
			//Definición del estado: «step.name»
			String estado«step.name.toFirstUpper» = "«step.name»";
			estados.put(estado«step.name.toFirstUpper», new «typeRef(State)»());
			«IF step.type!=null && step.type==StateType.START»
				//«step.type» «StateType.START» «StateType.START_VALUE»
				//Estado inicial: «step.name»
				inicial = estados.get(estado«step.name.toFirstUpper»);
			«ENDIF»
		«ENDFOR»
		«FOR step : declaracion.steps»	
			«IF !step.transitions.isEmpty»
				«FOR transition : step.transitions»
					//Transicion de «transition.event.name» -> «transition.target.name»
					estadoLlegada = "«transition.target.name»";
					if(!estados.containsKey(estadoLlegada)){
						estados.put(estado«step.name.toFirstUpper», new «typeRef(State)»());
					}
					caracter = (char)consecutivo;
					consecutivo++;
					nombreEvento = "«transition.event.name»";
					if(!mapping.containsKey(nombreEvento)){
						mapping.put(nombreEvento, caracter);
						expressions.put(new «DefaultEqualsExpression»(new «NamedEvent»(nombreEvento)), mapping.get(nombreEvento));
					}
					«typeRef(Transition)» «step.name»«transition.event.name.toFirstUpper» = new «typeRef(Transition)»(estados.get(estado«step.name.toFirstUpper»), estados.get(estadoLlegada), mapping.get(nombreEvento));
					transitionSet.add(«step.name»«transition.event.name.toFirstUpper»);
					
				«ENDFOR»
			«ENDIF»
			«IF step.type==StateType.END»
				//Estado final «step.name.toFirstUpper»
				estados.get(estado«step.name.toFirstUpper»).setAccept(true);
				estadosFinales.add(estados.get(estado«step.name.toFirstUpper»));
				
			«ENDIF»
		«ENDFOR»
		«typeRef(Automaton)» automata = new Automaton(transitionSet, inicial, estadosFinales, expressions);
		automata.initializeAutomaton();
		instance = automata;
		'''
		]
		return method
	}
	
//				members += automaton.toMethod("transiciones", typeRef(Set))[
//					abstract = true
//					static = true
//					visibility = JvmVisibility.PRIVATE
//					body = '''
//					return null;
//	   				'''
//				]
	
}