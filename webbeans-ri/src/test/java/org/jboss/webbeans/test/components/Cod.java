package org.jboss.webbeans.test.components;

import javax.webbeans.Named;
import javax.webbeans.Production;

import org.jboss.webbeans.test.annotations.Chunky;
import org.jboss.webbeans.test.annotations.Whitefish;

@Production
@Whitefish
@Chunky(realChunky=true)
@Named("whitefish")
public class Cod implements ScottishFish
{

}
