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
import java.util.Hashtable
import co.edu.icesi.ketal.core.Expression
import org.jgroups.Message
import co.edu.icesi.eketal.eketal.Rc
import co.edu.icesi.eketal.eketal.Pos
import java.net.URL
import co.edu.icesi.eketal.eketal.JVarD
import java.net.MalformedURLException
import co.edu.icesi.eketal.eketal.Host
import java.util.regex.Pattern
import java.util.Collections

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

	public static String groupClassName = "_GroupsControl"
	public static String handlerClassName = "_EventHandler"
	public static String reaction = "_Reaction"

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

		if (implementation == null)
			return;

		var eventClass = element.typeDeclaration
		var eventClassGenerate = eventClass.toClass(eventClass.fullyQualifiedName)

//		eventClassGenerate.eAdapters.add(new OutputConfigurationAdapter(EketalOutputConfigurationProvider::ASPECTJ_OUTPUT))
		eventClassGenerate.eAdapters.add(new OutputConfigurationAdapter(IFileSystemAccess.DEFAULT_OUTPUT))

		acceptor.accept(eventClassGenerate) [
			println("línea 97 Inferrer")
		]

		/*
		 * Creates a class that contains the groups declared
		 */
		val groupsClass = element.typeDeclaration
		createGroupClass(acceptor, groupsClass)

		/*
		 * Collects all the automatons and creates an automaton for each one
		 */
		var automatons = element.typeDeclaration.declarations.filter(typeof(co.edu.icesi.eketal.eketal.Automaton));
		val eventsOfAutomaton = automatons.toInvertedMap [ a |
			val Set<String> steps = new TreeSet
			// steps.addAll(a.steps.toSet)//.forEach[s|s.transitions.forall[t|events.add(t.event.name)]]
			a.steps.forall[s|steps.add(a.name+":"+s.name)]
			return steps
		]

		var String nameAutomaton;
		for (declaracion : automatons) {
			// Debe ir con la ruta para el que compilador entienda que no es el objeto automáta de la libreria ketal, sino el elmento automata de la definicion del lenguaje (es decir, la producción)
			/*
			 * Creates the class with the singleton nature
			 */
			nameAutomaton = "co.edu.icesi.eketal.automaton." + declaracion.name.toFirstUpper

			acceptor.accept(declaracion.toClass(nameAutomaton)) [
				// superTypes+=entity.superType.cloneWithProxies
				val typeAutomaton = typeRef(it)
				superTypes += typeRef(Automaton)
				members += declaracion.toField("instance", typeAutomaton)[static = true]
				members += declaracion.toField("estados", typeRef(HashMap, typeRef(String), typeRef(State))) [
					static = true
					visibility = JvmVisibility::PUBLIC
					initializer = '''new «typeRef(HashMap)»<String, «typeRef(State)»>()'''
				]

				members += declaracion.toMethod("getInstance", typeRef(Automaton)) [
					static = true
					body = '''
						if(instance==null){
							//lista de estados finales
							«typeRef(Set, typeRef(State))» estadosFinales = new «typeRef(HashSet)»();
							//conjunto de transiciones
						   	«typeRef(Set, typeRef(Transition))» transitionSet = new «typeRef(HashSet)»();
							//map de expresiones con caracteres
						   	«typeRef(Hashtable, typeRef(Expression), typeRef(Character))» expressions = new «typeRef(Hashtable)»();
						   	«typeRef(State)» initial = initialize(transitionSet, estadosFinales, expressions);
							return new «typeAutomaton»(transitionSet, initial, estadosFinales, expressions);
						}else{
							return instance;						
						}
					'''
				]

				members += declaracion.toMethod("evaluate", typeRef(boolean)) [
//					annotations+=annotationRef(typeRef(Override).class)
					parameters += declaracion.toParameter("event", typeRef(Event))
					body = '''
						if(event instanceof «typeRef(NamedEvent)»){
						   			return super.evaluate(event);
						   		}
						   		return false;
					'''
				]

				members += declaracion.toConstructor [
					visibility = JvmVisibility::PRIVATE
					parameters += declaracion.toParameter("transitions", typeRef(Set, typeRef(Transition)))
					parameters += declaracion.toParameter("begin", typeRef(State))
					parameters += declaracion.toParameter("finalStates", typeRef(Set, typeRef(State)))
					parameters +=
						declaracion.toParameter("expressions",
							typeRef(Hashtable, typeRef(Expression), typeRef(Character)))
					body = '''
						super(transitions, begin, finalStates, expressions);
						initializeAutomaton();
						instance = this;
					'''
				]
				/*
				 * Creates the main method
				 */
				members += AutomatonInit(declaracion as co.edu.icesi.eketal.eketal.Automaton)
			]

		}

		/*
		 * Creates the class that contains the required reactions
		 */
		var reactions = element.typeDeclaration;
		createReactionClass(acceptor, reactions, eventsOfAutomaton)

		/*
		 * Creates the class that handles the control in the jgroups
		 */
		val handlerClass = element.typeDeclaration;
		createHandlerClass(acceptor, handlerClass, automatons.toSet)

	}

	def createReactionClass(IJvmDeclaredTypeAcceptor acceptor, EventClass reactions, Map automatonsMap) {
		acceptor.accept(reactions.toClass("co.edu.icesi.eketal.reaction." + reaction)) [
			val set = reactions.declarations.filter(typeof(Rc))
			val variables = reactions.declarations.filter(typeof(JVarD))
			if (!variables.isEmpty) {
				for (variable : variables) {
					members += reactions.toField(variable.name.toFirstLower, variable.type) [
						static = true
					]
				}
			}
			val after = new HashMap<String, String>()
			val before = new HashMap<String, String>()
			for (rc : set) {
				if (rc.automaton === null || rc.state === null)
					return
				var name = "reaction" + rc.automaton.name + rc.state.name
				members += reactions.toMethod(name, typeRef(void)) [
					static = true
					body = rc.body.body
//					printBody(event.body.body as XBlockExpression)
//						def printBody(XBlockExpression exp){
//						val body = NodeModelUtils.findActualNodeFor(exp)
//						return body.text
//					}
				]
				if (rc.pos == Pos.BEFORE) {
					before.put(rc.automaton.name +":"+ rc.state.name, name + "()")
				} else if (rc.pos == Pos.AFTER) {
					after.put(rc.automaton.name +":"+ rc.state.name, name + "()")
				}
			}
			members += reactions.toMethod("verifyBefore", typeRef(void)) [
				parameters += reactions.toParameter("automaton", typeRef(Automaton))
				static = true
				synchronized = true
				body = '''
					«IF !before.isEmpty»
						«typeRef(State)» actual = automaton.getCurrentState();
						«FOR state:before.keySet»	
							«FOR automaton:automatonsMap.keySet.map[a|a as co.edu.icesi.eketal.eketal.Automaton]»
								«IF (automatonsMap.get(automaton) as Set<String>).contains(state)»
									if(co.edu.icesi.eketal.automaton.«automaton.name.toFirstUpper».class.isInstance(automaton)){
										if(actual.equals(co.edu.icesi.eketal.automaton.«automaton.name.toFirstUpper».estados.get("«state.split(Pattern.quote(":")).get(1)»"))){
											«before.get(state)»;
										}
									}
								«ENDIF»
							«ENDFOR»								
						«ENDFOR»
						
					«ENDIF»
				'''
			]

			members += reactions.toMethod("verifyAfter", typeRef(void)) [
				static = true
				parameters += reactions.toParameter("automaton", typeRef(Automaton))
				body = '''
					«IF !after.isEmpty»
						«typeRef(State)» actual = automaton.getCurrentState();
						«FOR state:after.keySet»
							«FOR automaton:automatonsMap.keySet.map[a|a as co.edu.icesi.eketal.eketal.Automaton]»
								«IF automaton.steps.contains(state)»
									if(automaton.getClass().isAssignableFrom(co.edu.icesi.eketal.automaton.«automaton.name.toFirstUpper».class){
										if(actual.equals(co.edu.icesi.eketal.automaton.«automaton.name.toFirstUpper».estados.get("«state.split(Pattern.quote(":")).get(1)»"))){
											«after.get(state)»;
										}
									}
								«ENDIF»
							«ENDFOR»
						«ENDFOR»
					«ENDIF»
				'''
			]

		]
	}

	/*
	 * Also adds the Singleton nature
	 */
	def createHandlerClass(IJvmDeclaredTypeAcceptor acceptor, EventClass eventDefinitionClass, Set machines) {
		val automatons = machines.map[a|a as co.edu.icesi.eketal.eketal.Automaton].toSet
		acceptor.accept(eventDefinitionClass.toClass("co.edu.icesi.eketal.handlercontrol." + handlerClassName)) [
			// Implementación de la simulación Singleton
			members += eventDefinitionClass.toField("instance", typeRef(it)) [
				static = true
				initializer = '''new «co.edu.icesi.eketal.jvmmodel.EketalJvmModelInferrer.handlerClassName»()'''
			]

			members += eventDefinitionClass.toField("brokerMessageHandler", typeRef(BrokerMessageHandler)) [
				static = true
			]
			members += eventDefinitionClass.toField("eventBroker", typeRef(EventBroker)) [
				static = true
			]

			members += eventDefinitionClass.toConstructor [
				visibility = JvmVisibility.PRIVATE
				body = '''
					brokerMessageHandler = new «typeRef(ReceiverMessageHandler)»(){
						@Override
						public Object handle(«typeof(Event)» event, «typeof(Map)» metadata, «typeof(Message)» msg,
						    			«typeof(int)» typeOfMsgSent){
						    if(event.getLocalization().equals(eventBroker.getAsyncAddress())){
						    	return null;
						    }
						    
						    Set<URL> host = (Set<URL>) metadata.get("host");
						    if(!host.isEmpty()){
						    	if(!host.contains(eventBroker.getAsyncAddress())){
						    		return null;
						    	}
						    }
						    	    
							Object handle = super.handle(event, metadata, msg, typeOfMsgSent);
							«FOR nameAutomaton : automatons»
								«typeRef(Automaton)» automaton«nameAutomaton.name.toFirstUpper» = co.edu.icesi.eketal.automaton.«nameAutomaton.name.toFirstUpper».getInstance();
								if(!automaton«nameAutomaton.name.toFirstUpper».evaluate(event)){
									«typeRef(ReceiverMessageHandler)».getLogger().info("[Handle] Event not recognized by the automaton: «nameAutomaton.name.toFirstUpper»");
												//System.out.println("[Handle] Event not recognized by the automaton: «nameAutomaton.name.toFirstUpper»");
											}else{
												«typeRef(ReceiverMessageHandler)».getLogger().info("[Handle] Recognized event "+event+" in «nameAutomaton.name»");
												//System.out.println("[Handle] Recognized event "+event+" by automaton «nameAutomaton.name»");							
												co.edu.icesi.eketal.reaction.«reaction».verifyBefore(automaton«nameAutomaton.name.toFirstUpper»);					
												co.edu.icesi.eketal.reaction.«reaction».verifyAfter(automaton«nameAutomaton.name.toFirstUpper»);					
											}
							«ENDFOR»
							return handle;
						}
					};
					eventBroker = new «typeRef(JGroupsEventBroker)»("Eketal", brokerMessageHandler, true);
				'''
			// TODO automaton name
			// TODO if
			]

			members += eventDefinitionClass.toMethod("getInstance", typeRef(it)) [
				static = true
				body = '''
					if(instance==null)
						instance = new «co.edu.icesi.eketal.jvmmodel.EketalJvmModelInferrer.handlerClassName»();
					return instance;
				'''
			]
			// Aquí termina la definición sintética del Sigleton
			// TODO en este es el mulsticasSync o el Async?
			members += eventDefinitionClass.toMethod("multicast", typeRef(void)) [
				parameters += eventDefinitionClass.toParameter("evento", Event.typeRef)
				parameters += eventDefinitionClass.toParameter("map", Map.typeRef)
				static = false
				body = '''
					eventBroker.multicast(evento, map);
				'''
			]

			members += eventDefinitionClass.toMethod("getAsyncAddress", typeRef(URL)) [
				static = false
				body = '''
					«typeof(URL)» url = eventBroker.getAsyncAddress();
					if(url!=null){
						return url;
					}else{
						«typeRef(ReceiverMessageHandler)».getLogger().error("[Handle] Could not obtain JGroups ip Address for the async monitor");
						try{
							return new «URL»("http:127.0.0.1");
						}catch(«typeRef(MalformedURLException)» e){
							«typeRef(ReceiverMessageHandler)».getLogger().error("[Handle] "+e.getMessage());
							e.printStackTrace();
							return null;
						}
					}
				'''
			]

		// TODO Síncrono
		/* 
		 * members+=eventDefinitionClass.toField("ketalMessageHandler", typeRef(BrokerMessageHandler))[
		 * 	static = true
		 * 	initializer = '''new «typeRef(KetalMessageHandler)»()'''
		 * ]
		 * members+=eventDefinitionClass.toField("eventBrokerHandler", typeRef(EventBroker))[
		 * 	static = true
		 * 	initializer = '''new «typeRef(JGroupsEventBroker)»("Eketal", ketalMessageHandler)'''
		 * ]
		 * members+=eventDefinitionClass
		 * .toMethod("multicastSync", typeRef(void))[
		 * 	parameters+=eventDefinitionClass.toParameter("evento", Event.typeRef)
		 * 	parameters+=eventDefinitionClass.toParameter("map", Map.typeRef)
		 * 	static = false
		 * 	body='''
		 * 		eventBrokerHandler.multicastSync(evento, map);
		 * 	'''
		 * ]
		 * members+=eventDefinitionClass.toMethod("getEvents", typeRef(Vector))[
		 * 	parameters+=eventDefinitionClass.toParameter("evento", Event.typeRef)
		 * 	static = true
		 * 	body='''
		 * 		return ((((«typeRef(KetalMessageHandler)») ketalMessageHandler).getVectorEvents()));
		 * 	'''
		 * ]		
		 */
		]
	}

	def createGroupClass(IJvmDeclaredTypeAcceptor acceptor, EventClass claseGrupos) {
		acceptor.accept(claseGrupos.toClass("co.edu.icesi.eketal.groupsimpl." + groupClassName)) [
//			annotations+=annotationRef(Singleton)
			val grupos = new TreeSet()
			val function = [Host h|h.ip]
			claseGrupos.declarations.filter(typeof(Group)).forEach [
				grupos += "\"" + it.name + ":[" + it.hosts.join(",", function) + "]\""
			]

			if (!grupos.isEmpty) {
				members += claseGrupos.toField("SET_VALUES", typeRef("java.lang.String[]")) [
					static = true
					initializer = '''{«grupos.join(",")»}'''
				]
			}

			members += claseGrupos.toField("grupos", typeRef(Map, typeRef(String), typeRef(HashSet, typeRef(URL)))) [
				static = true
				initializer = '''initializeGroups()'''
			]

			members += claseGrupos.toMethod("initializeGroups", typeRef(Map)) [
				static = true
				body = '''
					«Map» retorno = «Collections».synchronizedMap(new «Hashtable»());
					for(«typeRef(String)» s : SET_VALUES){
						«typeRef(String)»[] keyValue = s.replace("]","").split(«typeRef(Pattern)».quote(":["));
						«typeRef(HashSet, typeRef(URL))» values = new «typeRef(HashSet)»();
						for(«typeRef(String)» ip : keyValue[1].split(",")){
							try{
								if(ip.equals("localhost")){
									co.edu.icesi.eketal.handlercontrol.«co.edu.icesi.eketal.jvmmodel.EketalJvmModelInferrer.handlerClassName» local = co.edu.icesi.eketal.handlercontrol.«co.edu.icesi.eketal.jvmmodel.EketalJvmModelInferrer.handlerClassName».getInstance();
									values.add(new «typeRef(URL)»("http://"+local.getAsyncAddress().getHost()));
								}else{
									values.add(new «typeRef(URL)»("http://"+ip));
								}
							}catch(«typeRef(Exception)» e){
								e.printStackTrace();
							}
						}
						retorno.put(keyValue[0],values);
					}
					
					return retorno;
				'''
			]

			members += claseGrupos.toConstructor[]

			members += claseGrupos.toMethod("addGroup", typeRef(void)) [
				parameters += claseGrupos.toParameter("newGrupo", String.typeRef)
				parameters += claseGrupos.toParameter("hosts", typeRef(Set, typeRef(URL)))
				static = true
				body = '''
					grupos.put(newGrupo, hosts);
				'''
			]

			members += claseGrupos.toMethod("removeGroup", typeRef(Boolean)) [
				parameters += claseGrupos.toParameter("grupoEliminar", String.typeRef)
				static = true
				body = '''
					return grupos.remove(grupoEliminar)!=null;
				'''
			]

			// TODO realizar el llamado para ver
			members += claseGrupos.toMethod("host", typeRef(HashSet, typeRef(URL))) [
				parameters += claseGrupos.toParameter("grupo", typeRef(String))
				static = true
				body = '''
					if(grupos.containsKey(grupo)){
				    	return grupos.get(grupo);
				    }else{
				    	return new HashSet<>();
				    }
				    return true;
				'''
			]

			members += claseGrupos.toMethod("on", typeRef(boolean)) [
				parameters +=
					claseGrupos.toParameter("nombreGrupo",
						typeRef(
							String))
				static = true
						body = '''
							if(grupos==null){
								return false;
							}
							co.edu.icesi.eketal.handlercontrol.«co.edu.icesi.eketal.jvmmodel.EketalJvmModelInferrer.handlerClassName» local = co.edu.icesi.eketal.handlercontrol.«co.edu.icesi.eketal.jvmmodel.EketalJvmModelInferrer.handlerClassName».getInstance();
							«typeRef(URL)» url = local.getAsyncAddress();
							«typeRef(boolean)» retorno = false;
							try{						
								retorno = grupos.get(nombreGrupo).contains(new «typeRef(URL)»("http://"+url.getHost()));
							}catch(«typeRef(Exception)» e){
								e.printStackTrace();
								retorno = false;
							}
							return retorno;
						'''
					]
				]
			}

			def AutomatonInit(co.edu.icesi.eketal.eketal.Automaton declaracion) {
				val method = declaracion.toMethod("initialize", typeRef(State)) [
					parameters += declaracion.toParameter("transitionSet", typeRef(Set, typeRef(Transition)))
					parameters += declaracion.toParameter("estadosFinales", typeRef(Set, typeRef(State)))
					parameters += declaracion.toParameter("expressions",
							typeRef(Hashtable, typeRef(Expression), typeRef(Character)))
					static = true
					visibility = JvmVisibility::PRIVATE
					body = '''
						//Relación evento caracter
						«typeRef(Map, typeRef(String), typeRef(Character))» mapping = new «typeRef(TreeMap, typeRef(String), typeRef(Character))»();
						//Estado inicial
						«typeRef(State)» inicial = null;
						
						int consecutivo = 65;
						«Character» caracter = (char)consecutivo;
						«String» nombreEvento = "";
						«String» estadoLlegada = "";
						
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
						return inicial;
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
		