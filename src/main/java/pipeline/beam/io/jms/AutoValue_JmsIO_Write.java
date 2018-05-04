
package pipeline.beam.io.jms;

import javax.annotation.Generated;
import javax.annotation.Nullable;
import javax.jms.ConnectionFactory;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_JmsIO_Write extends NcJmsIO.Write {

    private final ConnectionFactory connectionFactory;
    private final String queue;
    private final String topic;
    private final String username;
    private final String password;

    private AutoValue_JmsIO_Write(
            @Nullable ConnectionFactory connectionFactory,
            @Nullable String queue,
            @Nullable String topic,
            @Nullable String username,
            @Nullable String password) {
        this.connectionFactory = connectionFactory;
        this.queue = queue;
        this.topic = topic;
        this.username = username;
        this.password = password;
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
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof NcJmsIO.Write) {
            NcJmsIO.Write that = (NcJmsIO.Write) o;
            return ((this.connectionFactory == null) ? (that.getConnectionFactory() == null) : this.connectionFactory.equals(that.getConnectionFactory()))
                    && ((this.queue == null) ? (that.getQueue() == null) : this.queue.equals(that.getQueue()))
                    && ((this.topic == null) ? (that.getTopic() == null) : this.topic.equals(that.getTopic()))
                    && ((this.username == null) ? (that.getUsername() == null) : this.username.equals(that.getUsername()))
                    && ((this.password == null) ? (that.getPassword() == null) : this.password.equals(that.getPassword()));
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
        return h;
    }

    @Override
    NcJmsIO.Write.Builder builder() {
        return new Builder(this);
    }

    static final class Builder extends NcJmsIO.Write.Builder {
        private ConnectionFactory connectionFactory;
        private String queue;
        private String topic;
        private String username;
        private String password;
        Builder() {
        }
        private Builder(NcJmsIO.Write source) {
            this.connectionFactory = source.getConnectionFactory();
            this.queue = source.getQueue();
            this.topic = source.getTopic();
            this.username = source.getUsername();
            this.password = source.getPassword();
        }
        @Override
        NcJmsIO.Write.Builder setConnectionFactory(@Nullable ConnectionFactory connectionFactory) {
            this.connectionFactory = connectionFactory;
            return this;
        }
        @Override
        NcJmsIO.Write.Builder setQueue(@Nullable String queue) {
            this.queue = queue;
            return this;
        }
        @Override
        NcJmsIO.Write.Builder setTopic(@Nullable String topic) {
            this.topic = topic;
            return this;
        }
        @Override
        NcJmsIO.Write.Builder setUsername(@Nullable String username) {
            this.username = username;
            return this;
        }
        @Override
        NcJmsIO.Write.Builder setPassword(@Nullable String password) {
            this.password = password;
            return this;
        }
        @Override
        NcJmsIO.Write build() {
            return new AutoValue_JmsIO_Write(
                    this.connectionFactory,
                    this.queue,
                    this.topic,
                    this.username,
                    this.password);
        }
    }

}
