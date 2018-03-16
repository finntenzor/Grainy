package indi.finntenzor.grainy.build;

import java.util.Set;
import java.util.TreeSet;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

public class ResourceProcessor extends AbstractProcessor {

	private Types typeUtils;
	private Elements elementUtils;
	private Filer filer;
	private Messager messager;

	@Override
	public synchronized void init(ProcessingEnvironment env) {
		super.init(env);
		elementUtils = env.getElementUtils();
		filer = env.getFiler();
		typeUtils = env.getTypeUtils();
		messager = env.getMessager();
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<String> getSupportedAnnotationTypes() {
		Set<String> types = new TreeSet<>();
		types.add(Resource.class.getCanonicalName());
		return super.getSupportedAnnotationTypes();
	}

	@Override
	public SourceVersion getSupportedSourceVersion() {
		// TODO Auto-generated method stub
		return super.getSupportedSourceVersion();
	}
}
