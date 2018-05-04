
package pipeline.beam.io.jdbc;

import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_JdbcIO_Write<T> extends NcJdbcIO.Write<T> {

    private final NcJdbcIO.DataSourceConfiguration dataSourceConfiguration;
    private final String statement;
    private final long batchSize;
    private final NcJdbcIO.PreparedStatementSetter<T> preparedStatementSetter;
    private final NcJdbcIO.RetryStrategy retryStrategy;

    private AutoValue_JdbcIO_Write(
            @Nullable NcJdbcIO.DataSourceConfiguration dataSourceConfiguration,
            @Nullable String statement,
            long batchSize,
            @Nullable NcJdbcIO.PreparedStatementSetter<T> preparedStatementSetter,
            @Nullable NcJdbcIO.RetryStrategy retryStrategy) {
        this.dataSourceConfiguration = dataSourceConfiguration;
        this.statement = statement;
        this.batchSize = batchSize;
        this.preparedStatementSetter = preparedStatementSetter;
        this.retryStrategy = retryStrategy;
    }

    @Nullable
    @Override
    NcJdbcIO.DataSourceConfiguration getDataSourceConfiguration() {
        return dataSourceConfiguration;
    }

    @Nullable
    @Override
    String getStatement() {
        return statement;
    }

    @Override
    long getBatchSize() {
        return batchSize;
    }

    @Nullable
    @Override
    NcJdbcIO.PreparedStatementSetter<T> getPreparedStatementSetter() {
        return preparedStatementSetter;
    }

    @Nullable
    @Override
    NcJdbcIO.RetryStrategy getRetryStrategy() {
        return retryStrategy;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof NcJdbcIO.Write) {
            NcJdbcIO.Write<?> that = (NcJdbcIO.Write<?>) o;
            return ((this.dataSourceConfiguration == null) ? (that.getDataSourceConfiguration() == null) : this.dataSourceConfiguration.equals(that.getDataSourceConfiguration()))
                    && ((this.statement == null) ? (that.getStatement() == null) : this.statement.equals(that.getStatement()))
                    && (this.batchSize == that.getBatchSize())
                    && ((this.preparedStatementSetter == null) ? (that.getPreparedStatementSetter() == null) : this.preparedStatementSetter.equals(that.getPreparedStatementSetter()))
                    && ((this.retryStrategy == null) ? (that.getRetryStrategy() == null) : this.retryStrategy.equals(that.getRetryStrategy()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= (dataSourceConfiguration == null) ? 0 : this.dataSourceConfiguration.hashCode();
        h *= 1000003;
        h ^= (statement == null) ? 0 : this.statement.hashCode();
        h *= 1000003;
        h ^= (int) ((this.batchSize >>> 32) ^ this.batchSize);
        h *= 1000003;
        h ^= (preparedStatementSetter == null) ? 0 : this.preparedStatementSetter.hashCode();
        h *= 1000003;
        h ^= (retryStrategy == null) ? 0 : this.retryStrategy.hashCode();
        return h;
    }

    @Override
    NcJdbcIO.Write.Builder<T> toBuilder() {
        return new Builder<T>(this);
    }

    static final class Builder<T> extends NcJdbcIO.Write.Builder<T> {
        private NcJdbcIO.DataSourceConfiguration dataSourceConfiguration;
        private String statement;
        private Long batchSize;
        private NcJdbcIO.PreparedStatementSetter<T> preparedStatementSetter;
        private NcJdbcIO.RetryStrategy retryStrategy;
        Builder() {
        }
        private Builder(NcJdbcIO.Write<T> source) {
            this.dataSourceConfiguration = source.getDataSourceConfiguration();
            this.statement = source.getStatement();
            this.batchSize = source.getBatchSize();
            this.preparedStatementSetter = source.getPreparedStatementSetter();
            this.retryStrategy = source.getRetryStrategy();
        }
        @Override
        NcJdbcIO.Write.Builder<T> setDataSourceConfiguration(@Nullable NcJdbcIO.DataSourceConfiguration dataSourceConfiguration) {
            this.dataSourceConfiguration = dataSourceConfiguration;
            return this;
        }
        @Override
        NcJdbcIO.Write.Builder<T> setStatement(@Nullable String statement) {
            this.statement = statement;
            return this;
        }
        @Override
        NcJdbcIO.Write.Builder<T> setBatchSize(long batchSize) {
            this.batchSize = batchSize;
            return this;
        }
        @Override
        NcJdbcIO.Write.Builder<T> setPreparedStatementSetter(@Nullable NcJdbcIO.PreparedStatementSetter<T> preparedStatementSetter) {
            this.preparedStatementSetter = preparedStatementSetter;
            return this;
        }
        @Override
        NcJdbcIO.Write.Builder<T> setRetryStrategy(@Nullable NcJdbcIO.RetryStrategy retryStrategy) {
            this.retryStrategy = retryStrategy;
            return this;
        }
        @Override
        NcJdbcIO.Write<T> build() {
            String missing = "";
            if (this.batchSize == null) {
                missing += " batchSize";
            }
            if (!missing.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + missing);
            }
            return new AutoValue_JdbcIO_Write<T>(
                    this.dataSourceConfiguration,
                    this.statement,
                    this.batchSize,
                    this.preparedStatementSetter,
                    this.retryStrategy);
        }
    }

}
