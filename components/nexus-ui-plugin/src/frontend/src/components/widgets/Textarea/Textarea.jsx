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
import classNames from 'classnames';
import PropTypes from 'prop-types';
import React from 'react';

import './Textarea.scss';

import FieldErrorMessage from '../FieldErrorMessage/FieldErrorMessage';

/**
 * @since 3.22
 */
export default function Textarea({isRequired, value, className, name, id, ...attrs}) {
  const isMissingRequiredValue = isRequired && !value;
  const classes = classNames('nxrm-textarea', className, {
    'missing-required-value': isMissingRequiredValue
  });
  return <>
    <textarea
        id={id || name}
        name={name}
        required={isRequired}
        value={value}
        className={classes}
        {...attrs}
    />
    {isMissingRequiredValue ? <FieldErrorMessage/> : null}
  </>;
}

Textarea.propTypes = {
  isRequired: PropTypes.bool
};
