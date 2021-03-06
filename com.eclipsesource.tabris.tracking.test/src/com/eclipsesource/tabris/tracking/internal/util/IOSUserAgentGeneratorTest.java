/*******************************************************************************
 * Copyright (c) 2014 EclipseSource and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: EclipseSource - initial API and
 * implementation
 ******************************************************************************/
package com.eclipsesource.tabris.tracking.internal.util;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

import com.eclipsesource.tabris.tracking.TrackingInfo;


public class IOSUserAgentGeneratorTest {

  private IOSUserAgentGenerator generator;

  @Before
  public void setUp() {
    generator = new IOSUserAgentGenerator();
  }

  @Test( expected = IllegalArgumentException.class )
  public void testFailsWithNullTrackingInfo() {
    generator.getUserAgent( null );
  }

  @Test( expected = IllegalStateException.class )
  public void testFailsWithNullDeviceModel() {
    TrackingInfo info = new TrackingInfo();
    info.setDeviceOsVersion( "foo" );
    info.setClientLocale( Locale.GERMAN );

    generator.getUserAgent( info );
  }

  @Test( expected = IllegalStateException.class )
  public void testFailsWithEmptyDeviceModel() {
    TrackingInfo info = new TrackingInfo();
    info.setDeviceModel( "" );
    info.setClientLocale( Locale.GERMAN );
    info.setDeviceOsVersion( "foo" );

    generator.getUserAgent( info );
  }

  @Test( expected = IllegalStateException.class )
  public void testFailsWithNullDeviceOsVersion() {
    TrackingInfo info = new TrackingInfo();
    info.setDeviceModel( "foo" );
    info.setClientLocale( Locale.GERMAN );

    generator.getUserAgent( info );
  }

  @Test( expected = IllegalStateException.class )
  public void testFailsWithEmptyDeviceOsVersion() {
    TrackingInfo info = new TrackingInfo();
    info.setDeviceOsVersion( "" );
    info.setDeviceModel( "foo" );
    info.setClientLocale( Locale.GERMAN );

    generator.getUserAgent( info );
  }

  @Test( expected = IllegalStateException.class )
  public void testFailsWithNullLocale() {
    TrackingInfo info = new TrackingInfo();
    info.setDeviceModel( "foo" );
    info.setDeviceOsVersion( "bar" );

    generator.getUserAgent( info );
  }

  @Test
  public void testGeneratesIOSUserAgent() {
    TrackingInfo info = new TrackingInfo();
    info.setDeviceModel( "foo" );
    info.setDeviceOsVersion( "bar" );
    info.setClientLocale( Locale.GERMAN );

    String userAgent = generator.getUserAgent( info );

    String expectedAgent = "Mozilla/5.0 (foo; U; CPU iPhone OS bar like Mac OS X; de ) AppleWebKit/532.9 (KHTML, like "
                           + "Gecko) Version/4.0.5 Mobile/8A293 Safari/6531.22.7";
    assertEquals( expectedAgent, userAgent );
  }
}
