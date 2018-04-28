<%@ page import="org.apache.beam.sdk.Pipeline" %>
<%@ page import="org.apache.beam.sdk.io.jms.JmsIO" %>
<%@ page import="org.apache.beam.sdk.io.jms.JmsRecord" %>
<%@ page import="org.apache.beam.sdk.options.PipelineOptions" %>
<%@ page import="org.apache.beam.sdk.options.PipelineOptionsFactory" %>
<%@ page import="org.apache.beam.sdk.transforms.DoFn" %>
<%@ page import="org.apache.beam.sdk.transforms.ParDo" %>
<%@ page import="org.apache.beam.sdk.values.PCollection" %>
<%@ page import="pipeline.beam.ConnectionFactoryWrapper" %>
<%@ page import="java.io.PrintWriter" %>

<%
    try {
        final String JMS_QUEUE = "com.netcracker.mediation.common.JmsDistributedExecutorQueue";

        final PipelineOptions options = PipelineOptionsFactory.create();
        final Pipeline pipeline = Pipeline.create(options);

        PCollection<JmsRecord> jmsRecord = pipeline.apply(
                JmsIO.read()
                        .withConnectionFactory(new ConnectionFactoryWrapper())
                        .withQueue(JMS_QUEUE)
        );

        jmsRecord.apply(ParDo.of(new DoFn<JmsRecord, JmsRecord>() {
            @ProcessElement
            public void processElement(ProcessContext c) {
                c.output(c.element());
            }
        }));

//        pipeline.run();
    } catch (Throwable t) {
        PrintWriter writer = new PrintWriter(out);
        t.printStackTrace(writer);
    }

    out.print("SUCCESS!");
%>
