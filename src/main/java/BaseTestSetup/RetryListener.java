package BaseTestSetup;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by ofirdahan on 3/3/17.
 */
public class RetryListener implements IAnnotationTransformer {

    public void transform(ITestAnnotation iTestAnnotation, Class aClass,
                          Constructor constructor, Method method) {

        IRetryAnalyzer retry = iTestAnnotation.getRetryAnalyzer();

        if(retry == null){
            iTestAnnotation.setRetryAnalyzer(Retry.class);
        }

    }
}
