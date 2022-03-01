package com.exasol.adapter.document.files;

import com.exasol.adapter.document.connection.ConnectionPropertiesReader;
import com.exasol.adapter.document.documentfetcher.files.FileFinderFactory;
import com.exasol.adapter.document.documentfetcher.files.RemoteFileFinder;
import com.exasol.adapter.document.files.connection.AbsConnectionPropertiesReader;
import com.exasol.adapter.document.files.stringfilter.StringFilter;

/**
 * Factory for {@link AbsRemoteFileFinder}s.
 */
public class AbsFileFinderFactory implements FileFinderFactory {

    @Override
    public RemoteFileFinder getFinder(final StringFilter filePattern,
            final ConnectionPropertiesReader connectionInformation) {
        return new AbsRemoteFileFinder(filePattern, new AbsConnectionPropertiesReader().read(connectionInformation));
    }

    @Override
    public String getUserGuideUrl() {
        return AbsVsConstants.USER_GUIDE_URL;
    }
}
