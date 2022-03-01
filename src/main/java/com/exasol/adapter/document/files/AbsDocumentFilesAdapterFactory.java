package com.exasol.adapter.document.files;

import com.exasol.adapter.AdapterFactory;
import com.exasol.adapter.VirtualSchemaAdapter;
import com.exasol.adapter.document.DocumentAdapter;
import com.exasol.logging.VersionCollector;

/**
 * Factory for the ABS Virtual Schema adapter.
 * 
 * <p>
 * This factory is loaded via a service loader (resources/services/com.exasol.adapter.AdapterFactory).
 * </p>
 */
public class AbsDocumentFilesAdapterFactory implements AdapterFactory {
    /** Name of the adapter */
    public static final String ADAPTER_NAME = "AZURE_BLOB_STORAGE_DOCUMENT_FILES";

    @Override
    public VirtualSchemaAdapter createAdapter() {
        return new DocumentAdapter(new DocumentFilesAdapter(ADAPTER_NAME, new AbsFileFinderFactory()));
    }

    @Override
    public String getAdapterVersion() {
        final VersionCollector versionCollector = new VersionCollector(
                "META-INF/maven/com.exasol/azure-blob-storage-document-files-virtual-schema/pom.properties");
        return versionCollector.getVersionNumber();
    }

    @Override
    public String getAdapterName() {
        return ADAPTER_NAME;
    }
}
