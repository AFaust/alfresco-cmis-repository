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
package de.axelfaust.alfresco.hackathon.cmisserver.repo.service;

import java.util.Collections;
import java.util.List;

import org.alfresco.model.RenditionModel;
import org.alfresco.repo.ownable.impl.OwnableServiceImpl;
import org.alfresco.service.cmr.rendition.CompositeRenditionDefinition;
import org.alfresco.service.cmr.rendition.RenderCallback;
import org.alfresco.service.cmr.rendition.RenderingEngineDefinition;
import org.alfresco.service.cmr.rendition.RenditionDefinition;
import org.alfresco.service.cmr.rendition.RenditionService;
import org.alfresco.service.cmr.repository.ChildAssociationRef;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.repository.NodeService;
import org.alfresco.service.namespace.QName;
import org.alfresco.util.PropertyCheck;
import org.springframework.beans.factory.InitializingBean;

/**
 * This rendition service implementation exists solely to remove the actual rendition service without breaking the incorrect dependency the
 * {@link OwnableServiceImpl#setRenditionService(RenditionService) ownable service has on it}.
 *
 * @author Axel Faust
 */
public class NOOPRenditionServiceImpl implements RenditionService, InitializingBean
{

    protected NodeService nodeService;

    /**
     * @param nodeService
     *            the nodeService to set
     */
    public void setNodeService(final NodeService nodeService)
    {
        this.nodeService = nodeService;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void afterPropertiesSet()
    {
        PropertyCheck.mandatory(this, "nodeService", this.nodeService);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveRenditionDefinition(final RenditionDefinition renditionDefinition)
    {
        // NO-OP

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RenditionDefinition loadRenditionDefinition(final QName renditionName)
    {
        // NO-OP
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<RenditionDefinition> loadRenditionDefinitions()
    {
        // NO-OP
        return Collections.emptyList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<RenditionDefinition> loadRenditionDefinitions(final String renderingEngineName)
    {
        // NO-OP
        return Collections.emptyList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RenderingEngineDefinition getRenderingEngineDefinition(final String name)
    {
        // NO-OP
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<RenderingEngineDefinition> getRenderingEngineDefinitions()
    {
        // NO-OP
        return Collections.emptyList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RenditionDefinition createRenditionDefinition(final QName renditionName, final String renderingEngineName)
    {
        throw new UnsupportedOperationException("This is a no-op rendition service implementation");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CompositeRenditionDefinition createCompositeRenditionDefinition(final QName renditionName)
    {
        throw new UnsupportedOperationException("This is a no-op rendition service implementation");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ChildAssociationRef> getRenditions(final NodeRef node)
    {
        // NO-OP
        return Collections.emptyList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ChildAssociationRef> getRenditions(final NodeRef node, final String mimeTypePrefix)
    {
        // NO-OP
        return Collections.emptyList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChildAssociationRef getRenditionByName(final NodeRef node, final QName renditionName)
    {
        // NO-OP
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isRendition(final NodeRef node)
    {
        final boolean result;

        if (this.nodeService.exists(node))
        {
            result = this.nodeService.hasAspect(node, RenditionModel.ASPECT_RENDITION);
        }
        else
        {
            result = false;
        }

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChildAssociationRef getSourceNode(final NodeRef renditionNode)
    {
        // NO-OP
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChildAssociationRef render(final NodeRef sourceNode, final RenditionDefinition renditionDefinition)
    {
        throw new UnsupportedOperationException("This is a no-op rendition service implementation");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render(final NodeRef sourceNode, final RenditionDefinition renditionDefinition, final RenderCallback callback)
    {
        // NO-OP
        callback.handleFailedRendition(new UnsupportedOperationException("This is a no-op rendition service implementation"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChildAssociationRef render(final NodeRef sourceNode, final QName renditionDefinitionQName)
    {
        throw new UnsupportedOperationException("This is a no-op rendition service implementation");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render(final NodeRef sourceNode, final QName renditionDefinitionQName, final RenderCallback callback)
    {
        // NO-OP
        callback.handleFailedRendition(new UnsupportedOperationException("This is a no-op rendition service implementation"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cancelRenditions(final NodeRef sourceNode)
    {
        // NO-OP

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cancelRenditions(final NodeRef sourceNode, final String type)
    {
        // NO-OP

    }

}
