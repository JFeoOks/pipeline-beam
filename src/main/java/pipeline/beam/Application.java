package pipeline.beam;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.BigEndianIntegerCoder;
import org.apache.beam.sdk.coders.StringUtf8Coder;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.values.PCollection;
import pipeline.beam.options.MyOptions;

import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        PipelineOptions options = PipelineOptionsFactory.create();
        Pipeline pipeline = Pipeline.create(options);

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
