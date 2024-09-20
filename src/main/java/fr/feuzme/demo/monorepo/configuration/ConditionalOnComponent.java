package fr.feuzme.demo.monorepo.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * This annotation is used on an input interface (Controller, Listener...)
 * to instanciate this class only if this component name match the annotation parameter
 * Usage example :
 *
 * @ConditionalOnComponent("foo-component-name") class FooController{
 * ...
 * }
 */

@Retention(RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Conditional(ConditionalOnComponent.OnComponentCondition.class)
public @interface ConditionalOnComponent {

    String[] value() default {};

    class OnComponentCondition extends SpringBootCondition {

        private static final String KEY = "component";

        @Override
        public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
            String propertyValue = context.getEnvironment().getProperty(KEY);
            if (propertyValue == null)
                return ConditionOutcome.noMatch("Property \"" + KEY + "\" not defined");

            MultiValueMap<String, Object> allAnnotationAttributes =
                    metadata.getAllAnnotationAttributes(ConditionalOnComponent.class.getName());
            List<Object> annotationValuesAttr = allAnnotationAttributes.get("value");
            if (annotationValuesAttr.size() != 1 || !(annotationValuesAttr.get(0) instanceof String[] annotationValues))
                throw new IllegalStateException("Error processing @" + ConditionalOnComponent.class.getSimpleName());

            if (!Arrays.asList(annotationValues).contains(propertyValue))
                return ConditionOutcome
                        .noMatch("Property \"" + KEY + "\" not found, or doesn't contain any of: " + Arrays.toString(annotationValues));

            return ConditionOutcome.match();
        }
    }
}

