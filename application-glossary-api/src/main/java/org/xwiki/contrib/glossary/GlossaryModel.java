/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.contrib.glossary;

import java.util.Locale;
import java.util.Map;

import org.xwiki.component.annotation.Role;
import org.xwiki.model.reference.DocumentReference;
import org.xwiki.rendering.block.XDOM;

/**
 * The model for retrieving Glossary entries. The entries received will be used as a cache for the Glossary
 * transformation to speed up execution.
 *
 * @version $Id$
 * @since 0.3
 */
@Role
public interface GlossaryModel
{
    /**
     * Find all existing Glossary definition in the current wiki.
     *
     * @return the map containing the glossary entries with the index being the Glossary page name
     * @throws GlossaryException when an error happens when finding Glossary entries
     */
    Map<Locale, Map<String, DocumentReference>> getGlossaryEntries() throws GlossaryException;

    /**
     * @param entryReference the reference to the glossary entry for which to get the definition/content
     * @param locale the locale to be used when loading the entry
     * @return the parsed content
     * @throws GlossaryException in case of an error
     */
    XDOM getGlossaryContent(DocumentReference entryReference, Locale locale) throws GlossaryException;

    /**
     * @param entryReference the reference of the glossary entry
     * @return the glossary ID corresponding to the given reference
     */
    String getGlossaryId(DocumentReference entryReference);
}
