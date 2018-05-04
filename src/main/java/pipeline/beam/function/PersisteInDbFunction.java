package pipeline.beam.function;

import pipeline.beam.io.jdbc.NcJdbcIO;

import java.io.Serializable;
import java.sql.PreparedStatement;

public class PersisteInDbFunction implements Serializable, NcJdbcIO.PreparedStatementSetter<String> {

    @Override
    public void setParameters(String element, PreparedStatement statement) throws Exception {
        statement.setString(1, element);
    }
}
