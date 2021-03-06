package com.aliyun.odps.jdbc.utils.transformer.to.odps;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class ToOdpsSmallintTransformer extends AbstractToOdpsTransformer {

  @Override
  public Object transform(Object o, String charset) throws SQLException {
    if (o == null) {
      return null;
    }

    if (Short.class.isInstance(o)) {
      return o;
    } else {
      String errorMsg = getInvalidTransformationErrorMsg(o.getClass(), Short.class);
      throw new SQLException(errorMsg);
    }
  }
}
