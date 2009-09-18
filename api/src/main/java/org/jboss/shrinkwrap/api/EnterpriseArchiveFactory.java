/*
 * JBoss, Home of Professional Open Source
 * Copyright 2009, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.shrinkwrap.api;

import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;

/**
 * EnterpriseArchiveFactory
 * 
 * Factory used to create {@link EnterpriseArchive} instances. 
 * 
 * @author <a href="mailto:baileyje@gmail.com">John Bailey</a>
 * @version $Revision: $
 */
public abstract class EnterpriseArchiveFactory extends ArchiveFactory<EnterpriseArchive>
{

   //-------------------------------------------------------------------------------------||
   // Class Members ----------------------------------------------------------------------||
   //-------------------------------------------------------------------------------------||

   /**
    * Implementation type as a FQN to avoid direct compile-time dependency
    */
   private static final String IMPL_TYPE = "org.jboss.shrinkwrap.impl.base.EnterpriseArchiveFactoryImpl";

   /**
    * Instance of EnterpriseArchiveFactory implementation
    */
   private static EnterpriseArchiveFactory instance;

   //-------------------------------------------------------------------------------------||
   // Class Methods ----------------------------------------------------------------------||
   //-------------------------------------------------------------------------------------||

   /**
    * Creates a {@link EnterpriseArchive} instance with the provided name.
    * 
    * @param archiveName
    * @return EnterpriseArchive instance 
    * @throws IllegalArgumentException if the archiveName is not present
    */
   public static EnterpriseArchive create(String archiveName)
   {
      return getInstance().doCreate(archiveName);
   }

   /**
    * Return instance of the EnterpriseArchiveFactory
    * 
    * @return
    */
   private synchronized static EnterpriseArchiveFactory getInstance()
   {
      if (instance == null)
      {
         instance = createInstance(EnterpriseArchiveFactory.class, IMPL_TYPE);
      }
      return instance;
   }

}