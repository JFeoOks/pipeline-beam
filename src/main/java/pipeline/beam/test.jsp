<%@ page import="org.apache.beam.sdk.Pipeline" %>
<%@ page import="org.apache.beam.sdk.transforms.ParDo" %>
<%@ page import="org.apache.beam.sdk.transforms.windowing.FixedWindows" %>
<%@ page import="org.apache.beam.sdk.transforms.windowing.Window" %>
<%@ page import="org.joda.time.Duration" %>
<%@ page import="pipeline.beam.wrapper.ConnectionFactoryWrapper" %>
<%@ page import="pipeline.beam.function.WriteInFileFunction" %>
<%@ page import="pipeline.beam.io.jdbc.NcJdbcIO" %>
<%@ page import="pipeline.beam.io.jms.NcJmsIO" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="pipeline.beam.wrapper.DataSourceWrapper" %>
<%@ page import="pipeline.beam.function.PersisteInDbFunction" %>
<%
    try {
        final String JMS_CONNECTION_FACTORY = "com.netcracker.mediation.MediationQueueConnectionFactory";
        final String JMS_QUEUE = "com.netcracker.mediation.common.JmsDistributedExecutorQueue";
        final ConnectionFactoryWrapper connectionFactory = new ConnectionFactoryWrapper(JMS_CONNECTION_FACTORY);

        final Pipeline pipeline = Pipeline.create();

        pipeline
                .apply(NcJmsIO.read().withConnectionFactory(connectionFactory).withQueue(JMS_QUEUE))
                .apply(ParDo.of(new WriteInFileFunction()))
                .apply(Window.<String>into(FixedWindows.of(Duration.standardSeconds(30))))
                .apply(NcJdbcIO.<String>write().withDataSourceConfiguration(
                        NcJdbcIO.DataSourceConfiguration.create(new DataSourceWrapper()))
                        .withStatement("insert into test values(?)")
                        .withPreparedStatementSetter(new PersisteInDbFunction()));

        pipeline.run();
        out.print("SUCCESS!");
    } catch (Throwable t) {
        PrintWriter writer = new PrintWriter(out);
        t.printStackTrace(writer);
    }

%>
