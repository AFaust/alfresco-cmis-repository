/*
 * Copyright 2015 Axel Faust
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 *
 * https://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package de.axelfaust.alfresco.hackathon.cmisserver.repo.transformer;

import org.alfresco.repo.content.transform.ContentTransformer;
import org.alfresco.repo.content.transform.TransformerConfig;
import org.alfresco.repo.content.transform.TransformerStatistics;
import org.alfresco.service.cmr.repository.TransformationOptionLimits;
import org.alfresco.service.cmr.repository.TransformationOptions;

/**
 * @author Axel Faust
 */
public class NOOPTransformerConfig implements TransformerConfig
{

    /**
     * {@inheritDoc}
     */
    @Override
    public String getProperty(final String name)
    {
        // NO-OP
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getProperties(final boolean changesOnly)
    {
        // NO-OP
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int removeProperties(final String propertyNames)
    {
        // NO-OP
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int setProperties(final String propertyNamesAndValues)
    {
        // NO-OP
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransformerStatistics getStatistics(final ContentTransformer transformer, final String sourceMimetype,
            final String targetMimetype, final boolean createNew)
    {
        // NO-OP
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TransformationOptionLimits getLimits(final ContentTransformer transformer, final String sourceMimetype,
            final String targetMimetype, final String use)
    {
        // NO-OP
        return new TransformationOptionLimits();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSupportedTransformation(final ContentTransformer transformer, final String sourceMimetype,
            final String targetMimetype, final TransformationOptions options)
    {
        // NO-OP
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPriority(final ContentTransformer contentTransformerHelper, final String sourceMimetype, final String targetMimetype)
    {
        // NO-OP
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getThresholdCount(final ContentTransformer contentTransformerHelper, final String sourceMimetype, final String targetMimetype)
    {
        // NO-OP
        return 0;
    }

}
