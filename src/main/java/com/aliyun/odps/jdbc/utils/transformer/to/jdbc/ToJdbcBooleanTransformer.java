/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */

package com.aliyun.odps.jdbc.utils.transformer.to.jdbc;

import java.sql.SQLException;


public class ToJdbcBooleanTransformer extends AbstractToJdbcTransformer {

  @Override
  public Object transform(Object o, String charset) throws SQLException {
    if (o == null) {
      return false;
    }

    if (Boolean.class.isInstance(o)) {
      return o;
    } else if (Number.class.isInstance(o)) {
      return ((Number) o).intValue() != 0;
    } else if (o instanceof byte[]) {
      return !"0".equals(encodeBytes((byte[]) o, charset));
    } else {
      String errorMsg = getInvalidTransformationErrorMsg(o.getClass(), boolean.class);
      throw new SQLException(errorMsg);
    }
  }
}