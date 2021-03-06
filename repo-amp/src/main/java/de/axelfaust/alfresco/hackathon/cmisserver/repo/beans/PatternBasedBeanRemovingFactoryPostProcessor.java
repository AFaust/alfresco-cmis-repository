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
package de.axelfaust.alfresco.hackathon.cmisserver.repo.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.alfresco.util.ParameterCheck;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @author Axel Faust, <a href="http://www.prodyna.com">PRODYNA AG</a>
 */
public class PatternBasedBeanRemovingFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor
{

    protected List<String> excludeBeanNames = Collections.emptyList();

    protected String beanNamePattern;

    /**
     *
     * @param excludeBeanNames
     *            the excludeBeanNames to set
     */
    public void setExcludeBeanNames(final List<String> excludeBeanNames)
    {
        ParameterCheck.mandatoryCollection("excludeBeanNames", excludeBeanNames);

        this.excludeBeanNames = new ArrayList<String>(excludeBeanNames);
    }

    /**
     * @param beanNamePattern
     *            the beanNamePattern to set
     */
    public void setBeanNamePattern(final String beanNamePattern)
    {
        this.beanNamePattern = beanNamePattern;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void postProcessBeanDefinitionRegistry(final BeanDefinitionRegistry registry) throws BeansException
    {
        for (final String beanName : registry.getBeanDefinitionNames())
        {
            if (beanName.matches(this.beanNamePattern) && !this.excludeBeanNames.contains(beanName))
            {
                registry.removeBeanDefinition(beanName);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void postProcessBeanFactory(final ConfigurableListableBeanFactory beanFactory) throws BeansException
    {
        // NO-OP - all done in bean definition registry post processor
    }

}
