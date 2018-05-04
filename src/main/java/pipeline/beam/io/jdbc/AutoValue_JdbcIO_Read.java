
package pipeline.beam.io.jdbc;

import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.apache.beam.sdk.coders.Coder;
import org.apache.beam.sdk.options.ValueProvider;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_JdbcIO_Read<T> extends NcJdbcIO.Read<T> {

    private final NcJdbcIO.DataSourceConfiguration dataSourceConfiguration;
    private final ValueProvider<String> query;
    private final NcJdbcIO.StatementPreparator statementPreparator;
    private final NcJdbcIO.RowMapper<T> rowMapper;
    private final Coder<T> coder;

    private AutoValue_JdbcIO_Read(
            @Nullable NcJdbcIO.DataSourceConfiguration dataSourceConfiguration,
            @Nullable ValueProvider<String> query,
            @Nullable NcJdbcIO.StatementPreparator statementPreparator,
            @Nullable NcJdbcIO.RowMapper<T> rowMapper,
            @Nullable Coder<T> coder) {
        this.dataSourceConfiguration = dataSourceConfiguration;
        this.query = query;
        this.statementPreparator = statementPreparator;
        this.rowMapper = rowMapper;
        this.coder = coder;
    }

    @Nullable
    @Override
    NcJdbcIO.DataSourceConfiguration getDataSourceConfiguration() {
        return dataSourceConfiguration;
    }

    @Nullable
    @Override
    ValueProvider<String> getQuery() {
        return query;
    }

    @Nullable
    @Override
    NcJdbcIO.StatementPreparator getStatementPreparator() {
        return statementPreparator;
    }

    @Nullable
    @Override
    NcJdbcIO.RowMapper<T> getRowMapper() {
        return rowMapper;
    }

    @Nullable
    @Override
    Coder<T> getCoder() {
        return coder;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof NcJdbcIO.Read) {
            NcJdbcIO.Read<?> that = (NcJdbcIO.Read<?>) o;
            return ((this.dataSourceConfiguration == null) ? (that.getDataSourceConfiguration() == null) : this.dataSourceConfiguration.equals(that.getDataSourceConfiguration()))
                    && ((this.query == null) ? (that.getQuery() == null) : this.query.equals(that.getQuery()))
                    && ((this.statementPreparator == null) ? (that.getStatementPreparator() == null) : this.statementPreparator.equals(that.getStatementPreparator()))
                    && ((this.rowMapper == null) ? (that.getRowMapper() == null) : this.rowMapper.equals(that.getRowMapper()))
                    && ((this.coder == null) ? (that.getCoder() == null) : this.coder.equals(that.getCoder()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= (dataSourceConfiguration == null) ? 0 : this.dataSourceConfiguration.hashCode();
        h *= 1000003;
        h ^= (query == null) ? 0 : this.query.hashCode();
        h *= 1000003;
        h ^= (statementPreparator == null) ? 0 : this.statementPreparator.hashCode();
        h *= 1000003;
        h ^= (rowMapper == null) ? 0 : this.rowMapper.hashCode();
        h *= 1000003;
        h ^= (coder == null) ? 0 : this.coder.hashCode();
        return h;
    }

    @Override
    NcJdbcIO.Read.Builder<T> toBuilder() {
        return new Builder<T>(this);
    }

    static final class Builder<T> extends NcJdbcIO.Read.Builder<T> {
        private NcJdbcIO.DataSourceConfiguration dataSourceConfiguration;
        private ValueProvider<String> query;
        private NcJdbcIO.StatementPreparator statementPreparator;
        private NcJdbcIO.RowMapper<T> rowMapper;
        private Coder<T> coder;
        Builder() {
        }
        private Builder(NcJdbcIO.Read<T> source) {
            this.dataSourceConfiguration = source.getDataSourceConfiguration();
            this.query = source.getQuery();
            this.statementPreparator = source.getStatementPreparator();
            this.rowMapper = source.getRowMapper();
            this.coder = source.getCoder();
        }
        @Override
        NcJdbcIO.Read.Builder<T> setDataSourceConfiguration(@Nullable NcJdbcIO.DataSourceConfiguration dataSourceConfiguration) {
            this.dataSourceConfiguration = dataSourceConfiguration;
            return this;
        }
        @Override
        NcJdbcIO.Read.Builder<T> setQuery(@Nullable ValueProvider<String> query) {
            this.query = query;
            return this;
        }
        @Override
        NcJdbcIO.Read.Builder<T> setStatementPreparator(@Nullable NcJdbcIO.StatementPreparator statementPreparator) {
            this.statementPreparator = statementPreparator;
            return this;
        }
        @Override
        NcJdbcIO.Read.Builder<T> setRowMapper(@Nullable NcJdbcIO.RowMapper<T> rowMapper) {
            this.rowMapper = rowMapper;
            return this;
        }
        @Override
        NcJdbcIO.Read.Builder<T> setCoder(@Nullable Coder<T> coder) {
            this.coder = coder;
            return this;
        }
        @Override
        NcJdbcIO.Read<T> build() {
            return new AutoValue_JdbcIO_Read<T>(
                    this.dataSourceConfiguration,
                    this.query,
                    this.statementPreparator,
                    this.rowMapper,
                    this.coder);
        }
    }

}
