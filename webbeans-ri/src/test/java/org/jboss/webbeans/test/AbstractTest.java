package org.jboss.webbeans.test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.webbeans.Production;
import javax.webbeans.Standard;

import org.jboss.webbeans.ManagerImpl;
import org.jboss.webbeans.introspector.AnnotatedType;
import org.jboss.webbeans.introspector.SimpleAnnotatedType;
import org.jboss.webbeans.model.StereotypeModel;
import org.jboss.webbeans.test.annotations.AnimalStereotype;
import org.jboss.webbeans.test.annotations.AnotherDeploymentType;
import org.jboss.webbeans.test.annotations.FishStereotype;
import org.jboss.webbeans.test.annotations.HornedAnimalDeploymentType;
import org.jboss.webbeans.test.annotations.HornedMammalStereotype;
import org.jboss.webbeans.test.annotations.MammalStereotype;
import org.jboss.webbeans.test.annotations.RequestScopedAnimalStereotype;
import org.jboss.webbeans.test.annotations.RiverFishStereotype;
import org.jboss.webbeans.test.mock.MockManagerImpl;
import org.testng.annotations.BeforeMethod;

public class AbstractTest
{
   
   protected ManagerImpl manager;

   
   @BeforeMethod
   public void before()
   {
      
      List<Class<? extends Annotation>> enabledDeploymentTypes = new ArrayList<Class<? extends Annotation>>();
      enabledDeploymentTypes.add(Standard.class);
      enabledDeploymentTypes.add(Production.class);
      enabledDeploymentTypes.add(AnotherDeploymentType.class);
      enabledDeploymentTypes.add(HornedAnimalDeploymentType.class);
      manager = new MockManagerImpl(enabledDeploymentTypes);
      
      initStereotypes(manager);
   }
   
   private void initStereotypes(ManagerImpl container)
   {
      container.getModelManager().addStereotype(new StereotypeModel<AnimalStereotype>(new SimpleAnnotatedType<AnimalStereotype>(AnimalStereotype.class)));
      container.getModelManager().addStereotype(new StereotypeModel<HornedMammalStereotype>(new SimpleAnnotatedType<HornedMammalStereotype>(HornedMammalStereotype.class)));
      container.getModelManager().addStereotype(new StereotypeModel<MammalStereotype>(new SimpleAnnotatedType<MammalStereotype>(MammalStereotype.class)));
      container.getModelManager().addStereotype(new StereotypeModel<FishStereotype>(new SimpleAnnotatedType<FishStereotype>(FishStereotype.class)));
      container.getModelManager().addStereotype(new StereotypeModel<RiverFishStereotype>(new SimpleAnnotatedType<RiverFishStereotype>(RiverFishStereotype.class)));
      container.getModelManager().addStereotype(new StereotypeModel<RequestScopedAnimalStereotype>(new SimpleAnnotatedType<RequestScopedAnimalStereotype>(RequestScopedAnimalStereotype.class)));
   }
   
   protected static <T> AnnotatedType<T> getEmptyAnnotatedItem(Class<T> type)
   {
      return new SimpleAnnotatedType<T>(type, new HashMap<Class<? extends Annotation>, Annotation>());
   }

}
