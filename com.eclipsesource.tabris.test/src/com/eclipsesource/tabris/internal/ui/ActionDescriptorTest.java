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
package com.eclipsesource.tabris.internal.ui;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.io.InputStream;
import java.io.Serializable;

import org.junit.Rule;
import org.junit.Test;

import com.eclipsesource.tabris.test.util.TabrisEnvironment;
import com.eclipsesource.tabris.ui.Action;
import com.eclipsesource.tabris.ui.PlacementPriority;


public class ActionDescriptorTest {

  @Rule
  public TabrisEnvironment environment = new TabrisEnvironment();

  @Test
  public void testIsSerializable() {
    assertTrue( Serializable.class.isAssignableFrom( ActionDescriptor.class ) );
  }

  @Test
  public void testGetId() {
    ActionDescriptor descriptor = new ActionDescriptor( "foo", mock( Action.class ) );

    assertEquals( "foo", descriptor.getId() );
  }

  @Test
  public void testGetAction() {
    Action action = mock( Action.class );
    ActionDescriptor descriptor = new ActionDescriptor( "foo", action );

    assertSame( action, descriptor.getAction() );
  }

  @Test
  public void testIsVisible() {
    Action action = mock( Action.class );
    ActionDescriptor descriptor = new ActionDescriptor( "foo", action );

    descriptor.setVisible( true );

    assertTrue( descriptor.isVisible() );
  }

  @Test
  public void testSetVisibleReturnsActionDescriptor() {
    Action action = mock( Action.class );
    ActionDescriptor descriptor = new ActionDescriptor( "foo", action );

    ActionDescriptor actualDescriptor = descriptor.setVisible( true );

    assertSame( descriptor, actualDescriptor );
  }

  @Test
  public void testIsEnabled() {
    Action action = mock( Action.class );
    ActionDescriptor descriptor = new ActionDescriptor( "foo", action);

    descriptor.setEnabled( true );

    assertTrue( descriptor.isEnabled() );
  }

  @Test
  public void testSetEnabledReturnsDescriptor() {
    Action action = mock( Action.class );
    ActionDescriptor descriptor = new ActionDescriptor( "foo", action);

    ActionDescriptor actualDescriptor = descriptor.setEnabled( true );

    assertSame( descriptor, actualDescriptor );
  }

  @Test
  public void testGetTitle() {
    Action action = mock( Action.class );
    ActionDescriptor descriptor = new ActionDescriptor( "foo", action );

    descriptor.setTitle( "bar" );

    assertEquals( "bar", descriptor.getTitle() );
  }

  @Test
  public void testSetTitleReturnsDescriptor() {
    Action action = mock( Action.class );
    ActionDescriptor descriptor = new ActionDescriptor( "foo", action );

    ActionDescriptor actualDescriptor = descriptor.setTitle( "bar" );

    assertSame( descriptor, actualDescriptor );
  }

  @Test
  public void testGetImage() {
    Action action = mock( Action.class );
    InputStream image = ActionDescriptorTest.class.getResourceAsStream( "testImage.png" );
    ActionDescriptor descriptor = new ActionDescriptor( "foo", action );

    descriptor.setImage( ImageUtil.getBytes( image ) );

    assertArrayEquals( UITestUtil.getImageBytes(), descriptor.getImage() );
  }

  @Test
  public void testSetImageReturnsDescriptor() {
    Action action = mock( Action.class );
    InputStream image = ActionDescriptorTest.class.getResourceAsStream( "testImage.png" );
    ActionDescriptor descriptor = new ActionDescriptor( "foo", action );

    ActionDescriptor actualDescriptor = descriptor.setImage( ImageUtil.getBytes( image ) );

    assertSame( descriptor, actualDescriptor );
  }

  @Test
  public void testGetPlacementPriority() {
    Action action = mock( Action.class );
    ActionDescriptor descriptor = new ActionDescriptor( "foo", action );

    descriptor.setPlacementPrority( PlacementPriority.HIGH );

    assertSame( PlacementPriority.HIGH, descriptor.getPlacementPriority() );
  }

  @Test
  public void testSetPlacementPriorityReturnsDescriptor() {
    Action action = mock( Action.class );
    ActionDescriptor descriptor = new ActionDescriptor( "foo", action );

    ActionDescriptor actualDescriptor = descriptor.setPlacementPrority( PlacementPriority.HIGH );

    assertSame( descriptor, actualDescriptor );
  }

}
