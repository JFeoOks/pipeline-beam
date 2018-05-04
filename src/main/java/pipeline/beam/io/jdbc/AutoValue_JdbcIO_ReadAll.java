
package pipeline.beam.io.jdbc;

import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.apache.beam.sdk.coders.Coder;
import org.apache.beam.sdk.options.ValueProvider;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_JdbcIO_ReadAll<ParameterT, OutputT> extends NcJdbcIO.ReadAll<ParameterT, OutputT> {

    private final NcJdbcIO.DataSourceConfiguration dataSourceConfiguration;
    private final ValueProvider<String> query;
    private final NcJdbcIO.PreparedStatementSetter<ParameterT> parameterSetter;
    private final NcJdbcIO.RowMapper<OutputT> rowMapper;
    private final Coder<OutputT> coder;

    private AutoValue_JdbcIO_ReadAll(
            @Nullable NcJdbcIO.DataSourceConfiguration dataSourceConfiguration,
            @Nullable ValueProvider<String> query,
            @Nullable NcJdbcIO.PreparedStatementSetter<ParameterT> parameterSetter,
            @Nullable NcJdbcIO.RowMapper<OutputT> rowMapper,
            @Nullable Coder<OutputT> coder) {
        this.dataSourceConfiguration = dataSourceConfiguration;
        this.query = query;
        this.parameterSetter = parameterSetter;
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
    NcJdbcIO.PreparedStatementSetter<ParameterT> getParameterSetter() {
        return parameterSetter;
    }

    @Nullable
    @Override
    NcJdbcIO.RowMapper<OutputT> getRowMapper() {
        return rowMapper;
    }

    @Nullable
    @Override
    Coder<OutputT> getCoder() {
        return coder;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof NcJdbcIO.ReadAll) {
            NcJdbcIO.ReadAll<?, ?> that = (NcJdbcIO.ReadAll<?, ?>) o;
            return ((this.dataSourceConfiguration == null) ? (that.getDataSourceConfiguration() == null) : this.dataSourceConfiguration.equals(that.getDataSourceConfiguration()))
                    && ((this.query == null) ? (that.getQuery() == null) : this.query.equals(that.getQuery()))
                    && ((this.parameterSetter == null) ? (that.getParameterSetter() == null) : this.parameterSetter.equals(that.getParameterSetter()))
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
        h ^= (parameterSetter == null) ? 0 : this.parameterSetter.hashCode();
        h *= 1000003;
        h ^= (rowMapper == null) ? 0 : this.rowMapper.hashCode();
        h *= 1000003;
        h ^= (coder == null) ? 0 : this.coder.hashCode();
        return h;
    }

    @Override
    NcJdbcIO.ReadAll.Builder<ParameterT, OutputT> toBuilder() {
        return new Builder<ParameterT, OutputT>(this);
    }

    static final class Builder<ParameterT, OutputT> extends NcJdbcIO.ReadAll.Builder<ParameterT, OutputT> {
        private NcJdbcIO.DataSourceConfiguration dataSourceConfiguration;
        private ValueProvider<String> query;
        private NcJdbcIO.PreparedStatementSetter<ParameterT> parameterSetter;
        private NcJdbcIO.RowMapper<OutputT> rowMapper;
        private Coder<OutputT> coder;
        Builder() {
        }
        private Builder(NcJdbcIO.ReadAll<ParameterT, OutputT> source) {
            this.dataSourceConfiguration = source.getDataSourceConfiguration();
            this.query = source.getQuery();
            this.parameterSetter = source.getParameterSetter();
            this.rowMapper = source.getRowMapper();
            this.coder = source.getCoder();
        }
        @Override
        NcJdbcIO.ReadAll.Builder<ParameterT, OutputT> setDataSourceConfiguration(@Nullable NcJdbcIO.DataSourceConfiguration dataSourceConfiguration) {
            this.dataSourceConfiguration = dataSourceConfiguration;
            return this;
        }
        @Override
        NcJdbcIO.ReadAll.Builder<ParameterT, OutputT> setQuery(@Nullable ValueProvider<String> query) {
            this.query = query;
            return this;
        }
        @Override
        NcJdbcIO.ReadAll.Builder<ParameterT, OutputT> setParameterSetter(@Nullable NcJdbcIO.PreparedStatementSetter<ParameterT> parameterSetter) {
            this.parameterSetter = parameterSetter;
            return this;
        }
        @Override
        NcJdbcIO.ReadAll.Builder<ParameterT, OutputT> setRowMapper(@Nullable NcJdbcIO.RowMapper<OutputT> rowMapper) {
            this.rowMapper = rowMapper;
            return this;
        }
        @Override
        NcJdbcIO.ReadAll.Builder<ParameterT, OutputT> setCoder(@Nullable Coder<OutputT> coder) {
            this.coder = coder;
            return this;
        }
        @Override
        NcJdbcIO.ReadAll<ParameterT, OutputT> build() {
            return new AutoValue_JdbcIO_ReadAll<ParameterT, OutputT>(
                    this.dataSourceConfiguration,
                    this.query,
                    this.parameterSetter,
                    this.rowMapper,
                    this.coder);
        }
    }

}
