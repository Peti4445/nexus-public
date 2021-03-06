/*
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) 2008-present Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package org.sonatype.nexus.repository.npm.internal.search.orient;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.sonatype.nexus.repository.npm.internal.NpmFormat;
import org.sonatype.nexus.repository.search.ComponentMetadataProducerExtension;
import org.sonatype.nexus.repository.search.DefaultComponentMetadataProducer;
import org.sonatype.nexus.repository.storage.Asset;
import org.sonatype.nexus.repository.storage.Component;

/**
 * Npm implementation of {@link DefaultComponentMetadataProducer}
 *
 * @since 3.14
 */
@Singleton
@Named(NpmFormat.NAME)
public class NpmComponentMetadataProducer
    extends DefaultComponentMetadataProducer
{
  @Inject
  public NpmComponentMetadataProducer(final Set<ComponentMetadataProducerExtension> extensions) {
    super(extensions);
  }

  @Override
  protected boolean isPrerelease(final Component component, final Iterable<Asset> assets) {
    return component.version().contains("-");
  }
}
