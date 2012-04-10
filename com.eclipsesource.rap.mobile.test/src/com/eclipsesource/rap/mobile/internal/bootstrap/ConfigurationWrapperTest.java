/*******************************************************************************
 * Copyright (c) 2012 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    EclipseSource - initial API and implementation
 ******************************************************************************/
package com.eclipsesource.rap.mobile.internal.bootstrap;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.eclipse.rwt.application.ApplicationConfigurator;
import org.eclipse.rwt.internal.application.ApplicationConfigurationImpl;
import org.eclipse.rwt.internal.application.ApplicationContext;
import org.junit.Test;


@SuppressWarnings("restriction")
public class ConfigurationWrapperTest {
  
  @Test
  public void testCreatesWithRightContext() {
    ApplicationConfigurationImpl configuration = mock( ApplicationConfigurationImpl.class );
    ApplicationConfigurator configurator = mock( ApplicationConfigurator.class );
    
    new ConfigurationWrapper( configuration, configurator );
    
    verify( configuration ).getAdapter( eq( ApplicationContext.class ) );
  }
}