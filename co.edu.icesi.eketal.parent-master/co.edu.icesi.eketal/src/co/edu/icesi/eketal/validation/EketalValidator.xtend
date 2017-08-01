/*
 * generated by Xtext 2.9.2
 */
package co.edu.icesi.eketal.validation

import co.edu.icesi.eketal.eketal.Model
import java.util.ArrayList
import org.eclipse.xtext.validation.Check
import org.eclipse.emf.common.util.URI
import java.util.Arrays
import co.edu.icesi.eketal.eketal.EketalPackage
import co.edu.icesi.eketal.eketal.EventClass
import co.edu.icesi.eketal.eketal.Step
import java.util.TreeSet
import co.edu.icesi.eketal.eketal.Automaton
import co.edu.icesi.eketal.eketal.StateType
import co.edu.icesi.eketal.eketal.Host
import co.edu.icesi.eketal.eketal.Group
import java.net.URL
import java.net.MalformedURLException

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class EketalValidator extends AbstractEketalValidator {
	
	public static val INVALID_FILE_NAME = "eketal.issue.invalidFileName"
	public static val NON_CAPITAL_NAME = "eketal.issue.nonCapitalName"
	public static val DETERMINIST_AUTOMATON_DEFINITION = "eketal.issue.deterministAutomatonDefinition"
	public static val NO_INITIAL_STATE_FOUND = "eketal.issue.noInitialStateFound"
	public static val MANY_INITIAL_STATES_FOUND = "eketal.issue.manyInitialStatesFound"
	public static val NO_TRANSITIONS_FROM_INITIAL_STATE = "eketal.issue.noTransitionsFromInitialState"
	public static val NO_VALID_IP = "eketal.issue.noValidIpOnGroup"
	
	@Check
	def checkAutomatonDeterminism(Step step){
		val duplicate = step.transitions.groupBy[t|t.event].filter[e,l|l.size > 1]
		if (!duplicate.empty) {
			for(event:duplicate.keySet){
				error("The step '" + step.name + "' cannot have another transition with the same event as '" + event.name +
					"'", EketalPackage.Literals.STEP__TRANSITIONS, DETERMINIST_AUTOMATON_DEFINITION)
			}			
		}
	}
	
	@Check
	def checkAutomatonDeterminism(Group group){
		for(host:group.hosts){
			try {
				if(!(host.ip.equals("localhost")||host.ip.equals("jphost"))){
					var bytes = host.ip.split("\\.")
					for(byteIter:bytes){
						if(byteIter=='*'){							
							
						}else if(Integer.parseInt(byteIter)<0 || Integer.parseInt(byteIter)>255){
							error("The host '" + host+ "' cannot be resolved because their bytes must must be between 0<x<255 in '" + group.name +
								"'", EketalPackage.Literals.GROUP__NAME, NO_VALID_IP)							
						}
					}
					var URL test = new URL("http://"+host.ip)
				}
			} catch (MalformedURLException exception) {
				error("The host '" + host.ip+ "' cannot be resolved as a correct address in the group'" + group.name +
					"'", EketalPackage.Literals.GROUP__NAME, NO_VALID_IP)
			}catch(Exception e){
				
			}
		}
	}
	
	@Check
	def checkInitialState(Automaton automaton){
		val initialState = automaton.steps.filter[s | s.type==StateType.START]
		if(initialState.size==0){
			error("The automaton '" + automaton.name + "' must have an initial State '"+
					"'", EketalPackage.Literals.AUTOMATON__STEPS, NO_INITIAL_STATE_FOUND)
		}else if(initialState.size>1){
			for(state : initialState)
				error("The automaton '" + automaton.name + "' can only have one initial state '"+
					"'", EketalPackage.Literals.AUTOMATON__STEPS, MANY_INITIAL_STATES_FOUND)
		}else{
			for(state : initialState)
				if(state.transitions==null || state.transitions.empty){
					error("The automaton '" + automaton.name + "' must have at least one transition in his initial state '"+ state.name +
							"'", EketalPackage.Literals.AUTOMATON__STEPS, NO_TRANSITIONS_FROM_INITIAL_STATE)
				}			
		}
	}
	
	def fromURItoFQN(URI resourceURI) {
		// e.g., platform:/resource/<project>/<source-folder>/org/example/.../TypeDecl.pascani
		var segments = new ArrayList
		if (resourceURI.segments.size > 1) {
			// Remove the first 3 segments, and return the package and file segments
			segments.addAll(resourceURI.segmentsList.subList(3, resourceURI.segments.size - 1))
			// Remove file extension and add the last segment
			segments.add(resourceURI.lastSegment.substring(0, resourceURI.lastSegment.lastIndexOf(".")))
		} else if(resourceURI.lastSegment.contains(".")) {
			segments.add(resourceURI.lastSegment.substring(0, resourceURI.lastSegment.lastIndexOf(".")))
		} else {
			segments.add(resourceURI.lastSegment)
		}
		return segments.fold("", [r, t|if(r.isEmpty) t else r + "." + t])
	}
	
	@Check
	def checkMonitorStartsWithCapital(EventClass typeDecl) {
		if (!Character.isUpperCase(typeDecl.name.charAt(0))) {
			warning("Name should start with a capital", EketalPackage.Literals.EVENT_CLASS__NAME,
				NON_CAPITAL_NAME)
		}
	}
	
	@Check
	def checkTypeDeclarationNameMatchesPhysicalName(EventClass typeDecl) {
		// e.g., platform:/resource/<project>/<source-folder>/org/example/.../TypeDecl.pascani
		val URI = typeDecl.eResource.URI
		val fileName = URI.lastSegment.substring(0, URI.lastSegment.indexOf(URI.fileExtension) - 1)
		val isPublic = typeDecl.eContainer != null && typeDecl.eContainer instanceof Model

		if (isPublic && !fileName.equals(typeDecl.name)) {
			error("The declared type '" + typeDecl.name + "' does not match the corresponding file name '" + fileName +
				"'", EketalPackage.Literals.EVENT_CLASS__NAME, INVALID_FILE_NAME)
		}
	}
	
}
