package org.jboss.weld.environment.servlet.test.injection;



import static org.jboss.weld.environment.servlet.test.util.JettyDeployments.JETTY_ENV;
import static org.jboss.weld.environment.servlet.test.util.JettyDeployments.JETTY_WEB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class LookupTest extends LookupTestBase
{
   
   @Deployment
   public static WebArchive deployment()
   {
      return LookupTestBase.deployment().addAsWebResource(JETTY_ENV, "jetty-env.xml").addAsWebResource(JETTY_WEB, "jetty-web.xml");
   }
   
}
