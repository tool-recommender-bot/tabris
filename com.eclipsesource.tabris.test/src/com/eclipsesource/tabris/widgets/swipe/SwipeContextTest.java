/*******************************************************************************
 * Copyright (c) 2013 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    EclipseSource - initial API and implementation
 ******************************************************************************/
package com.eclipsesource.tabris.widgets.swipe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;


public class SwipeContextTest {
  
  @Test
  public void testGetValue() {
    SwipeContext context = new SwipeContext();
    context.add( "foo", "bar" );
    
    assertEquals( "bar", context.get( "foo", String.class ) );
  }
  
  @Test( expected = IllegalArgumentException.class )
  public void testGetValueWithWrongType() {
    SwipeContext context = new SwipeContext();
    context.add( "foo", "bar" );
    
    context.get( "foo", Integer.class );
  }
  
  @Test
  public void testGetWithNonExistingKeyReturnsNull() {
    SwipeContext context = new SwipeContext();
    
    assertNull( context.get( "foo", String.class ) );
  }
}