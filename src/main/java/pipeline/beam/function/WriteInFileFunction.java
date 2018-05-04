package pipeline.beam.function;

import org.apache.beam.sdk.io.jms.JmsRecord;
import org.apache.beam.sdk.transforms.DoFn;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class WriteInFileFunction extends DoFn<JmsRecord, String> implements Serializable {

    @ProcessElement
    public void processElement(ProcessContext processContext) {
        JmsRecord element = processContext.element();

        try (FileWriter writer = new FileWriter("./pipeline_test", true)) {
            writer.write(element.getPayload() + "\n");
        } catch (IOException e) {
        }
        processContext.output(element.getPayload());
    }
}
