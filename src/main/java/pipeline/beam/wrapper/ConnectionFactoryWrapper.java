package pipeline.beam.wrapper;

import com.netcracker.mediation.common.ExceptionUtils;
import com.netcracker.mediation.common.spring.CommonContextProvider;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.naming.NamingException;
import java.io.Serializable;

public class ConnectionFactoryWrapper implements ConnectionFactory, Serializable {

    private final String jmsConnectionFactoryName;

    public ConnectionFactoryWrapper(String jmsConnectionFactoryName) {
        this.jmsConnectionFactoryName = jmsConnectionFactoryName;
    }

    public Connection createConnection() throws JMSException {
        try {
            ConnectionFactory connectionFactory = CommonContextProvider.provide().jndiTemplate().lookup(jmsConnectionFactoryName, ConnectionFactory.class, 20000L);
            return connectionFactory.createConnection();
        } catch (NamingException e) {
            ExceptionUtils.castAndThrow(e);
            throw new AssertionError();
        }
    }

    public Connection createConnection(String userName, String password) throws JMSException {
        try {
            ConnectionFactory connectionFactory = CommonContextProvider.provide().jndiTemplate().lookup(jmsConnectionFactoryName, ConnectionFactory.class, 20000L);
            return connectionFactory.createConnection(userName, password);
        } catch (NamingException e) {
            ExceptionUtils.castAndThrow(e);
            throw new AssertionError();
        }
    }
}