package com.exasol.adapter.document.files.connection;

/**
 * Connection properties for Azure Blob Storage.
 */
public class AbsConnectionProperties {
    private final String absStorageAccountConnectionString;
    private final String absContainerName;

    private AbsConnectionProperties(final Builder builder) {
        this.absStorageAccountConnectionString = builder.absStorageAccountConnectionString;
        this.absContainerName = builder.absContainerName;
    }

    /**
     * Creates builder to build {@link AbsConnectionProperties}.
     *
     * @return created builder
     */
    public static Builder builder() {
        return new Builder();
    }

    public String getAbsStorageAccountConnectionString() {
        return this.absStorageAccountConnectionString;
    }

    public String getAbsContainerName() {
        return this.absContainerName;
    }

    /**
     * Builder to build {@link AbsConnectionProperties}.
     */
    public static final class Builder {
        private String absStorageAccountConnectionString = null;
        private String absContainerName = null;

        private Builder() {
        }

        /**
         * Builder method for absStorageAccountConnectionString parameter.
         *
         * @param absStorageAccountConnectionString field to set
         * @return builder
         */
        public Builder absStorageAccountConnectionString(final String absStorageAccountConnectionString) {
            this.absStorageAccountConnectionString = absStorageAccountConnectionString;
            return this;
        }

        /**
         * Builder method for absContainerName parameter.
         *
         * @param absContainerName field to set
         * @return builder
         */
        public Builder absContainerName(final String absContainerName) {
            this.absContainerName = absContainerName;
            return this;
        }

        /**
         * Builder method of the builder.
         *
         * @return built class
         */
        public AbsConnectionProperties build() {
            return new AbsConnectionProperties(this);
        }
    }
}
