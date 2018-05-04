
package pipeline.beam.io.jms;

import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.jms.ConnectionFactory;
import org.apache.beam.sdk.coders.Coder;
import org.joda.time.Duration;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_JmsIO_Read<T> extends NcJmsIO.Read<T> {

    private final ConnectionFactory connectionFactory;
    private final String queue;
    private final String topic;
    private final String username;
    private final String password;
    private final long maxNumRecords;
    private final Duration maxReadTime;
    private final NcJmsIO.MessageMapper<T> messageMapper;
    private final Coder<T> coder;

    private AutoValue_JmsIO_Read(
            @Nullable ConnectionFactory connectionFactory,
            @Nullable String queue,
            @Nullable String topic,
            @Nullable String username,
            @Nullable String password,
            long maxNumRecords,
            @Nullable Duration maxReadTime,
            @Nullable NcJmsIO.MessageMapper<T> messageMapper,
            @Nullable Coder<T> coder) {
        this.connectionFactory = connectionFactory;
        this.queue = queue;
        this.topic = topic;
        this.username = username;
        this.password = password;
        this.maxNumRecords = maxNumRecords;
        this.maxReadTime = maxReadTime;
        this.messageMapper = messageMapper;
        this.coder = coder;
    }

    @Nullable
    @Override
    ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    @Nullable
    @Override
    String getQueue() {
        return queue;
    }

    @Nullable
    @Override
    String getTopic() {
        return topic;
    }

    @Nullable
    @Override
    String getUsername() {
        return username;
    }

    @Nullable
    @Override
    String getPassword() {
        return password;
    }

    @Override
    long getMaxNumRecords() {
        return maxNumRecords;
    }

    @Nullable
    @Override
    Duration getMaxReadTime() {
        return maxReadTime;
    }

    @Nullable
    @Override
    NcJmsIO.MessageMapper<T> getMessageMapper() {
        return messageMapper;
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
        if (o instanceof NcJmsIO.Read) {
            NcJmsIO.Read<?> that = (NcJmsIO.Read<?>) o;
            return ((this.connectionFactory == null) ? (that.getConnectionFactory() == null) : this.connectionFactory.equals(that.getConnectionFactory()))
                    && ((this.queue == null) ? (that.getQueue() == null) : this.queue.equals(that.getQueue()))
                    && ((this.topic == null) ? (that.getTopic() == null) : this.topic.equals(that.getTopic()))
                    && ((this.username == null) ? (that.getUsername() == null) : this.username.equals(that.getUsername()))
                    && ((this.password == null) ? (that.getPassword() == null) : this.password.equals(that.getPassword()))
                    && (this.maxNumRecords == that.getMaxNumRecords())
                    && ((this.maxReadTime == null) ? (that.getMaxReadTime() == null) : this.maxReadTime.equals(that.getMaxReadTime()))
                    && ((this.messageMapper == null) ? (that.getMessageMapper() == null) : this.messageMapper.equals(that.getMessageMapper()))
                    && ((this.coder == null) ? (that.getCoder() == null) : this.coder.equals(that.getCoder()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= (connectionFactory == null) ? 0 : this.connectionFactory.hashCode();
        h *= 1000003;
        h ^= (queue == null) ? 0 : this.queue.hashCode();
        h *= 1000003;
        h ^= (topic == null) ? 0 : this.topic.hashCode();
        h *= 1000003;
        h ^= (username == null) ? 0 : this.username.hashCode();
        h *= 1000003;
        h ^= (password == null) ? 0 : this.password.hashCode();
        h *= 1000003;
        h ^= (int) ((this.maxNumRecords >>> 32) ^ this.maxNumRecords);
        h *= 1000003;
        h ^= (maxReadTime == null) ? 0 : this.maxReadTime.hashCode();
        h *= 1000003;
        h ^= (messageMapper == null) ? 0 : this.messageMapper.hashCode();
        h *= 1000003;
        h ^= (coder == null) ? 0 : this.coder.hashCode();
        return h;
    }

    @Override
    NcJmsIO.Read.Builder<T> builder() {
        return new Builder<T>(this);
    }

    static final class Builder<T> extends NcJmsIO.Read.Builder<T> {
        private ConnectionFactory connectionFactory;
        private String queue;
        private String topic;
        private String username;
        private String password;
        private Long maxNumRecords;
        private Duration maxReadTime;
        private NcJmsIO.MessageMapper<T> messageMapper;
        private Coder<T> coder;
        Builder() {
        }
        private Builder(NcJmsIO.Read<T> source) {
            this.connectionFactory = source.getConnectionFactory();
            this.queue = source.getQueue();
            this.topic = source.getTopic();
            this.username = source.getUsername();
            this.password = source.getPassword();
            this.maxNumRecords = source.getMaxNumRecords();
            this.maxReadTime = source.getMaxReadTime();
            this.messageMapper = source.getMessageMapper();
            this.coder = source.getCoder();
        }
        @Override
        NcJmsIO.Read.Builder<T> setConnectionFactory(@Nullable ConnectionFactory connectionFactory) {
            this.connectionFactory = connectionFactory;
            return this;
        }
        @Override
        NcJmsIO.Read.Builder<T> setQueue(@Nullable String queue) {
            this.queue = queue;
            return this;
        }
        @Override
        NcJmsIO.Read.Builder<T> setTopic(@Nullable String topic) {
            this.topic = topic;
            return this;
        }
        @Override
        NcJmsIO.Read.Builder<T> setUsername(@Nullable String username) {
            this.username = username;
            return this;
        }
        @Override
        NcJmsIO.Read.Builder<T> setPassword(@Nullable String password) {
            this.password = password;
            return this;
        }
        @Override
        NcJmsIO.Read.Builder<T> setMaxNumRecords(long maxNumRecords) {
            this.maxNumRecords = maxNumRecords;
            return this;
        }
        @Override
        NcJmsIO.Read.Builder<T> setMaxReadTime(@Nullable Duration maxReadTime) {
            this.maxReadTime = maxReadTime;
            return this;
        }
        @Override
        NcJmsIO.Read.Builder<T> setMessageMapper(@Nullable NcJmsIO.MessageMapper<T> messageMapper) {
            this.messageMapper = messageMapper;
            return this;
        }
        @Override
        NcJmsIO.Read.Builder<T> setCoder(@Nullable Coder<T> coder) {
            this.coder = coder;
            return this;
        }
        @Override
        NcJmsIO.Read<T> build() {
            String missing = "";
            if (this.maxNumRecords == null) {
                missing += " maxNumRecords";
            }
            if (!missing.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + missing);
            }
            return new AutoValue_JmsIO_Read<T>(
                    this.connectionFactory,
                    this.queue,
                    this.topic,
                    this.username,
                    this.password,
                    this.maxNumRecords,
                    this.maxReadTime,
                    this.messageMapper,
                    this.coder);
        }
    }

}
