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

import java.util.Map;

import org.alfresco.repo.content.transform.ContentTransformer;
import org.alfresco.service.cmr.repository.ContentIOException;
import org.alfresco.service.cmr.repository.ContentReader;
import org.alfresco.service.cmr.repository.ContentWriter;
import org.alfresco.service.cmr.repository.TransformationOptions;
import org.springframework.beans.factory.BeanNameAware;

/**
 * @author Axel Faust
 */
public class NOOPContentTransformer implements ContentTransformer, BeanNameAware
{
    protected String beanName;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBeanName(final String name)
    {
        this.beanName = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTransformable(final String sourceMimetype, final String targetMimetype, final TransformationOptions options)
    {
        // NO-OP
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTransformable(final String sourceMimetype, final long sourceSize, final String targetMimetype,
            final TransformationOptions options)
    {
        // NO-OP
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTransformableMimetype(final String sourceMimetype, final String targetMimetype, final TransformationOptions options)
    {
        // NO-OP
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTransformableSize(final String sourceMimetype, final long sourceSize, final String targetMimetype,
            final TransformationOptions options)
    {
        // NO-OP
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getComments(final boolean available)
    {
        return "NO-OP implementation";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getMaxSourceSizeKBytes(final String sourceMimetype, final String targetMimetype, final TransformationOptions options)
    {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isExplicitTransformation(final String sourceMimetype, final String targetMimetype, final TransformationOptions options)
    {
        // NO-OP
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getTransformationTime()
    {
        // NO-OP
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getTransformationTime(final String sourceMimetype, final String targetMimetype)
    {
        // NO-OP
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void transform(final ContentReader reader, final ContentWriter writer) throws ContentIOException
    {
        throw new ContentIOException("No-op transformer can't transform squat");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void transform(final ContentReader reader, final ContentWriter writer, final Map<String, Object> options)
            throws ContentIOException
    {
        throw new ContentIOException("No-op transformer can't transform squat");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void transform(final ContentReader reader, final ContentWriter contentWriter, final TransformationOptions options)
            throws ContentIOException
    {
        throw new ContentIOException("No-op transformer can't transform squat");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName()
    {
        return this.beanName;
    }

}
