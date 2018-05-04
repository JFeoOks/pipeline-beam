package pipeline.beam;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.BigEndianIntegerCoder;
import org.apache.beam.sdk.coders.StringUtf8Coder;
import org.apache.beam.sdk.io.FileBasedSink;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.io.jms.JmsIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.windowing.FixedWindows;
import org.apache.beam.sdk.transforms.windowing.Window;
import org.apache.beam.sdk.values.PCollection;
import org.joda.time.Duration;
import pipeline.beam.function.WriteInFileFunction;
import pipeline.beam.options.MyOptions;
import pipeline.beam.wrapper.ConnectionFactoryWrapper;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        final String JMS_QUEUE = "com.netcracker.mash.queue";
        final String JMS_CONNECTION_FACTORY = "com.ntcracker.mash.connectionfactory";
        final ConnectionFactoryWrapper connectionFactory = new ConnectionFactoryWrapper(JMS_CONNECTION_FACTORY);

        final Pipeline pipeline = Pipeline.create();

        pipeline
                .apply(JmsIO.read().withConnectionFactory(connectionFactory).withQueue(JMS_QUEUE))
                .apply(ParDo.of(new WriteInFileFunction()))
                .apply(Window.<String>into(FixedWindows.of(Duration.standardSeconds(30))))
                .apply(
                        TextIO.write().to("/netcracker/config/u214_d46_6810/applications/NetCracker/NetCrackerWebApp/mediation/test")
                                .withWindowedWrites()
                                .withNumShards(1)
                                .withSuffix(".txt")
                                .withWritableByteChannelFactory(FileBasedSink.CompressionType.GZIP)
                );

        pipeline.run();
    }

    private static void setDefaultCoder(Pipeline p) {
        p.getCoderRegistry().registerCoderForClass(Integer.class, BigEndianIntegerCoder.of());
    }

    private static PCollection<String> createPCollectionFromInMemoryData() {
        List<String> lines = Arrays.asList(
                "To be, or not to be: that is the question: ",
                "Whether 'tis nobler in the mind to suffer ",
                "The slings and arrows of outrageous fortune, ",
                "Or to take arms against a sea of troubles, ");

        return Pipeline.create(createDefaultOptions())
                .apply(Create.of(lines).withCoder(StringUtf8Coder.of()));
    }

    private static PCollection<String> readPCollectionFromExternalSource() {
        return Pipeline.create(createDefaultOptions())
                .apply("ReadMyFile", TextIO.read().from("protocol://path/to/some/inputData.txt"));
    }

    private static PipelineOptions createDefaultOptions() {
        return PipelineOptionsFactory.create();
    }

    private static PipelineOptions createCustomOptions(String[] args) {
        PipelineOptionsFactory.register(MyOptions.class);
        return PipelineOptionsFactory
                .fromArgs(args)
                .withValidation()
                .as(MyOptions.class);
    }
}
