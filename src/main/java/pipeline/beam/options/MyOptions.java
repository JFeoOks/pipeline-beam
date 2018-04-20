package pipeline.beam.options;

import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;

public interface MyOptions extends PipelineOptions {

    @Description("Custom argument")
    @Default.String("DEFAULT")
    String getMyCustomOption();

    void setMyCustomOption(String myCustomOption);
}
